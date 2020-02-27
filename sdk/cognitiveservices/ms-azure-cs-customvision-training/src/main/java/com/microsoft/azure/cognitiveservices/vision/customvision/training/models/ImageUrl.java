/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.vision.customvision.training.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Image url.
 */
public class ImageUrl {
    /**
     * Url of the image.
     */
    @JsonProperty(value = "url", required = true)
    private String url;

    /**
     * Get the url value.
     *
     * @return the url value
     */
    public String url() {
        return this.url;
    }

    /**
     * Set the url value.
     *
     * @param url the url value to set
     * @return the ImageUrl object itself.
     */
    public ImageUrl withUrl(String url) {
        this.url = url;
        return this;
    }

}