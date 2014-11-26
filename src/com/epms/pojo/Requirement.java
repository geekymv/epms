package com.epms.pojo;

import java.util.Date;

/**
 * 项目需求类
 * 一个项目可以有多个需求
 * @author Geek_ymv
 */
public class Requirement {

	private Integer id;
	private String title; /*需求标题*/
	private Project project; /*所属项目*/
	private Date createDate; /*创建时间*/
	private Date updateDate; /*更新时间*/
	private String remarks; /*备注*/
	private String description; /*需求描述*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
