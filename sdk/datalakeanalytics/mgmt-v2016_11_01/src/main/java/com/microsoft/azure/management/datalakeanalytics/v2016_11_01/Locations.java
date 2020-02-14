/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakeanalytics.v2016_11_01;

import rx.Observable;
import com.microsoft.azure.management.datalakeanalytics.v2016_11_01.implementation.LocationsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Locations.
 */
public interface Locations extends HasInner<LocationsInner> {
    /**
     * Gets subscription-level properties and limits for Data Lake Analytics specified by resource location.
     *
     * @param location The resource location without whitespace.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<CapabilityInformation> getCapabilityAsync(String location);

}