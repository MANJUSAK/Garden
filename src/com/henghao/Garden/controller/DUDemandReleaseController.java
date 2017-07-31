package com.henghao.Garden.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DUDemandReleaseService;

/**
 * function 需求发布模块更新删除访问接口Java类
 * 
 * date 2017.03.28
 * 
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
@Controller
@RequestMapping("/release")
public class DUDemandReleaseController {
	@Resource
	private DUDemandReleaseService service;
	// 实例化结果集实体类，并定义为公共结果集
	private Result result = null;

	// 批量删除需求发布信息数据访问接口
	@ResponseBody
	@RequestMapping(value = "/delete/{type}", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public Result deleteController(@PathVariable("type") String type,
			@RequestBody List<BatchID> list) {
		if ("equipmentleasing".equals(type)) {
			// 删除我的设备租赁信息数据
			this.result = this.service.deleteEquipmentleasingService(list);
			return this.result;
		} else if ("seedlingmassage".equals(type)) {
			// 删除我发布的苗木信息数据
			this.result = this.service.deleteSeedlingmassageService(list);
			return this.result;
		} else if ("recruit".equals(type)) {
			// 删除我发布的人员招聘信息数据
			this.result = this.service.deleteRecruitService(list);
			return this.result;
		}
		return this.result = new Result("资源不存在", 1);
	}
}
