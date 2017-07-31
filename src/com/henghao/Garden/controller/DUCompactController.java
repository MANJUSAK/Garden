package com.henghao.Garden.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DUCompactService;

/**
 * function 合同管理模块批量更新删除访问接口Java类
 * 
 * date 2017.04.24
 * 
 * @author 严彬荣
 */
@Controller
@RequestMapping("deleteCompact")
public class DUCompactController {

	@Resource
	private DUCompactService service;
	// 实例化公共结果集
	private Result result = null;

	// 批量删除建设类合同数据访问接口
	@ResponseBody
	@RequestMapping(value = "/build", produces = "application/json;charset=utf-8")
	public Result deleteBuildController(@RequestBody List<BatchID> list) {
		if (list == null || list.size() == 0) {
			this.result = new Result("未选则相关数据", 1);
		} else {
			this.result = this.service.deleteBuildCompactService(list);
		}
		return this.result;
	}

	// 批量删除园林类合同数据访问接口
	@ResponseBody
	@RequestMapping(value = "/garden", produces = "application/json;charset=utf-8")
	public Result deleteGardenController(@RequestBody List<BatchID> list) {
		if (list == null || list.size() == 0) {
			this.result = new Result("未选则相关数据", 1);
		} else {
			this.result = this.service.deleteGardenCompactService(list);
		}
		return this.result;
	}

	// 批量删除园林工程类合同数据访问接口
	@ResponseBody
	@RequestMapping(value = "/engineering", produces = "application/json;charset=utf-8")
	public Result deleteEngineeringController(@RequestBody List<BatchID> list) {
		if (list == null || list.size() == 0) {
			this.result = new Result("未选则相关数据", 1);
		} else {
			this.result = this.service.deleteEngineeringCompactService(list);
		}
		return this.result;
	}

	// 批量删除景观类合同数据访问接口
	@ResponseBody
	@RequestMapping(value = "/landscape", produces = "application/json;charset=utf-8")
	public Result deleteLandsacpeController(@RequestBody List<BatchID> list) {
		if (list == null || list.size() == 0) {
			this.result = new Result("未选则相关数据", 1);
		} else {
			this.result = this.service.deleteLandscapeCompactService(list);
		}
		return this.result;
	}
}
