package com.epms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.epms.dao.TaskDAO;
import com.epms.pojo.Pager;
import com.epms.pojo.Task;
import com.epms.service.TaskService;
import com.epms.util.MyBatisUtil;

public class TaskServiceImpl implements TaskService {

	private TaskDAO taskDAO;
	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	
	@Override
	public Pager<Task> list(int pageOffset, int pageSize) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		taskDAO = session.getMapper(TaskDAO.class);
		
		Pager<Task> pager = new Pager<Task>();
		
		List<Task> tasks = taskDAO.queryByPage(pageOffset, pageSize);
		
		// 总记录数
		int totalRecord = taskDAO.totalRecord();
		// 总页数
		int totalPage = totalRecord % pageSize == 0? totalRecord / pageSize : totalRecord / pageSize + 1;

		pager.setDatas(tasks);
		pager.setTotalRecord(totalRecord);
		pager.setTotalPage(totalPage);
		
		return pager;
	}

	@Override
	public Task query(Integer id) {
		SqlSession session = MyBatisUtil.getSqlSession();
		taskDAO = session.getMapper(TaskDAO.class);
		
		Task task = taskDAO.query(id);
		
		session.close();
		
		return task;
	}

	@Override
	public int update(Task t) {
		SqlSession session = MyBatisUtil.getSqlSession();
		taskDAO = session.getMapper(TaskDAO.class);
		
		int res = taskDAO.update(t);
		
		session.commit();
		session.close();
		
		return res;
	}

	@Override
	public int add(Task task) {
		SqlSession session = MyBatisUtil.getSqlSession();
		taskDAO = session.getMapper(TaskDAO.class);
		
		int res = taskDAO.add(task);
		
		session.commit();
		session.close();
		
		return res;
	}

}





