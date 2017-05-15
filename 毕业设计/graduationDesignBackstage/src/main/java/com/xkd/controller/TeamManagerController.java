package com.xkd.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 团队管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/teamManagerController")
public class TeamManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@RequestMapping("/teamList.do")
	public String teamList() {
		return "team/teamlist";
	}
}
