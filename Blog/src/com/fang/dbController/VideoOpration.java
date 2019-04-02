package com.fang.dbController;
import java.util.List;

import com.fang.model.Video;
import com.fang.model.ReuniteModel.VideoClass;

/**
 *视频的操作封装
 * @author fang
 *
 */
public interface VideoOpration {
	
	
	/**
	 *获得所有的视频数据
	 * @param video
	 * @return
	 */
  List<?> getAllVideo();
  
  /**
   *获得视频数据，获得的数据是通过起始位置获得的数据
   * @param startPage
   * @param size
   * @return
   */
  List<?> getVideo(int startPage,int size);
  
  /**
   * 获得最新的数据
   */
  List<?> queryNowVideo(int size);
     
  /**
   * 删除视频数据
   * @param video
   * @return
   */
  int delVideo(Video video);
  
  /**
   * 查询视频的信息，通过视频的地址
   * @param videoAddress
   * @return
   */
  Video queryVideoInfoByVideoAddress(String videoAddress);
  
  /**
   * 查询文章的分类，以及根据分类查询出对应的文章的数据结果
   * @return
   */
  public List<?> queryVideoByClassfy();
  

}
