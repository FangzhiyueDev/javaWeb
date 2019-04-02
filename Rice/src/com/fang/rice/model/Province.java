package com.fang.rice.model;


public class Province {

    private String name;
    private int provinceId;

    public Province(String name, int provinceId) {
  
        this.name = name;
        this.provinceId = provinceId;
    }



    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public Province(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
