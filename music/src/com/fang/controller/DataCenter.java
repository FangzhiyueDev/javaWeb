package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.mapping.AlbumDbCenter;
import com.fang.mapping.AlbumOprate;
import com.fang.mapping.MusicDbCenter;
import com.fang.mapping.MusicOprate;
import com.fang.mapping.SingerDbCenter;
import com.fang.mapping.SingerOprate;
import com.fang.model.Album;
import com.fang.model.Singer;
import com.fang.modelWrapper.MusicWrapper;
import com.google.gson.Gson;

@WebServlet("/DataCenter")
public class DataCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String classfy = request.getParameter("classfy");
		String musicId = request.getParameter("musicId");
		String albums = request.getParameter("albums");
		String singers = request.getParameter("singers");

		if (singers != null) {
			try {
				getAllSingerList(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		if (musicId != null) {
			try {
				getMusicDetailInfo(request, response, musicId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		if (classfy != null) {

			System.out.println(classfy);

			try {
				getClassfyMusicList(request, response, classfy);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * 获得热门的歌单的信息
		 */
		if (albums != null) {

			try {
				getAlbumList(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 获得所有的歌手的想关信息
	 * 
	 * @param request
	 * @param response
	 */
	private void getAllSingerList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		SingerOprate singerOprate = new SingerDbCenter();
		List<Singer> singers = singerOprate.getAllSinger();
		Gson gson = new Gson();
		String jsonData = gson.toJson(singers);
		PrintWriter pw = response.getWriter();
		pw.println(jsonData);
		return;
	}

	/**
	 * 获得歌单的相关信息
	 * 
	 * @param response
	 * @param request
	 */
	private void getAlbumList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		AlbumOprate albumOprate = new AlbumDbCenter();
		List<Album> albums = albumOprate.getAllAlbumList();
		Gson gson = new Gson();
		String jsonData = gson.toJson(albums);
		PrintWriter pw = response.getWriter();
		pw.println(jsonData);
		return;
	}

	/**
	 * 获得固定分类的音乐的列表信息
	 * 
	 * @param request
	 * @param response
	 * @param classfy
	 */
	private void getClassfyMusicList(HttpServletRequest request, HttpServletResponse response, String classfy)
			throws Exception {

		MusicOprate musicOprate = new MusicDbCenter();
		List<MusicWrapper> wrappers = musicOprate.getMusicByClassId(classfy);
		Gson gson = new Gson();
		String jsonData = gson.toJson(wrappers);
		PrintWriter pw = response.getWriter();
		pw.println(jsonData);
		return;
	}

	/**
	 * 获得音乐的详情信息，之后设置为属性跳转到播放界面
	 * 
	 * @param request
	 * @param response
	 * @param musicId
	 */
	private void getMusicDetailInfo(HttpServletRequest request, HttpServletResponse response, String musicId)
			throws Exception {

		MusicOprate musicOprate = new MusicDbCenter();
		MusicWrapper musicWrapper = musicOprate.getMusicDetailInfo(Integer.parseInt(musicId));
		Gson gson = new Gson();
		String jsonData = gson.toJson(musicWrapper);
		PrintWriter pw = response.getWriter();
		pw.println(jsonData);
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
