package com.fang.Ajax;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AjaxTest
 */
@WebServlet("/AjaxTest")
public class AjaxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json;charset=utf-8");  //text/html
		
	//上面是设置编码集。。设置允许跨域请求 ，设置响应的mime类型
		
	    String[] value= {
	    	"奥斯卡的 ","我放弃","案发前我","爱人废弃物","案日前五个"	
	    };
	    
	    //需要返回的结果
	    
	    
	    //在这里对查询的数据进行匹配，可以使用数据库，也可以使用map
	   //ajax实现的就是在界面没有刷新的情况下自动发送请求到服务器，实现数据的请求
	    
	    
	    Gson gson=new Gson();//google提供的json数据格式的解析工具，可以将一个数据对象直接序列化为一个json的数据格式
		String jsonData=gson.toJson(value);//将上面的数组序列为一个json的字符串
		
		System.out.println(jsonData);
		
         PrintWriter print=response.getWriter();
         
         print.print(jsonData);//返回数据
	    
	   return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		
	}

}
