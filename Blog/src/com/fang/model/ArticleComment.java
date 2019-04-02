package com.fang.model;

public class ArticleComment {

	private int userid;
	private String content;
	private int articleCommentid;
	private String articlePublishTime;
	private String commentTime;
	@Override
	public String toString() {
		return "ArticleComment [userid=" + userid + ", content=" + content + ", articleCommentid=" + articleCommentid
				+ ", articlePublishTime=" + articlePublishTime + "]";
	}

	
	
	public ArticleComment(int userid, String content, int articleCommentid, String articlePublishTime,
			String commentTime) {
		this.userid = userid;
		this.content = content;
		this.articleCommentid = articleCommentid;
		this.articlePublishTime = articlePublishTime;
		this.commentTime = commentTime;
	}
	
	public ArticleComment() {
		// TODO Auto-generated constructor stub
	}



	public String getCommentTime() {
		return commentTime;
	}



	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}



	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getArticleCommentid() {
		return articleCommentid;
	}
	public void setArticleCommentid(int articleCommentid) {
		this.articleCommentid = articleCommentid;
	}
	public String getArticlePublishTime() {
		return articlePublishTime;
	}
	public void setArticlePublishTime(String articlePublishTime) {
		this.articlePublishTime = articlePublishTime;
	}
	
	
}
