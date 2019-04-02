package com.fang.model.ReuniteModel;

import java.util.List;

import com.fang.model.Article;

/***
 * 对文章进行特定分类的model
 * @author fang
 *
 */
public class ArticleClass {

	private String  classfy;
	private List<Article> articles;
	public ArticleClass(String classfy, List<Article> articles) {
		this.classfy = classfy;
		this.articles = articles;
	}
	public ArticleClass() {
		// TODO Auto-generated constructor stub
	}
	public String getClassfy() {
		return classfy;
	}
	public void setClassfy(String classfy) {
		this.classfy = classfy;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "ArticleClass [classfy=" + classfy + ", articles=" + articles + "]";
	}
	
	
	
	
	
	
}
