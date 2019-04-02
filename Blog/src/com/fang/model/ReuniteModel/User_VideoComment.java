package com.fang.model.ReuniteModel;

import com.fang.model.ArticleComment;
import com.fang.model.User;
import com.fang.model.VideoComment;

public class User_VideoComment {
	
	private User user;
	private VideoComment videoComment;
	
	public User_VideoComment(User user, VideoComment videoComment) {
		super();
		this.user = user;
		this.videoComment = videoComment;
	}
	
	public User_VideoComment() {
	
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public VideoComment getVideoComment() {
		return videoComment;
	}

	public void setVideoComment(VideoComment videoComment) {
		this.videoComment = videoComment;
	}

	@Override
	public String toString() {
		return "User_ArticleComment [user=" + user + ", articleComment=" + videoComment + "]";
	}
	
	
	
	

}
