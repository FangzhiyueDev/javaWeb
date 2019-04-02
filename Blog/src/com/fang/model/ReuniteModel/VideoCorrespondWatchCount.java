package com.fang.model.ReuniteModel;


import com.fang.model.Video;


/**
 * 添加了文章的阅读数量的包装类
 * @author fang
 *
 */
public class VideoCorrespondWatchCount extends Video {
   
	private int count;
	
	public VideoCorrespondWatchCount(Video video,int count) {
		super(video);
		this.count=count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public VideoCorrespondWatchCount() {
	
	}

	public VideoCorrespondWatchCount(String videoName, String videoAddress, String videoSize, String uploadTime,
			String videoNote, String videoDestribute, int authorid, String classfy, String classOrder) {
		super(videoName, videoAddress, videoSize, uploadTime, videoNote, videoDestribute, authorid, classfy, classOrder);
		// TODO Auto-generated constructor stub
	}

	
	public VideoCorrespondWatchCount(String videoName, String videoAddress, String videoSize, String uploadTime,
			String videoNote, String videoDestribute, int authorid, String classfy, String classOrder, int count) {
		super(videoName, videoAddress, videoSize, uploadTime, videoNote, videoDestribute, authorid, classfy,
				classOrder);
		this.count = count;
	}
	
	public VideoCorrespondWatchCount(String videoAddress,String videoName,int count) {
		this(videoName, videoAddress, null, null, null, null, -1, null, null);
		this.count=count;
	}
	
	
	
	
	
	
}
