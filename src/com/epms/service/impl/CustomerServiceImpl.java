package com.epms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.epms.dao.CustomerDAO;
import com.epms.pojo.Customer;
import com.epms.pojo.Pager;
import com.epms.service.CustomerService;
import com.epms.util.MyBatisUtil;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public Pager<Customer> list(int pageOffset, int pageSize) {
		
		Pager<Customer> pager = new Pager<Customer>(); 
		
		SqlSession session = MyBatisUtil.getSqlSession();
		customerDAO = session.getMapper(CustomerDAO.class);
		
		List<Customer> customers = customerDAO.queryByPage(pageOffset, pageSize);
		
		// 总记录数
		int totalRecord = customerDAO.totalRecord();	
		// 总页数
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
		
		pager.setDatas(customers);
		pager.setTotalRecord(totalRecord);
		pager.setTotalPage(totalPage);
		
		session.close();
		
		return pager;
	}

	@Override
	public Customer query(Integer id) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		customerDAO = session.getMapper(CustomerDAO.class);
		
		Customer customer = customerDAO.query(id);
		
		session.close();
		
		return customer;
	}

	@Override
	public int update(Customer customer) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		customerDAO = session.getMapper(CustomerDAO.class);
		
		int res = customerDAO.update(customer);
		
		session.commit();
		session.close();
		
		return res;
	}

	@Override
	public int add(Customer customer) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		customerDAO = session.getMapper(CustomerDAO.class);
		
		int res = customerDAO.add(customer);
		
		session.commit();
		session.close();
		
		return res;
	}

}
