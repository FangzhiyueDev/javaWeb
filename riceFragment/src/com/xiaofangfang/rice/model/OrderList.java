package com.xiaofangfang.rice.model;

public abstract class OrderList {

    private int saleVolume = 0;
    private String name;
    private String destribute;
    private float price = 0;

    public int getSaleVolume() {
        return saleVolume;
    }

    public void setSaleVolume(int saleVolume) {
        this.saleVolume = saleVolume;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestribute() {
        return destribute;
    }

    public void setDestribute(String destribute) {
        this.destribute = destribute;
    }
}
