package com.fang.model;


public class Music {
	
	private int id;
	private String name;
	private int albumId;
	private String image;
	private int singerId;
	private String playTime;
	private int playCount;
	private int classfyId;
	
	
	public Music(int id, String name, int albumId, String image, int singerId, String playTime, int playCount,
			int classfyId) {
		super();
		this.id = id;
		this.name = name;
		this.albumId = albumId;
		this.image = image;
		this.singerId = singerId;
		this.playTime = playTime;
		this.playCount = playCount;
		this.classfyId = classfyId;
	}
	
    public Music() {
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

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getClassfyId() {
		return classfyId;
	}

	public void setClassfyId(int classfyId) {
		this.classfyId = classfyId;
	}
    
    
    
	
	
	
}
