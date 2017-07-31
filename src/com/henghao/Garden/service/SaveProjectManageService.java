package com.henghao.Garden.service;

import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.resultEntity.Result;

/**
 * function 项目管理信息保存模块业务逻辑Java接口类
 *
 * @author 严彬荣
 */
public interface SaveProjectManageService {
    // 保存我的轨迹信息数据接口
    public Result saveMylocusMsgService(Mylocus msg);

    // 保存会审结果信息数据接口
    public Result saveHsResultMsgService(HsResult msg);

    // 添加开工报告信息数据接口
    public Result saveKgReportMsgService(KgReport msg);

    // 添加项目信息数据接口
    public Result saveProjectMsgService(Project msg);

    // 添加现场检验信息数据接口
    public Result saveCheckoutMsgService(Checkout msg);

    // 添加设备信息数据dao接口
    public Result saveEquipmentMsgService(Equipment msg);

    // 添加施工人员信息数据dao接口
    public Result saveSgPersonnelMsgService(SgPersonnel msg);

    // 保存现场施工检验信息数据接口
    public Result saveProspectMsgService(Prospect msg);

    // 添加供货商信息数据接口
    public Result saveSupplierMsgService(Supplier msg);

    // 添加变更管理信息数据接口
    public Result saveAlterationMsgService(Alteration msg);

    // 添加技术交底信息数据接口
    public Result saveTechnologyMsgService(Technology msg);

    // 用户注册后初始化我的钱包信息数据接口
    public Result saveWalletMsgService(Wallet msg);

    // 添加申报进度信息数据接口
    public Result saveDeclarationMsgService(Declaration msg);

    // 添加结算信息数据接口
    public Result saveSettlementMsgService(Settlement msg);

    // 添加施工日志信息数据接口
    public Result saveConstructionLogMsgService(ConstructionLog msg);

    // 添加监理日志信息数据接口
    public Result saveSupervisionlogMsgService(Supervisionlog msg);

    // 添加竣工验收信息数据接口
    public Result saveFinalacceptanceMsgService(Finalacceptance msg);

    // 添加施工安全日志信息数据接口
    public Result saveConstructionSafetyLogMsgService(ConstructionSafetyLog msg);
}
