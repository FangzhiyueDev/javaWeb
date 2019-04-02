package com.fang.rice.dbHelper;

import java.nio.channels.ClosedByInterruptException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * 数据操控层，使用驱动对mysql数据的调用
 * @author fang
 *
 */
public class DbHelper {
	
	public static final String DbName="Rice";
	
	public static void main(String[] argc) {
	
	   
		Connection con=DbHelper.initDB();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from card");
			
			ResultSet  resultSet=ps.executeQuery();
			
			while(resultSet.next()) {
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private  static final  String URL="jdbc:mysql://localhost:3306/Rice?useUnicode=true&characterEncoding=UTF-8&user=root&password=123"; 

	public static Connection initDB() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	/**
	 * 关闭数据库的链接
	 * @param connection
	 */
	public static void closeDb(Connection connection,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
			rs.close();
			}
			connection.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库的链接
	 * @param connection
	 */
	public static void closeDb(Connection connection,Statement statement,ResultSet rs) {
		try {
			rs.close();
			connection.close();
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	
	
}
