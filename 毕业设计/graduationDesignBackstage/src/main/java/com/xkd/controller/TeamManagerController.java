package com.xkd.controller;

import java.io.Serializable;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Home;
import com.xkd.service.ProjectManageService;
import com.xkd.service.TeamManagerService;
import com.xkd.service.UserManagerService;

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
	@Resource(name = "userManagerService")
	private UserManagerService		userManagerService;

	@RequestMapping("/teamList.do")
	public String teamList(Model model, Home home, HttpServletRequest request) {
		model.addAttribute("myprojectlist", projectManageService.getCreatProject(request));
		model.addAttribute("homeprojectlist", teamManagerService.teamList(home, request));
		model.addAttribute("studentlist", userManagerService.userAllStudentList());
		model.addAttribute("home", home);
		return "team/teamlist";
	}

	@RequestMapping("/delHandle.do")
	@ResponseBody
	public StateResult delHandle(Home home, StateResult stateResult) {
		teamManagerService.delHandle(home, stateResult);
		return stateResult;
	}

	@RequestMapping("/addHandle.do")
	public String addHandle(Model model, Home home, HttpServletRequest request, StateResult stateResult) {
		teamManagerService.addHandle(home, stateResult);
		model.addAttribute("myprojectlist", projectManageService.getCreatProject(request));
		model.addAttribute("homeprojectlist", teamManagerService.teamList(home, request));
		model.addAttribute("studentlist", userManagerService.userAllStudentList());
		model.addAttribute("stateResult", stateResult);
		return "team/teamlist";
	}

	@ModelAttribute
	public void populateModel(HttpServletRequest request, Model model) throws ControllerException, ParseException {
		projectManageService.setProjstatus();
		SessionController.noSeeiondelwith(request);
	};
}
