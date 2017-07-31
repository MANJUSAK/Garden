package com.henghao.Garden.service.servicelmpl;

import com.henghao.Garden.dao.userManageDao;
import com.henghao.Garden.entity.user.*;
import com.henghao.Garden.formFilter.LoginFromFilterUtil;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.UserManageService;
import com.henghao.Garden.util.CreateMD5Util;
import com.henghao.Garden.util.UUIDUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * function 登陆注册模块业务逻辑Java类
 *
 * @author 严彬荣
 */
@SuppressWarnings("ALL")
@Service
public class UserManageServicelmpl implements UserManageService {

    @Resource
    private userManageDao dao;
    //实例化日志管理工具类
    private Logger logger = Logger.getLogger(UserManageServicelmpl.class);
    // 实例化md5加密工具类
    private CreateMD5Util md5 = CreateMD5Util.getInstance();
    // 实例化字符验证工具类
    private LoginFromFilterUtil charset = LoginFromFilterUtil.getInstance();
    // 实例化结果集实体类,并定义为公共结果集
    //实例化uuid工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    private Result result = null;

    // 用户登陆验证方法
    @Override
    public Result login(Users user) {
        boolean check = this.charset.checkLogin(user.getUsername(),
                user.getPassword());
        if (check == false) {
            this.result = new Result("输入有误，请检查正确后重试", 5);
            return this.result;
        }
        // 进行md5解密
        user.setPassword(user.getPassword().substring(0, 3)
                + this.md5.getMd5(user.getPassword()));
        Users data = null;
        try {
            data = this.dao.login(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("服务器走丢了！", 2);
            return this.result;
        }
        if (data != null) {
            this.result = new Result(0, data);
        } else {
            this.result = new Result("用户名或密码错误", 1);
        }
        return this.result;
    }

    // 管理员登陆方法
    @Override
    public Result roleLogin(Admin role) {
        boolean check = this.charset.checkLogin(role.getUserName(),
                role.getPassWord());
        if (check == false) {
            this.result = new Result("输入有误，请检查正确后重试", 5);
            return this.result;
        }
        // 进行md5解密
        role.setPassWord(role.getPassWord().substring(0, 3)
                + this.md5.getMd5(role.getPassWord()));
        Admin data = null;
        try {
            data = this.dao.roleLogin(role);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("服务器繁忙，请稍后重试！", 1);
            return this.result;
        }
        if (data != null) {
            this.result = new Result(0, data);
        } else {
            this.result = new Result("用户名或密码错误", 1);
        }
        return this.result;
    }

    // 查询用户信息方法
    @Override
    public Result queryUser(Users user) {
        Users data = null;
        try {
            data = this.dao.login(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("服务器走丢了！", 2);
            return this.result;
        }
        if (data != null) {
            this.result = new Result(0, data);
        } else {
            this.result = new Result("用户名不存在", 1);
        }
        return this.result;
    }

    // 用户信息注册方法
    @Override
    public Result register(Users user) {
        // 进行md5加密
        user.setPassword(user.getPassword().substring(0, 3)
                + this.md5.getMd5(user.getPassword()));
        // 分配用户编号
        user.setUid(this.uuid.getUUID().toString());
        try {
            Grade grade = this.dao.queryRightsById(user.getLevel());
            user.setRoleId(grade.getRoleId());
            this.dao.register(user);
            this.result = new Result("注册成功", 0);
        } catch (Exception e) {
            e.printStackTrace();
            this.result = new Result("注册失败，请重试！", 1);
        }
        return this.result;
    }

    // 用户签到方法
    @Override
    public Result report(Sites site) {
        try {
            this.dao.report(site);
            this.result = new Result("签到成功", 0);
        } catch (Exception e) {
            e.printStackTrace();
            this.result = new Result("签到失败，请重试！", 1);
        }
        return this.result;
    }

    // 检查用户名是否重复方法
    @Override
    public int checkUserName(String userName) {
        Users data = null;
        try {
            data = this.dao.checkUserName(userName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 1;
        }
        if (data != null)
            return 1;
        return 0;
    }

    // 检查手机号是否重复方法
    @Override
    public int checkUserTel(String tel) {
        Users data = null;
        try {
            data = this.dao.checkUserTel(tel);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 1;
        }
        if (data != null)
            return 1;
        return 0;
    }

    // 用户签到次数
    @Override
    public Result report(String uid) {
        int num = 0;
        try {
            num = this.dao.report(uid,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                    .intValue();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new Result(0, num);
    }

    // 管理员注册方法
    @Override
    public Result roleRegister(Admin role) {
        // 密码加密
        role.setPassWord(role.getPassWord().substring(0, 3)
                + this.md5.getMd5(role.getPassWord()));
        try {
            this.dao.roleRegister(role);
            this.result = new Result("注册成功", 0);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("管理员账号已存在", 1);
        }
        return this.result;
    }

    /**
     * 功能：服务器启动初始化系统权限管理
     *
     * @return Boolean
     * @parameter 无
     */
    @Override
    @Transactional
    public boolean rightsInitialization() {
        List<Rights> rightsList = new ArrayList<Rights>();
        List<Grade> gradeList = new ArrayList<Grade>();
        Rights rights = new Rights();
        Grade grade = new Grade();
        rights.setRole("法人");
        rights.setRoleId(this.uuid.getUUID().toString());
        rightsList.add(rights);
        grade.setRoleId(rights.getRoleId());
        grade.setLevel(3);
        grade.setLevelId(this.uuid.getUUID().toString());
        gradeList.add(grade);
        Rights rights1 = new Rights();
        Grade grade1 = new Grade();
        rights1.setRole("授权代理人");
        rights1.setRoleId(this.uuid.getUUID().toString());
        rightsList.add(rights1);
        grade1.setRoleId(rights1.getRoleId());
        grade1.setLevel(2);
        grade1.setLevelId(this.uuid.getUUID().toString());
        gradeList.add(grade1);
        Rights rights2 = new Rights();
        Grade grade2 = new Grade();
        rights2.setRole("自然人");
        rights2.setRoleId(this.uuid.getUUID().toString());
        rightsList.add(rights2);
        grade2.setRoleId(rights2.getRoleId());
        grade2.setLevel(1);
        grade2.setLevelId(this.uuid.getUUID().toString());
        gradeList.add(grade2);
        try {
            this.dao.rightsInitialization(rightsList, gradeList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            this.logger.error(e);
            return false;
        }
    }

    /**
     * 功能：检查系统权限数据是否存在（防止服务器重启再次初始化权限数据）
     *
     * @return Boolean
     * @parameter 无
     */
    @Override
    @Transactional
    public boolean queryRights() {
        List<Rights> data = null;
        try {
            data = this.dao.queryRights();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            this.logger.error(e);
            return false;
        }
        if (data.size() > 0) {
            return false;
        } else {
            return true;
        }

    }
}
