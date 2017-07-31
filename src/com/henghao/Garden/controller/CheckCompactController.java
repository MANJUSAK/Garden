package com.henghao.Garden.controller;

import com.henghao.Garden.resultEntity.CompactBath;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.CheckCompactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * function 合同管理审核访问入口Java类
 * <p>
 * date 2017.04.21
 *
 * @author 严彬荣
 */
@Controller
@RequestMapping("/checkCompact")
public class CheckCompactController {

    @Resource
    private CheckCompactService service;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpSession session;
    // 实例化公共结果集实体
    private Result result = null;

    // 待审核建设类合同数据访问接口
    @RequestMapping("/build")
    public String buildController(Model model) {
        if (this.session.getAttribute("userInfo") == null) {
            return "/news/login.html";
        }
        this.result = this.service.checkBuildCompact(this.request);
        model.addAttribute("result", this.result);
        return "/WEB-INF/backstage/buildCompact.jsp";
    }

    // 待审核园林类合同数据访问接口
    @RequestMapping("/garden")
    public String gardenController(Model model) {
        if (this.session.getAttribute("userInfo") == null) {
            return "/news/login.html";
        }
        this.result = this.service.checkGardenCompact(this.request);
        model.addAttribute("result", this.result);
        return "/WEB-INF/backstage/gardenCompact.jsp";
    }

    // 待审核园林工程类合同数据访问接口
    @RequestMapping("/engineering")
    public String engineeringController(Model model) {
        if (this.session.getAttribute("userInfo") == null) {
            return "/news/login.html";
        }
        this.result = this.service.checkEngineeringCompact(this.request);
        model.addAttribute("result", this.result);
        return "/WEB-INF/backstage/engineeringCompact.jsp";
    }

    // 待审核景观类合同数据访问接口
    @RequestMapping("/landscape")
    public String landscapeController(Model model) {
        if (this.session.getAttribute("userInfo") == null) {
            return "/news/login.html";
        }
        this.result = this.service.checkLandscapeCompact(this.request);
        model.addAttribute("result", this.result);
        return "/WEB-INF/backstage/landscapeCompact.jsp";
    }

    // 建设类合同审核公示访问接口
    @RequestMapping(value = "/updateBuild", method = {RequestMethod.POST})
    public String updateBuildController(CompactBath bath, Model model) {
        if (bath.getIds() == null) {
            model.addAttribute("status", "未选则相关数据");
            return "/checkCompact/build";
        }
        this.result = this.service.updateBuildCompact(bath);
        model.addAttribute("status", this.result.getResult());
        return "/checkCompact/build";
    }

    // 园林类合同审核公示访问接口
    @RequestMapping(value = "/updateGarden", method = {RequestMethod.POST})
    public String updateGardenController(CompactBath bath, Model model) {
        if (bath.getIds() == null) {
            model.addAttribute("status", "未选则相关数据");
            return "/checkCompact/garden";
        }
        this.result = this.service.updateGardenCompact(bath);
        model.addAttribute("status", this.result.getResult());
        return "/checkCompact/garden";
    }

    // 园林工程类合同审核公示访问接口
    @RequestMapping(value = "/updateEngineering", method = {RequestMethod.POST})
    public String updateEngineeringController(CompactBath bath, Model model) {
        if (bath.getIds() == null) {
            model.addAttribute("status", "未选则相关数据");
            return "/checkCompact/engineering";
        }
        this.result = this.service.updateEngineeringCompact(bath);
        model.addAttribute("status", this.result.getResult());
        return "/checkCompact/engineering";
    }

    // 景观类合同审核公示访问接口
    @RequestMapping(value = "/updateLandscape", method = {RequestMethod.POST})
    public String updateLandscapeController(CompactBath bath, Model model) {
        if (bath.getIds() == null) {
            model.addAttribute("status", "未选则相关数据");
            return "/checkCompact/landscape";
        }
        this.result = this.service.updateLandscapeCompact(bath);
        model.addAttribute("status", this.result.getResult());
        return "/checkCompact/landscape";
    }
}
