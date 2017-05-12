package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.StateResult;
import com.xkd.entity.User;
import com.xkd.service.RegisterService;

/**
 * 用户注册控制器
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController implements Serializable {

	/**
	 * 序列化
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 * 用户注册服务
	 */
	@Resource(name = "RegisterService")
	private RegisterService		registerService;

	/**
	 * 进入注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/toRegister.do")
	public String toRegister() {
		return "register/register";
	}

	@RequestMapping("/regist")
	@ResponseBody
	public StateResult register(User user) {
		StateResult result = registerService.registUser(user);
		System.out.println("注册成功");
		return result;
	}
}
