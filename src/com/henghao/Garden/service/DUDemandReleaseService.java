package com.henghao.Garden.service;

import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;

import java.util.List;

/**
 * function 需求发布批量更新删除业务处理Java接口类
 * <p>
 * date 2017-03-28
 *
 * @author 严彬荣
 */
public interface DUDemandReleaseService {

    // 批量删除我发布的设备租赁信息数据接口
    public Result deleteEquipmentleasingService(List<BatchID> list);

    // 批量删除我发布的苗木信息数据接口
    public Result deleteSeedlingmassageService(List<BatchID> list);

    // 批量删除我发布的人员招聘信息数据接口
    public Result deleteRecruitService(List<BatchID> list);

}
