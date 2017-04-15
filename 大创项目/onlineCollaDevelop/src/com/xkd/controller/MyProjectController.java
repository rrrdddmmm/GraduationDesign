package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.service.MyProjectService;

/**
 * 我的项目控制器
 * @author RBB
 *
 */
@Controller
@RequestMapping("/myProject")
public class MyProjectController  implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 我的项目服务
	 */
	@Resource(name="MyProjectService")
    private MyProjectService myProjectService;
    /**
     * 进入创建项目
     * @return
     */
    @RequestMapping("/toMyProject.do")
    public String toMyProject() {
        return "my_project";
    }

}
