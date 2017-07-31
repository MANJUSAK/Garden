package com.henghao.Garden.service;

import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;

import java.util.List;

/**
 * function 项目管理模块更新批量删除业务逻辑接口Java类
 * 
 * @author 严彬荣
 */
public interface DUProjectManageService {

	// 批量删除变更管理信息数据接口
	public Result deleteAlterationService(List<BatchID> list);

	// 批量删除工序报验信息数据接口
	public Result deleteCheckoutService(List<BatchID> list);

	// 批量删除施工日志信息数据接口
	public Result deleteConstructionLogService(List<BatchID> list);

	// 批量删除安全施工日志信息数据接口
	public Result deleteConstructionSafetyLogService(List<BatchID> list);

	// 批量删除进度申报信息数据接口
	public Result deleteDeclarationService(List<BatchID> list);

	// 批量删除设备信息信息数据接口
	public Result deleteEquipmentService(List<BatchID> list);

	// 批量删除竣工验收信息数据接口
	public Result deleteFinalacceptanceService(List<BatchID> list);

	// 批量删除会审结果信息数据接口
	public Result deleteHsResultService(List<BatchID> list);

	// 批量删除开工报告信息数据接口
	public Result deleteKgReportService(List<BatchID> list);

	// 批量删除我的轨迹信息数据接口
	public Result deleteMylocusService(List<BatchID> list);

	// 批量批量删除项目信息信息数据接口
	public Result deleteProjectService(List<BatchID> list);

	// 批量删除现场施工检验信息数据接口
	public Result deleteProspectService(List<BatchID> list);

	// 批量删除项目结算信息数据接口
	public Result deleteSettlementService(List<BatchID> list);

	// 批量删除施工人员信息数据接口
	public Result deleteSgPersonnelService(List<BatchID> list);

	// 批量删除监理日志信息数据接口
	public Result deleteSupervisionlogService(List<BatchID> list);

	// 批量删除供货商信息数据接口
	public Result deleteSupplierService(List<BatchID> list);

	// 批量删除技术交底信息数据接口
	public Result deleteTechnologyService(List<BatchID> list);
}
