package com.epms.pojo;

import java.util.Date;

/**
 * 模块类
 *
 * 一个需求可以有多个模块
 * @author Geek_ymv
 */
public class Module {
	
	private Integer id;
	private String name; /*模块名称*/
	private Requirement requirement; /*所属需求*/
	private Date createDate; /*创建时间*/
	private String priority; /*优先级*/
	private String description; /*模块描述*/
	
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
	public Requirement getRequirement() {
		return requirement;
	}
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
