package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.service.TeactherStrengthService;

/***
 * 师资力量控制器
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/teacherStrength")
public class TeactherStrengthController implements Serializable {

	/**
	 * 序列化
	 */
	private static final long		serialVersionUID	= 1L;
	/**
	 * 师资力量服务
	 */
	@Resource(name = "TeactherStrengthService")
	private TeactherStrengthService	teactherStrengthService;

	@RequestMapping("/toTeachersStrength.do")
	public String toTeactherStrength() {
		return "teacherstrength/teachers_strength";
	}

}
