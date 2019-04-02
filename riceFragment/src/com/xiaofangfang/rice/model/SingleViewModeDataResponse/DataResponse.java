package com.xiaofangfang.rice.model.SingleViewModeDataResponse;


import com.xiaofangfang.rice.model.StatusResponseJson;

/**
 * 响应数据的调用接口
 */
public class DataResponse {

    private StatusResponseJson statusResponseJson;
    private String consumeViewName;
    private String parentViewName;
    private int additionLocationIndex;


    public DataResponse(StatusResponseJson statusResponseJson, String consumeViewName, String parentViewName, int additionLocationIndex) {
        this.statusResponseJson = statusResponseJson;
        this.consumeViewName = consumeViewName;
        this.parentViewName = parentViewName;
        this.additionLocationIndex = additionLocationIndex;
    }

    public int getAdditionLocationIndex() {
        return additionLocationIndex;
    }

    public void setAdditionLocationIndex(int additionLocationIndex) {
        this.additionLocationIndex = additionLocationIndex;
    }

    public String getConsumeViewName() {
        return consumeViewName;
    }

    public void setConsumeViewName(String consumeViewName) {
        this.consumeViewName = consumeViewName;
    }

    public String getParentViewName() {
        return parentViewName;
    }

    public void setParentViewName(String parentViewName) {
        this.parentViewName = parentViewName;
    }

    public DataResponse() {
    }

    public StatusResponseJson getStatusResponseJson() {
        return statusResponseJson;
    }

    public void setStatusResponseJson(StatusResponseJson statusResponseJson) {
        this.statusResponseJson = statusResponseJson;
    }
}
