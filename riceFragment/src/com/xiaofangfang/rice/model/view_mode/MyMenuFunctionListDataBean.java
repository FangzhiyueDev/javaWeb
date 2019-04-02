package com.xiaofangfang.rice.model.view_mode;



import java.util.List;

/**
 * 菜单功能的数据封装
 */
public class MyMenuFunctionListDataBean {


    List<SingleData> singleDataList;


    public MyMenuFunctionListDataBean(List<SingleData> singleDataList) {
        this.singleDataList = singleDataList;
    }


    public MyMenuFunctionListDataBean() {
    }


    public List<SingleData> getSingleDataList() {
        return singleDataList;
    }

    public void setSingleDataList(List<SingleData> singleDataList) {
        this.singleDataList = singleDataList;
    }

    public static class SingleData extends DataBean {
      
    	private String tableName;
    	
        public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public SingleData() {
        }
		

        public SingleData(String imageAddress, String clickStartActivityName, String describute,String tableName) {
        	 super(imageAddress, clickStartActivityName, describute);
			this.tableName = tableName;
		}

		public SingleData(String imageAddress, String clickStartActivityName, String describute) {
            super(imageAddress, clickStartActivityName, describute);
        }
        
        

    }


}
