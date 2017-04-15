package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String toLogin(HttpServletRequest request){
    	//删除session
    	HttpSession session=request.getSession();
		session.setAttribute("user", null);
    	System.out.println("进入登陆页面");
        return "login";
    }

    @RequestMapping("/loginIn")
	@ResponseBody
	public StateResult login(User user,HttpServletRequest request){
    	System.out.println("登录验证"+user);
		StateResult result = loginService.checkLogin(user);
		if(result.getStatus()==0){
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
		}
		System.out.println("resultstatus"+result.getStatus());
		return result;
	}
  
  
}