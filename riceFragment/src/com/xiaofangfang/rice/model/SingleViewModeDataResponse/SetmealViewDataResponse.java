package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.SetmealViewDataBean;

public class SetmealViewDataResponse extends DataResponse {

    private SetmealViewDataBean setmealViewDataBean;

    public SetmealViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName, int additionLocationIndex, SetmealViewDataBean setmealViewDataBean) {
        super(statusResponseJson, consumeViewName, parentViewName, additionLocationIndex);
        this.setmealViewDataBean = setmealViewDataBean;
    }

    public SetmealViewDataResponse(SetmealViewDataBean setmealViewDataBean) {
        this.setmealViewDataBean = setmealViewDataBean;
    }

    public SetmealViewDataBean getSetmealViewDataBean() {
        return setmealViewDataBean;
    }

    public void setSetmealViewDataBean(SetmealViewDataBean setmealViewDataBean) {
        this.setmealViewDataBean = setmealViewDataBean;
    }
}
