package com.xkd.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xkd.entity.BaseConfig;
import com.xkd.entity.StateResult;
import com.xkd.service.ConfigManagerService;

/**
 * 配置管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/configManagerController")
public class ConfigManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;

	@Resource(name = "configManagerService")
	private ConfigManagerService	configManagerService;

	@RequestMapping("configList.do")
	public String configList(Model model, Integer flage) {
		@SuppressWarnings("unchecked")
		List<BaseConfig> configlist = (List<BaseConfig>) configManagerService.configList(flage);
		model.addAttribute("configlist", configlist);
		model.addAttribute("flage", flage);
		return "config/configlist";
	}

	@RequestMapping("configAdd.do")
	public String configAdd(Model model, BaseConfig baseConfig) {
		model.addAttribute("baseConfig", baseConfig);
		return "config/configadd";
	}

	@RequestMapping("configHandle.do")
	@ResponseBody
	public StateResult configHandle(BaseConfig baseConfig, StateResult stateResult) {
		stateResult = configManagerService.configHandle(baseConfig, stateResult);
		return stateResult;
	}

	@RequestMapping("configDefaultTask.do")
	public String configDefaultTask() {
		return "config/defaulttask";
	}

	@ModelAttribute
	public void populateModel(HttpServletRequest request, Model model) throws ControllerException {
		SessionController.noSeeiondelwith(request);
	};
}
