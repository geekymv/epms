package com.epms.util;

public class SystemContext {
	
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
//	private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
	
	public static void setPageSize(int pageSize_){
		pageSize.set(pageSize_);
	}
	public static int getPageSize(){
		return pageSize.get();
	}
	public static void removePageSize(){
		pageSize.remove();
	}
	
	public static void setPageOffset(int pageOffset_){
		pageOffset.set(pageOffset_);
	}
	public static int getPageOffset(){
		return pageOffset.get();
	}
	public static void removePageOffset(){
		pageOffset.remove();
	}
	
}
