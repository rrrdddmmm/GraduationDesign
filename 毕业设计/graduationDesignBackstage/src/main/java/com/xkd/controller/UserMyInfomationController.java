package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 我的信息
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/userMyInfomationController")
public class UserMyInfomationController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("myInfomation.do")
	public String myInfomation(Model model) {
		return "user/myinfomation";
	}
}
