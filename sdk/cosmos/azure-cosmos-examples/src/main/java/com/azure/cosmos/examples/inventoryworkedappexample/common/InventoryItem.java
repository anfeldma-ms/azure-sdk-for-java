// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.examples.inventoryworkedappexample.common;

import java.util.UUID;

public class InventoryItem {
    private String brandName;
    private String productName;
    private String id;
    private String productGUID; //Recommended /pk
    private String storeLocation;
    private String itemAisle;
    private int quantity;
    private float price;

    public InventoryItem() {
        this.id="";
        this.productGUID="";
        this.productName="";
        this.storeLocation="";
        this.itemAisle="";
        this.quantity=0;
        this.price=0.0f;
    }

    public InventoryItem(String id, String productGUID, String brandName, String productName, String storeLocation, String itemAisle, int quantity, float price) {
        this.id=id;
        this.productGUID=productGUID;
        this.productName=productName;
        this.storeLocation=storeLocation;
        this.itemAisle=itemAisle;
        this.quantity=quantity;
        this.price=price;
    }

    public InventoryItem(String brandName, String productName, String storeLocation, String itemAisle, int quantity, float price) {
        //"Random" id and UUID with id prefixed by productName
        this(brandName + productName + System.currentTimeMillis(),UUID.randomUUID().toString(),brandName,productName,storeLocation,itemAisle,quantity,price);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getProductGUID() { return productGUID; }

    public void setProductGUID(String productGUID) { this.productGUID = productGUID; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getItemAisle() {
        return itemAisle;
    }

    public void setItemAisle(String itemAisle) {
        this.itemAisle = itemAisle;
    }

    public String getProductName() {
        return productName;
    }

    public String setProductName() {
        return productName;
    }

    public String getBrandName() {
        return productName;
    }

    public String setBrandName() {
        return productName;
    }
}
