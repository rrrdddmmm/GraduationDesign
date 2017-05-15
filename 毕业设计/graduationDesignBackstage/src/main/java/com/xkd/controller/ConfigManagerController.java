package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("configList.do")
	public String configList(Integer flage) {
		return "config/configlist";
	}

	@RequestMapping("configAdd.do")
	public String configAdd(Integer flage) {
		return "config/configadd";
	}
}
