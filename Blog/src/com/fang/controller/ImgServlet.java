package com.fang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.dbController.ImgDbController;
import com.fang.model.Img;
import com.fang.net.NetRequest;
import com.fang.net.model.Images;
import com.fang.net.model.Root;
import com.google.gson.Gson;

/**
 * 该类的作用是实现对img 数据的回传，通过ajax访问该servlet返回封装数据相对应的json数据
 * 
 * @author fang
 *
 */
@WebServlet(urlPatterns = { "/ImgServlet" })
public class ImgServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter pw = resp.getWriter();
		String currentBg = req.getParameter("currentBg");
		if (currentBg != null) {// 代表的请求的是当前图片的背景
			if (Integer.parseInt(currentBg) == 1) {
				// 代表请求的是必应的数据
				String url = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
				String baseUrl = "http://cn.bing.com";
				String responseJson = NetRequest.sendRequest(url);
				// System.out.println("响应的数据"+responseJson);
				Gson gson = new Gson();
				Root root = gson.fromJson(responseJson, Root.class);
				Images images = root.getImages().get(0);
				url = images.getUrl();
				images.setUrl(baseUrl + url);
				String value = gson.toJson(images);
				pw.println(value);
				return;
			}
		}
		// 这个代表的是默认的访问请求
		if (currentBg == null) {
			// 响应系统banner图片的请求
			ImgDbController idc = ImgDbController.GetInstance();
			List<Img> imgs = (List<Img>) idc.queryAllImgInfo();
			Gson gson = new Gson();
			String imageJson = gson.toJson(imgs);
			pw.print(imageJson);
			return;
		}
	}

	/**
	 * 用来添加图片数据，我们使用这个技术实现后台操作 被添加的图片存放在
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getInputStream();

	}

}
