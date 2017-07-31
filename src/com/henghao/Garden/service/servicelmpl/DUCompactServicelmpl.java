package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.DUCompactDao;
import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DUCompactService;

/**
 * function 合同管理批量更新删除业务处理Java类
 * 
 * date 2017-04-24
 * 
 * @author 严彬荣
 */

@Service
public class DUCompactServicelmpl implements DUCompactService {

	@Resource
	private DUCompactDao dao;
	// 实例化公共结果集实体
	private Result result = null;

	// 批量删除建设类合同数据方法
	@Override
	public Result deleteBuildCompactService(List<BatchID> list) {
		try {
			this.dao.deleteBuildCompactDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了", 1);
		}
		return this.result;
	}

	// 批量删除园林类合同数据方法
	@Override
	public Result deleteGardenCompactService(List<BatchID> list) {
		try {
			this.dao.deleteGardenCompactDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了", 1);
		}
		return this.result;
	}

	// 批量删除园林工程类合同数据方法
	@Override
	public Result deleteEngineeringCompactService(List<BatchID> list) {
		try {
			this.dao.deleteEngineeringCompactDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了", 1);
		}
		return this.result;
	}

	// 批量删除景观类合同数据方法
	@Override
	public Result deleteLandscapeCompactService(List<BatchID> list) {
		try {
			this.dao.deleteLandscapeCompactDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了", 0);
		}
		return this.result;
	}

}
