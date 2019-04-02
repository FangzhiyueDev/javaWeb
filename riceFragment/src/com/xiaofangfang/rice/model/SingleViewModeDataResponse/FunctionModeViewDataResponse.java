package com.xiaofangfang.rice.model.SingleViewModeDataResponse;


import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.FunctionModeViewDataBean;

public class FunctionModeViewDataResponse extends DataResponse {

    private FunctionModeViewDataBean functionModeViewDataBean;

    public FunctionModeViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName, FunctionModeViewDataBean functionModeViewDataBean, int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName,additionLocationIndex);
        this.functionModeViewDataBean = functionModeViewDataBean;
    }

    public FunctionModeViewDataResponse(FunctionModeViewDataBean functionModeViewDataBean) {
        this.functionModeViewDataBean = functionModeViewDataBean;
    }

    public FunctionModeViewDataResponse(){

    }



    public FunctionModeViewDataBean getFunctionModeViewDataBean() {
        return functionModeViewDataBean;
    }

    public void setFunctionModeViewDataBean(FunctionModeViewDataBean functionModeViewDataBean) {
        this.functionModeViewDataBean = functionModeViewDataBean;
    }

}
