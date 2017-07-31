package com.henghao.Garden.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.henghao.Garden.resultEntity.*;
import com.henghao.Garden.service.DUProjectManageService;

/**
 * function 项目管理模块更新批量删除Java类
 * 
 * date 2017.03.29
 * 
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.POST })
@Controller
@RequestMapping("/projectManage")
public class DUProjectManageController {

	@Resource
	private DUProjectManageService service;
	// 实例化结果集实体类，并定义为公共结果集
	private Result result = null;

	// 批量删除项目管理信息数据访问接口
	@ResponseBody
	@RequestMapping(value = "/delete/{type}", produces = "application/json;charset=utf-8", method = { RequestMethod.POST })
	public Result deleteController(@RequestBody List<BatchID> list,
			@PathVariable("type") String type) {
		if (list.size() > 0) {
			if ("alteration".equals(type)) {
				// 批量删除变更管理信息数据
				this.result = this.service.deleteAlterationService(list);
				return this.result;
			} else if ("checkout".equals(type)) {
				// 批量删除工序报验信息数据
				this.result = this.service.deleteCheckoutService(list);
				return this.result;
			} else if ("constructionLog".equals(type)) {
				// 批量删除施工日志信息数据
				this.result = this.service.deleteConstructionLogService(list);
				return this.result;
			} else if ("constructionSafetyLog".equals(type)) {
				// 批量删除施工安全日志信息数据
				this.result = this.service
						.deleteConstructionSafetyLogService(list);
				return this.result;
			} else if ("declaration".equals(type)) {
				// 批量删除进度申报信息数据
				this.result = this.service.deleteDeclarationService(list);
				return this.result;
			} else if ("equipment".equals(type)) {
				// 批量删除设备信息信息数据
				this.result = this.service.deleteEquipmentService(list);
				return this.result;
			} else if ("finalacceptance".equals(type)) {
				// 批量删除竣工验收信息数据
				this.result = this.service.deleteFinalacceptanceService(list);
				return this.result;
			} else if ("hsResult".equals(type)) {
				// 批量删除会审结果信息数据
				this.result = this.service.deleteHsResultService(list);
				return this.result;
			} else if ("kgReport".equals(type)) {
				// 批量删除开工报告信息数据
				this.result = this.service.deleteKgReportService(list);
				return this.result;
			} else if ("mylocus".equals(type)) {
				// 批量删除我的轨迹信息数据
				this.result = this.service.deleteMylocusService(list);
				return this.result;
			} else if ("project".equals(type)) {
				// 批量删除项目信息信息数据
				this.result = this.service.deleteProjectService(list);
				return this.result;
			} else if ("prospect".equals(type)) {
				// 批量删除现场施工检验信息数据
				this.result = this.service.deleteProspectService(list);
				return this.result;
			} else if ("settlement".equals(type)) {
				// 批量删除项目结算信息数据
				this.result = this.service.deleteSettlementService(list);
				return this.result;
			} else if ("sgPersonnel".equals(type)) {
				// 批量删除施工人员信息数据
				this.result = this.service.deleteSgPersonnelService(list);
				return this.result;
			} else if ("supervisionlog".equals(type)) {
				// 批量删除监理日志信息数据
				this.result = this.service.deleteSupervisionlogService(list);
				return this.result;
			} else if ("supplier".equals(type)) {
				// 批量删除供货商信息数据
				this.result = this.service.deleteSupplierService(list);
				return this.result;
			} else if ("technology".equals(type)) {
				// 批量删除技术交底信息数据
				this.result = this.service.deleteTechnologyService(list);
				return this.result;
			}
			return null;
		} else {
			return this.result = new Result("资源不存在", 1);
		}
	}
}
