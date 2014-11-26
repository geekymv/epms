package com.epms.pojo;

import java.util.Date;

/**
 * 任务类
 * @author Geek_ymv
 */
public class Task {
	
	private Integer id;
	private String title; /*任务标题*/
	private String period; /*工期*/
	private Employee creator; /*任务创建者(发送者)*/
	private Date createtime; /*创建时间*/
	private Employee executor; /*任务执行人*/
	private Date starttime; /*计划开始时间*/
	private Date endtime; /*计划结束时间*/
	private String priority; /*优先级*/
	private String explain; /*任务说明*/
	private String status; /*状态*/
	
	public Task() {
	}
	public Task(Integer id, String title, String period, Employee creator,
			Date createtime, Employee executor, Date starttime, Date endtime,
			String priority, String explain, String status) {
		
		this(title, period, creator, createtime, executor, starttime, endtime, priority, explain, status);
		this.id = id;
	}

	public Task(String title, String period, Employee creator,
			Date createtime, Employee executor, Date starttime, Date endtime,
			String priority, String explain, String status) {
		this.title = title;
		this.period = period;
		this.creator = creator;
		this.createtime = createtime;
		this.executor = executor;
		this.starttime = starttime;
		this.endtime = endtime;
		this.priority = priority;
		this.explain = explain;
		this.status = status;
	}

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
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Employee getCreator() {
		return creator;
	}
	public void setCreator(Employee creator) {
		this.creator = creator;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Employee getExecutor() {
		return executor;
	}
	public void setExecutor(Employee executor) {
		this.executor = executor;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", period=" + period
				+ ", creator=" + creator + ", createtime=" + createtime
				+ ", executor=" + executor + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", priority=" + priority
				+ ", explain=" + explain + ", status=" + status + "]";
	}
	
}
