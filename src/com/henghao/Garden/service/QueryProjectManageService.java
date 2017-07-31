package com.henghao.Garden.service;

import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.resultEntity.Result;

/**
 * function 项目管理信息查询模块业务逻辑接口Java类
 *
 * @author 严彬荣
 */
public interface QueryProjectManageService {

    // 查询我的轨迹信息数据接口
    public Result queryMylocusMsgService(String uid);

    // 查询会审结果信息数据接口
    public Result queryHsResultMsgService(String uid);

    // 查询开工报告信息数据接口
    public Result queryKgReportMsgService(String uid);

    // 查询项目信息数据接口
    public Result queryProjectMsgService(String uid);

    // 查询项目信息数据通过项目名称接口
    public Result queryProjectMsgByNameService(String xmName, String uid);

    // 查询现场检验信息数据接口
    public Result queryCheckoutMsgService(String uid);

    // 查询设备信息数据接口
    public Result queryEquipmentMsgService(String uid);

    // 查询施工人员信息数据接口
    public Result querySgPersonnelMsgServiec(String uid);

    // 查询现场施工检验信息数据接口
    public Result queryProspectMsgService(String uid);

    // 查询供货商信息数据接口
    public Result querySupplierMsgService(String uid);

    // 查询变更管理信息数据接口
    public Result queryAlterationMsgService(String uid);

    // 查询技术交底信息数据接口
    public Result queryTechnologyMsgService(String uid);

    // 查询我的钱包信息数据接口
    public Result queryWalletMsgService(String uid);

    // 查询申报进度信息数据接口
    public Result queryDeclarationMsgService(String uid);

    // 查询结算信息数据接口
    public Result querySettlementMsgService(String uid);

    // 查询施工日志信息数据接口
    public Result queryConstructionLogMsgService(String uid);

    // 查询文件信息数据接口
    public Excelmassage queryFileMsgService(String uid);

    // 查询监理日志信息数据接口
    public Result querySupervisionlogMsgService(String uid);

    // 查询竣工验收信息数据接口
    public Result queryFinalacceptanceMsgService(String uid);

    // 查询施工安全日志概要信息数据接口
    public Result querySummaryLogMsgService(String uid);

}
