package com.xiaofangfang.rice.model.view_mode;

import com.xiaofangfang.rice.model.PhoneNumber;

import java.util.List;

/**
 * 靓号展示视图的视图封装对象
 */
public class LiangHaoDisplayViewDataBean {

    private String title;
    private String linkName;
    private String linkClickStartActivityName;
    private List<LiangHaoType> liangHaoTypes;
    //linkClickStartActivityName代表了具体的启动的activity，tableName规定了启动视图做的具体操作
    private String tableName;

    public LiangHaoDisplayViewDataBean(String title, String linkName, String linkClickStartActivityName, List<LiangHaoType> liangHaoTypes, String tableName) {
        this.title = title;
        this.linkName = linkName;
        this.linkClickStartActivityName = linkClickStartActivityName;
        this.liangHaoTypes = liangHaoTypes;
        this.tableName = tableName;
    }

    public List<LiangHaoType> getLiangHaoTypes() {
        return liangHaoTypes;
    }

    public void setLiangHaoTypes(List<LiangHaoType> liangHaoTypes) {
        this.liangHaoTypes = liangHaoTypes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
    	this.tableName = tableName;
    }

    public LiangHaoDisplayViewDataBean() {
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


    /**
     * 靓号的类型具体信息的封装对象
     * 定义了类型
     */
   public static class LiangHaoType {

        private String type;
        private List<PhoneNumber> phoneNumbers;
        private String tableName;
        private String clickStartActivityName;

        public LiangHaoType(String type, List<PhoneNumber> phoneNumbers, String tableName, String clickStartActivityName) {
            this.type = type;
            this.phoneNumbers = phoneNumbers;
            this.tableName = tableName;
            this.clickStartActivityName = clickStartActivityName;
        }

        public String getClickStartActivityName() {
            return clickStartActivityName;
        }

        public void setClickStartActivityName(String clickStartActivityName) {
            this.clickStartActivityName = clickStartActivityName;
        }

        public LiangHaoType() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<PhoneNumber> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }
    }

}
