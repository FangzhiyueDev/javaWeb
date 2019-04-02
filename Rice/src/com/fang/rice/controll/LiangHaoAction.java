package com.fang.rice.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * 处理靓号类型的请求处理中心节点
 * @author fang
 *
 */
@WebServlet("/LiangHaoAction")
public class LiangHaoAction extends HttpServlet {

	
	/**
	 * 其中type 
        zhihuixuanhao("zhihuixuanhao"),
        jixiang("jixiang"),
        jiatinghao("jiatinghao"),
        qinglvhao("qinglvhao");
	 * 
	 * url = NetRequest.liangHaoRequestUrl
                + "?LiangHaoType="
                + iter.type
                + "&typeDetailIndex="
                + typeDetailIndex
                + "&cityId=" + ParentActivity.currentSelectCity.getCityId();
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("application/json;charset=utf-8");
    	Gson gson=new Gson();
    	String liangHaoType=req.getParameter("LiangHaoType");
    	int typeDetailIndex=Integer.parseInt(req.getParameter("typeDetailIndex"));
        int cityId=Integer.parseInt(req.getParameter("cityId")); 
        
        
        
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    }
    
    
    public static enum LiangHaoTypeIter {

        zhihuixuanhao("zhihuixuanhao"),
        jixiang("jixiang"),
        jiatinghao("jiatinghao"),
        qinglvhao("qinglvhao");


        public String type;

        LiangHaoTypeIter(String type) {
            this.type = type;
        }


    }

}
