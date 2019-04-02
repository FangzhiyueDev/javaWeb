package com.fang.model.ReuniteModel;

import java.util.List;

import com.fang.model.Video;

/**
 * 文章的分类信息的数据
 * 
 * @author fang
 *
 */
public class VideoClass  {
	
	private String classfy;
	private List<Video> videos;

	public String getClassfy() {
		return classfy;
	}

	public void setClassfy(String classfy) {
		this.classfy = classfy;
	}
	
	public VideoClass() {
		// TODO Auto-generated constructor stub
	}
	
	public VideoClass(List<Video> videos,String classfy) {
		this.classfy=classfy;
		this.videos=videos;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	


	
	
	
	
	
	
}
