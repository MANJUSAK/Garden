package com.henghao.Garden.dao;

import com.henghao.Garden.entity.conservation.GhManage;
import com.henghao.Garden.entity.conservation.TreeMassage;
import com.henghao.Garden.entity.conservation.YhStatus;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * function 养护管理模块访问数据库接口Java类
 * <p>
 * date 2017.02.28
 *
 * @author 严彬荣
 */
public interface YHManageDao {

    // 定义查询所有植物信息dao接口
    public List<T> queryAllTreeMassageDao();

    // 定义通过养护状态（芯片）查询树木信息dao接口
    public TreeMassage queryTreeMassageByIdDao(String chip);

    // 定义查询养护工作记录信息数据dao接口
    public List<T> queryYhstatusDao(String date, String uid);

    // 定义通过状态查询养护信息dao接口
    public YhStatus queryYhmassageByIdDao(String uid);

    // 定义查询管护信息dao接口
    public List<T> queryGhmsgDao();

    // 定义查询管护信息通过植物编号dao接口
    public GhManage queryGhmsgByidDao(String treeId, int yid, String uid);

    // 查询当天已扫过的植物信息dao接口
    public YhStatus queryNowTree(String chip, String date);

    // 定义植物信息保存dao接口
    public void saveTreeMassageDao(TreeMassage tree) throws Exception;

    // 定义养护工作记录保存数据dao接口
    public void saveYhstatusDao(YhStatus msg) throws Exception;

    // 定义管护信息保存数据dao接口
    public void saveGhmsgDao(GhManage msg) throws Exception;

    // 更新管护状态dao接口
    public void updateYhstatusDao(int yid) throws Exception;

}
