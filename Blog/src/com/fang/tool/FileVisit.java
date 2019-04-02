package com.fang.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletContext;

/***
 * 提供对
 * @author fang
 *
 */
public class FileVisit {

	/**
	 * 提供了对文件的访问,该方法对程序的路径存在依赖关系
	 * 请不要对该方法进行修改   
	 * 返回的是家目录　/Home 对于不同的用户需要传递不同的用户名称。进入自己的目录
	 * @param sc
	 * @param url
	 * @return
	 */
	public static  String  visitHome() {
		return "/../../../home";
	}
	
	/**
	 * 访问的是自己的家目录
	 * @param userName
	 * @return
	 */
	public static String visitSelfHome(String userName) {
		
		return visitHome()+"/"+userName;
	}
	
	//打印的是/opt/eclipse/eclipse/fileName     
	//打印的是eclipse的安装目录，但是在实际部署的过程中
	//实际传递的是　　　tomcat/bin/fileName
	
	/**
	 * 访问根目录，通过和数据库的文件的路径进行叠加
	 * 返回文件的路径
	 * @return
	 */
	public static String visitRoot() {
		return "/../../..";
	}
	
	
	
	
}
