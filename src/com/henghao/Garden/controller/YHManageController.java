package com.henghao.Garden.controller;

import com.henghao.Garden.entity.conservation.GhManage;
import com.henghao.Garden.entity.conservation.TreeMassage;
import com.henghao.Garden.entity.conservation.YhStatus;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.YHManageService;
import com.henghao.Garden.util.DomainNameUtil;
import com.henghao.Garden.util.YhmanagerFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * function 养护管理模块访问入口java类
 * <p>
 * date 2017.02.28
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
@RequestMapping("/YhManage")
public class YHManageController {

    @Resource
    private YHManageService service;
    // 实例化结果集实体类,并定义为公共结果集
    private Result result = null;
    // 实例化文件上传工具类
    private YhmanagerFileUtil fileUpload = YhmanagerFileUtil.getInstance();
    // 实例化http域名工具类
    private DomainNameUtil http = DomainNameUtil.getInstance();

    // 查询植物所有信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryTreeAllMsg", produces = "application/json;charset=utf-8")
    public Result queryAllTreeMassage() {
        this.result = this.service.queryAllTreeMassageService();
        return this.result;
    }

    // 通过植物编号查询树木信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryTreeMsgById", produces = "application/json;charset=utf-8")
    public Result queryAllTreeMassageById(@RequestParam("treeId") String treeId) {
        this.result = this.service.queryTreeMsgByIdService(treeId);
        return this.result;
    }

    // 查询当天养护工作记录信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryYhStatusMsg", produces = "application/json;charset=utf-8")
    public Result queryYhstatusMsgController(@RequestParam("uid") String uid) {
        this.result = null;
        if (uid == null || uid.length() == 0 || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.result = this.service.queryYhStatusmsgService(date, uid);
        return this.result;
    }

    // 查询管护所有信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryGhManagemsg", produces = "application/json;charset=utf-8")
    public Result queryGhmsgController(HttpServletRequest request) {
        this.result = this.service.queryGhmsgService();
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.http.getDomainName(request));
        }
        return this.result;
    }

    // 查询管护信息通过植物编号访问接口
    @ResponseBody
    @RequestMapping(value = "/queryGhManageMsgByid", produces = "application/json;charset=utf-8")
    public Result queryGhManageMsgByidController(
            @RequestParam("treeId") String treeId,
            @RequestParam("yid") int yid, @RequestParam("uid") String uid,
            HttpServletRequest request) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service
                .queryGhManageMsgByidService(treeId, yid, uid);
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.http.getDomainName(request));
        }
        return this.result;
    }

    // 植物信息保存访问接口
    @ResponseBody
    @RequestMapping(value = "/saveTreeMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result savaTreeMassage(TreeMassage tree) {
        this.result = this.service.saveTreeMassageService(tree);
        return this.result;

    }

    // 养护工作记录信息数据保存接口
    @ResponseBody
    @RequestMapping(value = "/saveStatusMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveYhStatus(YhStatus msg) {
        this.result = this.service.saveYhStatusService(msg);
        return this.result;

    }

    // 管护信息数据保存接口
    @ResponseBody
    @RequestMapping(value = "/saveGhManageMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result savegHmassage(@RequestParam("file1") MultipartFile oldfile,
                                @RequestParam("file2") MultipartFile nowfile, YhStatus yid,
                                GhManage msg, HttpServletRequest request) {
        String oldfilePath = null;
        String nowfilePath = null;
        try {
            oldfilePath = this.fileUpload.fileUpload(oldfile, request);
            nowfilePath = this.fileUpload.fileUpload(nowfile, request);
            if (oldfilePath == null) {
                return new Result("图片为空或格式不正确", 5);
            } else if (nowfilePath == null) {
                return new Result("图片为空或格式不正确", 5);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Result("文件上传失败，请重试！", 3);
        }
        msg.setOldfile(oldfilePath);
        msg.setNowfile(nowfilePath);
        msg.setYhStatus(yid);
        this.result = this.service.saveGhmsgService(msg, yid.getYid());
        return this.result;
    }
}
