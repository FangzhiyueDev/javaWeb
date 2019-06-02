package com.fang.taotao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.net.NetRequest;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 当前小程序的App—— secret
	 */
	public static final String APP_SECRET = "fb6cfbb18c939129bd9a01ef4934d757";

	/**
	 * 当前小程序的id
	 */
	public static final String APP_ID = "wxd97&14c3e8601cd1";

	public static final String URL = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID + "&secret="
			+ APP_SECRET + "&js_code=%s&grant_type=authorization_code";

	public static final String CODE = "code";

	private String contextPath;

	private String errorPage = "/error.html";

	@Override
	public void init() throws ServletException {
		contextPath = getServletContext().getContextPath();
	}

	public String url;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");

		String code = req.getParameter(CODE);

		if (code == null) {
			resp.sendRedirect(contextPath + errorPage);
			return;
		}
		url = String.format(URL, code);

		System.out.println(url);

		String jsonValueString = NetRequest.sendRequest(url);

		System.out.println(jsonValueString);

		resp.getWriter().print(jsonValueString);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
