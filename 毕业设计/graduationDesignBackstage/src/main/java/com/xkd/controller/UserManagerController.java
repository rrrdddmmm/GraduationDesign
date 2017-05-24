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
import org.springframework.web.multipart.MultipartFile;

import com.xkd.entity.BaseConfig;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.service.ConfigManagerService;
import com.xkd.service.UserManagerService;

/**
 * 用户管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/userManagerController")
public class UserManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "configManagerService")
	private ConfigManagerService	configManagerService;
	@Resource(name = "userManagerService")
	private UserManagerService		userManagerService;

	@RequestMapping("/userAdd.do")
	public String userAdd(Model model) {
		@SuppressWarnings("unchecked")
		List<BaseConfig> educationconfiglist = (List<BaseConfig>) configManagerService.configList(1);
		model.addAttribute("educationconfiglist", educationconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> titleconfiglist = (List<BaseConfig>) configManagerService.configList(3);
		model.addAttribute("titleconfiglist", titleconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> directionconfiglist = (List<BaseConfig>) configManagerService.configList(2);
		model.addAttribute("directionconfiglist", directionconfiglist);
		return "user/useradd";
	}

	@RequestMapping("/userAddHandle.do")
	@ResponseBody
	public StateResult userAddHandle(BaseUser user, StateResult stateResult) {
		userManagerService.userAddHandle(user, stateResult);
		return stateResult;
	}

	@RequestMapping("/userDelHandle.do")
	@ResponseBody
	public StateResult userDelHandle(BaseUser user, StateResult stateResult) {
		userManagerService.userDelHandle(user, stateResult);
		return stateResult;
	}

	@RequestMapping("/userAlter.do")
	public String userAlter(Model model, Integer id, Integer statefalse) {
		BaseUser user = userManagerService.userAlterHandle(id);
		@SuppressWarnings("unchecked")
		List<BaseConfig> educationconfiglist = (List<BaseConfig>) configManagerService.configList(1);
		model.addAttribute("educationconfiglist", educationconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> titleconfiglist = (List<BaseConfig>) configManagerService.configList(3);
		model.addAttribute("titleconfiglist", titleconfiglist);
		@SuppressWarnings("unchecked")
		List<BaseConfig> directionconfiglist = (List<BaseConfig>) configManagerService.configList(2);
		model.addAttribute("directionconfiglist", directionconfiglist);
		model.addAttribute("user", user);
		model.addAttribute("statefalse", statefalse);
		return "user/useralter";
	}

	@RequestMapping("userAlterHandle.do")
	@ResponseBody
	public StateResult userAlterHandle(BaseUser user, StateResult stateResult) {
		if ("".equals(user.getPassword())) {
			user.setPassword(null);
		}
		userManagerService.userAlterHandle(user, stateResult);
		return stateResult;
	}

	@RequestMapping("/userList.do")
	public String userList(Model model) {
		List<BaseUser> list = userManagerService.userList();
		model.addAttribute("baseUserList", list);
		model.addAttribute("statefalse", 2);
		return "user/userlist";
	}

	@RequestMapping("/userStateList.do")
	public String userStateList(Model model, String state) {
		List<BaseUser> list = userManagerService.userStateList(model, state);
		model.addAttribute("baseUserList", list);
		model.addAttribute("statefalse", 1);
		return "user/userlist";
	}

	@RequestMapping("uploadMyimage.do")
	@ResponseBody
	public StateResult uploadMyimage(StateResult stateResult, Model model, BaseUser user,
			@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request)
			throws IOException {
		userManagerService.uploadMyimage(user, stateResult, model, file, request);
		return stateResult;
	}

	@ModelAttribute
	public void populateModel(HttpServletRequest request, Model model) throws ControllerException {
		SessionController.noSeeiondelwith(request);
	};
}
