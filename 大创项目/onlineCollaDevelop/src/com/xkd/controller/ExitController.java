package com.xkd.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 退出系统
 * @author RBB
 *
 */
@Controller
@RequestMapping("/exit")
public class ExitController  implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	 /**
     * 退出系统处理
     * @return
     */
    @RequestMapping("/toExit.do")
    public String toExit(HttpServletRequest request){
    	//删除session
    	HttpSession session=request.getSession();
		session.setAttribute("user", null);
        return "redirect:../index/toIndex.do";
    }
}
