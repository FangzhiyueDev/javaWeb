package com.xiaofangfang.rice.model;


/**
 * 手机号码的封装类
 */
public class PhoneNumber {

	   private String phoneNumber;
	    private String address;
	    private String clickStartActivityName;
	    private String tableName;

	    public PhoneNumber(String phoneNumber, String address,String clickStartActivityName,String tableName) {
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	        this.clickStartActivityName=clickStartActivityName;
	        this.tableName=tableName;
	    }

	    public PhoneNumber() {
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
}
