// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.examples.inventoryworkedappexample.async;

public class InventoryClientAsync {
}


/*

    private void readItems(Flux<Family> familiesToCreate) {
        //  Using partition key for point read scenarios.
        //  This will help fast look up of items because of partition key
        //  <ReadItem>

        final CountDownLatch completionLatch = new CountDownLatch(1);

        familiesToCreate.flatMap(family -> {
            Mono<CosmosAsyncItemResponse<Family>> asyncItemResponseMono = container.readItem(family.getId(), new PartitionKey(family.getLastName()), Family.class);
            return asyncItemResponseMono;
        })
            .subscribe(
                itemResponse -> {
                    double requestCharge = itemResponse.getRequestCharge();
                    Duration requestLatency = itemResponse.getRequestLatency();
                    System.out.println(String.format("Item successfully read with id %s with a charge of %.2f and within duration %s",
                        itemResponse.getResource().getId(), requestCharge, requestLatency));
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
            );

        try {
            completionLatch.await();
        } catch (InterruptedException err) {
            throw new AssertionError("Unexpected Interruption",err);
        }

        //  </ReadItem>
    }

    private void queryItems() {
        //  <QueryItems>
        // Set some common query options

        FeedOptions queryOptions = new FeedOptions();
        queryOptions.maxItemCount(10);
        //queryOptions.setEnableCrossPartitionQuery(true); //No longer needed in SDK v4
        //  Set populate query metrics to get metrics around query executions
        queryOptions.populateQueryMetrics(true);

        CosmosContinuablePagedFlux<Family> pagedFluxResponse = container.queryItems(
            "SELECT * FROM Family WHERE Family.lastName IN ('Andersen', 'Wakefield', 'Johnson')", queryOptions, Family.class);

        final CountDownLatch completionLatch = new CountDownLatch(1);

        pagedFluxResponse.byPage().subscribe(
            fluxResponse -> {
                System.out.println("Got a page of query result with " +
                    fluxResponse.getResults().size() + " items(s)"
                    + " and request charge of " + fluxResponse.getRequestCharge());

                System.out.println("Item Ids " + fluxResponse
                    .getResults()
                    .stream()
                    .map(Family::getId)
                    .collect(Collectors.toList()));
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
        );

        try {
            completionLatch.await();
        } catch (InterruptedException err) {
            throw new AssertionError("Unexpected Interruption",err);
        }

        // </QueryItems>
    }

 */
