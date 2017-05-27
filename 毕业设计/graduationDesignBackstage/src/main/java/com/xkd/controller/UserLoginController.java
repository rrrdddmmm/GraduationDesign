package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.service.UserLoginService;
import com.xkd.util.ConfigStr;

/**
 * 用户登出处理程序
 * 
 * @author RBB
 *
 */
@Controller
@Scope("prototype")
@SessionAttributes(ConfigStr.userInfomation)
@RequestMapping("/userLoginController")
public class UserLoginController implements Serializable {

	private static final long	serialVersionUID	= 1L;
	/**
	 * 
	 */
	@Resource(name = "userLoginService")
	private UserLoginService	userLoginService;

	@RequestMapping("/getIndex.do")
	public String getIndex(Model model) {
		// 处理代码
		return "common/index";
	}

	@RequestMapping("/loginHandle.do")
	@ResponseBody
	public StateResult loginHandle(BaseUser user, Model model, StateResult stateResult) {
		BaseUser dbuser = userLoginService.loginHandle(user, stateResult);
		if (dbuser != null) {
			model.addAttribute(ConfigStr.userInfomation, dbuser);
		}
		return stateResult;
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// session.removeAttribute(ConfigStr.userInfomation);
		// session.setMaxInactiveInterval(0);
		session.invalidate();
		return "user/login";
	}
}
