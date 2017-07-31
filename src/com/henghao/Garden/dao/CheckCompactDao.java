package com.henghao.Garden.dao;

import com.henghao.Garden.entity.compact.BuildCompact;
import com.henghao.Garden.entity.compact.GardenCompact;
import com.henghao.Garden.entity.compact.GardenEngineeringCompact;
import com.henghao.Garden.entity.compact.LandscapeCompact;
import com.henghao.Garden.entity.user.Users;
import com.henghao.Garden.resultEntity.CompactBath;

import java.util.List;

/**
 * function 合同管理审核访问数据库Java接口类
 * <p>
 * date 2017.04.21
 *
 * @author 严彬荣
 */
public interface CheckCompactDao {

    // 查询待审核的建设类合同dao接口
    public List<BuildCompact> checkBuildCompact();

    // 查询待审核的园林类合同dao接口
    public List<GardenCompact> checkGardenCompact();

    // 查询待审核的园林工程类合同dao接口
    public List<GardenEngineeringCompact> checkEngineeringCompact();

    // 查询待审核的景观类合同dao接口
    public List<LandscapeCompact> checkLandscapeCompact();

    // 查找推送合同的用户dao接口
    public Users queryUser(String name, String idCard);

    // 建设类合同审核结果的公示dao接口
    public void updateBuildCompact(CompactBath ids) throws Exception;

    // 园林类合同审核结果的公示dao接口
    public void updateGardenCompact(CompactBath ids) throws Exception;

    // 园林工程类合同审核结果的公示dao接口
    public void updateEngineeringCompact(CompactBath ids) throws Exception;

    // 景观类合同审核结果的公示dao接口
    public void updateLandscapeCompact(CompactBath ids) throws Exception;

}
