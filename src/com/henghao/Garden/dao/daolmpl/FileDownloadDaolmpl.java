package com.henghao.Garden.dao.daolmpl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.henghao.Garden.dao.FileDownloadDao;
import com.henghao.Garden.entity.project.KgReport;

/**
 * function 文件下载访问数据库Java类
 * 
 * @author 严彬荣
 */
@Repository
public class FileDownloadDaolmpl implements FileDownloadDao {

	@Resource
	private SessionFactory factory;

	// 下载开工报告dao方法
	@Override
	public KgReport queryKgReportFilePathDao(String uid, int kid) {
		return (KgReport) this.factory
				.getCurrentSession()
				.createQuery(
						"from KgReport where uid=:uid and kid=:kid and isNo=0")
				.setParameter("uid", uid).setParameter("kid", kid)
				.uniqueResult();
	}

}
