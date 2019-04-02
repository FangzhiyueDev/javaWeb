package com.fang.rice.model;

public class VIP {
	
	
	private int vipId;
	private String telNumber;
	private  int vipLevel;
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public VIP(int vipId, String telNumber, int vipLevel) {
		super();
		this.vipId = vipId;
		this.telNumber = telNumber;
		this.vipLevel = vipLevel;
	}
	
	public VIP() {
		// TODO Auto-generated constructor stub
	}
	

}
