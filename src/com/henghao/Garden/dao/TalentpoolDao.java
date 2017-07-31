package com.henghao.Garden.dao;

import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;
import com.henghao.Garden.entity.talentpool.Corporation;
import com.henghao.Garden.entity.talentpool.Employees;

import java.util.List;

public interface TalentpoolDao {

    // 查询人才库文件信息数据dao接口
    public List<Talentpoolmassage> queryFileMassage(String fileId);

    // 查询法人库信息数据dao接口
    public List<Corporation> queryCorporationDao();

    // 查询从业人才哭信息数据dao接口
    public List<Employees> queryEmployeesDao();

    // 法人库信息数据录入dao接口
    public void saveCorporationDao(Corporation msg) throws Exception;

    // 从业人才库信息数据录入dao接口
    public void saveEmployeesDao(Employees msg) throws Exception;

}
