package com.fang.model;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class Picture {

	private int authorid;
	private String pictureAddress;
	private String uploadTime;
	private int pictureid;
	@Override
	public String toString() {
		return "Picture [authorid=" + authorid + ", pictureAddress=" + pictureAddress + ", uploadTime=" + uploadTime
				+ ", pictureid=" + pictureid + "]";
	}
	public Picture(int authorid, String pictureAddress, String uploadTime, int pictureid) {
		super();
		this.authorid = authorid;
		this.pictureAddress = pictureAddress;
		this.uploadTime = uploadTime;
		this.pictureid = pictureid;
	}
	
	
	public Picture() {
		// TODO Auto-generated constructor stub
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getPictureAddress() {
		return pictureAddress;
	}
	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public int getPictureid() {
		return pictureid;
	}
	public void setPictureid(int pictureid) {
		this.pictureid = pictureid;
	}
	
	
	
	
}
