package com.fang.dbController;



import java.util.List;

import com.fang.model.Article;

/**
 * 提供对文章操作的封装
 * @author fang
 *
 */
public interface ArticleOpration {

	/**
	 * 添加一个文章到数据库中
	 * @param article
	 * @return
	 */
    int addArticle(Article article);
    
    /**
     * 查询所有的文章的数据
     * @return
     */
    List<?> queryAllArticle();
    
    /**
     * 分页查询数据库中的数据
     * @param startPage
     * @param pageSize
     * @return
     */
    List<?> queryArticleByPage(int startPage,int pageSize);
    
    /**
     * 删除文章，根据相关信息进行删除
     * @param article
     * @return
     */
    int delArticle(Article article);
    
    /**
     * 删除所有的文章的相关信息
     * @return
     */
    int delAllArticle();
    
    /**
     * 
     * 更新文章相关的信息
     * 当我们使用管理员登录的时候
     * 浏览整个站点，可以点击文章直接进行编辑，这时候使用的就是更新功能
     * @param article
     * @return
     */
    int updateArticle(Article article);
	
    /**
     * 查询文章的详细信息
     * @param article
     * @return
     */
    Article queryArticleDetailInfo(Article article);
    
    /***
     * 查询最新的文章信息 
     * @param size
     * @return
     */
    List<?> queryNowArticle(int size);
    
    /**
     * 查询最新的文章信息以及与之相对应的作者信息
     * @param size
     * @return
     */
    List<?> queryNowArticleAndUserInfo(int size);

    /***
     * 查询文章文章分类
     * @return
     */
	List<String> queryAllArticleClassfy();
	
	/**
	 * 查询文章的信息通过类名称
	 * @param classfy
	 * @return
	 */
	List<?> queryArticleByClass(String classfy);
	
	/**
	 * 查询文章的信息通过类名称
	 * 分类是系统表文章数据的全部数据
	 * @return
	 */
	List<?> queryArticleByClass();
    /**
     * 查询指定时间之前的文章
     * @param articlePublishTime
     * @param sizeInt
     * @return 返回article的集合
     */
	List<?> queryArticleByTimeBefore(String articlePublishTime, int sizeInt);
	/**
	 * 返回指定事件之后的文章的信息
	 * @param articlePublishTime
	 * @param size
	 * @return
	 */
	List<?> queryArticleByTimeAfter(String articlePublishTime,int size);
	
}
