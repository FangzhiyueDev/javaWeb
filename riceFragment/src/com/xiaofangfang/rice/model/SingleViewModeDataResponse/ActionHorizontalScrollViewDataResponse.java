package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.ActionHorizontalScrollViewDataBean;

/**
 * 对于每一个活动滚动视图的数据响应来说，
 * 里面的所有的视图都应该是可以点击的，也就是可以响应的
 * 所以对于每一个dataBean都会存在区分操作的数据表
 */
public class ActionHorizontalScrollViewDataResponse extends DataResponse {

    private ActionHorizontalScrollViewDataBean actionHorizontalScrollViewDataBean;


    public ActionHorizontalScrollViewDataResponse(StatusResponseJson statusResponseJson,
                                                  String consumeViewName, String parentViewName,
                                                  ActionHorizontalScrollViewDataBean actionHorizontalScrollViewDataBean,
                                                  int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName, additionLocationIndex);
        this.actionHorizontalScrollViewDataBean = actionHorizontalScrollViewDataBean;
    }

    public ActionHorizontalScrollViewDataResponse(ActionHorizontalScrollViewDataBean actionHorizontalScrollViewDataBean, String tableName) {
        this.actionHorizontalScrollViewDataBean = actionHorizontalScrollViewDataBean;
    }

    public ActionHorizontalScrollViewDataBean getActionHorizontalScrollViewDataBean() {
        return actionHorizontalScrollViewDataBean;
    }

    public void setActionHorizontalScrollViewDataBean(ActionHorizontalScrollViewDataBean actionHorizontalScrollViewDataBean) {
        this.actionHorizontalScrollViewDataBean = actionHorizontalScrollViewDataBean;
    }

    public ActionHorizontalScrollViewDataResponse() {

    }

}
