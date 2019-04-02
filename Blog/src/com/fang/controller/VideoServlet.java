package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.dao.DbHelper;
import com.fang.dbController.DbGeneric;
import com.fang.dbController.DbGenericController;
import com.fang.dbController.ProverbDbController;
import com.fang.dbController.VideoDbController;
import com.fang.dbController.VideoWatchDbController;
import com.fang.dbController.VideoWatchOpration;
import com.fang.model.Error;
import com.fang.model.Video;
import com.fang.model.VideoWatch;
import com.fang.model.ReuniteModel.VideoClass;
import com.fang.model.ReuniteModel.VideoCorrespondWatchCount;
import com.fang.tool.DateTool;
import com.google.gson.Gson;

/**
 * 视频访问的servlet
 * @author fang
 *
 */


@WebServlet(
		urlPatterns={
				"/VideoServlet"
		}
		)
public class VideoServlet extends HttpServlet {

	
    /**
     * getAllVideo()
     * allvideo=1;
     * getVideo(int size)
     * size=?
     * queryNowVideo(int size)
     * nowVideo=?
     * delVideo(Video video)
     * articlePublishTime=?
     * 
     * 
     */
	private PrintWriter pw;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		 //requestUrl=videoServerAddress+"?videoAddress"+videoSingleJsonObj.videoAddress+"&opration=watchCount";
		
		 req.setCharacterEncoding("utf-8");
		 resp.setHeader("Access-Control-Allow-Origin", "*");
		 Gson gson=new Gson();
		 String videoAddress=req.getParameter("videoAddress");
		 String opration=req.getParameter("opration");
		 String allVideo=req.getParameter("allVideo");
		 String size=req.getParameter("size");
		 String current=req.getParameter("current");
		 String classfy=req.getParameter("classfy");
		 //System.out.println("得到的数据"+videoAddress);
		if(allVideo==null&&size==null&&current==null&&classfy==null&&videoAddress==null&&opration==null) {
			    resp.setContentType("application/json;charset=utf-8");
			   	pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
		}
		/**
		 * 下面是对数据的真正处理
		 */
		
		 if(videoAddress!=null) {//代表的执行的是获得一个视频的详细信息,这里实现的是界面的跳转，实现对数据的封装
		
			 if(opration!=null) {//代表处理的是视频的观看数量以及对视频观看数量的写入
				VideoWatchOpration vwo=VideoWatchDbController.getInstance();
				HttpSession httpSession=req.getSession();
				String userid=(String) httpSession.getAttribute("userid");
				//System.out.println(videoAddress);
				videoAddress=videoAddress.replaceAll(" ","+");
				if(userid!=null) {
					//用户登录，所以用写入
					//写入用户观看记录
					int useridInt=Integer.parseInt(userid);
					//添加
					vwo.addNowWatchRecord(new VideoWatch(useridInt, videoAddress, -1,
							DateTool.getCurrentDateAndTime()));
				}
					//查询数量
					int count=vwo.getVideoWatchCount(videoAddress);
					VideoCorrespondWatchCount vcwc=new VideoCorrespondWatchCount();
					vcwc.setCount(count);
					vcwc.setVideoAddress(videoAddress);
					String responseData=gson.toJson(vcwc);
					resp.setContentType("application/json;charset=utf-8");
					pw=resp.getWriter();
					pw.print(responseData);
				
				return; 
			 }
			 //查询某一个视频的详细信息
			 VideoDbController vdc;
			 resp.setContentType("text/html;charset=utf-8");
			 pw=resp.getWriter();
			 vdc=(VideoDbController) VideoDbController.getInstance();
			 //System.out.print("视频地址"+videoAddress);
			 String urlAddress=videoAddress.replaceAll(" ","+");
			 Video video=vdc.queryVideoInfoByVideoAddress(urlAddress);
			 if(video==null) {
				 resp.setContentType("application/json;charset=utf-8");
				 Error error=new Error("没有找到该视频数据");
				 String paramError=gson.toJson(error);
				 pw.print(paramError);
				 return;
			 }
			 //System.out.print("执行跳转");
			 VideoWatchOpration vwo=VideoWatchDbController.getInstance();
			 //添加一条播放记录
			 HttpSession httpSession=req.getSession();
			 String userid=(String) httpSession.getAttribute("userid");
			 if(userid!=null) {
			 int useridInt=Integer.parseInt(userid);
			 //用户不为空，代表的是用户进行了登录
			 boolean sucessful=vwo.addNowWatchRecord(new VideoWatch(useridInt, urlAddress, -1, DateTool.getCurrentDateAndTime()));
			 if(!sucessful) {
				System.out.println("数据库添加新的视频观看记录出错");
			  }
			}	 
			 //在这里得到视频的播放量
			 int count=vwo.getVideoWatchCount(urlAddress);
			 req.setAttribute("video",video);
			 req.setAttribute("watchCount",count);
			 req.getRequestDispatcher("jsp/jsp/videoplayer.jsp").forward(req, resp);
			 return;
		 }
	   	
		 
		//获得所有的视频结果
		if (allVideo!=null) {
			int count;
			List<Video> videos;
			VideoDbController vdc;
			try {
				count=Integer.parseInt(allVideo);
				vdc=(VideoDbController) VideoDbController.getInstance();
				videos=(List<Video>) vdc.getAllVideo();
				String videoJson=gson.toJson(videos);
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				pw.print(videoJson);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
		}
		
		//获得分页效果的显示
		if(size!=null) {
			int count;
			List<Video> videos;
			VideoDbController vdc;
			DbGeneric dbGeneric = null;
			float rate;
			int startPage;
			try {
				count=Integer.parseInt(size);
				rate=((float)DateTool.getCurrentDayByMonth())/DateTool.getCurrentMonthCount();
				vdc=(VideoDbController) VideoDbController.getInstance();
				dbGeneric=DbGenericController.getInstance();
				count=dbGeneric.getResultCount(VideoDbController.VIDEO_TABLE);
				startPage=(int) (rate*count);
				videos=(List<Video>) vdc.getVideo(startPage, count);
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				String videoJson=gson.toJson(videos);
				pw.print(videoJson);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
		}
		
		/**
		 * 查询最新的数据
		 */
		if(current!=null) {
			int count;
			List<Video> videos;
			VideoDbController vdc;
			try {
				count=Integer.parseInt(current);
				vdc=(VideoDbController) VideoDbController.getInstance();
				videos=(List<Video>) vdc.queryNowVideo(count);
				String videoJson=gson.toJson(videos);
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				pw.print(videoJson);
				return;
			}catch (Exception e) {
				e.printStackTrace();
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
		 }	
		
		if(classfy!=null) {
			int count;
			List<VideoClass> videos;
			VideoDbController vdc=null;
			try {
				count=Integer.parseInt(classfy);
			}catch (Exception e) {
				e.printStackTrace();
				resp.setContentType("application/json;charset=utf-8");
				pw=resp.getWriter();
				Error error=new Error("参数错误");
				String paramError=gson.toJson(error);
				pw.print(paramError);
				return;
			}
			vdc=(VideoDbController) VideoDbController.getInstance();
			videos=(List<VideoClass>) vdc.queryVideoByClassfy();
			resp.setContentType("application/json;charset=utf-8");
			pw=resp.getWriter();
			String videoJson=gson.toJson(videos);
			pw.print(videoJson);		
		  }
		 //requestUrl=videoServerAddress+"?videoAddress"+videoSingleJsonObj.videoAddress+"&opration=watchCount";
	}
	
	/**
	 *delVideo(Video video)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
}
