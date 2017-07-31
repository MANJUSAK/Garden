package com.henghao.Garden.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * function 日期工具类
 * 
 * date 2017.02.28
 * 
 * @author 严彬荣
 */
public class DateUtil {
	/**
	 * 创建DateUitl类单例
	 * **/
	private volatile static DateUtil instance;

	private DateUtil() {
	}

	public static DateUtil getInstance() {
		if (instance == null) {
			synchronized (DateUtil.class) {
				if (instance == null)
					instance = new DateUtil();
			}
		}
		return instance;
	}

	// 扫描植物信息数据时间段方法
	public int judge(String time) {

		// 获取第一次扫描植物信息数据时间并转换为时间格式
		Date treeDate = null;
		try {
			treeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
		// 将字符串日期转换为时间戳
		long treeTime = treeDate.getTime();
		// 设置时间段
		// treeTime += 480 * 60 * 1000;
		// 获取当天最晚日期并转换格式与植物信息格式一至
		String newTime = new SimpleDateFormat("yyyy-MM-dd 23:59")
				.format(treeDate);
		// 将当天最晚日期转换为时间格式
		Date systemDate = null;
		try {
			systemDate = new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.parse(newTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
		// 将当天最晚日期转换为时间戳
		long newDate = systemDate.getTime();
		if (treeTime < newDate) {
			return 1;
		}
		return 0;

	}

	public boolean delayed(long time) {
		// 增加一个小时时间
		time += 180 * 60 * 180;
		// 系统当前时间
		long newTime = System.currentTimeMillis();
		// 如果超过一个小时返回假，以便执行数据库查询
		if (newTime > time)
			return false;
		return true;
	}
}
