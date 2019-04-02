package com.fang.model;

public class Author {

	private int authorid;
	private String nikeName;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", nikeName=" + nikeName + "]";
	}
	public Author(int authorid, String nikeName) {
		super();
		this.authorid = authorid;
		this.nikeName = nikeName;
	}
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
}
