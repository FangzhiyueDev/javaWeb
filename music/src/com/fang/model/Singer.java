package com.fang.model;

public class Singer {
	
	private int id;
	private String name;
	private String describute;
	private String image;
	
	
	public Singer(int id, String name, String describute, String image) {
		super();
		this.id = id;
		this.name = name;
		this.describute = describute;
		this.image = image;
	}
	
	
	public Singer() {
		// TODO Auto-generated constructor stub
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


	public String getDescribute() {
		return describute;
	}


	public void setDescribute(String describute) {
		this.describute = describute;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	

}
