package com.fang.rice.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fang.rice.tool.TableNameMappingOpration;


/**
 * 产品销售界面的请求的数据
 * @author fang
 * 
 * http://192.168.42.182:8080/Rice/ProductSalePageAction?
 * tableName=phone&
 * size=10
 * &page=0&
 * saleSortAsc=false&
 * priceSortAsc=false&
 * 网络类型=全网通&
 * 卡类型=双卡&
 * 品牌=小米&
 * startPrice=10&
 * endPrice=19
 *这个类的作用是通过请求转发来实现具体的业务逻辑的处理
 */

@WebServlet("/ProductSalePageAction")
public class ProductSalePageAction extends HttpServlet {
	

	@Override
	public void init() {
	
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String classes=req.getParameter("class");
		System.out.println("接受到请求");
		//请求的是card的数据
		if (classes.equalsIgnoreCase(ViewMap.MAIN_FRAGMENT.name)) {
			req.getRequestDispatcher("/CardProductSalePageAction").forward(req, resp);
			return;
		}
		if (classes.equalsIgnoreCase(ViewMap.PRODUCT.name)) {
			req.getRequestDispatcher("/CardProductSalePageAction").forward(req, resp);
			return;
		}
		if (classes.equalsIgnoreCase(ViewMap.HAND.name)) {
			req.getRequestDispatcher("/CardProductSalePageAction").forward(req, resp);
			return;
		}
		if (classes.equalsIgnoreCase(ViewMap.BACK.name)) {
			req.getRequestDispatcher("/AddvanceBack").forward(req, resp);
			return;
		}		
		if (classes.equalsIgnoreCase(ViewMap.CARD_DETAIL.name)) {
			req.getRequestDispatcher("/CardProductSalePageAction").forward(req, resp);
			return;
		}
		if(classes.equalsIgnoreCase(ViewMap.SUBMIT.name)) {
			req.getRequestDispatcher("/SubmitBill").forward(req, resp);
			return;
		}
		
	}
	
	
	public static enum ViewMap{
		
		MAIN_FRAGMENT("MainFragment"),//card  三张
		PRODUCT("ProductSalePageActivity"),//card
		HAND("HandSaleMainFragment"),//card
		BACK("AddvanceBack"),//提交信息
		SUBMIT("SubmitCardProgress"),
		CARD_DETAIL("CardDetailActivity");
		
		public String name;
		
		private ViewMap(String name) {
			this.name=name;
		}
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
