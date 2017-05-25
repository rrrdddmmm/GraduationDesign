package com.xkd.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.entity.BaseConfig;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.service.ConfigManagerService;
import com.xkd.service.UserMyInfomationService;
import com.xkd.util.ConfigStr;

/**
 * 我的信息
 * 
 * @author RBB
 *
 */
@Controller
@SessionAttributes(ConfigStr.userInfomation)
@RequestMapping("/userMyInfomationController")
public class UserMyInfomationController implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "configManagerService")
	private ConfigManagerService	configManagerService;
	@Resource(name = "userMyInfomationService")
	private UserMyInfomationService	userMyInfomationService;

	@RequestMapping("myInfomation.do")
	public String myInfomation(Model model) {
		@SuppressWarnings("unchecked")
		List<BaseConfig> educationconfiglist = (List<BaseConfig>) configManagerService.configList(1);
		model.addAttribute("educationconfiglist", educationconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> titleconfiglist = (List<BaseConfig>) configManagerService.configList(3);
		model.addAttribute("titleconfiglist", titleconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> directionconfiglist = (List<BaseConfig>) configManagerService.configList(2);
		model.addAttribute("directionconfiglist", directionconfiglist);
		return "user/myinfomation";
	}

	@RequestMapping("myInfomationAlter.do")
	@ResponseBody
	public StateResult myInfomationAlter(Model model, BaseUser user, StateResult stateResult, HttpServletRequest request) {
		user = userMyInfomationService.myInfomationAlter(user, stateResult, request);
		model.addAttribute(ConfigStr.userInfomation, user);
		return stateResult;
	}

	@RequestMapping("uploadMyimage.do")
	@ResponseBody
	public StateResult uploadMyimage(StateResult stateResult, Model model, Integer id,
			@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request)
			throws IOException {
		userMyInfomationService.uploadMyimage(id, stateResult, model, file, request);
		return stateResult;
	}

	@ModelAttribute
	public void populateModel(HttpServletRequest request, Model model) throws ControllerException {
		SessionController.noSeeiondelwith(request);
	};
}
