package com.fang.model;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class ReadRecords {

	private int readRecordsid;
	private int userid;
	private String articlepublishTime;
	@Override
	public String toString() {
		return "ReadRecords [readRecordsid=" + readRecordsid + ", userid=" + userid + ", articleublishTime="
				+ articlepublishTime + "]";
	}
	public ReadRecords(int readRecordsid, int userid, String articleublishTime) {
		super();
		this.readRecordsid = readRecordsid;
		this.userid = userid;
		this.articlepublishTime = articleublishTime;
	}
   
	public ReadRecords() {
		// TODO Auto-generated constructor stub
	}
	public int getReadRecordsid() {
		return readRecordsid;
	}
	public void setReadRecordsid(int readRecordsid) {
		this.readRecordsid = readRecordsid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getArticlepublishTime() {
		return articlepublishTime;
	}
	public void setArticlepublishTime(String articlepublishTime) {
		this.articlepublishTime = articlepublishTime;
	}
	
	
}
