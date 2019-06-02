package com.fang.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Security2Servlet
 */
@WebServlet(description = "身份验证的实现2", urlPatterns = { "/Security2Servlet" })
public class Security2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Security2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String passwd = request.getParameter("passwd");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("其他用户可以看见");

		/**
		 * 这里报错，显示登录失败
		 */
		request.login(user, passwd);

		pw.print("必须验证过用户可以看见");
		request.logout();
		pw.print("其他用户可以看见");

	}

}
