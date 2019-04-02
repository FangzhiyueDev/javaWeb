package com.fang.model;

/**
 * 日记的部分
 * @author fang
 *
 */
public class DayNote {
	private String content;
	private String publishTime;
	private int authorid;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public DayNote(String content, String publishTime, int authorid) {
		super();
		this.content = content;
		this.publishTime = publishTime;
		this.authorid = authorid;
	}
	
	public DayNote() {
		
	}
}
