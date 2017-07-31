package com.henghao.Garden.controller;

/**
 * function 验证码访问入口Java类
 * <p>
 * date 2017.03.02
 *
 * @author 严彬荣
 */

import com.henghao.Garden.util.AuthCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
public class AuthCodeController {

    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpSession session;
    private AuthCodeUtil authCode = AuthCodeUtil.getInstance();

    // 验证码接口
    @RequestMapping("/authCode")
    public void AuthCode(HttpServletResponse response) {
        try {
            this.authCode.getAuthCode(request, response, session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
