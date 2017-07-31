package com.henghao.Garden.service;

import com.henghao.Garden.resultEntity.CompactBath;
import com.henghao.Garden.resultEntity.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * function 合同管理审核业务逻辑Java接口类
 * <p>
 * date 2017.04.21
 *
 * @author 严彬荣
 */
public interface CheckCompactService {
    // 查询待审核的建设类合同接口
    public Result checkBuildCompact(HttpServletRequest request);

    // 查询待审核的园林类合同接口
    public Result checkGardenCompact(HttpServletRequest request);

    // 查询待审核的园林工程类合同接口
    public Result checkEngineeringCompact(HttpServletRequest request);

    // 查询待审核的景观类合同接口
    public Result checkLandscapeCompact(HttpServletRequest request);

    // 建设类合同审核结果的公示接口
    public Result updateBuildCompact(CompactBath ids);

    // 园林类合同审核结果的公示接口
    public Result updateGardenCompact(CompactBath ids);

    // 园林工程类合同审核结果的公示接口
    public Result updateEngineeringCompact(CompactBath ids);

    // 景观类合同审核结果的公示接口
    public Result updateLandscapeCompact(CompactBath ids);
}
