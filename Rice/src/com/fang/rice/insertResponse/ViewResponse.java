package com.fang.rice.insertResponse;

import com.fang.viewdataBean.DataResponse;

public abstract class ViewResponse {


    protected int index;

    protected int oprateCode;


    public abstract void setResponse(DataResponse dataResponse);

    public abstract DataResponse getResponse();


}
