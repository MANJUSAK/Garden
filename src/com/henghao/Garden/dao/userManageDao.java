package com.henghao.Garden.dao;

import com.henghao.Garden.entity.user.*;

import java.math.BigInteger;
import java.util.List;

/**
 * function 登录注册模块访问数据库接口Java类
 * <p>
 * date 2017.02.28
 *
 * @author 严彬荣
 */
public interface userManageDao {

    // 用户登录验证dao接口
    public Users login(Users user);

    // 管理员登录dao接口
    public Admin roleLogin(Admin role);

    // 检查用户名是否重复dao接口
    public Users checkUserName(String userName);

    // 检查手机号是否重复dao接口
    public Users checkUserTel(String tel);

    // 用户签到次数dao接口
    public BigInteger report(String uid, String date);

    // 用户注册dao接口
    public void register(Users user) throws Exception;

    // 管理员注册dao接口
    public void roleRegister(Admin role) throws Exception;

    // 用户签到dao接口
    public void report(Sites site) throws Exception;

    //初始化系统权限管理dao接口
    public void rightsInitialization(List<Rights> rights, List<Grade> grade) throws Exception;

    //检查系统权限数据是否存在（方式服务器重启再次初始化权限数据）dao接口
    public List queryRights();

    //初始化用户具有系统权限dao接口
    public Grade queryRightsById(int var);
}
