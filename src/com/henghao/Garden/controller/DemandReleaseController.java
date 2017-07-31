package com.henghao.Garden.controller;

import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.leasing.Bid;
import com.henghao.Garden.entity.leasing.Equipmentleasing;
import com.henghao.Garden.entity.leasing.Recruit;
import com.henghao.Garden.entity.leasing.Seedlingmessage;
import com.henghao.Garden.formFilter.DemandReleaseFormFilter;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DemandReleaseService;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.util.DomainNameUtil;
import com.henghao.Garden.util.ReleaseFileUploadUtil;
import com.henghao.Garden.util.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * function 需求发布模块访问入口Java类
 * <p>
 * date 2017.03.28
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
@RequestMapping("/release")
public class DemandReleaseController {

    @Resource
    private DemandReleaseService service;
    @Resource
    private HttpServletRequest request;
    @Resource
    private SaveFileService fileService;
    // 实例化域名对象方法类
    DomainNameUtil domain = DomainNameUtil.getInstance();
    // 实例化需求发布文件保存工具类
    private ReleaseFileUploadUtil uploadService = ReleaseFileUploadUtil
            .getInstance();
    // 实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    // 实例化文件保存信息实体类
    private Filemassage file = new Filemassage();
    // 实例化结果集实体类，并定义为公共结果集
    private Result result = null;
    // 初始化公共集合
    private LinkedList<String> list = null;
    // 实例化表单验证工具类
    private DemandReleaseFormFilter charset = DemandReleaseFormFilter
            .getInstance();

    // 查询发布设备租赁信息公共数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryEquipmentLeasing", produces = "application/json;charset=utf-8")
    public Result queryEquipmentLeasingController() {
        this.result = this.service.queryEquipmentLeasingService();
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.domain.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询用户发布设备租赁信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryUserEquipmentLeasing", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryEquipmentLeasingByIdController(
            @RequestParam("uid") String uid) {
        this.result = this.service.queryEquipmentLeasingByIdService(uid);
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.domain.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询发布苗木信息公共数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySeedlingmessage", produces = "application/json;charset=utf-8")
    public Result querySeedlingmessageController() {
        this.result = this.service.querySeedlingmessageService();
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.domain.getDomainName(this.request));
        }
        return this.result;
    }

    // 按类型查询发布苗木信息公共数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySeedlingmessage/tp", produces = "application/json;charset=utf-8")
    public Result querySeedlingmessageByTypeController(
            @RequestParam("type") String type) {
        this.result = this.service.querySeedlingmessageByTypeService(type);
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.domain.getDomainName(this.request));
        }
        return this.result;
    }

    // 按多个类型查询发布苗木信息公共数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySeedlingmessage/tp/sub", produces = "application/json;charset=utf-8")
    public Result querySeedlingmessageByTypeController(
            @RequestParam("type") String type,
            @RequestParam("subclass") String subclass) {
        this.result = this.service.querySeedlingmessageByTypeService(type,
                subclass);
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.domain.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询用户发布的苗木信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryUserSeedlingmessage", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryUserSeedlingmessageController(
            @RequestParam("uid") String uid) {
        this.result = this.service.querySeedlingmessageByIdService(uid);
        if (this.result.getStatus() == 0) {
            this.result.setPath(this.domain.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询发布招标信息公共数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryBid", produces = "application/json;charset=utf-8")
    public Result queryBidController() {
        this.result = this.service.queryBidService();
        return this.result;
    }

    // 查询发布人员招聘信息公共数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryRecruit", produces = "application/json;charset=utf-8")
    public Result queryRecruitController() {
        this.result = this.service.queryRecruitService();
        return this.result;
    }

    // 查询用户发布人员招聘信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryUserRecruit", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryUserRecruitController(@RequestParam("uid") String uid) {
        this.result = this.service.queryRecruitByIdService(uid);
        return this.result;
    }

    // 添加用户发布人员招聘信息访问接口
    @CrossOrigin(origins = "*", maxAge = 36000, methods = {RequestMethod.POST})
    @ResponseBody
    @RequestMapping(value = "/saveRecruit", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveRecruitController(Recruit msg) {
        boolean tip = this.charset.recruitForm(msg);
        if (tip == false) {
            this.result = new Result("输入有误，请检查后重试", 5);
            return this.result;
        }
        this.result = this.service.saveRecruitService(msg);
        return this.result;
    }

    // 抓取招标信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveBidsMsgs", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveBidMsgsController(@RequestBody List<Bid> msg) {
        this.result = this.service.saveBidsService(msg);
        return this.result;
    }

    // 添加用户的发布设备租赁信息访问接口
    @SuppressWarnings("static-access")
    @CrossOrigin(origins = "*", maxAge = 36000, methods = {RequestMethod.POST})
    @ResponseBody
    @RequestMapping(value = "/saveEquipmentLeasing", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveEquipmentLeasingController(HttpServletRequest req,
                                                 Equipmentleasing msg) {
        boolean check = this.charset.equipmentForm(msg);
        if (check == false) {
            this.result = new Result("输入有误，请检查后重试", 5);
            return this.result;
        }
        try {
            // 获取上传文件路径
            this.list = this.uploadService.equipmentLeasingFileSave(req);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("文件上传失败，请重试", 1);
            return this.result;
        }
        if (this.list.size() > 0) {
            // 设置上传文件编号
            msg.setFilesId(this.uuid.getUUID().toString());
            // 获取用户编号
            this.file.setUid(msg.getUid());
            // 将设置的文件编号保存到文件信息表中
            this.file.setPhotofile(msg.getFilesId());
            // 保存文件信息数据
            boolean tip = this.fileService.SaveFileMassage(this.list,
                    this.file, req);
            if (tip == false) {
                this.result = new Result("系统忙！请稍后重试", 1);
                return this.result;
            }
        } else {
            this.result = new Result("文件为空或格式不正确", 1);
            return this.result;
        }
        // 文件上传成功后保存设备租赁发布信息
        this.result = this.service.saveEquipmentLeasingService(msg);
        return this.result;
    }

    // 添加用户的发布苗木信息访问接口
    @SuppressWarnings("static-access")
    @CrossOrigin(origins = "*", maxAge = 36000, methods = {RequestMethod.POST})
    @ResponseBody
    @RequestMapping(value = "/saveSeedlingmessage", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveSeedlingmessageController(HttpServletRequest req,
                                                Seedlingmessage msg) {
        boolean check = this.charset.seedlingForm(msg);
        if (check == false) {
            this.result = new Result("输入有误，请检查后重试", 5);
            return this.result;
        }
        try {
            // 获取上传文件路径
            this.list = this.uploadService.seedlingMassageFileSave(req);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("文件上传失败，请重试", 1);
            return this.result;
        }
        if (this.list.size() > 0) {
            // 设置上传文件编号
            msg.setFilesId(this.uuid.getUUID().toString());
            // 获取用户编号
            this.file.setUid(msg.getUid());
            // 将设置的文件编号保存到文件信息表中
            this.file.setPhotofile(msg.getFilesId());
            // 保存文件信息数据
            boolean tip = this.fileService.SaveFileMassage(this.list,
                    this.file, req);
            if (tip == false) {
                this.result = new Result("系统忙！请稍后重试", 1);
                return this.result;
            }
        } else {
            this.result = new Result("文件为空或格式不正确", 1);
            return this.result;
        }
        // 文件上传成功后保存苗木发布信息
        this.result = this.service.saveSeedlingmessageService(msg);
        return this.result;
    }
}
