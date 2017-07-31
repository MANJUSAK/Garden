package com.henghao.Garden.service;

import com.henghao.Garden.entity.conservation.GhManage;
import com.henghao.Garden.entity.conservation.TreeMassage;
import com.henghao.Garden.entity.conservation.YhStatus;
import com.henghao.Garden.resultEntity.Result;

/**
 * function 养护管理模块业务逻辑接口Java类
 *
 * @author 严彬荣
 */
public interface YHManageService {
    // 定义查询植物所有信息接口
    public Result queryAllTreeMassageService();

    // 定义通过养护状态（二维码）查询树木信息接口
    public Result queryTreeMsgByIdService(String chip);

    // 定义当天养护工作记录信息数据查询接口额
    public Result queryYhStatusmsgService(String date, String uid);

    // 定义管护信息数据查询接口额
    public Result queryGhmsgService();

    // 定义查询管护信息通过植物编号接口
    public Result queryGhManageMsgByidService(String treeId, int yid, String uid);

    // 定义通过状态编号查询养护信息
    public Result queryYhmassageByIdService(String uid);

    // 定义植物信息保存接口
    public Result saveTreeMassageService(TreeMassage tree);

    // 定义养护工作记录信息数据保存接口
    public Result saveYhStatusService(YhStatus msg);

    // 定义管护信息数据保存接口
    public Result saveGhmsgService(GhManage msg, int yid);

}
