package com.fang.dbController;

import java.util.List;

import com.fang.model.LeaveMessage;
import com.fang.model.ReuniteModel.LeaveMessageUser;

public interface LeaveMessageOpration {
	
	/**
	 * 添加一条留言
	 * @param leaveMessage
	 * @return
	 */
	boolean addLeaveMessage(LeaveMessage leaveMessage);
	
	/**
	 * 删除一条留言
	 */
	int delLeaveMessage(LeaveMessage leaveMessage);
	/**
	 * 根据大小获得leaveMessage的大小
	 * @param size
	 * @return
	 */
	List<?> getLeaveMessageBySize(int size);
   
	List<?> getLeaveMessageUserBySize(int countIn);
	
	

}
