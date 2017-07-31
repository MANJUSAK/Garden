package com.henghao.Garden.formFilter;

import com.henghao.Garden.entity.user.Users;

/**
 * function 登陆注册表单验证工具类
 * 
 * date 2017.05.25
 * 
 * @author 严彬荣
 */
public class LoginFromFilterUtil {

	/* 创建CharsetFilteringUtil单例 */

	private volatile static LoginFromFilterUtil instance;

	private LoginFromFilterUtil() {
	}

	public static LoginFromFilterUtil getInstance() {

		if (instance == null) {
			synchronized (LoginFromFilterUtil.class) {
				if (instance == null)
					instance = new LoginFromFilterUtil();
			}
		}
		return instance;
	}

	// 邮箱正则
	// private final String EMAIL =
	// "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	// 手机号正则
	private final String TEL = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[^4,5-9]))\\d{8}$";
	// 身份证号码正则
	private final String IDCARD = "(^\\d{18}$)|(^\\d{15}$)";

	// 登陆字符验证
	public boolean checkLogin(String name, String pwd) {
		if (name == null || pwd == null) {
			return false;
		}
		if (name.length() <= 0) {
			return false;
		} else if (pwd.length() <= 3) {
			return false;
		} else {
			return true;
		}
	}

	// 注册字符验证
	public boolean checkRegister(Users user) {
		if (user.getUsername() == null || user.getContact() == null
				|| user.getLegalPersonIDcard() == null
				|| user.getPassword() == null || user.getTel() == null) {
			return false;
		}
		if (user.getUsername().length() < 1 || user.getUsername().length() > 15) {
			return false;
		} else if (!(user.getTel().matches(this.TEL))) {
			return false;
		} else if (!(user.getLegalPersonIDcard().matches(this.IDCARD))) {
			return false;
		} else if (user.getPassword().length() < 6
				|| user.getPassword().length() > 16) {
			return false;
		} else if (user.getContact().length() < 1
				|| user.getContact().length() > 15) {
			return false;
		} else {
			return true;
		}
	}
}
