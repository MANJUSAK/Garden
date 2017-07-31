package com.henghao.Garden.controller;

import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.QueryProjectManageService;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.util.DomainNameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * function 项目管理信息查询模块访问入口java类
 * <p>
 * date 2013.03.12
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
@RequestMapping("/projectManage")
public class QueryProjectManageController {

    @Resource
    private QueryProjectManageService service;
    @Resource
    private SaveFileService fileService;
    @Resource
    private HttpServletRequest request;
    // 实例化域名对象方法类
    private DomainNameUtil url = DomainNameUtil.getInstance();
    // 实例化结果集实体类，并定义为公共结果集
    private Result result = null;

    // 查询我的轨迹信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryMylocusMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryBuildDataMsgController(@RequestParam("uid") String uid) {
        this.result = null;
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryMylocusMsgService(uid);
        return this.result;
    }

    // 查询会审结果信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryHsResultMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryHsResultMsgContorller(@RequestParam("uid") String uid) {
        this.result = null;
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryHsResultMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询开工报告信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryKgReportMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryKgReportMsgContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryKgReportMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询项目信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryProjectMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryProjectMsgController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0 || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryProjectMsgService(uid);
        return this.result;
    }

    // 查询项目信息访问接口
    @ResponseBody
    @RequestMapping(value = "/queryProjectMsgByName", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryProjectMsgByNameController(
            @RequestParam("xmName") String xmName,
            @RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryProjectMsgByNameService(xmName, uid);
        return this.result;
    }

    // 查询现场检验信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryCheckoutMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryCheckoutMsgContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryCheckoutMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询设备信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryEquipmentMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryEquipmentContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryEquipmentMsgService(uid);
        return this.result;
    }

    // 查询施工人员信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySgPersonnelMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result querySgPersonnelContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.querySgPersonnelMsgServiec(uid);
        return this.result;
    }

    // 查询现场施工检验信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryProspectMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryProspectContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryProspectMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询供货商信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySupplierMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result querySupplierMsgContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.querySupplierMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询变更管理信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryAlterationMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryAlterationMsgContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryAlterationMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询技术交底信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryTechnologyMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryTechnologyMsgController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryTechnologyMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询我的钱包信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryWalletMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryWalletMsgContorller(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryWalletMsgService(uid);
        return this.result;
    }

    // 查询申报进度信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryDeclarationMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryDeclarationMsgController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryDeclarationMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询结算信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySettlementMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result querySettlementMsgController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.querySettlementMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询施工日志信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryConstructionLogMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryConstructionLogMsgController(
            @RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryConstructionLogMsgService(uid);
        return this.result;
    }

    // 查询监理日志信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySupervisionlogMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result querySupervisionlogMsgController(
            @RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.querySupervisionlogMsgService(uid);
        return this.result;
    }

    // 查询竣工验收信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/queryFinalacceptanceMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result queryFinalacceptanceMsgController(
            @RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.queryFinalacceptanceMsgService(uid);
        if (this.result.getStatus() == 0) {
            // 获取服务器域名信息
            this.result.setPath(this.url.getDomainName(this.request));
        }
        return this.result;
    }

    // 查询施工安全日志概要信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/querySummaryLogMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result querySummaryLogMsgController(@RequestParam("uid") String uid) {
        if (uid == null || uid.length() == 0) {
            this.result = new Result("请登录", 1);
            return this.result;
        }
        this.result = this.service.querySummaryLogMsgService(uid);
        return this.result;
    }
}
