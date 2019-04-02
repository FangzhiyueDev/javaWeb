package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.PhoneDisplayViewDataBean;
import com.xiaofangfang.rice.model.view_mode.PhoneSaleViewDataBean;

public class PhoneDisplayViewDataResponse extends DataResponse {

    private PhoneDisplayViewDataBean phoneDisplayViewDataBean;

    public PhoneDisplayViewDataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName,
                                        PhoneDisplayViewDataBean phoneDisplayViewDataBean,
                                        int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName, additionLocationIndex);
        this.phoneDisplayViewDataBean = phoneDisplayViewDataBean;
    }


    public PhoneDisplayViewDataResponse(PhoneDisplayViewDataBean phoneDisplayViewDataBean) {
        this.phoneDisplayViewDataBean = phoneDisplayViewDataBean;
    }

    public PhoneDisplayViewDataResponse() {

    }

    public PhoneDisplayViewDataBean getPhoneDisplayViewDataBean() {
        return phoneDisplayViewDataBean;
    }

    public void setPhoneDisplayViewDataBean(PhoneDisplayViewDataBean phoneDisplayViewDataBean) {
        this.phoneDisplayViewDataBean = phoneDisplayViewDataBean;
    }
}
