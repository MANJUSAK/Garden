package com.henghao.Garden.service;

import com.henghao.Garden.entity.leasing.Bid;
import com.henghao.Garden.resultEntity.Result;

import java.util.List;

/**
 * function 招投标模块信息保存业务逻辑接口Java类
 *
 * @author 严彬荣
 */
public interface SaveBidService {

    // 抓取招标信息数据接口
    public Result saveBidsMsgsService(List<Bid> msg);

    // 本系统发布招标信息数据接口
    public Result saveBidMsgService(Bid msg);

}
