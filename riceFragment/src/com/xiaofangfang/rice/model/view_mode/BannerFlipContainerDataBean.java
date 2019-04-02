package com.xiaofangfang.rice.model.view_mode;

import java.util.List;

/**
 * 轮播视图的数据封装
 */
public class BannerFlipContainerDataBean {


    List<SingleData> singleDataList;


    public BannerFlipContainerDataBean(List<SingleData> singleDataList) {
        this.singleDataList = singleDataList;
    }


    public BannerFlipContainerDataBean() {
    }


    public List<SingleData> getSingleDataList() {
        return singleDataList;
    }

    public void setSingleDataList(List<SingleData> singleDataList) {
        this.singleDataList = singleDataList;
    }

    public static class SingleData extends DataBean {

        private String tableName;

        public SingleData(String tableName) {
            this.tableName = tableName;
        }

        public SingleData(String imageAddress, String clickStartActivityName, String describute, String tableName) {
            super(imageAddress, clickStartActivityName, describute);
            this.tableName = tableName;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public SingleData() {
        }


    }

}
