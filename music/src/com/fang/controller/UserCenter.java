package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.mapping.UserDbCenter;
import com.fang.model.Album;
import com.fang.model.Singer;
import com.fang.model.StatusResponse;
import com.fang.modelWrapper.MusicWrapper;
import com.google.gson.Gson;


@WebServlet("/UserCenter")
public class UserCenter extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		String theme=req.getParameter("theme");
		
		System.out.println("接受到请求");
		
		HttpSession session=req.getSession();
		String user=(String) session.getAttribute("user");
		if(user==null) {
			StatusResponse statusResponse=new StatusResponse(StatusResponse.response_error);
            PrintWriter pw=resp.getWriter();
            Gson gson=new Gson();
            String jsonData=gson.toJson(statusResponse);
            pw.print(jsonData);
			return;
		}
	
		
		if(theme!=null) {
			
			if(theme.equals("收藏的歌曲")) {
				getMusicList(req,resp,user);
			}
			if (theme.equals("热门推荐")) {
				getHotTuijianList(req,resp,user);
			}
			if(theme.equals("推荐歌手")) {
				getTuijianSinger(req,resp,user);
			}
			if(theme.equals("推荐歌单")) {
				getTuijianMusicMenu(req,resp,user);
			}
			return;
		}
	}

	/**
	 *获得推荐歌单
	 * @param req
	 * @param resp
	 * @param user
	 * @throws IOException 
	 */
	private void getTuijianMusicMenu(HttpServletRequest req, HttpServletResponse resp, String user) throws IOException {
		UserDbCenter userDbCenter=new UserDbCenter();
		List<Album> albums=userDbCenter.getTuijianMusicMenu(user);
		PrintWriter pw=resp.getWriter();
        Gson gson=new Gson();
        String jsonData=gson.toJson(albums);
        pw.print(jsonData);
         return;
	}


	/**
	 * 获得热门推荐歌手
	 * @param user 
	 * @param resp 
	 * @param req 
	 * @throws IOException 
	 */
	private void getTuijianSinger(HttpServletRequest req, HttpServletResponse resp, String user) throws IOException {
		UserDbCenter userDbCenter=new UserDbCenter();
		List<Singer> singers=userDbCenter.getTuijianSinger(user);
		PrintWriter pw=resp.getWriter();
        Gson gson=new Gson();
        String jsonData=gson.toJson(singers);
        pw.print(jsonData);
         return;
	}


	/**
	 * 获得热门
	 * @param user 
	 * @param resp 
	 * @param req 
	 * @throws IOException 
	 */
	private void getHotTuijianList(HttpServletRequest req, HttpServletResponse resp, String user) throws IOException {
		UserDbCenter userDbCenter=new UserDbCenter();
		List<MusicWrapper> musicWrappers=userDbCenter.getHotTuijianList(user);
		PrintWriter pw=resp.getWriter();
        Gson gson=new Gson();
        String jsonData=gson.toJson(musicWrappers);
        pw.print(jsonData);
        return;
	}

	/**
	 * 获得用户收藏的歌曲
	 * @param resp 
	 * @param req 
	 * @param user 
	 * @throws IOException 
	 */
	private void getMusicList(HttpServletRequest req, HttpServletResponse resp, String user) throws IOException {
		UserDbCenter userDbCenter=new UserDbCenter();
		List<MusicWrapper> musicWrappers=userDbCenter.getCollectionByUserName(user);
		PrintWriter pw=resp.getWriter();
        Gson gson=new Gson();
        String jsonData=gson.toJson(musicWrappers);
        pw.print(jsonData);
         return;
	}
	
	

	
	

}
