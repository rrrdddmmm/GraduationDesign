package com.xkd.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.entity.BaseConfig;
import com.xkd.entity.BaseDirection;
import com.xkd.entity.BaseProject;
import com.xkd.entity.StateResult;
import com.xkd.service.ConfigManagerService;
import com.xkd.service.ProjectCreatService;
import com.xkd.service.UserManagerService;

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
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "configManagerService")
	private ConfigManagerService	configManagerService;
	@Resource(name = "userManagerService")
	private UserManagerService		userManagerService;

	@Resource(name = "projectCreatService")
	private ProjectCreatService		projectCreatService;

	@RequestMapping("/toCreatProject.do")
	public String toCreatProject(Model model) {
		@SuppressWarnings("unchecked")
		List<BaseConfig> languageconfiglist = (List<BaseConfig>) configManagerService.configList(4);
		model.addAttribute("languageconfiglist", languageconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> platformconfiglist = (List<BaseConfig>) configManagerService.configList(5);
		model.addAttribute("platformconfiglist", platformconfiglist);
		// 教师方向全部信息
		List<BaseDirection> baseDirectionList = userManagerService.getTeacherMenuForCreat();
		model.addAttribute("baseDirectionList", baseDirectionList);
		// 添加处理代码
		return "project/projectcreat";
	}

	@RequestMapping("/creatProjectHandle.do")
	@ResponseBody
	public StateResult creatProjectHandle(BaseProject baseProject, StateResult stateResult,
			@RequestParam(value = "file", required = true) MultipartFile[] file, HttpServletRequest request) {
		return projectCreatService.creatProjectHandle(baseProject, stateResult, file, request);
	}
}
