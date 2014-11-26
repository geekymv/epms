package com.epms.pojo;

import java.util.Date;

/**
 * 客户
 * @author Geek_ymv
 */
public class Customer {
	
	private Integer id;
	private String name;	// 公司名称
	private String contacts; // 联系人
	private String phone; // 联系电话
	private String address; // 联系地址
	private String background; // 公司背景
	private Date addtime; // 添加时间
	private String remarks; // 备注
	
	public Customer() {
	}
	public Customer(Integer id) {
		this.id = id;
	}
	
	public Customer(String name, String contacts, String phone,
			String address, String background, Date addtime, String remarks) {
		
		this.name = name;
		this.contacts = contacts;
		this.phone = phone;
		this.address = address;
		this.background = background;
		this.addtime = addtime;
		this.remarks = remarks;
	}
	
	public Customer(Integer id, String name, String contacts, String phone,
			String address, String background, Date addtime, String remarks) {
		
		this(name, contacts, phone, address, background, addtime, remarks);
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
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contacts="
				+ contacts + ", phone=" + phone + ", address=" + address
				+ ", background=" + background + ", addtime=" + addtime
				+ ", remarks=" + remarks + "]";
	}
	
}
