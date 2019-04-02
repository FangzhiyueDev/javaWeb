package com.fang.dbController;

import java.util.List;

import com.fang.model.VideoWatch;
import com.fang.model.ReuniteModel.ArticleCorrespondReadCount;
import com.fang.model.ReuniteModel.VideoCorrespondWatchCount;

/**
 * 视频观看记录的操作
 * @author fang
 *
 */
public interface VideoWatchOpration {
	/**
	 * 获得视频观看数量最多的视频的相关信息
	 * @return 返回的是视频的主键 也就是视频的地址，通过
	 * 这个key，可以获得视频的相关数据
	 */
	public List<VideoCorrespondWatchCount> getVideoWatch(int size);
    
   /**
    * 根据文章的地址来获得视频的观看数量
    * @param urlAddress
    */
	public int getVideoWatchCount(String urlAddress);
	
	/**
	 * 添加一条文章的阅读记录
	 * @param videoWatch
	 * @return
	 */
	public boolean addNowWatchRecord(VideoWatch videoWatch);
	
}
