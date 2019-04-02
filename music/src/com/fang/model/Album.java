package com.fang.model;

public class Album {
	
	private int id;
	private String name;
	private String image;
	private String author;
	private String type;
	private int playCount;
	
	public Album() {
	
	}

	public Album(int id, String name, String image, String author, String type, int playCount) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.author = author;
		this.type = type;
		this.playCount = playCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	
	
	
	
	
	
	

}
