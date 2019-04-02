package com.fang.model;

public class Link {
	
	private String linkAddress;
	private int linkId;
	private int authorid;
	private String content;
	@Override
	public String toString() {
		return "Link [linkAddress=" + linkAddress + ", linkId=" + linkId + ", authorid=" + authorid + ", content="
				+ content + "]";
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
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
	public Link(String linkAddress, int linkId, int authorid, String content) {
		super();
		this.linkAddress = linkAddress;
		this.linkId = linkId;
		this.authorid = authorid;
		this.content = content;
	}
	
	public Link() {
		// TODO Auto-generated constructor stub
	}
	
}
