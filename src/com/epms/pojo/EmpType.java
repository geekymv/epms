package com.epms.pojo;

/**
 * 员工类型类
 * 实习生
 * 试用员工
 * 正式员工
 * @author Geek_ymv
 */
public class EmpType {
	
	private Integer id;
	private String name;
	
	public EmpType() {
	}
	public EmpType(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "EmpType [id=" + id + ", name=" + name + "]";
	}
}
