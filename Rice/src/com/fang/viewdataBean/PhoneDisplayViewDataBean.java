package com.fang.viewdataBean;


import java.util.List;

import com.xiaofangfang.rice.model.Phone;

/**
 * 手机展示视图的数据封装类
 */
public class PhoneDisplayViewDataBean implements DataResponse {

    private String title;
    private String linkName;
    private String linkClickStartActivityName;
    private String tableName;

    private List<SingleData> singleDatas;


    public PhoneDisplayViewDataBean(String title, String linkName, String linkClickStartActivityName, List<SingleData> singleDatas,String tableName) {
        this.title = title;
        this.linkName = linkName;
        this.linkClickStartActivityName = linkClickStartActivityName;
        this.singleDatas = singleDatas;
        this.tableName=tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public PhoneDisplayViewDataBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkClickStartActivityName() {
        return linkClickStartActivityName;
    }

    public void setLinkClickStartActivityName(String linkClickStartActivityName) {
        this.linkClickStartActivityName = linkClickStartActivityName;
    }



    public List<SingleData> getSingleDatas() {
        return singleDatas;
    }

    public void setSingleDatas(List<SingleData> singleDatas) {
        this.singleDatas = singleDatas;
    }


    public static class SingleData{

        private Phone phone;
        private String clickStartActivityName;
        private String tableName;

        public SingleData() {
            // TODO Auto-generated constructor stub
        }

        public SingleData(Phone phone,String clickStartActivityName,String tableName) {
            this.phone=phone;
            this.clickStartActivityName=clickStartActivityName;
            this.tableName=tableName;
        }

        public Phone getPhones() {
            return phone;
        }
        public void setPhones(Phone phones) {
            this.phone = phones;
        }
        public String getClickStartActivityName() {
            return clickStartActivityName;
        }
        public void setClickStartActivityName(String clickStartActivityName) {
            this.clickStartActivityName = clickStartActivityName;
        }
        public String getTableName() {
            return tableName;
        }
        public void setTableName(String tableName) {
            this.tableName = tableName;
        }


    }






}