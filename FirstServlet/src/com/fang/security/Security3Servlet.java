package com.fang.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Security3Servlet
 */
@WebServlet(description = "实现的同样是安全的设置", urlPatterns = { "/Security3Servlet" })

/**
 * 下面的servlet安全的角色允许访问的配置 实在web.xml中配置的角色 在tomcat的.tomcat-users下面配置的role
 * 
 * @author fang
 *
 */
//@ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))

/**
 * 配置 只能一些角色的用户才能访问界面 同时 部分使用的是https
 * 
 * @author fang
 *
 */
@ServletSecurity(httpMethodConstraints = { @HttpMethodConstraint(value = "GET", rolesAllowed = { "admin", "root" }),
		@HttpMethodConstraint(value = "POST", rolesAllowed = { "admin",
				"root" }, transportGuarantee = TransportGuarantee.CONFIDENTIAL),
		@HttpMethodConstraint(value = "TRACE", emptyRoleSemantic = EmptyRoleSemantic.DENY) })

public class Security3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Security3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		response.getWriter().print("经过验证才能看到资料");

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
