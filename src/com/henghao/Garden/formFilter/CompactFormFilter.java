package com.henghao.Garden.formFilter;

/**
 * function 合同管理表单验证工具类
 * 
 * date 2017.05.25
 * 
 * @author 严彬荣
 */
public class CompactFormFilter {

	/* 创建本类为单例模式 */
	private volatile static CompactFormFilter instance;

	private CompactFormFilter() {
	}

	public static CompactFormFilter getInstance() {
		if (instance == null) {
			synchronized (CompactFormFilter.class) {
				if (instance == null)
					instance = new CompactFormFilter();
			}
		}
		return instance;
	}

	// 合同表单验证
	public boolean compactForm(String name, String gener, String uid) {
		if (name == null || gener == null || uid == null) {
			return false;
		}
		if (name.length() <= 0 || name.length() > 150) {
			return false;
		} else if (gener.length() <= 0 || gener.length() > 50) {
			return false;
		} else if (uid.length() <= 0 || uid.length() > 32) {
			return false;
		} else {
			return true;
		}
	}
}
