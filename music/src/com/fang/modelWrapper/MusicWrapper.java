package com.fang.modelWrapper;

import com.fang.model.Music;

public class MusicWrapper {
	
	
	private int musicId;
	private String singerName;
	private String playTime;
	private String musicName;
	private String image;
	private String albumName;
	private String musicAddress;
	
	/**
	 * 这个的作用是用来设置一些music的相关数据
	 */
	private Music music;
	
	public MusicWrapper() {
	
	}
	
	public  void setMusic(Music music) {
	this.music=music;
	}
	
	public Music getMusic() {
		return music;
	}
	
	
	public String getAlbumName() {
		return albumName;
	}
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	

	public String getMusicAddress() {
		return musicAddress;
	}
	
	
	public void setMusicAddress(String musicAddress) {
		this.musicAddress = musicAddress;
	}
		
		
	public MusicWrapper(int musicId, String singerName, String playTime, String musicName,String image) {
		super();
		this.musicId = musicId;
		this.image=image;
		this.singerName = singerName;
		this.playTime = playTime;
		this.musicName = musicName;
	}
	
	
	public MusicWrapper(String musicAddress,int musicId, String singerName, String playTime, String musicName,String image) {
		super();
		this.musicId = musicId;
		this.musicAddress=musicAddress;
		this.image=image;
		this.singerName = singerName;
		this.playTime = playTime;
		this.musicName = musicName;
	}
	
	
	public MusicWrapper(int musicId, String singerName, String playTime, String musicName,String image,String aubumName) {
		super();
		this.musicId = musicId;
		this.image=image;
		this.singerName = singerName;
		this.playTime = playTime;
		this.musicName = musicName;
		this.albumName=aubumName;
	}
	
	
	public MusicWrapper(int musicId, String singerName, String playTime, String musicName,String image,String aubumName,String musicAddress) {
		super();
		this.musicId = musicId;
		this.image=image;
		this.musicAddress=musicAddress;
		this.singerName = singerName;
		this.playTime = playTime;
		this.musicName = musicName;
		this.albumName=aubumName;
	}


	
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}


	@Override
	public String toString() {
		return "MusicWrapper [musicId=" + musicId + ", singerName=" + singerName + ", playTime=" + playTime
				+ ", musicName=" + musicName + "]";
	}

   
	
	
	
	

}
