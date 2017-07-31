package com.henghao.Garden.service;

import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;

import java.util.List;

/**
 * function 合同管理批量更新删除业务处理Java接口类
 * 
 * date 2017-04-24
 * 
 * @author 严彬荣
 */
public interface DUCompactService {

	// 批量删除建设类合同数据接口
	public Result deleteBuildCompactService(List<BatchID> list);

	// 批量删除园林类合同数据接口
	public Result deleteGardenCompactService(List<BatchID> list);

	// 批量删除园林工程类合同数据接口
	public Result deleteEngineeringCompactService(List<BatchID> list);

	// 批量删除景观类合同数据接口
	public Result deleteLandscapeCompactService(List<BatchID> list);

}
