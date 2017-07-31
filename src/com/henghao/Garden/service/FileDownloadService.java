package com.henghao.Garden.service;

import com.henghao.Garden.entity.project.KgReport;

/**
 * function 文件下载业务处理接口Java类
 * 
 * @author 严彬荣
 */
public interface FileDownloadService {
	// 下载开工报告接口
	public KgReport queryKgReportFilePathService(String uid, int kid);

}
