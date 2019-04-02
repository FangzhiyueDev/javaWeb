package com.fang.model;

public class VideoWatch {
	
	private int userid;
	private String videoAddress;
	private int videoWatchId;
	private String watchTime;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getVideoAddress() {
		return videoAddress;
	}
	public void setVideoAddress(String videoAddress) {
		this.videoAddress = videoAddress;
	}
	public int getVideoWatchId() {
		return videoWatchId;
	}
	public void setVideoWatchId(int videoWatchId) {
		this.videoWatchId = videoWatchId;
	}
	public String getWatchTime() {
		return watchTime;
	}
	public void setWatchTime(String watchTime) {
		this.watchTime = watchTime;
	}
	@Override
	public String toString() {
		return "VideoWatch [userid=" + userid + ", videoAddress=" + videoAddress + ", videoWatchId=" + videoWatchId
				+ ", watchTime=" + watchTime + "]";
	}
	public VideoWatch(int userid, String videoAddress, int videoWatchId, String watchTime) {
		super();
		this.userid = userid;
		this.videoAddress = videoAddress;
		this.videoWatchId = videoWatchId;
		this.watchTime = watchTime;
	}
     
	public VideoWatch() {
		// TODO Auto-generated constructor stub
	}
}
