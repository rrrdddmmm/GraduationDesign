package com.xkd.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.entity.Project;
import com.xkd.entity.User;
import com.xkd.service.JionService;

@Controller
@RequestMapping("/jion")
public class JoinController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Resource(name = "JionService")
	private JionService			jionservice;

	@RequestMapping("/toJion.do")
	public String toJion(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User use = (User) session.getAttribute("user");
		if (use == null) {
			return "redirect:../login/toLogin.do";
		}
		System.out.println("加入页面");
		List<Project> list = jionservice.findJion();
		for (Project p : list) {
			System.out.println(p.getProject_name());
		}
		model.addAttribute("list", list);
		return "addproject/jion";
	}

	@RequestMapping("/toShow.do")
	public String toShow(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User use = (User) session.getAttribute("user");
		if (use == null) {
			return "redirect:../login/toLogin.do";
		}
		int id = Integer.parseInt(request.getParameter("id"));
		Project pro = new Project();
		pro = jionservice.findProjectByid(id);
		model.addAttribute("pro", pro);
		return "show";
	}

	@RequestMapping("/toAdd.do")
	public String toAdd(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User use = (User) session.getAttribute("user");
		if (use == null) {
			return "redirect:../login/toLogin.do";
		}
		int id = Integer.parseInt(request.getParameter("id"));
		jionservice.updateJion(id, use.getEmail());
		return "redirect:toJion.do";
	}

}
