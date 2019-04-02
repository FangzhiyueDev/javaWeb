package com.xiaofangfang.rice.model.view_mode;

import java.util.List;

/**
 * 活动滚动视图的封装对象
 */
public class ActionHorizontalScrollViewDataBean {


    List<SingleData> singleDataList;


    public ActionHorizontalScrollViewDataBean(List<SingleData> singleDataList) {
        this.singleDataList = singleDataList;
    }


    public ActionHorizontalScrollViewDataBean() {
    }


    public List<SingleData> getSingleDataList() {
        return singleDataList;
    }

    public void setSingleDataList(List<SingleData> singleDataList) {
        this.singleDataList = singleDataList;
    }

    /**
     * 活动滚动视图内部单条数据的疯长对象
     */
   public static class SingleData extends DataBean {

        private String actionName;
        /**
         * 这个tablename的作用是用来标识具体的操作的，对于
         * {@link #clickStartActivityName}它的作用只是表示了启动的界面，但是不能具体到执行的操作
         * 通过tableName就能定义了活动的具体的操作细节
         */
        private String tableName;

        public SingleData(String imageAddress, String clickStartActivityName, String describute, String actionName, String tableName) {
            super(imageAddress, clickStartActivityName, describute);
            this.actionName = actionName;
            this.tableName = tableName;
        }

        public SingleData() {

        }


        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }
        
        public void setTableName(String tableName) {
			this.tableName = tableName;
		}
        
        public String getTableName() {
			return tableName;
		}

    }

}
