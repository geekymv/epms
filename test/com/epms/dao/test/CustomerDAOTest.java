package com.epms.dao.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.epms.dao.CustomerDAO;
import com.epms.pojo.Customer;
import com.epms.util.MyBatisUtil;

public class CustomerDAOTest {
	
	@Test
	public void testQueryByPage() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		CustomerDAO customerDAO = session.getMapper(CustomerDAO.class);
		
		List<Customer> customers = customerDAO.queryByPage(0, 3);
		
		for (Customer customer : customers) {
			System.out.println(customer.getId());
		}
		
		
	}
	
	@Test
	public void testUpdate() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		CustomerDAO customerDAO = session.getMapper(CustomerDAO.class);
		
		Customer customer = customerDAO.query(1);
		
		customer.setAddress("美国纽约");
		
		customerDAO.update(customer);
		
		session.commit();
		session.close();
		
	}
	
	@Test
	public void testAdd(){
		
		SqlSession session = MyBatisUtil.getSqlSession();
		CustomerDAO customerDAO = session.getMapper(CustomerDAO.class);
		
		Customer customer = new Customer("华为", "任先生", "111", "中国深圳", 
				"华为技术有限公司是一家生产销售通信设备的民营通信科技公司", new Date(), "华为于1987年在中国深圳正式注册成立。");
		
		customerDAO.add(customer);
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testQuery() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		CustomerDAO customerDAO = session.getMapper(CustomerDAO.class);
	
		Customer customer = customerDAO.query(1);
		
		System.out.println(customer);
	}
	
	
	
}
