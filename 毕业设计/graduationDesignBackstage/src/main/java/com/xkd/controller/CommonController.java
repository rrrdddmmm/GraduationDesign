package com.xkd.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 进入主页面
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/commonController")
public class CommonController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("/toDefault.do")
	public String toDefault() {
		return "common/default";
	}

	@RequestMapping("/getIndex.do")
	public String getIndex(Model model) {
		// 处理代码
		return "common/index";
	}

	@ModelAttribute
	public void populateModel(HttpServletRequest request, Model model) throws ControllerException {
		SessionController.noSeeiondelwith(request);
	};
}
