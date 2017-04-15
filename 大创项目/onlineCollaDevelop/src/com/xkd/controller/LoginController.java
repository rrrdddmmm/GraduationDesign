package com.xkd.controller;

import java.io.Serializable;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.xkd.entity.StateResult;
import com.xkd.entity.User;
import com.xkd.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController implements Serializable {
    @Resource
    private LoginService loginService;
    
    @RequestMapping("/toLogin.do")
    public String toLogin() {
    	System.out.println("进入登陆页面");
        return "login";
    }
    
    @RequestMapping("/toIndex.do")
    public String toIndex() {
    	System.out.println("进入首页");
        return "index";
    }
    
    @RequestMapping("/toRegist.do")
    public String toRegist() {
    	System.out.println("进入注册页面");
        return "register";
    }
 
    @RequestMapping("/loginIn")
	@ResponseBody
	public StateResult login(User user){
    	System.out.println("登录验证");
		StateResult result = loginService.checkLogin(user);
		System.out.println("resultstatus"+result.getStatus());
		return result;
	}
    
    @RequestMapping("/regist")
	@ResponseBody
	public StateResult register(User user){
    	System.out.println("注册中");
    	StateResult result = loginService.registUser(user);
    	System.out.println("注册成功");
		return result;
	}
  
}