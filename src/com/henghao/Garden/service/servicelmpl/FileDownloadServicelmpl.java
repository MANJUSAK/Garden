package com.henghao.Garden.service.servicelmpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.FileDownloadDao;
import com.henghao.Garden.entity.project.KgReport;
import com.henghao.Garden.service.FileDownloadService;

/**
 * function 文件下载业务处理Java类
 * 
 * @author 严彬荣
 */
@Service
public class FileDownloadServicelmpl implements FileDownloadService {

	@Resource
	private FileDownloadDao dao;

	// 下载开工报告方法
	@Override
	public KgReport queryKgReportFilePathService(String uid, int kid) {
		return this.dao.queryKgReportFilePathDao(uid, kid);
	}
}
