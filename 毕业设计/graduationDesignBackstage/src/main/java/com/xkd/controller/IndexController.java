package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前端
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController implements Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("index.do")
	public String index(Model model) {
		return "jsp/index";
	}

	@RequestMapping("news.do")
	public String news(Model model) {
		return "jsp/newsinformation/news_information";
	}

	@RequestMapping("projectNews.do")
	public String projectNews(Model model) {
		return "jsp/newsinformation/news_project";
	}

	@RequestMapping("jion.do")
	public String jion(Model model) {
		return "jsp/addproject/jion";
	}

	@RequestMapping("register.do")
	public String register(Model model) {
		return "jsp/register/register";
	}

	@RequestMapping("teachersStrength.do")
	public String teachersStrength(Model model) {
		return "jsp/teacherstrength/teachers_strength";
	}

}
