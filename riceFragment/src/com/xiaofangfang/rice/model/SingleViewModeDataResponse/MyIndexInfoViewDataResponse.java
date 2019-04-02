package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.MyIndexInfoViewDataBean;

public class MyIndexInfoViewDataResponse extends DataResponse {

    private MyIndexInfoViewDataBean myIndexInfoViewDataBean;

    public MyIndexInfoViewDataResponse(MyIndexInfoViewDataBean myIndexInfoViewDataBean) {
        this.myIndexInfoViewDataBean = myIndexInfoViewDataBean;
    }

    public MyIndexInfoViewDataResponse() {
    }

    public MyIndexInfoViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName, MyIndexInfoViewDataBean myIndexInfoViewDataBean, int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName, additionLocationIndex);
        this.myIndexInfoViewDataBean = myIndexInfoViewDataBean;
    }


  
    
    
}
