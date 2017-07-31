package com.henghao.Garden.dao;

import com.henghao.Garden.resultEntity.BatchID;

import java.util.List;

/**
 * function 项目管理模块更新批量删除访问数据dao接口库接口Java类
 * <p>
 * date 2017.03.29
 *
 * @author 严彬荣
 */
public interface DUProjectManageDao {

    // 批量删除变更管理信息数据dao接口
    public void deleteAlterationDao(List<BatchID> list) throws Exception;

    // 批量删除工序报验信息数据dao接口
    public void deleteCheckoutDao(List<BatchID> list) throws Exception;

    // 批量删除施工日志信息数据dao接口
    public void deleteConstructionLogDao(List<BatchID> list) throws Exception;

    // 批量删除安全施工日志信息数据dao接口
    public void deleteConstructionSafetyLogDao(List<BatchID> list) throws Exception;

    // 批量删除进度申报信息数据dao接口
    public void deleteDeclarationDao(List<BatchID> list) throws Exception;

    // 批量删除设备信息信息数据dao接口
    public void deleteEquipmentDao(List<BatchID> list) throws Exception;

    // 批量删除竣工验收信息数据dao接口
    public void deleteFinalacceptanceDao(List<BatchID> list) throws Exception;

    // 批量删除会审结果信息数据dao接口
    public void deleteHsResultDao(List<BatchID> list) throws Exception;

    // 批量删除开工报告信息数据dao接口
    public void deleteKgReportDao(List<BatchID> list) throws Exception;

    // 批量删除我的轨迹信息数据dao接口
    public void deleteMylocusDao(List<BatchID> list) throws Exception;

    // 批量批量删除项目信息信息数据dao接口
    public void deleteProjectDao(List<BatchID> list) throws Exception;

    // 批量删除现场施工检验信息数据dao接口
    public void deleteProspectDao(List<BatchID> list) throws Exception;

    // 批量删除项目结算信息数据dao接口
    public void deleteSettlementDao(List<BatchID> list) throws Exception;

    // 批量删除施工人员信息数据dao接口
    public void deleteSgPersonnelDao(List<BatchID> list) throws Exception;

    // 批量删除监理日志信息数据dao接口
    public void deleteSupervisionlogDao(List<BatchID> list) throws Exception;

    // 批量删除供货商信息数据dao接口
    public void deleteSupplierDao(List<BatchID> list) throws Exception;

    // 批量删除技术交底信息数据dao接口
    public void deleteTechnologyDao(List<BatchID> list) throws Exception;
}
