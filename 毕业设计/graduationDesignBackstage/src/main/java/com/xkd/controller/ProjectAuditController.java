package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("projectChakan.do")
	public String projectChakan(String projid) {
		return "project/projectchakan";
	}
}
