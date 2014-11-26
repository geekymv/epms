package com.epms.dao.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.epms.dao.ProjectDAO;
import com.epms.pojo.Customer;
import com.epms.pojo.Employee;
import com.epms.pojo.Project;
import com.epms.util.MyBatisUtil;

public class ProjectDAOTest {
	
	@Test
	public void testAdd() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		ProjectDAO projectDAO = session.getMapper(ProjectDAO.class);
		
		Customer customer = new Customer(3);
		Employee employee = new Employee(1);
		
		Project project = new Project("项目二", customer, employee, 4, new Date(), new Date(), new Date(), 
				new Date(), new Date(), "30万", "20万", "急", "已完成", "项目进展很顺利~~~");
		
		projectDAO.add(project);
		
		session.commit();
		session.close();
	}
}
