package com.xkd.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.BaseConfig;
import com.xkd.entity.BaseProject;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Project;
import com.xkd.service.ConfigManagerService;
import com.xkd.service.ProjectAuditService;
import com.xkd.service.ProjectManageService;
import com.xkd.service.UserManagerService;
import com.xkd.util.ConfigStr;
import com.xkd.util.FileDealWith;

/**
 * 项目审核
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/projectAuditController")
public class ProjectAuditController implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "projectAuditService")
	private ProjectAuditService		projectAuditService;
	@Resource(name = "projectManageService")
	private ProjectManageService	projectManageService;
	@Resource(name = "userManagerService")
	private UserManagerService		userManagerService;
	@Resource(name = "configManagerService")
	private ConfigManagerService	configManagerService;

	@RequestMapping("projectChakan.do")
	public String projectChakan(Model model, String msg, String projid) {
		@SuppressWarnings("unchecked")
		List<BaseConfig> languageconfiglist = (List<BaseConfig>) configManagerService.configList(4);
		model.addAttribute("languageconfiglist", languageconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> platformconfiglist = (List<BaseConfig>) configManagerService.configList(5);
		model.addAttribute("platformconfiglist", platformconfiglist);
		BaseProject obj = projectManageService.getProjectById(projid);
		BaseUser user = userManagerService.findByEmail(obj.getProjemail());
		model.addAttribute("user", user);
		model.addAttribute("allResultPath", ConfigStr.ResourcesPath + user.getId() + "/" + obj.getProjid() + "");
		model.addAttribute("project", obj);
		model.addAttribute("msg", msg);
		return "project/projectchakan";
	}

	@RequestMapping("auditHandle.do")
	@ResponseBody
	public StateResult auditHandle(Project project, StateResult stateResult) throws ParseException {
		projectAuditService.auditHandle(project, stateResult);
		return stateResult;
	}

	@RequestMapping("alterProjectHandle.do")
	@ResponseBody
	public StateResult alterProjectHandle(BaseProject baseProject, StateResult stateResult, HttpServletRequest request)
			throws ParseException, IllegalStateException, IOException {
		projectAuditService.alterProjectHandle(baseProject, stateResult, request);
		return stateResult;
	}

	@RequestMapping("download.do")
	public void download(HttpServletResponse response, String filePath) {
		try {
			if (new File(filePath).isDirectory()) {
				FileDealWith.iteratorDirdownjoad(response, filePath);
			} else {
				FileDealWith.downloadFile(response, filePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
