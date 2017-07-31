package com.henghao.Garden.service.servicelmpl;

import com.henghao.Garden.dao.SystemPrivilegesDao;
import com.henghao.Garden.entity.user.Grade;
import com.henghao.Garden.service.SystemPrivilegesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * function 系统权限管理业务处理类
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
@Service
public class SystemPrivilegesServicelmpl implements SystemPrivilegesService {

    @Resource
    private SystemPrivilegesDao dao;


    /**
     * function 系统权限判断业务方法
     *
     * @parameter var 用户权限id
     * <p>
     * return 权限等级
     */
    @Override
    public int judgeRights(String var) {
        Grade grade = null;
        try {
            grade = this.dao.judgeRights(var);
        } catch (Exception e) {
            System.out.println(e.toString());
            return 500;
        }
        if (grade != null) {
            int var1 = grade.getLevel();
            if (var1 >= 0 && var1 < 3) {
                return 0;
            } else if (var1 > 2 && var1 < 5) {
                return 3;
            } else {
                return 5;
            }
        } else {
            return -1;
        }
    }
}
