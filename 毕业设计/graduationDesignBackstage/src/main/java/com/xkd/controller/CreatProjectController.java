package com.xkd.controller;

import java.io.Serializable;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xkd.entity.Project;
import com.xkd.entity.User;
import com.xkd.service.CreatProjectService;

/**
 * 创建项目控制器
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/creatProject")
public class CreatProjectController implements Serializable {

	/**
	 * 序列化
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 * 创建项目服务
	 */
	@Resource(name = "CreatProjectService")
	private CreatProjectService	creatProjectService;

	/**
	 * 进入创建项目
	 * 
	 * @return
	 */
	@RequestMapping("/toCreatProject.do")
	public String toCreatProject(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User use = (User) session.getAttribute("user");
		if (use != null) {
			model.addAttribute("project", new Project());
			return "creatproject/creat_project";
		} else {
			return "redirect:../login/toLogin.do";
		}
	}

	/**
	 * 创建项目保存
	 * 
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/toSave.do", method = RequestMethod.POST)
	public String toSave(Project project, HttpServletRequest request) throws ParseException {
		HttpSession session = request.getSession();
		User use = (User) session.getAttribute("user");
		if (use == null) {
			return "redirect:../login/toLogin.do";
		}
		creatProjectService.toSave(project);
		return "creatproject/creat_project";
	}
}
