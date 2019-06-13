package com.fang.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fang.mapping.UserDbCenter;
import com.fang.model.StatusResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class UserServlet
 * 
 * @time 2019-6月11日，添加的代码
 * 
 *       由于之前的代码居然没有注册的实现，没有复用之前的servlet，原因是之前的servlet的接口编写的不规范，在这里我们使用的是规范的接口实现
 * 
 *
 * 
 * 
 * 
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 代表的是执行的活动
	 */
	public static final String ACTION = "action";

	/**
	 * 代表的是注册的活动
	 */
	public static final String ACTION_REGISTER = "register";

	/**
	 * 代表的是登录的活动
	 */
	public static final String ACTION_LOGIN = "login";

	/**
	 * 代表的是登出的操作
	 */

	public static final String ACTION_LOGOUT = "logout";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter(ACTION);

		switch (action) {
		// 代表的是执行的是注册的逻辑
		case ACTION_REGISTER:
			doRegister(request, response);
			break;

		case ACTION_LOGOUT:

			doLogout(request, response);

			break;

		default:
			break;
		}

	}

	/**
	 * 登出的操作
	 * 
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		response.getWriter().print("");
	}

	/**
	 * 进行注册的实现
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("application/json;charset=utf-8");

		String user = request.getParameter("user");

		String password = request.getParameter("password");

		UserDbCenter uc = new UserDbCenter();

		StatusResponse sr = uc.register(user, password);

		Gson gson = new Gson();

		response.getWriter().print(gson.toJson(sr));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
