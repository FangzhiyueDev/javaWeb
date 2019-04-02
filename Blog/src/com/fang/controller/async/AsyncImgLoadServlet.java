package com.fang.controller.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.fang.net.NetRequest;
import com.fang.net.model.Images;
import com.fang.net.model.Root;
import com.google.gson.Gson;


@WebServlet(
		urlPatterns= {"/AsyncImgLoadServlet"},
		asyncSupported=true
		)
public class AsyncImgLoadServlet extends HttpServlet {

	private ExecutorService es=Executors.newFixedThreadPool(1);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		AsyncContext asyncContext=req.startAsync();
		es.execute(new AsyncRequestTask(asyncContext));
	}
	
	private static final long serialVersionUID = 1L;
	
}


class AsyncRequestTask implements Runnable{

	private AsyncContext asyncContext;
	public AsyncRequestTask(AsyncContext asyncContext) {
		this.asyncContext=asyncContext;
	}

	@Override
	public void run() {
		HttpServletRequest hsr=(HttpServletRequest) asyncContext.getRequest();
		try {
			hsr.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url="http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
		String baseUrl="http://cn.bing.com";
		String responseJson=NetRequest.sendRequest(url);
		System.out.println(responseJson);
		Gson gson=new Gson();
		Root root=gson.fromJson(responseJson, Root.class);
	    Images images=root.getImages().get(0);
	    baseUrl+=images.getUrl();
	    PrintWriter pw;
	    HttpServletResponse hsResp=null;
	    try {
	    	hsResp=(HttpServletResponse) asyncContext.getResponse();
	    	hsResp.setHeader("Access-Control-Allow-Origin", "*");
	    	pw=hsResp.getWriter();
	    	hsResp.setContentType("text/html");
			pw.print(baseUrl);
			asyncContext.complete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	    
		
	}
	
	
}


