package com.epms.dao.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.epms.dao.EmployeeDAO;
import com.epms.pojo.EmpType;
import com.epms.pojo.Employee;
import com.epms.pojo.JobType;
import com.epms.util.MyBatisUtil;

public class EmployeeDAOTest {
	
	@Test
	public void testPageOffset() {
		SqlSession session = MyBatisUtil.getSqlSession();
		EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);
		
		List<Employee> emps = employeeDAO.queryByPage(5, 5);
		
		for (Employee employee : emps) {
			System.out.println(employee.getId());
		}
	}
	
	@Test
	public void testTotalRecord() {
		SqlSession session = MyBatisUtil.getSqlSession();
		EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);
		
		int total = employeeDAO.totalRecord();
		
		System.out.println(total);
	}
	
	@Test
	public void testUpdate() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Employee employee = employeeDAO.query(1);
		
		employee.setAddress("江苏南京");
		employee.setName("江苏");
		
		int res = employeeDAO.update(employee);
		
		System.out.println(res);
		
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testAdd(){
		
		SqlSession session = MyBatisUtil.getSqlSession();
		EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Employee e = new Employee("1002", "123", "紫霞", "女", new Date(), "1234567890", "123@gmail.com", 
				"中国大唐", new JobType(2), new EmpType(3), new Date(), "坐等至尊宝");
		
		employeeDAO.add(e);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testQuery() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Employee employee = employeeDAO.query(1);
		
		System.out.println(employee);
		
		session.close();
	}
	
	
	
}
