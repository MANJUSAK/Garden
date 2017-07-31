package com.henghao.Garden.dao;

import com.henghao.Garden.entity.project.KgReport;

/**
 * function 文件下载访问数据库接口Java类
 * 
 * date 2017.03.18
 * 
 * @author 严彬荣
 */
public interface FileDownloadDao {
	// 下载开工报告dao接口
	public KgReport queryKgReportFilePathDao(String uid, int kid);
}
