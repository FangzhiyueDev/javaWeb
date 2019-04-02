package com.xiaofangfang.rice.model.serverBackResponseData;

import java.util.List;

import javax.xml.crypto.Data;

import com.xiaofangfang.rice.model.SingleViewModeDataResponse.*;

public class ViewModeResponseData {
	
	
	private List viewRootChilds;
	private List viewGroupChilds;
	
	public ViewModeResponseData(List viewRootChilds, List viewGroupChilds) {

		this.viewRootChilds = viewRootChilds;
		this.viewGroupChilds = viewGroupChilds;
	}
	
	public ViewModeResponseData() {
		// TODO Auto-generated constructor stub
	}

	public List getViewRootChilds() {
		return viewRootChilds;
	}

	public void setViewRootChilds(List viewRootChilds) {
		this.viewRootChilds = viewRootChilds;
	}

	public List getViewGroupChilds() {
		return viewGroupChilds;
	}

	public void setViewGroupChilds(List viewGroupChilds) {
		this.viewGroupChilds = viewGroupChilds;
	}
     
	
	
	



}
