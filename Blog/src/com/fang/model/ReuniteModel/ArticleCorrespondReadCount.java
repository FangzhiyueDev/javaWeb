package com.fang.model.ReuniteModel;

import com.fang.model.Article;

/**
 * 文章以及文章对应的阅读数量
 * @author fang
 *
 */
public class ArticleCorrespondReadCount extends Article {

	private int count;

	public ArticleCorrespondReadCount(Article article,int count) {
	 super(article);
	 this.count=count;
	}
	
	public ArticleCorrespondReadCount() {
		// TODO Auto-generated constructor stub
	}

	public ArticleCorrespondReadCount(int count){
		this.count=count;
	}

	public ArticleCorrespondReadCount(String articleDestribute, String articleName, String articlePublishTime,
			int authorid, String articleAddress, String classfy, String articlePictureAddress,int count) {
		super(articleDestribute, articleName, articlePublishTime, authorid, articleAddress, classfy, articlePictureAddress);
		this.count=count;
	}
	
	
	public ArticleCorrespondReadCount(String articleName, String articlePublishTime,int count) {
		super(articleName,articlePublishTime);
		this.count=count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
   
}
