package com.henghao.Garden.service;

import com.henghao.Garden.entity.leasing.Bid;
import com.henghao.Garden.entity.leasing.Equipmentleasing;
import com.henghao.Garden.entity.leasing.Recruit;
import com.henghao.Garden.entity.leasing.Seedlingmessage;
import com.henghao.Garden.resultEntity.Result;

import java.util.List;

/**
 * function 需求发布模块业务处理Java接口类
 * 
 * date 2017-03-28
 * 
 * @author 严彬荣
 */
public interface DemandReleaseService {

	// 查询发布的设备租赁信息接口
	public Result queryEquipmentLeasingService();

	// 查询用户发布的设备租赁信息接口
	public Result queryEquipmentLeasingByIdService(String uid);

	// 查询发布苗木信息公共数据接口
	public Result querySeedlingmessageService();

	// 查询用户发布的苗木信息数据接口
	public Result querySeedlingmessageByIdService(String uid);

	// 按类型查询苗木信息公共数据接口
	public Result querySeedlingmessageByTypeService(String type);

	// 按多个类型查询苗木信息公共数据接口
	public Result querySeedlingmessageByTypeService(String type, String subclass);

	// 查询招标信息数据公共数据接口
	public Result queryBidService();

	// 查询人才招聘信息公共数据接口
	public Result queryRecruitService();

	// 查询用户发布的招聘信息接口
	public Result queryRecruitByIdService(String uid);

	// 添加设备租赁发布信息数据接口
	public Result saveEquipmentLeasingService(Equipmentleasing msg);

	// 添加苗木发布信息数据接口
	public Result saveSeedlingmessageService(Seedlingmessage msg);

	// 添加人员招聘发布信息数据接口
	public Result saveRecruitService(Recruit msg);

	// 抓取招标信息数据接口
	public Result saveBidsService(List<Bid> msg);
}
