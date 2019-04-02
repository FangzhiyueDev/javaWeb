package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.PhoneSaleViewDataBean;

public class PhoneSaleViewDataResponse extends DataResponse {

    private PhoneSaleViewDataBean phoneSaleViewDataBean;

    public PhoneSaleViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName,
                                     String parentViewName, PhoneSaleViewDataBean phoneSaleViewDataBean,
                                     int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName, additionLocationIndex);
        this.phoneSaleViewDataBean = phoneSaleViewDataBean;
    }

    public PhoneSaleViewDataResponse(PhoneSaleViewDataBean phoneSaleViewDataBean, String tableName) {
        this.phoneSaleViewDataBean = phoneSaleViewDataBean;
    }

    public PhoneSaleViewDataResponse() {

    }


    public PhoneSaleViewDataBean getPhoneSaleViewDataBean() {
        return phoneSaleViewDataBean;
    }

    public void setPhoneSaleViewDataBean(PhoneSaleViewDataBean phoneSaleViewDataBean) {
        this.phoneSaleViewDataBean = phoneSaleViewDataBean;
    }


}
