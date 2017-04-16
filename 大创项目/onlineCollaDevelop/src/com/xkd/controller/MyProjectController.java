package com.xkd.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.entity.Project;
import com.xkd.entity.User;
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
    public String toMyProject(HttpServletRequest request, Model model) {
    	HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null){
			System.out.println(user.getEmail());
			System.out.println("显示我的项目");
			List<Project> list=myProjectService.findMyProject(user.getEmail());
			  for(Project p:list){
				System.out.println(p.getProject_name());
			}
			model.addAttribute("list", list);
	        return "my_project";
		}else{
			return "redirect:../login/toLogin.do";
		}
		
    }

}
