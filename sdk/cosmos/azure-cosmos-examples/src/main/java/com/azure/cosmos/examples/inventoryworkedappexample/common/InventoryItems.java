// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.examples.inventoryworkedappexample.common;

import reactor.core.publisher.Flux;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InventoryItems {
    public static Flux<InventoryItem> getInventoryItemListRandomId() {
        return Flux.just(
            new InventoryItem("Contoso","Laptop", "Chicago1", "A", 2, 1000.50f),
            new InventoryItem("Generic","Ibuprofen", "Chicago1", "A", 2, 1.00f),
            new InventoryItem("EasyWrite","Marker", "Chicago1", "A", 2, 5.00f),
            new InventoryItem("Paper1","PrinterPaper", "Chicago1", "A", 2, 8.00f),
            new InventoryItem("InkSmart","Pen1Pack", "Chicago1", "A", 2, 5.55f),
            new InventoryItem("InkSmart","Pen2Pack", "Chicago1", "A", 2, 9.35f),
            new InventoryItem("InkSmart","Pen5Pack", "Chicago1", "A", 2, 22.00f),
            new InventoryItem("Speakeasy","ConferenceHeadset", "Chicago1", "A", 2, 12.25f),
            new InventoryItem("Quicksmart","DesktopOrganizer", "Chicago1", "A", 2, 5.50f),
            new InventoryItem("Stationary","Stationery", "Chicago1", "A", 2, 10.50f)
        );
    }
}
