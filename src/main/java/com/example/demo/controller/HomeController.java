package com.example.demo.controller;

/**
 * Created by Administrator on 2018/4/10.
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping({ "/", "index" })
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/headhtml", method = RequestMethod.GET)
    public String index1() {
        return "/head";
    }
    @RequestMapping(value = "/lefthtml", method = RequestMethod.GET)
    public String index2() {
        return "/left";
    }
    @RequestMapping(value = "/mainhtml", method = RequestMethod.GET)
    public String index3() {
        return "/main";
    }

    @RequestMapping("member-list")
    public String member(){
        SimpleAuthenticationInfo sim=new SimpleAuthenticationInfo();

        return "/member-list";
    }
    @RequestMapping("user-list")
    public String member1(){
        return "/user-list";
    }


    /**
     * 登录入口
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) {
        System.out.println("HomeController.login");
        // 登录失败从request中获取shiro处理的异常信息
        // shiroLoginFailure:就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -->帐号不存在：");
                msg = "UnknownAccountException -->帐号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            }else if (ExcessiveAttemptsException.class.getName().equals(exception)) {
                System.out.println("ExcessiveAttemptsException -- > 登录失败次数过多：");
                msg = "ExcessiveAttemptsException -- > 登录失败次数过多：";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }
}
