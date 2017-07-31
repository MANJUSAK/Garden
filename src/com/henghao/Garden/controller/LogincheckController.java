package com.henghao.Garden.controller;

import com.henghao.Garden.entity.user.*;
import com.henghao.Garden.formFilter.LoginFromFilterUtil;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.UserManageService;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.service.SaveProjectManageService;
import com.henghao.Garden.util.UUIDUtil;
import com.henghao.Garden.util.UserFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

/**
 * function 登陆注册模块访问入口java类
 * <p>
 * date 2017.02.28
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
public class LogincheckController {

    @Resource
    private UserManageService service;
    @Resource
    private SaveProjectManageService wallet;
    @Resource
    private HttpServletRequest request;
    @Resource
    private SaveFileService fileService;
    @Resource
    private HttpSession session;
    // 实例化文件保存实体类
    private Userfile file = new Userfile();
    // 实例化文件保存方法类
    private UserFileUtil uploadService = UserFileUtil.getInstance();
    // 实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    // 实例化结果集实体类，并定义为公共结果集
    private Result result = null;
    // 初始化公共集合
    private LinkedList<String> list = null;
    // 实例化字符验证工具类
    private LoginFromFilterUtil charset = LoginFromFilterUtil.getInstance();

    // 用户登陆访问接口
    @ResponseBody
    @RequestMapping(value = "/login", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result Login(Users user) {
        this.result = this.service.login(user);
        return this.result;
    }

    // PC端用户登陆访问接口
    /*
     * @RequestMapping(value = "/login/pc", method = { RequestMethod.POST })
	 * public String pcLogin(Users user, String userCode) { String pcCode =
	 * (String) this.session.getAttribute("PcCode"); if
	 * (!pcCode.equals(userCode)) { this.result = new Result("验证码错误", 1);
	 * this.request.getSession().setAttribute("result", result); return
	 * "/test/login.html"; } result = this.service.login(user);
	 * this.request.getSession().setAttribute("result", result); if
	 * (result.getStatus() == 1) { return "/test/login.html"; } return
	 * "/test/test.html"; }
	 */

    // 管理员登陆访问接口
    @RequestMapping(value = "/login/role", method = {RequestMethod.POST})
    public String adminLogin(Admin role, Model model) {
        this.result = this.service.roleLogin(role);
        if (this.result.getStatus() > 0) {
            model.addAttribute("msg", this.result.getResult());
            return "/news/login.html";
        }
        this.session.setAttribute("userInfo", this.result.getData());
        return "/checkCompact/build";
    }

    // 用户注册信息访问接口
    @SuppressWarnings("static-access")
    @CrossOrigin(origins = "*", maxAge = 360000, methods = {RequestMethod.POST})
    @ResponseBody
    @RequestMapping(value = "/register", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result register(Users user, HttpServletRequest req) {
        // String pcCode = (String) this.session.getAttribute("PcCode");
        // 验证字符
        boolean check = this.charset.checkRegister(user);
        if (check == false) {
            this.result = new Result("输入有误，请检查正确后重试", 5);
            return this.result;
        }
        // 检查用户名是否已存在
        int uMsg = this.service.checkUserName(user.getUsername());
        int uTel = this.service.checkUserTel(user.getTel());
        if (uMsg == 1) {
            this.result = new Result("该用户名已存在", 1);
            return this.result;
        } else if (uTel == 1) {
            this.result = new Result("该手机号已被注册", 1);
            return this.result;
        } else {
            try {
                // 获取上传文件保存路径
                this.list = this.uploadService.enterpriseFileSave(req);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                this.result = new Result("文件上传失败，请稍后重试", 2);
                return this.result;
            }
            if (this.list.size() > 0) {
                // 设置文件路径编号
                user.setFilesId(this.uuid.getUUID().toString());
                // 将设置的文件路径编号存放到文件数据表
                this.file.setFileId(user.getFilesId());
                boolean tip = this.fileService.SaveUserFileMassage(this.list,
                        this.file);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 4);
                    return this.result;
                }
            } else {
                this.result = new Result("所需文件不能为空", 3);
                return this.result;
            }
            // 用户名不存在时注册用户
            this.result = this.service.register(user);
            if (this.result.getStatus() == 0) {
                // 查询注册的账户
                Result userWallet = this.service.queryUser(user);
                Users userMsg = (Users) userWallet.getData();
                Wallet wallet = new Wallet();
                // 获取用户ID
                wallet.setUid(userMsg.getUid());
                // 初始化用户钱包
                this.wallet.saveWalletMsgService(wallet);
            }
        }
        return this.result;
    }

    // 管理员注册访问接口
    @RequestMapping(value = "/role/register", method = {RequestMethod.POST})
    public String roleRegisterController(Admin role, Model model) {
        this.result = this.service.roleRegister(role);
        model.addAttribute("tip", this.result.getResult());
        if (this.result.getStatus() > 0) {
            return "/news/register.html";
        }
        return "/news/login.html";
    }

    // 用户签到访问接口
    @ResponseBody
    @RequestMapping(value = "/report", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result report(Sites site) {
        if (site.getUid() == null || site.getUid().length() == 0) {
            this.result = new Result("请先登陆", 1);
            return this.result;
        }
        this.result = this.service.report(site);
        return this.result;
    }

    // 用户签到次数访问接口
    @ResponseBody
    @RequestMapping(value = "/report/message", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result reportController(String uid) {
        this.result = this.service.report(uid);
        return this.result;
    }

    // 退出管理员登陆访问接口
    @RequestMapping("/loginOut")
    public String loginOut() {
        this.session.removeAttribute("userInfo");
        return "/news/login.html";
    }
}
