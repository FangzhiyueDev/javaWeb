package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.fang.dao.DbHelper;
import com.fang.model.LeaveMessage;
import com.fang.model.Link;
import com.fang.model.ReuniteModel.LeaveMessageUser;

public class LeaveMessageDbController implements LeaveMessageOpration {

	private LeaveMessageDbController() {
		
	}
	
	public static LeaveMessageOpration getInstance() {
		if(lmo==null) {
			lmo=new LeaveMessageDbController();
		}
		return lmo;
	}
	
	private static LeaveMessageOpration lmo;

	
	@Override
	public boolean addLeaveMessage(LeaveMessage leaveMessage) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean isSucessful=true;
		List<LeaveMessage> leaveMessages =new ArrayList<>();
		try {
			ps=connection.prepareStatement("insert into leaveMessage(userid,leaveMessageTime,content) values (?,?,?)");
			ps.setInt(1, leaveMessage.getUserid());
			ps.setString(2, leaveMessage.getLeaveMessageTime());
			ps.setString(3, leaveMessage.getContent());
			ps.executeUpdate();
		}catch(Exception e) {
			isSucessful=false;
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSucessful;
	}

	@Override
	public int delLeaveMessage(LeaveMessage leaveMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public List<?> getLeaveMessageBySize(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<LeaveMessage> leaveMessages =new ArrayList<>();
		try {
			ps=connection.prepareStatement("select leaveMessageTime,content,userid from leaveMessage"
					+ " order by leaveMessageTime desc"
					+ " limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String leaveMessageTime=resultSet.getString(1);
				String content=resultSet.getString(2);
				int userid=resultSet.getInt(3);
				leaveMessages.add(new LeaveMessage(userid, -1, leaveMessageTime, content));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return leaveMessages;
	
	}

	@Override
	public List<?> getLeaveMessageUserBySize(int countIn) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<LeaveMessageUser> leaveMessageUsers =new ArrayList<>();
		try {
			if(countIn==-1) {
				//代表的是获得所有的留言信息
				ps=connection.prepareStatement("select user.name,user.userid,user.picture,"
						+ "leaveMessage.content,leaveMessage.leaveMessageTime from user"
						+ " join leaveMessage on user.userid=leaveMessage.userid" 
						+ " order by leaveMessageTime desc");
			}else {
				ps=connection.prepareStatement("select user.name,user.userid,user.picture,"
						+ "leaveMessage.content,leaveMessage.leaveMessageTime from user"
						+ " join leaveMessage on user.userid=leaveMessage.userid" 
						+ " order by leaveMessageTime desc"
						+ " limit ?");
				ps.setInt(1, countIn);
			}
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString(1);
				int userid=resultSet.getInt(2);
				String picture=resultSet.getString(3);
				String content=resultSet.getString(4);
				String leaveMessageTime=resultSet.getString(5);
				leaveMessageUsers.add(new LeaveMessageUser(userid,
						name,picture,new LeaveMessage(userid, -1,
								leaveMessageTime, content)));	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return leaveMessageUsers;
	}
	
	
	
	
	

}
