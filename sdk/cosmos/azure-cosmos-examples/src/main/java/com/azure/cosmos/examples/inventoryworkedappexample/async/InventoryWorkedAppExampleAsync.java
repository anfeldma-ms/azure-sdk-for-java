package com.azure.cosmos.examples.inventoryworkedappexample.async;

import com.azure.cosmos.*;
import com.azure.cosmos.examples.common.AccountSettings;
import com.azure.cosmos.examples.common.Families;
import com.azure.cosmos.examples.common.Family;
import com.google.common.collect.Lists;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CountDownLatch;
import java.util.Scanner;

import static java.lang.System.exit;

public class InventoryWorkedAppExampleAsync {
    private CosmosAsyncClient client;

    private final String databaseName = "ContosoInventoryDB";
    private final String containerName = "ContosoInventoryFeedContainer";

    private CosmosAsyncDatabase database;
    private CosmosAsyncContainer container;

    public void demoCleanupClose() {
        System.out.println("Cleanup and close out the application...");
        if (client != null) client.close();
        System.out.println("Done.");
        exit(0);
    }

    /**
     * Run the Contoso Inventory Example Application.
     *
     * @param args command line args.
     */
    public static void main(String[] args) {
        InventoryWorkedAppExampleAsync p = new InventoryWorkedAppExampleAsync();

        try {
            System.out.println("Running Contoso Inventory Example Application.");
            p.initializeDemo();
            p.demoSuperLoop();
            System.out.println("Demo complete, please hold while resources are released");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(String.format("Cosmos getStarted failed with %s", e));
        } finally {
            System.out.println("Closing the client");
            p.demoCleanupClose();
        }
        exit(0);
    }

    private void demoSuperLoop() throws Exception {

        boolean cleanup_close=false;
        String user_cmd="";

        while(!cleanup_close) {
            System.out.println("\n\nWelcome to Contoso Inventory. What do you want to do?\n");
            System.out.println("-[I]nitial Data Ingestion\n");
            System.out.println("-[S]tart Contoso Inventory Server and Client Threads\n");
            System.out.println("-Sto[P] Server and Client Threads\n");
            System.out.println("-[C]leanup and exit.\n");
            Scanner s = new Scanner(System.in);
            user_cmd = s.nextLine();

            if (user_cmd.equals("C")) {
                //Cleanup and close
                cleanup_close = true;
            } else if (user_cmd.equals("I")) {
                //Initial Data Migration
                this.initialDataIngestion();
            } else if (user_cmd.equals("S")) {
                //Start Server and Client Threads
                System.out.println("Not implemented.");
            } else if (user_cmd.equals("P")) {
                //Stop Server and Client Threads
                System.out.println("Not implemented.");
            } else
                System.out.println("Command not recognized.");
        }
        this.demoCleanupClose();

    }

    private void initializeDemo() throws Exception {
        System.out.println("Initializing demo...");
        System.out.println("-Using Azure Cosmos DB endpoint: " + AccountSettings.HOST);

        ConnectionPolicy defaultPolicy = ConnectionPolicy.getDefaultPolicy();
        //  Setting the preferred location to Cosmos DB Account region
        //  West US is just an example. User should set preferred location to the Cosmos DB region closest to the application
        defaultPolicy.setPreferredLocations(Lists.newArrayList("West US"));

        //  Create async client
        client = new CosmosClientBuilder()
            .setEndpoint(AccountSettings.HOST)
            .setKey(AccountSettings.MASTER_KEY)
            .setConnectionPolicy(defaultPolicy)
            .setConsistencyLevel(ConsistencyLevel.EVENTUAL)
            .buildAsyncClient();
    }

    private void createDatabaseIfNotExists() throws Exception {
        System.out.println("Create database " + databaseName + " if not exists.");

        //  Create database if not exists
        //  <CreateDatabaseIfNotExists>
        Mono<CosmosAsyncDatabaseResponse> databaseIfNotExists = client.createDatabaseIfNotExists(databaseName);
        databaseIfNotExists.flatMap(databaseResponse -> {
            database = databaseResponse.getDatabase();
            System.out.println("Checking database " + database.getId() + " completed!\n");
            return Mono.empty();
        }).block();
        //  </CreateDatabaseIfNotExists>
    }

    private void createContainerIfNotExists() throws Exception {
        System.out.println("Create container " + containerName + " if not exists.");

        //  Create container if not exists
        //  <CreateContainerIfNotExists>

        CosmosContainerProperties containerProperties = new CosmosContainerProperties(containerName, "/lastName");
        Mono<CosmosAsyncContainerResponse> containerIfNotExists = database.createContainerIfNotExists(containerProperties, 400);

        //  Create container with 400 RU/s
        containerIfNotExists.flatMap(containerResponse -> {
            container = containerResponse.getContainer();
            System.out.println("Checking container " + container.getId() + " completed!\n");
            return Mono.empty();
        }).block();

        //  </CreateContainerIfNotExists>
    }

    private void initialDataIngestion() throws Exception {

        Flux<Family> families=null;

        createDatabaseIfNotExists();
        createContainerIfNotExists();

        Family andersenFamilyItem= Families.getAndersenFamilyItem();
        Family wakefieldFamilyItem=Families.getWakefieldFamilyItem();
        Family johnsonFamilyItem=Families.getJohnsonFamilyItem();
        Family smithFamilyItem=Families.getSmithFamilyItem();

        //  Setup family items to create
        Flux<Family> familiesToCreate = Flux.just(andersenFamilyItem,
            wakefieldFamilyItem,
            johnsonFamilyItem,
            smithFamilyItem);

        //  <CreateItem>

        final CountDownLatch completionLatch = new CountDownLatch(1);

        //  Combine multiple item inserts, associated success println's, and a final aggregate stats println into one Reactive stream.
        families.flatMap(family -> {
            return container.createItem(family);
        }) //Flux of item request responses
            .flatMap(itemResponse -> {
                System.out.println(String.format("Created item with request charge of %.2f within" +
                        " duration %s",
                    itemResponse.getRequestCharge(), itemResponse.getRequestLatency()));
                System.out.println(String.format("Item ID: %s\n", itemResponse.getResource().getId()));
                return Mono.just(itemResponse.getRequestCharge());
            }) //Flux of request charges
            .reduce(0.0,
                (charge_n,charge_nplus1) -> charge_n + charge_nplus1
            ) //Mono of total charge - there will be only one item in this stream
            .subscribe(charge -> {
                    System.out.println(String.format("Created items with total request charge of %.2f\n",
                        charge));
                },
                err -> {
                    if (err instanceof CosmosClientException) {
                        //Client-specific errors
                        CosmosClientException cerr = (CosmosClientException)err;
                        cerr.printStackTrace();
                        System.err.println(String.format("Read Item failed with %s\n", cerr));
                    } else {
                        //General errors
                        err.printStackTrace();
                    }

                    completionLatch.countDown();
                },
                () -> {completionLatch.countDown();}
            ); //Preserve the total charge and print aggregate charge/item count stats.

        try {
            completionLatch.await();
        } catch (InterruptedException err) {
            throw new AssertionError("Unexpected Interruption",err);
        }

        //  </CreateItem>
    }
}

