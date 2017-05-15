package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 新闻管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/newsManagerController")
public class NewsManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("newsList.do")
	public String newsList() {
		return "news/newslist";
	}

	@RequestMapping("newsAdd.do")
	public String newsAdd() {
		return "news/newsadd";
	}

	@RequestMapping("newsAlter.do")
	public String newsAlter() {
		return "news/newsadd";
	}
}
