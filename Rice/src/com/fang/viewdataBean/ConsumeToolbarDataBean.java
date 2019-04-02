package com.fang.viewdataBean;


public class ConsumeToolbarDataBean implements DataResponse {

    private String title;
    private String currentLocation;

    public ConsumeToolbarDataBean(String title, String currentLocation) {
        this.title = title;
        this.currentLocation = currentLocation;
    }

    public ConsumeToolbarDataBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}
