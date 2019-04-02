package com.fang.dbController;

import java.util.List;

import com.fang.model.ArticleComment;
import com.fang.model.User;
import com.fang.model.VideoComment;

/**
 * 对文章评论封装的操作
 * @author fang
 *
 */
public interface ArticleCommentOpration {

	/**
	 * 删除文章的评论
	 * @param articleComment
	 * @return
	 */
    int delArticleComment(ArticleComment articleComment);
    
    /**
     * 添加文章的评论
     */
    int addArticleComment(ArticleComment articleComment);
    
    /**
     * 更新文章评论
     * @param articleComment
     * @return
     */
    int updateArticleComment(ArticleComment articleComment);
    
    /**
     * 删除文章的所有评论
     * 根据文章发布时间的id，我们能够找到对应的文章所对应的所有的评论
     */
     int delAllArticleComment(ArticleComment articleComment);
     
     /**
      * 查询最新的文章的评论
      * @param size
      * @return
      */
     List<? extends User> queryNowComment(int size,ArticleComment articleComment);
     
     
     
     
    
    
    
    
    
	
}
