package com.fang.model;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Video {
	

	private String videoName;
	private String videoAddress;
	private String videoSize;
	private String uploadTime;
	private String videoNote;
	private String videoDestribute;
	private int authorid;
	private String classfy;
	private String classOrder;
	
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoAddress() {
		return videoAddress;
	}
	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}
	public String getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(String videoSize) {
		this.videoSize = videoSize;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getVideoNote() {
		return videoNote;
	}
	public void setVideoNote(String videoNote) {
		this.videoNote = videoNote;
	}
	public String getVideoDestribute() {
		return videoDestribute;
	}
	public void setVideoDestribute(String videoDestribute) {
		this.videoDestribute = videoDestribute;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	@Override
	public String toString() {
		return "Video [videoName=" + videoName + ", videoAddress=" + videoAddress + ", videoSize=" + videoSize
				+ ", uploadTime=" + uploadTime + ", videoNote=" + videoNote + ", videoDestribute=" + videoDestribute
				+ ", authorid=" + authorid + "]";
	}

	
	public Video(String videoName, String videoAddress, String videoSize, String uploadTime, String videoNote,
			String videoDestribute, int authorid, String classfy, String classOrder) {
		super();
		this.videoName = videoName;
		this.videoAddress = videoAddress;
		this.videoSize = videoSize;
		this.uploadTime = uploadTime;
		this.videoNote = videoNote;
		this.videoDestribute = videoDestribute;
		this.authorid = authorid;
		this.classfy = classfy;
		this.classOrder = classOrder;
	}
	public Video() {
		
	}
	public Video(Video video) {
		this.videoName = video.videoName;
		this.videoAddress = video.videoAddress;
		this.videoSize = video.videoSize;
		this.uploadTime = video.uploadTime;
		this.videoNote = video.videoNote;
		this.videoDestribute = video.videoDestribute;
		this.authorid = video.authorid;
		this.classfy = video.classfy;
		this.classOrder = video.classOrder;
	}
	

}
