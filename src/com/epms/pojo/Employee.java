package com.epms.pojo;

import java.util.Date;

/**
 * 员工类
 * @author Geek_ymv
 *
 */
public class Employee {
	
	private Integer id;
	private String empNum;
	private String password;
	private String name;
	private String gender;
	private Date birthday;
	private String phone;
	private String email;
	private String address;
	private JobType jobType;	// 职位
	private EmpType empType;	// 员工类型
	private Date hiredate;
	private String description;
	
	public Employee() {
	}
	public Employee(Integer id) {
		this.id = id;
	}
	public Employee(String empNum, String password, String name,
			String gender, Date birthday, String phone, String email,
			String address, JobType jobType, EmpType empType, Date hiredate,
			String description) {
		this.empNum = empNum;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.jobType = jobType;
		this.empType = empType;
		this.hiredate = hiredate;
		this.description = description;
	}
	
	public Employee(Integer id, String empNum, String password, String name,
			String gender, Date birthday, String phone, String email,
			String address, JobType jobType, EmpType empType, Date hiredate,
			String description) {
		this(empNum, password, name, gender, birthday, phone, email, address, jobType, empType, hiredate, description);
		
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public EmpType getEmpType() {
		return empType;
	}
	public void setEmpType(EmpType empType) {
		this.empType = empType;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empNum=" + empNum + ", password="
				+ password + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", jobType=" + jobType
				+ ", empType=" + empType + ", hiredate=" + hiredate
				+ ", description=" + description + "]";
	}
}

