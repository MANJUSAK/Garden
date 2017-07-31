package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.DUDemandReleaseDao;
import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DUDemandReleaseService;

/**
 * function 需求发布批量更新删除业务处理Java类
 * 
 * date 2017-03-28
 * 
 * @author 严彬荣
 */

@Service
public class DUDemandReleaseServicelmpl implements DUDemandReleaseService {

	@Resource
	private DUDemandReleaseDao dao;
	// 实例化结果集实体类,并定义为公共结果集
	private Result result = null;

	// 批量删除我发布的设备租赁信息数据方法
	@Override
	public Result deleteEquipmentleasingService(List<BatchID> list) {
		try {
			this.dao.deleteEquipmentleasingDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 批量删除我发布的苗木信息数据方法
	@Override
	public Result deleteSeedlingmassageService(List<BatchID> list) {
		try {
			this.dao.deleteSeedlingmassageDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 批量删除我发布的人员招聘信息数据方法
	@Override
	public Result deleteRecruitService(List<BatchID> list) {
		try {
			this.dao.deleteRecruitDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}
}
