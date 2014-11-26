package com.epms.pojo;

/**
 * 职位类
 * 程序员，项目经理，部门经理
 * @author Geek_ymv
 */
public class JobType {
	
	private Integer id;
	private String name;
	private int authority;	//权限
	
	public JobType() {
	}
	public JobType(Integer id) {
		this.id = id;
	}
	public JobType(Integer id, String name, int authority) {
		this.id = id;
		this.name = name;
		this.authority = authority;
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
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "JobType [id=" + id + ", name=" + name + ", authority="
				+ authority + "]";
	}
}
