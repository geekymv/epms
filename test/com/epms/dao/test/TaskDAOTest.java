package com.epms.dao.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.epms.dao.TaskDAO;
import com.epms.pojo.Employee;
import com.epms.pojo.Task;
import com.epms.util.MyBatisUtil;

public class TaskDAOTest {
	
	@Test
	public void testQuery() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		TaskDAO taskDAO = session.getMapper(TaskDAO.class);
	
		Task task = taskDAO.query(2);
		
		System.out.println(task);
		
		session.close();
	}
	
	@Test
	public void testAdd() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		TaskDAO taskDAO = session.getMapper(TaskDAO.class);
		
		Task task = new Task("任务三", "一个月", new Employee(2), new Date(), new Employee(4), new Date(), new Date(), "急急急", "这个任务很急~~~~", "执行中");
		
		taskDAO.add(task);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		TaskDAO taskDAO = session.getMapper(TaskDAO.class);
	
		Task task = taskDAO.query(2);
		
		task.setExplain("hahaha");
		task.setEndtime(new Date());
		
		int res = taskDAO.update(task);
		
		System.out.println(res);
		
		session.commit();
		session.close();
	}

}






















