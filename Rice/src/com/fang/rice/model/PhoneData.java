package com.fang.rice.model;

import java.util.List;

import com.xiaofangfang.rice.model.Phone;

public  class PhoneData {

    private Phone phone;
    private List<String> strangCapacity;
    private List<String> colors;
    private List<String> setmeals;
    private List<String> phoneDetailImageAddress;

    public PhoneData(Phone phone, List<String> strangCapacity, List<String> colors, List<String> setmeals, List<String> phoneDetailImageAddress) {
        this.phone = phone;
        this.strangCapacity = strangCapacity;
        this.colors = colors;
        this.setmeals = setmeals;
        this.phoneDetailImageAddress = phoneDetailImageAddress;
    }


    public PhoneData() {
    }


    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List<String> getStrangCapacity() {
        return strangCapacity;
    }

    public void setStrangCapacity(List<String> strangCapacity) {
        this.strangCapacity = strangCapacity;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSetmeals() {
        return setmeals;
    }

    public void setSetmeals(List<String> setmeals) {
        this.setmeals = setmeals;
    }

    public List<String> getPhoneDetailImageAddress() {
        return phoneDetailImageAddress;
    }

    public void setPhoneDetailImageAddress(List<String> phoneDetailImageAddress) {
        this.phoneDetailImageAddress = phoneDetailImageAddress;
    }
}