package com.fang.test.demo.filePathTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFilePathTestServlet")
public class MyFilePathTestServlet extends HttpServlet {

	/**
	 * 我们将home/fang/Music映射成了虚拟主机 ，下面的文件都是可以读取的 下面是访问的方式
	 * 
	 * 记录文件名 例如 简爱.mp3 存放到数据库就是 /简爱.mp3 在这里调用另一台host下面的web引用实现下载的功能，
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		demo1();
		try {
//			demo2(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void demo2(HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub

		/**
		 * java.security.AccessControlException: access denied ("java.io.FilePermission"
		 * "/home/fang/Music/韩红 - 天亮了.mp3" "read")
		 * 
		 * 
		 * 
		 */
		FileInputStream fStream = new FileInputStream("/home/fang/Music/韩红 - 天亮了.mp3");

		byte[] b = new byte[1024];

		int length = -1;
		OutputStream os = resp.getOutputStream();

		while ((length = fStream.read(b)) != -1) {
			os.write(b, 0, length);
		}
		os.flush();
	}

	private void demo1() {
		// TODO Auto-generated method stub
		/**
		 * 
		 * 不能在这里面对主机上面的数据进行读取 会java.security.AccessControlException: access denied
		 * ("java.io.FilePermission" "/home/fang/Music/韩红 - 天亮了.mp3" "read")
		 * 
		 * 
		 */
		File file = new File("/home/fang/Music/韩红 - 天亮了.mp3");
	}

}
