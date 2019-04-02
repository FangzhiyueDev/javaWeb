package com.fang.rice.controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.dbController.CardDbController;
import com.fang.rice.dbController.CardOpration;
import com.fang.rice.model.RootTable;
import com.fang.rice.tool.SystemParam;
import com.google.gson.Gson;

/**
 * 获得对应的套餐，以及对应的过滤条件
 * @author fang
 *
 */

@WebServlet("/ProductFilterClass")
public class ProductFilterClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("application/json;charset=utf-8");
    	String currentTable=req.getParameter("currentTable");
    	String provinceCode=req.getParameter("provinceCode");
    	
    	if(SystemParam.TableName.card.tableName.equals(currentTable)) {
    		//代表获取的是card的数据
    		progressCardClass(req,resp,provinceCode);
    	}	
    }
    
    
    
    private void progressCardClass(HttpServletRequest req, HttpServletResponse resp, String cityId) throws IOException {
	
    	CardOpration co=new CardDbController();
    	RootTable rootTable=co.queryCardClassfy(Integer.parseInt(cityId));
    	Gson gson=new Gson();
    	String jsonData=gson.toJson(rootTable);
    	PrintWriter pw=resp.getWriter();
    	pw.print(jsonData);
    	return;
	}



	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
	
	

}
