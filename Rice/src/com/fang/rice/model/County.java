package com.fang.rice.model;


public class County {

    private int countyId;
    private int cityId;
    private String name;

    public County(int countyId, int cityId, String name) {
        this.countyId = countyId;
        this.cityId = cityId;
        this.name = name;
    }

    public County(){

    }



    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
