package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.LiangHaoDisplayViewDataBean;

public class LiangHaoDisplayViewDataResponse extends DataResponse {

    private LiangHaoDisplayViewDataBean liangHaoDisplayViewDataBean;

    public LiangHaoDisplayViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName, LiangHaoDisplayViewDataBean liangHaoDisplayViewDataBean, int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName,additionLocationIndex);
        this.liangHaoDisplayViewDataBean = liangHaoDisplayViewDataBean;
    }

    public LiangHaoDisplayViewDataResponse(LiangHaoDisplayViewDataBean liangHaoDisplayViewDataBean, String tableName) {
        this.liangHaoDisplayViewDataBean = liangHaoDisplayViewDataBean;
    }

    public LiangHaoDisplayViewDataResponse() {

    }


    public LiangHaoDisplayViewDataBean getLiangHaoDisplayViewDataBean() {
        return liangHaoDisplayViewDataBean;
    }

    public void setLiangHaoDisplayViewDataBean(LiangHaoDisplayViewDataBean liangHaoDisplayViewDataBean) {
        this.liangHaoDisplayViewDataBean = liangHaoDisplayViewDataBean;
    }


}
