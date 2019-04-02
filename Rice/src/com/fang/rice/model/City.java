package com.fang.rice.model;


public class City  {

    private int provinceId;
    private String name;
    private int cityId;

    public City(int provinceId, String name, int cityId) {
    
        this.provinceId = provinceId;
        this.name = name;
        this.cityId = cityId;
    }


    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public City() {
    }


    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
