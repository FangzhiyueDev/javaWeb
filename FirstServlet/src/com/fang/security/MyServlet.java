package com.fang.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(urlPatterns = { "/MyServlet" }, description = "实现了一个最简单的servlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> bookName = new ArrayList<String>();

		bookName.add("你好吗");
		bookName.add("你好吗");
		bookName.add("你好吗");
		bookName.add("你好吗");
		bookName.add("你好吗");
		bookName.add("你好吗");
		bookName.add("你好吗");

		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();

		session.setAttribute("books", bookName);

		response.sendRedirect("/FirstServlet/index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
