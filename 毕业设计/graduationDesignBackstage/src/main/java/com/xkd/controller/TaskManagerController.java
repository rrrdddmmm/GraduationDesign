package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 任务管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/taskManagerController")
public class TaskManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * 进入任务主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/taskProject.do")
	public String taskProjectList(Model model) {
		// 添加处理代码
		return "task/taskprojectlist";
	}

	/**
	 * 创建任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskProjectList.do")
	public String taskstartcreat(Model model) {
		return "task/taskstartcreat";
	}

	/**
	 * 分配任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskDistribution.do")
	public String taskDistribution(Model model) {
		return "task/taskdistribution";
	}

	/**
	 * 查看任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskChakan.do")
	public String taskChakan(Model model) {
		return "task/taskchakan";
	}

	/**
	 * 修改任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskAlter.do")
	public String taskAlter(Model model) {
		return "task/taskalter";
	}
}
