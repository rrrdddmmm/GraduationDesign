package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.entity.BaseNews;
import com.xkd.entity.StateResult;
import com.xkd.service.NewsManagerService;

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
	@Resource(name = "newsManagerService")
	private NewsManagerService	newsManagerService;

	@RequestMapping("newsList.do")
	public String newsList(Model model) {
		model.addAttribute("newslist", newsManagerService.newsList());
		return "news/newslist";
	}

	@RequestMapping("newsAdd.do")
	public String newsAdd() {
		return "news/newsadd";
	}

	@RequestMapping("/newsAddHandle.do")
	@ResponseBody
	public StateResult newsAddHandle(BaseNews baseNews,
			@RequestParam(value = "file", required = true) MultipartFile file) {
		return newsManagerService.newsAddHandle(baseNews, file);
	}

	@RequestMapping("newsAlter.do")
	public String newsAlter(Model model, Integer id) {
		BaseNews baseNews = newsManagerService.getModelById(id);
		model.addAttribute("baseNews", baseNews);
		return "news/newsalter";
	}

	@RequestMapping("/newsAlterHandle.do")
	@ResponseBody
	public StateResult newsAlterHandle(BaseNews baseNews) {
		return newsManagerService.newsAlterHandle(baseNews);
	}

	@RequestMapping("/alterNewsImages.do")
	@ResponseBody
	public StateResult alterNewsImages(BaseNews baseNews,
			@RequestParam(value = "file", required = true) MultipartFile file) {
		return newsManagerService.alterNewsImages(baseNews, file);
	}

	@RequestMapping("/userDelHandle.do")
	@ResponseBody
	public StateResult userDelHandle(BaseNews baseNews, StateResult stateResult) {
		newsManagerService.userDelHandle(baseNews, stateResult);
		return stateResult;
	}
}
