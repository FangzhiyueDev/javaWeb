package com.fang.rice.model;


/**
 * 用户
 * @author fang
 *
 */
public class User {
	private String telNumber;
	private String userName;
	private String password;
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String telNumber, String userName, String password) {
		
		this.telNumber = telNumber;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userId) {
		this.telNumber=userId;
	}
	
	
	

	

}
