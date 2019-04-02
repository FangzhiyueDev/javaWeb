package com.fang.model.ReuniteModel;

import com.fang.model.Article;
import com.fang.model.Author;
import com.fang.model.User;

/**
 * 文章对应的作者信息
 * @author fang
 *
 */
public class ArticleUser extends Article {
   
	private User user;

	public User getUser() {
		return user;
	}

	public void setAuthor(User user) {
		this.user = user;
	}

	public ArticleUser(String articleDestribute, String articleName, String articlePublishTime, int authorid,
			User user) {
		super(articleDestribute, articleName, articlePublishTime, authorid);
		this.user = user;
	}
	
	public ArticleUser(User user,Article article) {
		super(article);
		this.user=user;
	}
	
}
