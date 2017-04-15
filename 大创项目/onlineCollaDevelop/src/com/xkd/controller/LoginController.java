package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.StateResult;
import com.xkd.entity.User;
import com.xkd.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController implements Serializable {
    /**
	 * 
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 登陆服务
	 */
	@Resource(name="LoginService")
    private LoginService loginService;
    /**
     * 进入登陆页面
     * @return
     */
    @RequestMapping("/toLogin.do")
    public String toLogin() {
    	System.out.println("进入登陆页面");
        return "login";
    }

    @RequestMapping("/loginIn")
	@ResponseBody
	public StateResult login(User user){
    	System.out.println("登录验证"+user);
		StateResult result = loginService.checkLogin(user);
		System.out.println("resultstatus"+result.getStatus());
		return result;
	}
  
  
}