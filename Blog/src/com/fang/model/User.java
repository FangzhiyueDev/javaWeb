package com.fang.model;

public class User {

	private String name;
	private String qqNumber;
	private String occupation;
	private String hobby;
	private String likeSinger;
	private String likeMusic;
	private String motto;
	private int userid;
	private String picture;
	private String password;
	private String nikeName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getLikeSinger() {
		return likeSinger;
	}
	public void setLikeSinger(String likeSinger) {
		this.likeSinger = likeSinger;
	}
	public String getLikeMusic() {
		return likeMusic;
	}
	public void setLikeMusic(String likeMusic) {
		this.likeMusic = likeMusic;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", qqNumber=" + qqNumber + ", occupation=" + occupation + ", hobby=" + hobby
				+ ", likeSinger=" + likeSinger + ", likeMusic=" + likeMusic + ", motto=" + motto + ", userid=" + userid
				+ ", picture=" + picture + ", password=" + password + ", nikeName=" + nikeName + ", getName()="
				+ getName() + ", getQqNumber()=" + getQqNumber() + ", getOccupation()=" + getOccupation()
				+ ", getHobby()=" + getHobby() + ", getLikeSinger()=" + getLikeSinger() + ", getLikeMusic()="
				+ getLikeMusic() + ", getMotto()=" + getMotto() + ", getUserid()=" + getUserid() + ", getPicture()="
				+ getPicture() + ", getPassword()=" + getPassword() + ", getNikeName()=" + getNikeName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public User(String name, String qqNumber, String occupation, String hobby, String likeSinger, String likeMusic,
			String motto, int userid, String picture, String password, String nikeName) {
		super();
		this.name = name;
		this.qqNumber = qqNumber;
		this.occupation = occupation;
		this.hobby = hobby;
		this.likeSinger = likeSinger;
		this.likeMusic = likeMusic;
		this.motto = motto;
		this.userid = userid;
		this.picture = picture;
		this.password = password;
		this.nikeName = nikeName;
	}
	
	public User(String userName,int userid,String picture) {
		this.userid=userid;
		this.name=userName;
		this.picture=picture;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userid, String password) {
		this.userid=userid;
		this.password=password;
	}
	
	
}
