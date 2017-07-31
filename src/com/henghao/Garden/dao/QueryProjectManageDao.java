package com.henghao.Garden.dao;

import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.entityvo.ConstructionSafetyLogVo;

import java.util.List;

/**
 * function 项目管理信息查询模块访问数据库接口Java类
 * <p>
 * date 2017.03.12
 *
 * @author 严彬荣
 */
public interface QueryProjectManageDao {

    // 查询我的轨迹数据信息dao接口
    public List<Mylocus> queryMylocusMsgDao(String uid);

    // 查询会审结果信息数据dao接口
    public List<HsResult> queryHsResultMsgDao(String uid);

    // 查询现场检验信息数据dao接口
    public List<Checkout> queryCheckoutMsgDao(String uid);

    // 查询开工报告信息数据dao接口
    public List<KgReport> queryKgReportMsgDao(String uid);

    // 查询项目信息数据dao接口
    public List<Project> queryProjectMsgDao(String uid);

    // 查询项目信息数据通过项目名称dao接口
    public Project queryProjectMsgByNameDao(String xmName, String uid);

    // 查询设备信息数据dao接口
    public List<Equipment> queryEquipmentMsgDao(String uid);

    // 查询施工人员信息数据dao接口
    public List<SgPersonnel> querySgPersonnelMsgDao(String uid);

    // 查询现场施工检验信息数据dao接口
    public List<Prospect> queryProspectMsgDao(String uid);

    // 查询供货商信息数据dao接口
    public List<Supplier> querySupplierMsgDao(String uid);

    // 查询项目管理文件信息dao接口
    public List<Filemassage> queryFilemassage(String uuid);

    // 查询变更信息dao接口
    public List<Alteration> queryAlterationMagDao(String uid);

    // 查询技术交底信息dao接口
    public List<Technology> queryTechnologyMsgDao(String uid);

    // 查询申报进度信息dao接口
    public List<Declaration> queryDeclarationMsgDao(String uid);

    // 查询我的钱包信息数据dao接口
    public List<Wallet> queryWalletMsgDao(String uid);

    // 查询结算信息数据dao接口
    public List<Settlement> querySettlementMsgDao(String uid);

    // 查询施工日志信息数据dao接口
    public List<ConstructionLog> queryConstructionLogMsgDao(String uid);

    // 通过用户编号查询文件信息dao接口
    public Excelmassage queryFileMsgDao(String uid);

    // 查询监理日志信息数据dao接口
    public List<Supervisionlog> querySupervisionlogMsgDao(String uid);

    // 查询竣工验收信息数据dao接口
    public List<Finalacceptance> queryFinalacceptanceMsgDao(String uid);

    // 查询施工安全日志概要信息数据dao接口
    public List<ConstructionSafetyLogVo> querySummaryLogMsgDao(String uid);

}
