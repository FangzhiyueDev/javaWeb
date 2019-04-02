package com.fang.model.ReuniteModel;

import java.util.List;

/**
 * 文章阅读和视频播放记录的统计总bean
 * @author fang
 *
 */
public class RecordCount {
	
	private List<ArticleCorrespondReadCount> articleReadCounts=null;
	private List<VideoCorrespondWatchCount> videoWatchCounts=null;
	public List<ArticleCorrespondReadCount> getArticleReadCounts() {
		return articleReadCounts;
	}
	public void setArticleReadCounts(List<ArticleCorrespondReadCount> articleReadCounts) {
		this.articleReadCounts = articleReadCounts;
	}
	public List<VideoCorrespondWatchCount> getVideoWatchCounts() {
		return videoWatchCounts;
	}
	public void setVideoWatchCounts(List<VideoCorrespondWatchCount> videoWatchCounts) {
		this.videoWatchCounts = videoWatchCounts;
	}
	@Override
	public String toString() {
		return "RecordCount [articleReadCounts=" + articleReadCounts + ", videoWatchCounts=" + videoWatchCounts + "]";
	}
	public RecordCount(List<ArticleCorrespondReadCount> articleReadCounts,
			List<VideoCorrespondWatchCount> videoWatchCounts) {
		super();
		this.articleReadCounts = articleReadCounts;
		this.videoWatchCounts = videoWatchCounts;
	}
	
	public RecordCount() {
			
	}
	
}
