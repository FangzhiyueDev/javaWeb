package com.xiaofangfang.rice.model;


/*
 * json的响应对象
 */
public class StatusResponseJson {
	
	public static final StatusResponseJson SUCESSFUL=new StatusResponseJson(0, "用户创建成功");
	
	/**
	 * 一般就是mysql数据错误
	 */
	public static final StatusResponseJson ERROR=new StatusResponseJson(1,"服务器内部错误");
	
	public static final StatusResponseJson EXIST=new StatusResponseJson(2, "用户已经存在");
	
	/**
	 * 登录成功
	 */
	public static final StatusResponseJson LOGIN_SUCESSFUL=new StatusResponseJson(3,"登录成功");
	
	/**
	 * 登录的响应
	 */
	public static final StatusResponseJson LOGIN_ERROR=new StatusResponseJson(4,"登录失败,账户或密码错误");
	
	/**
	 * 数据响应成功
	 */
	public static final StatusResponseJson DATA_RESPONSE_SUCESSFUL=new StatusResponseJson(5,"数据响应成功");
	
	/**
	 * 普通用户浏览过了赛选过滤的功能
	 */
	public static final StatusResponseJson USER_HAS_BROWSER=new StatusResponseJson(6,"普通用户已经浏览过了");
	/**
	 * 
	 */
	
	
	
	private int responseCode;
	
	private String responseContent;

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

	public StatusResponseJson(int responseCode, String responseContent) {
		super();
		this.responseCode = responseCode;
		this.responseContent = responseContent;
	}
	
	public StatusResponseJson(StatusResponseJson sResponseJson) {
		this.responseCode=sResponseJson.responseCode;
		this.responseContent=sResponseJson.responseContent;
	}

	
	
	

}
