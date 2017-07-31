package com.henghao.Garden.controller;

import com.henghao.Garden.entity.talentpool.Corporation;
import com.henghao.Garden.entity.talentpool.Employees;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.TalentpoolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 人才库访问数据入口java类
 * <p>
 * date 2017.05.18
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
@RequestMapping("/talentpool")
public class TalentpoolController {
    @Resource
    private TalentpoolService service;
    // 实例化公共结果集
    @SuppressWarnings("unused")
    private Result result = null;

    /*
     * 查询法人库信息数据访问接口
     *
     * Parma request http请求
     */
    @ResponseBody
    @RequestMapping(value = "/queryCorporation", produces = "application/json;charset=utf-8")
    public Result queryCorporationController(HttpServletRequest request) {
        return this.service.queryCorporationService(request);
    }

    /*
     * 查询从业人员库信息数据访问接口
     *
     * Parma request http请求
     */
    @ResponseBody
    @RequestMapping(value = "/queryEmployees", produces = "application/json;charset=utf-8")
    public Result queryEmployeesController(HttpServletRequest request) {
        return this.service.queryEmployeesService(request);
    }

    /*
     * 法人库数据录入访问接口
     *
     * Parma request http请求，files 上传的文件，msg 表单提交数据实体
     */
    @CrossOrigin(origins = "*", maxAge = 36000, methods = {RequestMethod.POST})
    @ResponseBody
    @RequestMapping(value = "/saveCorporation", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveCorporationController(HttpServletRequest request,
                                            @RequestParam("files") MultipartFile[] files, Corporation msg) {
        return this.result = this.service.saveCorporationService(files,
                request, msg);
    }

    /*
     * 从业人员库数据录入访问接口
     *
     * Parma request http请求，files 上传的文件，msg 表单提交数据实体
     */
    @CrossOrigin(origins = "*", maxAge = 36000, methods = {RequestMethod.POST})
    @ResponseBody
    @RequestMapping(value = "/saveEmployees", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveEmployeesController(HttpServletRequest request,
                                          @RequestParam("files") MultipartFile[] files, Employees msg) {
        return this.result = this.service.saveEmployeesService(files, request,
                msg);
    }

}
