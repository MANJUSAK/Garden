package com.henghao.Garden.dao;

import com.henghao.Garden.entity.compact.BuildCompact;
import com.henghao.Garden.entity.compact.GardenCompact;
import com.henghao.Garden.entity.compact.GardenEngineeringCompact;
import com.henghao.Garden.entity.compact.LandscapeCompact;
import com.henghao.Garden.entity.fileMassage.Compactmassage;

import java.util.List;

/**
 * function 合同管理模块访问数据库接口Java类
 * <p>
 * date 2017.04.20
 *
 * @author 严彬荣
 */
public interface CompactManageDao {

    // 查询合同管理图片信息数据dao接口
    public List<Compactmassage> queryCompactFileMassage(String pathId);

    // 查询建设类合同数据dao接口
    public List<BuildCompact> queryBuildCompactDao(String uid);

    // 查询园林类合同数据dao接口
    public List<GardenCompact> queryGardenCompact(String uid);

    // 查询园林工程类合同数据dao接口
    public List<GardenEngineeringCompact> queryEngineeringCompact(String uid);

    // 查询景观类合同数据dao接口
    public List<LandscapeCompact> queryLandscapeCompact(String uid);

    // 保存建设类合同管理dao接口
    public void saveBuildCompactDao(BuildCompact msg) throws Exception;

    // 保存园林类合同管理dao接口
    public void saveGardenCompactDao(GardenCompact msg) throws Exception;

    // 保存园林工程类合同管理dao接口
    public void saveGardenEngineeringCompactDao(GardenEngineeringCompact msg)
            throws Exception;

    // 保存景观类合同管理dao接口
    public void saveLandscapeCompact(LandscapeCompact msg) throws Exception;

}
