package com.fang.model;

import javax.swing.text.AbstractDocument.Content;

public class Log {

	 private String logTime;
	 private int authorid;
	 private String content;
	 private int logid;
	@Override
	public String toString() {
		return "Log [logTime=" + logTime + ", authorid=" + authorid + ", content=" + content + ", logid=" + logid + "]";
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	public Log(String logTime, int authorid, String content, int logid) {
		super();
		this.logTime = logTime;
		this.authorid = authorid;
		this.content = content;
		this.logid = logid;
	}
	 
	public Log() {
		// TODO Auto-generated constructor stub
	}
}
