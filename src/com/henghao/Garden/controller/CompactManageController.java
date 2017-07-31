package com.henghao.Garden.controller;

import com.henghao.Garden.entity.compact.BuildCompact;
import com.henghao.Garden.entity.compact.GardenCompact;
import com.henghao.Garden.entity.compact.GardenEngineeringCompact;
import com.henghao.Garden.entity.compact.LandscapeCompact;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.CompactManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 合同管理模块访问入口Java类
 * <p>
 * date 2017.04.20
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
@RequestMapping("/compact")
public class CompactManageController {

    @Resource
    private CompactManageService service;
    @Resource
    private HttpServletRequest request;
    // 初始化公共结果集
    private Result result = null;

    // 查询建设类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryBuildCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryBuildCompactController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 2);
            return this.result;
        }
        return this.service.queryBuildCompactService(uid, this.request);
    }

    // 查询园林类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryGardenCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryGardenCompactController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 2);
            return this.result;
        }
        return this.result = this.service.queryGardenCompactService(uid,
                this.request);
    }

    // 查询园林工程类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryEngineeringCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryEngineeringCompactController(
            @RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 2);
            return this.result;
        }
        return this.result = this.service.queryEngineeringCompactService(uid,
                this.request);
    }

    // 查询景观类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryLandscapeCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryLandscapeCompactController(
            @RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 2);
            return this.result;
        }
        return this.result = this.service.queryLandscapeCompact(uid,
                this.request);
    }

    // 保存建设类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveBuildCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result buildCompactController(
            @RequestParam("files") MultipartFile[] files, BuildCompact msg) {
        return this.result = this.service.saveBuildCompactService(msg, files,
                this.request);
    }

    // 保存园林类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveGardenCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result GardenCompactController(
            @RequestParam("files") MultipartFile[] files, GardenCompact msg) {
        return this.result = this.service.saveGardenCompactService(msg, files,
                this.request);

    }

    // 保存园林工程类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveEngineeringCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result GardenEngineeringCompactController(
            @RequestParam("files") MultipartFile[] files,
            GardenEngineeringCompact msg) {
        return this.service.saveGardenEngineeringCompactService(msg, files,
                this.request);

    }

    // 保存园林工程类合同数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveLandscapeCompact", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result LandscapeCompactController(
            @RequestParam("files") MultipartFile[] files, LandscapeCompact msg) {
        return this.service.saveLandscapeCompactService(msg, files,
                this.request);

    }
}
