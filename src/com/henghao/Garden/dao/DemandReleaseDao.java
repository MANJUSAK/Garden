package com.henghao.Garden.dao;

import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.leasing.Bid;
import com.henghao.Garden.entity.leasing.Equipmentleasing;
import com.henghao.Garden.entity.leasing.Recruit;
import com.henghao.Garden.entity.leasing.Seedlingmessage;

import java.util.List;

/**
 * function 需求发布模块访问数据库Java接口类
 * <p>
 * date 2017.03.28
 *
 * @author 严彬荣
 */
public interface DemandReleaseDao {

    // 查询设备租赁信息公共数据dao接口
    public List<Equipmentleasing> queryEquipmentLeasingDao();

    // 查询我用户发布的设备租赁信息dao接口
    public List<Equipmentleasing> queryEquipmentLeasingByIdDao(String uid);

    // 查询需求发布文件信息dao接口
    public List<Filemassage> queryFilemessageDao(String uuid);

    // 查询发布苗木信息公共数据dao接口
    public List<Seedlingmessage> querySeedlingmessageDao();

    // 按苗木类型查询苗木信息公共数据dao接口
    public List<Seedlingmessage> querySeedlingmessageByTypeDao(String type,
                                                               String subclass);

    // 查询用户发布的苗木信息数据dao接口
    public List<Seedlingmessage> querySeedlingmessageByIdDao(String uid);

    // 查询招标信息数据公共数据dao接口
    public List<Bid> queryBidDao();

    // 查询人才招聘信息公共数据dao接口
    public List<Recruit> queryRecruitDao();

    // 查询用户发布的招聘信息dao接口
    public List<Recruit> queryRecruitByIdDao(String uid);

    // 添加设备租赁发布信息数据dao接口
    public void saveEquipmentLeasingDao(Equipmentleasing msg) throws Exception;

    // 添加苗木发布信息数据dao接口
    public void saveSeedlingmessageDao(Seedlingmessage msg) throws Exception;

    // 添加人员招聘发布信息数据dao接口
    public void saveRecruitDao(Recruit msg) throws Exception;

    // 抓取招标信息数据存储dao接口
    public void saveBidsDao(List<Bid> msg) throws Exception;
}
