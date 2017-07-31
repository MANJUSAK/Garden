package com.henghao.Garden.service;

import com.henghao.Garden.entity.compact.BuildCompact;
import com.henghao.Garden.entity.compact.GardenCompact;
import com.henghao.Garden.entity.compact.GardenEngineeringCompact;
import com.henghao.Garden.entity.compact.LandscapeCompact;
import com.henghao.Garden.resultEntity.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * function 合同管理模块业务逻辑接口Java类
 * <p>
 * date 2017.04.20
 *
 * @author 严彬荣
 */
public interface CompactManageService {

    // 查询建设类合同数据接口
    public Result queryBuildCompactService(String uid, HttpServletRequest request);

    // 查询园林类合同数据接口
    public Result queryGardenCompactService(String uid, HttpServletRequest request);

    // 查询园林工程类合同数据接口
    public Result queryEngineeringCompactService(String uid, HttpServletRequest request);

    // 查询景观类合同数据接口
    public Result queryLandscapeCompact(String uid, HttpServletRequest request);

    // 保存建设类合同数据保存接口
    public Result saveBuildCompactService(BuildCompact msg, MultipartFile[] files, HttpServletRequest request);

    // 保存园林类合同数据保存接口
    public Result saveGardenCompactService(GardenCompact msg, MultipartFile[] files, HttpServletRequest request);

    // 保存园林工程类合同数据保存接口
    public Result saveGardenEngineeringCompactService(GardenEngineeringCompact msg, MultipartFile[] files, HttpServletRequest request);

    // 保存景观类合同数据保存接口
    public Result saveLandscapeCompactService(LandscapeCompact msg, MultipartFile[] files, HttpServletRequest request);

}
