package com.henghao.Garden.service;

import com.henghao.Garden.entity.talentpool.Corporation;
import com.henghao.Garden.entity.talentpool.Employees;
import com.henghao.Garden.resultEntity.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface TalentpoolService {

    // 查询法人库信息数据接口
    public Result queryCorporationService(HttpServletRequest request);

    // 查询从业人才库信息数据接口
    public Result queryEmployeesService(HttpServletRequest request);

    // 法人库数据录入接口
    public Result saveCorporationService(MultipartFile[] files, HttpServletRequest request, Corporation msg);

    // 从业人才库数据录入接口
    public Result saveEmployeesService(MultipartFile[] files, HttpServletRequest request, Employees msg);
}
