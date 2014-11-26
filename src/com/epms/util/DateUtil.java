package com.epms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 将日期转换成字符串
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		
		return format.format(date);
	}
	
	/**
	 * 将字符串转换成日期
	 * @param source
	 * @return
	 */
	public static Date string2Date(String source) {
		try {
			return format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
