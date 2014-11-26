package com.epms.pojo;

import java.util.Date;

/**
 * 项目类
 * @author Geek_ymv
 */
public class Project {

	private Integer id;
	private String name; /*项目名称*/
	private Customer customer; /*客户(所属单位)*/
	private Employee employee; /*项目经理*/
	private int devenum; /*开发人数*/
	private Date setupDate;	/*立项时间(添加时间)*/
	private Date startDate;	/*开始时间(计划开发日期)*/
	private Date actualDevDate; /*实际开发日期*/
	private Date actualFinDate; /*实际完成日期*/
	private Date updateTime; /*更新时间*/
	private String money; /*项目总金额(预算总成本)*/
	private String actualCosts; /*实际总成本*/
	private String priority; /*优先级*/
	private String status; /*完成状态*/
	private String remarks; /*备注*/
	
	public Project() {
	}

	public Project(String name, Customer customer, Employee employee,
			int devenum, Date setupDate, Date startDate, Date actualDevDate,
			Date actualFinDate, Date updateTime, String money,
			String actualCosts, String priority, String status, String remarks) {
		this.name = name;
		this.customer = customer;
		this.employee = employee;
		this.devenum = devenum;
		this.setupDate = setupDate;
		this.startDate = startDate;
		this.actualDevDate = actualDevDate;
		this.actualFinDate = actualFinDate;
		this.updateTime = updateTime;
		this.money = money;
		this.actualCosts = actualCosts;
		this.priority = priority;
		this.status = status;
		this.remarks = remarks;
	}





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getDevenum() {
		return devenum;
	}
	public void setDevenum(int devenum) {
		this.devenum = devenum;
	}
	public Date getSetupDate() {
		return setupDate;
	}
	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getActualDevDate() {
		return actualDevDate;
	}
	public void setActualDevDate(Date actualDevDate) {
		this.actualDevDate = actualDevDate;
	}
	public Date getActualFinDate() {
		return actualFinDate;
	}
	public void setActualFinDate(Date actualFinDate) {
		this.actualFinDate = actualFinDate;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getActualCosts() {
		return actualCosts;
	}
	public void setActualCosts(String actualCosts) {
		this.actualCosts = actualCosts;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
