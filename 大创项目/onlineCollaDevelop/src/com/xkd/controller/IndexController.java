package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.service.IndexService;

/**
 * 首页控制器
 * @author RBB
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController  implements Serializable {

	/**
	 *  序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 首页服务
	 */
	@Resource(name="IndexService")
    private IndexService indexService;
    /**
     * 进入主页面
     * @return
     */
    @RequestMapping("/toIndex.do")
    public String toIndex() {
        return "index";
    }
	

}
