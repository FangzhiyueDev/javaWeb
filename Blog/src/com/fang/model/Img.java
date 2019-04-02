package com.fang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fang.dao.DbHelper;

/**
 * 封装的IMg的javaBean
 * @author fang
 *
 */
public class Img {

	private int authorid;
	private String pictureAddress;
	private String uploadTime;
	private int pictureid;
	
	
	
	
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




	public Img(int authorid, String pictureAddress, String uploadTime, int pictureid) {
	
		this.authorid = authorid;
		this.pictureAddress = pictureAddress;
		this.uploadTime = uploadTime;
		this.pictureid = pictureid;
	}

	public Img() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Img [authorid=" + authorid + ", pictureAddress=" + pictureAddress + ", uploadTime=" + uploadTime
				+ ", pictureid=" + pictureid + "]";
	}
	
	
	
	
	
}
