package com.fang.viewdataBean;


/**
 * 数据的抽象类，定义了数据访问的基本接口和功能
 */
public class DataBean {

    private String imageAddress;
    private String clickStartActivityName;
    private String describute;


    public DataBean() {

    }


    public DataBean(String imageAddress, String clickStartActivityName, String describute) {
        this.imageAddress = imageAddress;
        this.clickStartActivityName = clickStartActivityName;
        this.describute = describute;
    }

    public String getClickStartActivityName() {
        return clickStartActivityName;
    }

    public void setClickStartActivityName(String clickStartActivityName) {
        this.clickStartActivityName = clickStartActivityName;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getDescribute() {
        return describute;
    }

    public void setDescribute(String describute) {
        this.describute = describute;
    }
}
