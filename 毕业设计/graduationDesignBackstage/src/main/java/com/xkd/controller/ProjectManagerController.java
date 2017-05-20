package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 项目管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/projectManagerController")
public class ProjectManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("/projectList.do")
	public String projectList(Model model) {

		// 添加处理代码
		return "project/projectlist";
	}
}
