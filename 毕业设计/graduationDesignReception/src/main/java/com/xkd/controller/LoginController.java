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
	private static final long	serialVersionUID	= 1L;
	/**
	 * 登陆服务
	 */
	@Resource(name = "LoginService")
	private LoginService		loginService;

	/**
	 * 进入登陆页面
	 * 
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(HttpServletRequest request) {
		System.out.println("进入登陆页面");
		return "login/login";
	}

	@RequestMapping("/loginIn")
	@ResponseBody
	public StateResult login(User user, HttpServletRequest request) {
		StateResult result = loginService.checkLogin(user);
		if (result.getStatus() == 0) {
			HttpSession session = request.getSession();
			System.out.println("session中的数据：" + (User) result.getUse());
			session.setAttribute("user", (User) result.getUse());
		}
		return result;
	}

}