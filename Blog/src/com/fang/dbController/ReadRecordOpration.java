package com.fang.dbController;

import java.util.List;

import com.fang.model.Article;
import com.fang.model.ReadRecords;
import com.fang.model.ReuniteModel.ArticleCorrespondReadCount;

/**
 * 阅读记录的操作集合
 * @author fang
 *
 */
public interface ReadRecordOpration {
	
	/**
	 * 获得阅读数量最多的文章的相关信息
	 * @return 返回的是文章的主键 也就是文章的发布时间，通过
	 * 这个key，可以获得文章的相关数据
	 */
	public List<ArticleCorrespondReadCount> getReadRecords(int size);
	
	
	/**
	 * 获得指定文章的阅读数量
	 * @param article
	 * @return
	 */
	public int getSpecifiedArticleReadCount(Article article);

    /**
     * 添加一条阅读记录
     * @param readRecords被添加的对象，需要设置两个属性，
     * 一个是用户的名称，一个是文章的发布时间，也就是文章的主键
     */
	public boolean addReadRecord(ReadRecords readRecords);
	
}
