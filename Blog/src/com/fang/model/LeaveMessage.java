package com.fang.model;

public class LeaveMessage {
	
	private int userid;
	private int leaveMessageid;
	private String leaveMessageTime;
	private String content;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getLeaveMessageid() {
		return leaveMessageid;
	}
	public void setLeaveMessageid(int leaveMessageid) {
		this.leaveMessageid = leaveMessageid;
	}
	public String getLeaveMessageTime() {
		return leaveMessageTime;
	}
	public void setLeaveMessageTime(String leaveMessageTime) {
		this.leaveMessageTime = leaveMessageTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "LeaveMessage [userid=" + userid + ", leaveMessageid=" + leaveMessageid + ", leaveMessageTime="
				+ leaveMessageTime + ", content=" + content + "]";
	}
	public LeaveMessage(int userid, int leaveMessageid, String leaveMessageTime, String content) {
		super();
		this.userid = userid;
		this.leaveMessageid = leaveMessageid;
		this.leaveMessageTime = leaveMessageTime;
		this.content = content;
	}
	
	
}
