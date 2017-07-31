package com.henghao.Garden.service;

import com.henghao.Garden.entity.user.Admin;
import com.henghao.Garden.entity.user.Sites;
import com.henghao.Garden.entity.user.Users;
import com.henghao.Garden.resultEntity.Result;

/**
 * function 登陆注册模块业务逻辑接口Java类
 * <p>
 * date 2017-02-28
 *
 * @author 严彬荣
 */
public interface UserManageService {

    // 用户登陆接口
    public Result login(Users user);

    // 管理员登陆接口
    public Result roleLogin(Admin role);

    // 查询用户信息接口
    public Result queryUser(Users user);

    // 检查用户名是否重复接口
    public int checkUserName(String userName);

    // 检查手机号是否重复接口
    public int checkUserTel(String tel);

    // 用户签到次数接口
    public Result report(String uid);

    // 用户注册接口
    public Result register(Users user);

    // 管理员注册接口
    public Result roleRegister(Admin role);

    // 用户签到接口
    public Result report(Sites site);

    //初始化系统权限管理接口
    public boolean rightsInitialization();

    //检查系统权限数据是否存在（方式服务器重启再次初始化权限数据）接口
    public boolean queryRights();

}
