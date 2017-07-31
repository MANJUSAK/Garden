package com.henghao.Garden.dao;

import com.henghao.Garden.resultEntity.BatchID;

import java.util.List;

/**
 * function 合同管理模块批量更新删除访问数据库Java接口类
 * <p>
 * <p>
 * date 2017-04-24
 *
 * @author 严彬荣
 */

public interface DUCompactDao {

    // 批量删除建设类合同数据dao接口
    public void deleteBuildCompactDao(List<BatchID> list) throws Exception;

    // 批量删除园林类合同数据dao接口
    public void deleteGardenCompactDao(List<BatchID> list) throws Exception;

    // 批量删除园林工程类合同数据dao接口
    public void deleteEngineeringCompactDao(List<BatchID> list) throws Exception;

    // 批量删除景观类合同数据dao接口
    public void deleteLandscapeCompactDao(List<BatchID> list) throws Exception;

}
