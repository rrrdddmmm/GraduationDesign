package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Project;
import com.xkd.service.ProjectManageService;
import com.xkd.service.UserManagerService;

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
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "projectManageService")
	private ProjectManageService	projectManageService;
	@Resource(name = "userManagerService")
	private UserManagerService		userManagerService;

	@RequestMapping("/projectList.do")
	public String projectList(Model model, Project project, HttpServletRequest request) {
		model.addAttribute("projectlist", projectManageService.projectList(project, request));
		model.addAttribute("applicationlist", projectManageService.projectApplication(request));
		model.addAttribute("project", project);
		return "project/projectlist";
	}

	@RequestMapping("/delHandle.do")
	@ResponseBody
	public StateResult delHandle(String projid, StateResult stateResult) {
		projectManageService.delHandle(projid, stateResult);
		return stateResult;
	}
}
