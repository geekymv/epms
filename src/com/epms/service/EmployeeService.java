package com.epms.service;

import java.util.List;

import com.epms.pojo.EmpType;
import com.epms.pojo.Employee;
import com.epms.pojo.JobType;

public interface EmployeeService extends BaseService<Employee> {
	
	/**
	 * 根据员工编号和密码查询员工
	 * @param empnum
	 * @param password
	 * @return
	 */
	public Employee find(String empnum, String password);
	
	/**
	 * 获得所有的职业类型
	 * @return
	 */
	public List<JobType> jobTypes();
	
	/**
	 * 获得所有的员工类型
	 * @return
	 */
	public List<EmpType> empTypes();
	
	/**
	 * 根据员工编号查询
	 * @param empNum
	 * @return
	 */
	public Employee queryByNumber(Integer empNum);

}
