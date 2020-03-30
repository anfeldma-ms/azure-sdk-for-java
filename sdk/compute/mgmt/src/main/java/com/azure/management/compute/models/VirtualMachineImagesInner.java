// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.compute.models;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.management.CloudException;
import java.util.List;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * VirtualMachineImages.
 */
public final class VirtualMachineImagesInner {
    /**
     * The proxy service used to perform REST calls.
     */
    private VirtualMachineImagesService service;

    /**
     * The service client containing this operation class.
     */
    private ComputeManagementClientImpl client;

    /**
     * Initializes an instance of VirtualMachineImagesInner.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    public VirtualMachineImagesInner(ComputeManagementClientImpl client) {
        this.service = RestProxy.create(VirtualMachineImagesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for
     * ComputeManagementClientVirtualMachineImages to be used by the proxy
     * service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "ComputeManagementClientVirtualMachineImages")
    private interface VirtualMachineImagesService {
        @Get("/subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmimage/offers/{offer}/skus/{skus}/versions/{version}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<VirtualMachineImageInner>> get(@HostParam("$host") String host, @PathParam("location") String location, @PathParam("publisherName") String publisherName, @PathParam("offer") String offer, @PathParam("skus") String skus, @PathParam("version") String version, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion);

        @Get("/subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmimage/offers/{offer}/skus/{skus}/versions")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> list(@HostParam("$host") String host, @PathParam("location") String location, @PathParam("publisherName") String publisherName, @PathParam("offer") String offer, @PathParam("skus") String skus, @QueryParam("$filter") String filter, @QueryParam("$top") Integer top, @QueryParam("$orderby") String orderby, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion);

        @Get("/subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmimage/offers")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listOffers(@HostParam("$host") String host, @PathParam("location") String location, @PathParam("publisherName") String publisherName, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion);

        @Get("/subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listPublishers(@HostParam("$host") String host, @PathParam("location") String location, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion);

        @Get("/subscriptions/{subscriptionId}/providers/Microsoft.Compute/locations/{location}/publishers/{publisherName}/artifacttypes/vmimage/offers/{offer}/skus")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listSkus(@HostParam("$host") String host, @PathParam("location") String location, @PathParam("publisherName") String publisherName, @PathParam("offer") String offer, @PathParam("subscriptionId") String subscriptionId, @QueryParam("api-version") String apiVersion);
    }

    /**
     * Gets a virtual machine image.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @param version 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<VirtualMachineImageInner>> getWithResponseAsync(String location, String publisherName, String offer, String skus, String version) {
        final String apiVersion = "2019-03-01";
        return service.get(this.client.getHost(), location, publisherName, offer, skus, version, this.client.getSubscriptionId(), apiVersion);
    }

    /**
     * Gets a virtual machine image.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @param version 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<VirtualMachineImageInner> getAsync(String location, String publisherName, String offer, String skus, String version) {
        return getWithResponseAsync(location, publisherName, offer, skus, version)
            .flatMap((SimpleResponse<VirtualMachineImageInner> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a virtual machine image.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @param version 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public VirtualMachineImageInner get(String location, String publisherName, String offer, String skus, String version) {
        return getAsync(location, publisherName, offer, skus, version).block();
    }

    /**
     * Gets a list of all virtual machine image versions for the specified location, publisher, offer, and SKU.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @param filter 
     * @param top 
     * @param orderby 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listWithResponseAsync(String location, String publisherName, String offer, String skus, String filter, Integer top, String orderby) {
        final String apiVersion = "2019-03-01";
        return service.list(this.client.getHost(), location, publisherName, offer, skus, filter, top, orderby, this.client.getSubscriptionId(), apiVersion);
    }

    /**
     * Gets a list of all virtual machine image versions for the specified location, publisher, offer, and SKU.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @param filter 
     * @param top 
     * @param orderby 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<VirtualMachineImageResourceInner>> listAsync(String location, String publisherName, String offer, String skus, String filter, Integer top, String orderby) {
        return listWithResponseAsync(location, publisherName, offer, skus, filter, top, orderby)
            .flatMap((SimpleResponse<List<VirtualMachineImageResourceInner>> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a list of all virtual machine image versions for the specified location, publisher, offer, and SKU.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<VirtualMachineImageResourceInner>> listAsync(String location, String publisherName, String offer, String skus) {
        final String filter = null;
        final Integer top = null;
        final String orderby = null;
        final String apiVersion = "2019-03-01";
        return listWithResponseAsync(location, publisherName, offer, skus, filter, top, orderby)
            .flatMap((SimpleResponse<List<VirtualMachineImageResourceInner>> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a list of all virtual machine image versions for the specified location, publisher, offer, and SKU.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @param filter 
     * @param top 
     * @param orderby 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<VirtualMachineImageResourceInner> list(String location, String publisherName, String offer, String skus, String filter, Integer top, String orderby) {
        return listAsync(location, publisherName, offer, skus, filter, top, orderby).block();
    }

    /**
     * Gets a list of all virtual machine image versions for the specified location, publisher, offer, and SKU.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @param skus 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<VirtualMachineImageResourceInner> list(String location, String publisherName, String offer, String skus) {
        final String filter = null;
        final Integer top = null;
        final String orderby = null;
        final String apiVersion = "2019-03-01";
        return listAsync(location, publisherName, offer, skus, filter, top, orderby).block();
    }

    /**
     * Gets a list of virtual machine image offers for the specified location and publisher.
     * 
     * @param location 
     * @param publisherName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listOffersWithResponseAsync(String location, String publisherName) {
        final String apiVersion = "2019-03-01";
        return service.listOffers(this.client.getHost(), location, publisherName, this.client.getSubscriptionId(), apiVersion);
    }

    /**
     * Gets a list of virtual machine image offers for the specified location and publisher.
     * 
     * @param location 
     * @param publisherName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<VirtualMachineImageResourceInner>> listOffersAsync(String location, String publisherName) {
        return listOffersWithResponseAsync(location, publisherName)
            .flatMap((SimpleResponse<List<VirtualMachineImageResourceInner>> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a list of virtual machine image offers for the specified location and publisher.
     * 
     * @param location 
     * @param publisherName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<VirtualMachineImageResourceInner> listOffers(String location, String publisherName) {
        return listOffersAsync(location, publisherName).block();
    }

    /**
     * Gets a list of virtual machine image publishers for the specified Azure location.
     * 
     * @param location 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listPublishersWithResponseAsync(String location) {
        final String apiVersion = "2019-03-01";
        return service.listPublishers(this.client.getHost(), location, this.client.getSubscriptionId(), apiVersion);
    }

    /**
     * Gets a list of virtual machine image publishers for the specified Azure location.
     * 
     * @param location 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<VirtualMachineImageResourceInner>> listPublishersAsync(String location) {
        return listPublishersWithResponseAsync(location)
            .flatMap((SimpleResponse<List<VirtualMachineImageResourceInner>> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a list of virtual machine image publishers for the specified Azure location.
     * 
     * @param location 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<VirtualMachineImageResourceInner> listPublishers(String location) {
        return listPublishersAsync(location).block();
    }

    /**
     * Gets a list of virtual machine image SKUs for the specified location, publisher, and offer.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<List<VirtualMachineImageResourceInner>>> listSkusWithResponseAsync(String location, String publisherName, String offer) {
        final String apiVersion = "2019-03-01";
        return service.listSkus(this.client.getHost(), location, publisherName, offer, this.client.getSubscriptionId(), apiVersion);
    }

    /**
     * Gets a list of virtual machine image SKUs for the specified location, publisher, and offer.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<List<VirtualMachineImageResourceInner>> listSkusAsync(String location, String publisherName, String offer) {
        return listSkusWithResponseAsync(location, publisherName, offer)
            .flatMap((SimpleResponse<List<VirtualMachineImageResourceInner>> res) -> {
                if (res.getValue() != null) {
                    return Mono.just(res.getValue());
                } else {
                    return Mono.empty();
                }
            });
    }

    /**
     * Gets a list of virtual machine image SKUs for the specified location, publisher, and offer.
     * 
     * @param location 
     * @param publisherName 
     * @param offer 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public List<VirtualMachineImageResourceInner> listSkus(String location, String publisherName, String offer) {
        return listSkusAsync(location, publisherName, offer).block();
    }
}