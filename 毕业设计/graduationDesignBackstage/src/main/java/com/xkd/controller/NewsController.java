package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.service.NewsService;

/**
 * 新闻动态控制器
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController implements Serializable {

	/**
	 * 序列化
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 * 新闻动态服务
	 */
	@Resource(name = "NewsService")
	private NewsService			newsService;

	/**
	 * 进入新闻动态
	 * 
	 * @return
	 */
	@RequestMapping("/toNews.do")
	public String toNews() {
		return "newsinformation/news_information";
	}

}
