/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.vision.computervision.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for TextRecognitionResultDimensionUnit.
 */
public enum TextRecognitionResultDimensionUnit {
    /** Enum value pixel. */
    PIXEL("pixel"),

    /** Enum value inch. */
    INCH("inch");

    /** The actual serialized value for a TextRecognitionResultDimensionUnit instance. */
    private String value;

    TextRecognitionResultDimensionUnit(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a TextRecognitionResultDimensionUnit instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed TextRecognitionResultDimensionUnit object, or null if unable to parse.
     */
    @JsonCreator
    public static TextRecognitionResultDimensionUnit fromString(String value) {
        TextRecognitionResultDimensionUnit[] items = TextRecognitionResultDimensionUnit.values();
        for (TextRecognitionResultDimensionUnit item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}