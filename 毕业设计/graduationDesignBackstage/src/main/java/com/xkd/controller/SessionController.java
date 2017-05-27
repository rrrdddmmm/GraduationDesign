package com.xkd.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xkd.entity.BaseUser;
import com.xkd.util.ConfigStr;

public class SessionController {

	// 解决方案：将要保存的值进行URLEncoder.encode(value,"utf-8")编码。
	// 在提取时，同样进行解码：URLDecoder.decode(c.getValue(),"UTF-8");
	public static void setCookie(Integer userid, HttpServletResponse response) {
		Cookie cookieUser = null;
		try {
			cookieUser = new Cookie(ConfigStr.userInfomation, URLEncoder.encode(userid.toString(), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cookieUser != null) {
			// 设定有效时间 以秒(s)为单位
			cookieUser.setMaxAge(7 * 24 * 60 * 60);
			// 设置Cookie路径和域名
			cookieUser.setPath("/");
			response.addCookie(cookieUser);
		}
	}

	// 判断session和账号是否过期
	public static boolean judgeUserSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		BaseUser users = (BaseUser) session.getAttribute(ConfigStr.userInfomation);
		if (users != null) {// session级别
			return true;
		}
		return false;
	}

	// 获得session中的用户信息
	public static BaseUser getLoginInfomation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		BaseUser users = (BaseUser) session.getAttribute(ConfigStr.userInfomation);
		return users;
	}

	// session失效处理
	@SuppressWarnings("null")
	public static void noSeeiondelwith(HttpServletRequest request) throws ControllerException {
		if (!judgeUserSession(request)) {
			String str = null;
			str.getBytes();
		}
	}

	// session失效处理
	public static void noSeeiondelwithdefalt(HttpServletRequest request) throws ControllerException {
		if (!judgeUserSession(request)) {
			request.setAttribute("controllerExceptionInfo", "您需要登陆,请登录!");
			throw new ControllerException("session异常跳转到主页面");
		}
	}
}
