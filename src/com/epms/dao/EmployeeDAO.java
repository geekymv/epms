package com.epms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epms.pojo.EmpType;
import com.epms.pojo.Employee;
import com.epms.pojo.JobType;

public interface EmployeeDAO extends BaseDAO<Employee>{
	
	/**
	 * 根据员工编号和密码查询员工
	 * @param empnum
	 * @param password
	 * @return
	 */
	public Employee find(@Param("empnum")String empnum, @Param("password")String password);
	
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
