package com.henghao.Garden.formFilter;

import com.henghao.Garden.entity.talentpool.Corporation;
import com.henghao.Garden.entity.talentpool.Employees;

/**
 * function 人才库表单验证工具类
 * 
 * date 2017.05.25
 * 
 * @author 严彬荣
 */
public class TalentpoolFormFilter {
	/* 创建本类为单例模式 */
	private volatile static TalentpoolFormFilter instance;

	private TalentpoolFormFilter() {
	}

	public static TalentpoolFormFilter getInstance() {
		if (instance == null) {
			synchronized (TalentpoolFormFilter.class) {
				if (instance == null)
					instance = new TalentpoolFormFilter();
			}
		}
		return instance;
	}

	// 手机号正则
	// private final String TEL =
	// "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	// 身份证号码正则
	// private final String IDCARD = "(^\\d{18}$)|(^\\d{15}$)";

	// 法人库表单验证
	public boolean corporationForm(Corporation msg) {
		if (msg.getName() == null || msg.getGender() == null
				|| msg.getCompanyName() == null
				|| msg.getCompanyProfile() == null || msg.getPosition() == null
				|| msg.getTitled() == null) {
			return false;
		}
		if (msg.getName().length() <= 0 || msg.getName().length() > 50) {
			return false;
		} else if (msg.getGender().longValue() < 1
				|| msg.getGender().longValue() > 2) {
			return false;
		} else if (msg.getCompanyName().length() <= 0
				|| msg.getCompanyName().length() > 100) {
			return false;
		} else if (msg.getCompanyProfile().length() <= 0
				|| msg.getCompanyProfile().length() > 3000) {
			return false;
		} else if (msg.getTitled().length() > 50) {
			return false;
		} else if (msg.getPosition().length() > 50) {
			return false;
		} else {
			return true;
		}
	}

	// 人才库表单验证
	public boolean employeesForm(Employees msg) {
		if (msg.getName() == null || msg.getPosition() == null
				|| msg.getNewProject() == null || msg.getTitled() == null
				|| msg.getCompanyName() == null || msg.getOldProject() == null
				|| msg.getGender() == null) {
			return false;
		}
		if (msg.getName().length() <= 0 || msg.getName().length() > 50) {
			return false;
		} else if (msg.getGender().longValue() < 1
				|| msg.getGender().longValue() > 2) {
			return false;
		} else if (msg.getCompanyName().length() <= 0
				|| msg.getCompanyName().length() > 100) {
			return false;
		} else if (msg.getTitled().length() > 50) {
			return false;
		} else if (msg.getPosition().length() > 50) {
			return false;
		} else if (msg.getOldProject().length() > 3000) {
			return false;
		} else if (msg.getNewProject().length() > 3000) {
			return false;
		} else {
			return true;
		}
	}
}
