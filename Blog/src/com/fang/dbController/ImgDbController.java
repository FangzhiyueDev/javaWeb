package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.fang.dao.DbHelper;
import com.fang.model.Img;
import com.fang.tool.FileVisit;


/***
 * img的数据库访问层代码
 * @author fang
 *
 */
public class ImgDbController implements ImgOpration {

	public static final String ImgTable="picture";

	private  ImgDbController() {
		
	}
	
	public static ImgDbController imgDbController;
	
	/**
	 * 实现单例模式
	 * @return
	 */
	public static ImgDbController GetInstance() {
		if(imgDbController==null) {
			imgDbController=new ImgDbController();
		}
			return imgDbController;
	
	}
	
	
	
	@Override
	public int addImg(Img img) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		int id=0;
		try {
			ps=connection.prepareStatement("insert into "+ImgTable+"(authorid,pictureAddress,uploadTime) values(?,?,?)");
		   ps.setInt(1, img.getAuthorid());
		   ps.setString(2, img.getPictureAddress());
		   ps.setString(3,img.getUploadTime());
		  id=ps.executeUpdate();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return id;
	}

	@Override
	public List<?> queryAllImgInfo() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Img>  list =new ArrayList<>();
		connection=DbHelper.initDB();
		int id=0;
		String linkAddress1;
		try {
			ps=connection.prepareStatement("select authorid,pictureAddress,uploadTime,pictureid from "+ImgTable);
			rs=ps.executeQuery();
			while(rs.next()) {
				int authorid=rs.getInt(1);
				String picutreAddress=rs.getString(2);
				String uploadTime=rs.getString(3);
				int pictureid=rs.getInt(4);
				list.add(new Img(authorid,picutreAddress,uploadTime,pictureid));
				}
			}catch(Exception e) {
				e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, rs);
		}
		return list;
		
	}


    
	
	
	
	
	
	
	
}
