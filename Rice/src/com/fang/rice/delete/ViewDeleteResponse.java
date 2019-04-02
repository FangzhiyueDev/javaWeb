package com.fang.rice.delete;

import com.fang.rice.insertResponse.ViewResponse;
import com.fang.viewdataBean.DataResponse;

public class ViewDeleteResponse extends ViewResponse{

	
	public ViewDeleteResponse(int index,int oprateCode) {
		this.index=index;
		this.oprateCode=oprateCode;
	}
	
	
	@Override
	public void setResponse(DataResponse dataResponse) {
		
		
	}

	@Override
	public DataResponse getResponse() {
		// TODO Auto-generated method stub
		return null;
	}

}
