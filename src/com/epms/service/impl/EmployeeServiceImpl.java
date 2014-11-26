package com.epms.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.epms.dao.EmployeeDAO;
import com.epms.pojo.EmpType;
import com.epms.pojo.Employee;
import com.epms.pojo.JobType;
import com.epms.pojo.Pager;
import com.epms.service.EmployeeService;
import com.epms.util.MyBatisUtil;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public Employee find(String empnum, String password) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Employee employee = employeeDAO.find(empnum, password);
		
		session.close();
		
		return employee;
	}

	@Override
	public Pager<Employee> list(int pageOffset, int pageSize) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Pager<Employee> pager = new Pager<Employee>();
		
		int totalRecord = employeeDAO.totalRecord();
		List<Employee> employees = employeeDAO.queryByPage(pageOffset, pageSize);
		
		int totalPage = totalRecord % pageSize == 0? totalRecord / pageSize : totalRecord / pageSize + 1;
				
		pager.setTotalRecord(totalRecord); // 总记录数
		pager.setDatas(employees);
		pager.setTotalPage(totalPage);	// 总页数
		
		session.close();
		
		return pager;
	}

	@Override
	public Employee query(Integer id) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Employee employee = employeeDAO.query(id);
		
		session.close();
		
		return employee;
	}

	@Override
	public List<JobType> jobTypes() {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		List<JobType> jobTypes = employeeDAO.jobTypes();
		
		session.close();
		
		return jobTypes;
	}

	@Override
	public List<EmpType> empTypes() {

		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		List<EmpType> empTypes = employeeDAO.empTypes();
		
		session.close();
		
		return empTypes;
	}

	@Override
	public int update(Employee employee) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		int res = employeeDAO.update(employee);

		session.commit();
		session.close();
		
		return res;
	}

	@Override
	public int add(Employee employee) {
		
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		int res = employeeDAO.add(employee);
		
		session.commit();
		session.close();
		
		return res;
	}

	@Override
	public Employee queryByNumber(Integer empNum) {
		SqlSession session = MyBatisUtil.getSqlSession();
		employeeDAO = session.getMapper(EmployeeDAO.class);
		
		Employee employee = employeeDAO.queryByNumber(empNum);
		
		session.close();
		
		return employee;
	}
}



















