package com.fang.rice.model;

public class Type {

    private String typeOne;
    private String typeTwo;


    public Type(String typeOne, String typeTwo) {
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo;
    }


    public Type() {

    }
}
