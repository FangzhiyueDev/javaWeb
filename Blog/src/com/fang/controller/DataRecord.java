package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.dbController.ArticleDbController;
import com.fang.dbController.ArticleOpration;
import com.fang.dbController.ReadRecordDbController;
import com.fang.dbController.ReadRecordOpration;
import com.fang.dbController.VideoDbController;
import com.fang.dbController.VideoOpration;
import com.fang.dbController.VideoWatchDbController;
import com.fang.dbController.VideoWatchOpration;
import com.fang.model.Article;
import com.fang.model.Error;
import com.fang.model.Video;
import com.fang.model.VideoWatch;
import com.fang.model.ReuniteModel.ArticleCorrespondReadCount;
import com.fang.model.ReuniteModel.RecordCount;
import com.fang.model.ReuniteModel.VideoCorrespondWatchCount;
import com.google.gson.Gson;

/**
 * @category controller
 * @author fang
 * @version 1.0
 * @function 作用实现对视频以及文章相关的阅读记录，阅读数量的统计
 *
 */
@WebServlet("/DataRecord")
public class DataRecord extends HttpServlet {
	//videoRecord=6&articleRecord=6
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json;charset=utf-8");	
		Gson gson=new Gson();
		String videoRecord=req.getParameter("videoRecord");
		String articleRecord=req.getParameter("articleRecord");
		
		if(videoRecord==null&&articleRecord==null) {
			PrintWriter pw=resp.getWriter();
			Error error=new Error("参数错误");
			String paramError=gson.toJson(error);
			pw.print(paramError);
			return;
		}else {
			List<ArticleCorrespondReadCount> articleReadCounts=null;
			List<VideoCorrespondWatchCount> videoWatchCounts=null;
			if(videoRecord!=null) {
				videoWatchCounts=(List<VideoCorrespondWatchCount>)
						progressVideoRecord(req,resp,gson,videoRecord);
			}
			if(articleRecord!=null) {
				articleReadCounts=(List<ArticleCorrespondReadCount>)
						progressArticleRecoid(req,resp,gson,articleRecord);
			}
			
			if(videoWatchCounts==null||articleReadCounts==null) {
				//代表的是数据出错
				PrintWriter pw=resp.getWriter();
				Error error=new Error("系统出错，请稍后再试");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			
			RecordCount recordCount=null;
			recordCount=new RecordCount(articleReadCounts, videoWatchCounts);
			String data=gson.toJson(recordCount);
			PrintWriter pw=resp.getWriter();
			pw.print(data);
			return;
		}
		
	}
	
	/**
	 *处理文章的读取记录相关数据
	 * @param req
	 * @param resp
	 * @param gson
	 * @param articleRecord
	 * @return
	 * @throws IOException 
	 */
	private List<? extends Article> progressArticleRecoid(HttpServletRequest req, HttpServletResponse resp, Gson gson,
			String articleRecord) throws IOException {
		int countIn = 0;
		ReadRecordOpration rro;
		List<ArticleCorrespondReadCount> readCounts=new ArrayList<>();
		ArticleOpration ao;
		try {
			countIn=Integer.parseInt(articleRecord);
			rro=ReadRecordDbController.getInstance();
			ao=ArticleDbController.getInstance();
			List<ArticleCorrespondReadCount> readCountsTemp=rro.getReadRecords(countIn);
			for(ArticleCorrespondReadCount acr:readCountsTemp) {
				Article article=ao.queryArticleDetailInfo(acr);
				acr=new ArticleCorrespondReadCount(article,acr.getCount());
				//System.out.println("文章观看数量"+acr.getCount());
				readCounts.add(acr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return readCounts;
	}

   /**
    * 处理视频播放记录相关数据
    * @param req
    * @param resp
    * @param gson
    * @param videoRecord
    * @return
 * @throws IOException 
    */
	private List<? extends Video> progressVideoRecord(HttpServletRequest req, HttpServletResponse resp, Gson gson,
			String videoRecord) throws IOException {
		int countIn = 0;
		VideoWatchOpration vwo;
		List<VideoCorrespondWatchCount> watchCounts=new ArrayList<>();
		VideoOpration vo;
		try {
			countIn=Integer.parseInt(videoRecord);
			vwo=VideoWatchDbController.getInstance();
			vo=VideoDbController.getInstance();
			List<VideoCorrespondWatchCount> watchCountstemp=vwo.getVideoWatch(countIn);
			for(VideoCorrespondWatchCount vcwc:watchCountstemp) {
				Video video=vo.queryVideoInfoByVideoAddress(vcwc.getVideoAddress());
				vcwc=new VideoCorrespondWatchCount(video,vcwc.getCount());
				//System.out.println("视频播放数量"+vcwc.getCount());
				watchCounts.add(vcwc);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return watchCounts;
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
