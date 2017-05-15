package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目创建
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/projectCreatController")
public class ProjectCreatController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("/toCreatProject.do")
	public String toCreatProject(Model model) {
		// 添加处理代码
		return "project/projectcreat";
	}
}
