package com.fang.modelWrapper;

public class MusicMenu {
	
	
	private int albumId;
	private String image;
	private String link;
	private String title1;
	private String title2;
	private String title3;
	
	
	public int getMusic() {
		return albumId;
	}
	public void setMusic(int albumId) {
		this.albumId = albumId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getTitle3() {
		return title3;
	}
	public void setTitle3(String title3) {
		this.title3 = title3;
	}
	public MusicMenu(int albumId, String image, String link, String title1, String title2, String title3) {
		super();
		this.albumId = albumId;
		this.image = image;
		this.link = link;
		this.title1 = title1;
		this.title2 = title2;
		this.title3 = title3;
	}
	
	public MusicMenu() {
		
		
		
	}
	
	
	

}
