package com.fang.model;

public class Proverb {

	private String publishTime;
	private String content;
	private int authorid;
	private int proverbid;
	@Override
	public String toString() {
		return "Proverb [publishTime=" + publishTime + ", content=" + content + ", authorid=" + authorid
				+ ", proverbid=" + proverbid + "]";
	}
	public Proverb(String publishTime, String content, int authorid, int proverbid) {
		super();
		this.publishTime = publishTime;
		this.content = content;
		this.authorid = authorid;
		this.proverbid = proverbid;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public int getProverbid() {
		return proverbid;
	}
	public void setProverbid(int proverbid) {
		this.proverbid = proverbid;
	}
	
	
}
