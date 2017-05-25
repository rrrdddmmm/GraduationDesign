package com.xkd.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.dao.BaseTaskMapper;
import com.xkd.entity.BaseNews;
import com.xkd.entity.BaseTask;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.service.NewsManagerService;
import com.xkd.service.UserManagerService;
import com.xkd.util.ConfigStr;

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
	@Resource(name = "newsManagerService")
	private NewsManagerService	newsManagerService;
	/**
	 * 任务表
	 */
	@Resource(name = "baseTaskMapper")
	private BaseTaskMapper		baseTaskMapper;
	@Resource(name = "userManagerService")
	private UserManagerService	userManagerService;

	@RequestMapping("index.do")
	public String index(Model model) {
		List<BaseNews> fivelist = new ArrayList<BaseNews>();
		List<BaseNews> list = newsManagerService.newsList();
		for (int i = 0; i < 4 && i < list.size(); i++) {
			fivelist.add(list.get(i));
		}
		model.addAttribute("newslist", fivelist);
		return "jsp/index";
	}

	@RequestMapping("news.do")
	public String news(Model model) {
		model.addAttribute("newslist", newsManagerService.newsList());
		return "jsp/newsinformation/news_information";
	}

	@RequestMapping("projectNews.do")
	public String projectNews(Model model, BaseTask baseTask) {
		baseTask.setDescription(ConfigStr.defaultTaskview);
		List<BaseTask> list = baseTaskMapper.selectByPrimaryAll(baseTask);
		System.out.println(list.size());
		model.addAttribute("list", list);
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

	@RequestMapping("registerHandle.do")
	@ResponseBody
	public StateResult registerHandle(StateResult stateResult, BaseUser user) {
		userManagerService.userAddHandle(user, stateResult);
		if (stateResult.getStatus() == 0) {
			stateResult.setMsg("注册成功！请尽快登陆系统完善信息!");
		}
		return stateResult;
	}

	@RequestMapping("teachersStrength.do")
	public String teachersStrength(Model model) {
		return "jsp/teacherstrength/teachers_strength";
	}

}
