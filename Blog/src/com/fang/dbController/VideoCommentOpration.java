package com.fang.dbController;

import java.util.List;

import com.fang.model.VideoComment;

public interface VideoCommentOpration {
	
    /**
     * 
     * @param page 起始页面
     * @param size 获得数据的大小
     * @param videoComment 视频的评论对象，里面存放的是视频的地址信息我们通过地址信息可以拿到不同的视频的
     * 评论
     * @return 返回视频评论的相关数据   
     */
    List<?> queryPageVideoComment(int page,int size,VideoComment videoComment);
    
    /**
     * 查询特定视频的评论数量
     * 可以用来实现数据的分页显示
     * @param videoComment
     * @return
     */
    int queryVideoCommentCount(VideoComment videoComment);
    
    /**
     * 添加一条视频的评论
     * @param videoComment
     * @return 返回执行的结果
     */
    int addNowVideoCommnet(VideoComment videoComment);
	

}
