package com.xkd.controller;

import java.io.Serializable;

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
    public String toExit() {
    	//删除session
        return "redirect:../index/toIndex.do";
    }
}
