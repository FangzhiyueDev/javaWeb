package com.fang.model;

public class VideoComment {
	
	private int videoCommentid;
	private int userid;
	private String videoAddress;
	private String content;
	private String commentTime;
	
	
	
	public int getVideoCommentid() {
		return videoCommentid;
	}
	public void setVideoCommentid(int videoCommentid) {
		this.videoCommentid = videoCommentid;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "VideoComment [videoCommentid=" + videoCommentid + ", userid=" + userid + ", videoAddress="
				+ videoAddress + ", content=" + content + "]";
	}


	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public VideoComment(int videoCommentid, int userid, String videoAddress, String content, String commentTime) {
		
		this.videoCommentid = videoCommentid;
		this.userid = userid;
		this.videoAddress = videoAddress;
		this.content = content;
		this.commentTime = commentTime;
	}
	public VideoComment() {
		// TODO Auto-generated constructor stub
	}
	
}
