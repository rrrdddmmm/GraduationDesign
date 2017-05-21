package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.entity.Page.Home;
import com.xkd.service.ProjectManageService;
import com.xkd.service.TeamManagerService;

/**
 * 团队管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/teamManagerController")
public class TeamManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "teamManagerService")
	private TeamManagerService		teamManagerService;
	@Resource(name = "projectManageService")
	private ProjectManageService	projectManageService;

	@RequestMapping("/teamList.do")
	public String teamList(Model model, Home home, HttpServletRequest request) {
		model.addAttribute("myprojectlist", projectManageService.getCreatProject(request));
		model.addAttribute("homeprojectlist", teamManagerService.teamList(home, request));
		model.addAttribute("home", home);
		return "team/teamlist";
	}
}
