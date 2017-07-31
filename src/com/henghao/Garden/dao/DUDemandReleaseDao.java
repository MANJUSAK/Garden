package com.henghao.Garden.dao;

import com.henghao.Garden.resultEntity.BatchID;

import java.util.List;

/**
 * function 需求发布模块批量更新删除操作数据库Java接口类
 * <p>
 * date 2017.03.28
 *
 * @author 严彬荣
 */
public interface DUDemandReleaseDao {

    // 批量删除我发布的设备租赁信息数据dao接口
    public void deleteEquipmentleasingDao(List<BatchID> list) throws Exception;

    // 批量删除我发布的苗木信息数据dao接口
    public void deleteSeedlingmassageDao(List<BatchID> list) throws Exception;

    // 批量删除我发布的人员招聘信息数据dao接口
    public void deleteRecruitDao(List<BatchID> list) throws Exception;

}
