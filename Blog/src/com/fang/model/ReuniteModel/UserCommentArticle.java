package com.fang.model.ReuniteModel;

import com.fang.model.ArticleComment;
import com.fang.model.User;

public class UserCommentArticle extends User {

	private ArticleComment articleComment;

	public ArticleComment getArticleComment() {
		return articleComment;
	}

	public void setArticleComment(ArticleComment articleComment) {
		this.articleComment = articleComment;
	}
	
	
	public UserCommentArticle(ArticleComment articleComment) {
		this.articleComment=articleComment;
	}
	
	
	public UserCommentArticle(String picture,int userid,String name,String content,String commentTime) {
		super(name, userid, picture);
		this.articleComment=new ArticleComment(userid, content, -1, null, commentTime);
	}
	
	
	
}
