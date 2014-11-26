package com.epms.service;

import com.epms.pojo.Pager;

public interface BaseService<T> {
	/**
	 * 分页查询
	 * @param pageOffset
	 * @param pageSize
	 * @return
	 */
	public Pager<T> list(int pageOffset, int pageSize);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T query(Integer id);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public int add(T t);

}
