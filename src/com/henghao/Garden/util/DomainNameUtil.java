package com.henghao.Garden.util;

import javax.servlet.http.HttpServletRequest;

/**
 * function 获取服务器域名工具类
 * 
 * date 2017.03.09
 * 
 * @author 严彬荣
 */
public class DomainNameUtil {

	/**
	 * 创建DomanNameUitl类单例
	 * 
	 * **/

	private volatile static DomainNameUtil instance;

	private DomainNameUtil() {
	}

	public static DomainNameUtil getInstance() {
		if (instance == null) {
			synchronized (DomainNameUtil.class) {
				if (instance == null)
					instance = new DomainNameUtil();
			}
		}
		return instance;
	}

	// 获得服务器域名并返回
	public String getDomainName(HttpServletRequest request) {
		StringBuffer domainName = null;
		// 判断服务器端口号是否为80
		if (request.getServerPort() == 80) {
			domainName = new StringBuffer(request.getScheme() + "://"
					+ request.getServerName());
		} else {
			domainName = new StringBuffer(request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort());
		}
		return domainName.toString();
	}
}
