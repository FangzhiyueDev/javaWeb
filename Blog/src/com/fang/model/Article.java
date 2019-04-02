package com.fang.model;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.function.Predicate;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Article {
	private String articleDestribute;
	private String articleName;
	private String articlePublishTime;
	private int authorid;
	private String articleAddress;
	private String classfy;
	private String articlePictureAddress;
	@Override
	public String toString() {
		return "article [articleDestribute=" + articleDestribute + ", articleName=" + articleName
				+ ", articlePublishTime=" + articlePublishTime + ", authorid=" + authorid + "]";
	}
	public Article(String articleDestribute, String articleName, String articlePublishTime, int authorid) {
		super();
		this.articleDestribute = articleDestribute;
		this.articleName = articleName;
		this.articlePublishTime = articlePublishTime;
		this.authorid = authorid;
	}
	
	
	public Article() {
	
	}
	
	
	
	
	
	public String getArticlePictureAddress() {
		return articlePictureAddress;
	}
	public void setArticlePictureAddress(String articlePictureAddress) {
		this.articlePictureAddress = articlePictureAddress;
	}
	public Article(String articleDestribute, String articleName, String articlePublishTime, int authorid,
			String articleAddress, String classfy, String articlePictureAddress) {
		super();
		this.articleDestribute = articleDestribute;
		this.articleName = articleName;
		this.articlePublishTime = articlePublishTime;
		this.authorid = authorid;
		this.articleAddress = articleAddress;
		this.classfy = classfy;
		this.articlePictureAddress = articlePictureAddress;
	}
	
	/**
	 * 这个构造函数是对于只需要文章的名称进行显示的构造
	 * @param articleName
	 * @param articlePublishTime
	 */
	public Article(String articleName, String articlePublishTime) {
		this.articleName=articleName;
		this.articlePublishTime=articlePublishTime;
	}
	
	
	public Article(String articleDestribute, String articleName, String articlePublishTime, int authorid,
			String articleAddress, String classfy) {
		super();
		this.articleDestribute = articleDestribute;
		this.articleName = articleName;
		this.articlePublishTime = articlePublishTime;
		this.authorid = authorid;
		this.articleAddress = articleAddress;
		this.classfy = classfy;
	}
	public String getClassfy() {
		return classfy;
	}
	public void setClassfy(String classfy) {
		this.classfy = classfy;
	}
	public Article(String articleDestribute, String articleName, String articlePublishTime, int authorid,
			String articleAddress) {
	
		this.articleDestribute = articleDestribute;
		this.articleName = articleName;
		this.articlePublishTime = articlePublishTime;
		this.authorid = authorid;
		this.articleAddress = articleAddress;
	}
	public Article(Article article) {
		this.articleDestribute =article.getArticleDestribute();
		this.articleName =article.getArticleName();
		this.articlePublishTime = article.getArticlePublishTime();
		this.articlePictureAddress=article.articlePictureAddress;
		this.classfy=article.getClassfy();
		this.authorid = article.getAuthorid();
		this.articleAddress = article.getArticleAddress();
	}
	public String getArticleAddress() {
		return articleAddress;
	}
	public void setArticleAddress(String articleAddress) {
		this.articleAddress = articleAddress;
	}
	public String getArticleDestribute() {
		return articleDestribute;
	}
	public void setArticleDestribute(String articleDestribute) {
		this.articleDestribute = articleDestribute;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticlePublishTime() {
		return articlePublishTime;
	}
	public void setArticlePublishTime(String articlePublishTime) {
		this.articlePublishTime = articlePublishTime;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	
	
	
}
