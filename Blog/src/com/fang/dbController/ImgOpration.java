package com.fang.dbController;

import java.util.List;

import com.fang.model.Img;

public interface ImgOpration {
    
	/**
	 * 添加一个img
	 * @param img
	 */
	 int addImg(Img img); 
	 
	 /**
	  * 查询所有的img
	  */
	 List<?> queryAllImgInfo();
	 
}
