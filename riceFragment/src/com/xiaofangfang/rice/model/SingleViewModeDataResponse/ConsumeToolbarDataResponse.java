package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.ConsumeToolbarDataBean;

/**
 * 自定义toolbar的自动以视图响应对象，由于内部不存在点击事件的处理，所以没有传递具体的数据
 */
public class ConsumeToolbarDataResponse extends DataResponse {

    private ConsumeToolbarDataBean consumeToolbarDataBean;

    public ConsumeToolbarDataResponse(StatusResponseJson statusResponseJson, String consumeViewName,
                                      String parentViewName, ConsumeToolbarDataBean consumeToolbarDataBean,
                                      int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName,additionLocationIndex);
        this.consumeToolbarDataBean = consumeToolbarDataBean;
    }

    public ConsumeToolbarDataResponse(ConsumeToolbarDataBean consumeToolbarDataBean) {
        this.consumeToolbarDataBean = consumeToolbarDataBean;
    }

    public ConsumeToolbarDataResponse() {
    }


    public ConsumeToolbarDataBean getConsumeToolbarDataBean() {
        return consumeToolbarDataBean;
    }

    public void setConsumeToolbarDataBean(ConsumeToolbarDataBean consumeToolbarDataBean) {
        this.consumeToolbarDataBean = consumeToolbarDataBean;
    }
}
