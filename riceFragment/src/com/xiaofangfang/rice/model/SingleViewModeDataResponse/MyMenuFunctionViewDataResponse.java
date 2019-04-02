package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.MyMenuFunctionListDataBean;

public class MyMenuFunctionViewDataResponse extends DataResponse {

    private MyMenuFunctionListDataBean myMenuFunctionListDataBean;

    public MyMenuFunctionViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName, int additionLocationIndex, MyMenuFunctionListDataBean myMenuFunctionListDataBean) {
        super(statusResponseJson, consumeViewName, parentViewName, additionLocationIndex);
        this.myMenuFunctionListDataBean = myMenuFunctionListDataBean;
    }

    public MyMenuFunctionViewDataResponse(MyMenuFunctionListDataBean myMenuFunctionListDataBean) {
        this.myMenuFunctionListDataBean = myMenuFunctionListDataBean;
    }

    public MyMenuFunctionListDataBean getMyMenuFunctionListDataBean() {
        return myMenuFunctionListDataBean;
    }

    public void setMyMenuFunctionListDataBean(MyMenuFunctionListDataBean myMenuFunctionListDataBean) {
        this.myMenuFunctionListDataBean = myMenuFunctionListDataBean;
    }
    
    
    
}
