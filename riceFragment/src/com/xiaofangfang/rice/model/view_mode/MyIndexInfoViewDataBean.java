package com.xiaofangfang.rice.model.view_mode;

import java.util.List;

/**
 * 主页的视图的相关数据的封装
 */
public class MyIndexInfoViewDataBean {


    /**
     * 这个LIst只能存放2个视图，以及对应的点击事件
     * 1.头像的图片以及对应的点击操作
     * 2.右上角imageButton图片的点击事件
     */
    private List<InnerImageButtonOpration> innerImageButtonOprations;

    private String nameOrId;

    private List<InnerCommandButtonOpration> innerCommandButtonOprations;


    public MyIndexInfoViewDataBean(List<InnerImageButtonOpration> innerImageButtonOprations, String nameOrId, List<InnerCommandButtonOpration> innerCommandButtonOprations) {
        this.innerImageButtonOprations = innerImageButtonOprations;
        this.nameOrId = nameOrId;
        this.innerCommandButtonOprations = innerCommandButtonOprations;
    }

    public MyIndexInfoViewDataBean() {
    }


    public List<InnerCommandButtonOpration> getInnerCommandButtonOprations() {
        return innerCommandButtonOprations;
    }

    public void setInnerCommandButtonOprations(List<InnerCommandButtonOpration> innerCommandButtonOprations) {
        this.innerCommandButtonOprations = innerCommandButtonOprations;
    }

    public List<InnerImageButtonOpration> getInnerImageButtonOprations() {
        return innerImageButtonOprations;
    }

    public void setInnerImageButtonOprations(List<InnerImageButtonOpration> innerImageButtonOprations) {
        this.innerImageButtonOprations = innerImageButtonOprations;
    }

    public String getNameOrId() {
        return nameOrId;
    }

    public void setNameOrId(String nameOrId) {
        this.nameOrId = nameOrId;
    }

   public static class InnerImageButtonOpration {

        private String imageAddress;
        private String imageClickStartActivityName;
        private String tableName;


        public InnerImageButtonOpration(String imageAddress, String imageClickStartActivityName, String tableName) {
            this.imageAddress = imageAddress;
            this.imageClickStartActivityName = imageClickStartActivityName;
            this.tableName = tableName;
        }

        public InnerImageButtonOpration(String imageAddress, String imageClickStartActivityName) {
            this.imageAddress = imageAddress;
            this.imageClickStartActivityName = imageClickStartActivityName;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public InnerImageButtonOpration() {
        }

        public String getImageAddress() {
            return imageAddress;
        }

        public void setImageAddress(String imageAddress) {
            this.imageAddress = imageAddress;
        }

        public String getImageClickStartActivityName() {
            return imageClickStartActivityName;
        }

        public void setImageClickStartActivityName(String imageClickStartActivityName) {
            this.imageClickStartActivityName = imageClickStartActivityName;
        }
    }


    /**
     * 内部普通的button的点击事件，
     */
   public static class InnerCommandButtonOpration {

        private String imageAddress;
        private String imageClickStartActivityName;
        private String name;
        private String tableName;

        /**
         * @param imageAddress                定义了图片的地址
         * @param imageClickStartActivityName 点击视图启动的activity的名称
         * @param name                        按钮的名称
         * @param tableName                   具体的执行的操作
         */
        public InnerCommandButtonOpration(String imageAddress, String imageClickStartActivityName, String name, String tableName) {
            this.imageAddress = imageAddress;
            this.imageClickStartActivityName = imageClickStartActivityName;
            this.name = name;
            this.tableName = tableName;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public InnerCommandButtonOpration() {
        }


        public String getImageAddress() {
            return imageAddress;
        }

        public void setImageAddress(String imageAddress) {
            this.imageAddress = imageAddress;
        }

        public String getImageClickStartActivityName() {
            return imageClickStartActivityName;
        }

        public void setImageClickStartActivityName(String imageClickStartActivityName) {
            this.imageClickStartActivityName = imageClickStartActivityName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
