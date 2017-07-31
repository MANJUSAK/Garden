package com.henghao.Garden.listener;

import com.henghao.Garden.service.UserManageService;

import javax.annotation.Resource;

/**
 * function 启动服务初始化权限管理数据
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
@SuppressWarnings("ALL")
public class RightInitialization {
    @Resource
    private UserManageService service;

    public void rightInitialization() {
        System.out.println(">>>>>>>>>>>>>>>初始化系统数据...<<<<<<<<<<<<<");
        boolean tip = this.service.queryRights();
        if (tip == false) {
            System.out.println(">>>>>>>>>>>>>>>初始化系统数据成功<<<<<<<<<<<<<");
        } else {
            boolean tip2 = this.service.rightsInitialization();
            if (tip2 == false) {
                System.out.println(">>>>>>>>>>>>>>>初始化系统数据失败<<<<<<<<<<<<<");
            } else {
                System.out.println(">>>>>>>>>>>>>>>初始化系统数据成功<<<<<<<<<<<<<");
            }
        }
    }
}
