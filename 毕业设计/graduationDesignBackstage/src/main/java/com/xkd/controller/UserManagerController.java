package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/userManagerController")
public class UserManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("/userAdd.do")
	public String userAdd(Model model) {
		return "user/useradd";
	}

	@RequestMapping("/userAlter.do")
	public String userAlter(Model model) {
		return "user/useradd";
	}

	@RequestMapping("/userList.do")
	public String userList(Model model) {
		return "user/userlist";
	}
}
