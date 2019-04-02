package com.fang.rice.model;

public class FeedBack {
	
	private String user;
	private String content;
	
	
	
	
	
	public FeedBack(String user, String content) {
		super();
		this.user = user;
		this.content = content;
	}
	
	public FeedBack() {
		
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	
	
}
