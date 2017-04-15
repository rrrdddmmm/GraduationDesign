package com.xkd.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.entity.Project;
import com.xkd.service.CreatProjectService;



/**
 * 创建项目控制器
 * @author RBB
 *
 */
@Controller
@RequestMapping("/creatProject")
public class CreatProjectController  implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 创建项目服务
	 */
	@Resource(name="CreatProjectService")
    private CreatProjectService creatProjectService;
    /**
     * 进入创建项目
     * @return
     */
    @RequestMapping("/toCreatProject.do")
    public String toCreatProject() {
        return "creat_project";
    }
    /**
     * 创建项目保存
     * @return
     */
    @RequestMapping("/toSave.do")
    public String toSave(Project project) {
    	System.out.println(project);
        return "creat_project";
    }

}
