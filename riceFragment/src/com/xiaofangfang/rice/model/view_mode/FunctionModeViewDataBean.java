package com.xiaofangfang.rice.model.view_mode;


import java.util.List;

/**
 * 功能模块对应的视图封装
 */
public class FunctionModeViewDataBean {


    private String title;
    private List<SingleData> singleDataList;

    public FunctionModeViewDataBean(String title, List<SingleData> singleDataList) {
        this.title = title;
        this.singleDataList = singleDataList;
    }


    public FunctionModeViewDataBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 单个实体对象，定义了图片的地址，点击的启动的activity的名称，描述，具体的操作细节
     * tableName定义了操作的具体细节，也就是定义了如何进行操作
     */
    public static class SingleData extends DataBean {

        private String tableName;

        public SingleData(String tableName) {
            this.tableName = tableName;
        }

        public SingleData(String imageAddress, String clickStartActivityName, String describute, String tableName) {
            super(imageAddress, clickStartActivityName, describute);
            this.tableName = tableName;
        }

        public SingleData() {

        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }
    }


}
