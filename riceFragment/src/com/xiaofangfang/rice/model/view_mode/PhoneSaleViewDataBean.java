package com.xiaofangfang.rice.model.view_mode;

import com.xiaofangfang.rice.model.Phone;

import java.util.List;

/**
 * 手机销售视图的数据封装bean
 */
public class PhoneSaleViewDataBean {

    private String title;
    private String linkName;
    private String linkClickStartActivityName;
    private String tableName;
    List<List<PhoneSingleData>> phoneSingleDataList;

    public PhoneSaleViewDataBean(String title, String linkName, String linkClickStartActivityName, String tableName, List<List<PhoneSingleData>> phoneSingleDataList) {
        this.title = title;
        this.linkName = linkName;
        this.linkClickStartActivityName = linkClickStartActivityName;
        this.tableName = tableName;
        this.phoneSingleDataList = phoneSingleDataList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {

        this.tableName = tableName;
    }

    public PhoneSaleViewDataBean() {
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


    public List<List<PhoneSingleData>> getPhoneSingleDataList() {
        return phoneSingleDataList;
    }

    public void setPhoneSingleDataList(List<List<PhoneSingleData>> phoneSingleDataList) {
        this.phoneSingleDataList = phoneSingleDataList;
    }

    public static class PhoneSingleData {

        private Phone phone;
        private String linkClickStartActivityName;
        private String tableName;

        public PhoneSingleData(Phone phone, String linkClickStartActivityName, String tableName) {
            this.phone = phone;
            this.linkClickStartActivityName = linkClickStartActivityName;
            this.tableName = tableName;
        }

        public Phone getPhone() {
            return phone;
        }

        public void setPhone(Phone phone) {
            this.phone = phone;
        }

        public String getLinkClickStartActivityName() {
            return linkClickStartActivityName;
        }

        public void setLinkClickStartActivityName(String linkClickStartActivityName) {
            this.linkClickStartActivityName = linkClickStartActivityName;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }
    }

}
