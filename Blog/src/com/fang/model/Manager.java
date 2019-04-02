package com.fang.model;

public class Manager {

	private String password;
	private int userid;
	private int managerId;
	private String permission;
	private int authorid;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public Manager(String password, int userid, int managerId, String permission, int authorid) {
		super();
		this.password = password;
		this.userid = userid;
		this.managerId = managerId;
		this.permission = permission;
		this.authorid = authorid;
	}
	@Override
	public String toString() {
		return "Manager [password=" + password + ", userid=" + userid + ", managerId=" + managerId + ", permission="
				+ permission + ", authorid=" + authorid + "]";
	}
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
