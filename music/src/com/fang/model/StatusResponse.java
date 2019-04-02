package com.fang.model;

public class StatusResponse {

	private int responseCode;
	private String responseContent;
	
	
	
	public static StatusResponse response_sucessful=new StatusResponse(0, "响应成功");
	
	public static StatusResponse response_error=new StatusResponse(1, "响应失败");
	
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}
	
	
	public StatusResponse(int responseCode, String responseContent) {
		super();
		this.responseCode = responseCode;
		this.responseContent = responseContent;
	}

	public StatusResponse() {
		
	}
	
	
	public StatusResponse(StatusResponse statusResponse) {
		this.responseCode=statusResponse.responseCode;
		this.responseContent=statusResponse.responseContent;
	}
	
	
}
