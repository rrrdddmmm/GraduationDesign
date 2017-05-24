package com.xkd.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.dao.BaseTaskMapper;
import com.xkd.entity.BaseTask;
import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Project;
import com.xkd.service.ProjectManageService;
import com.xkd.service.TaskManagerService;
import com.xkd.service.UserManagerService;
import com.xkd.util.ConfigStr;
import com.xkd.util.FileDealWith;

/**
 * 任务管理
 * 
 * @author RBB
 *
 */
@Controller
@RequestMapping("/taskManagerController")
public class TaskManagerController implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1L;
	@Resource(name = "projectManageService")
	private ProjectManageService	projectManageService;
	@Resource(name = "userManagerService")
	private UserManagerService		userManagerService;
	/**
	 * 任务表
	 */
	@Resource(name = "baseTaskMapper")
	private BaseTaskMapper			baseTaskMapper;
	/**
	 * 任务表
	 */
	@Resource(name = "taskManagerService")
	private TaskManagerService		taskManagerService;

	/**
	 * 进入任务主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/taskProject.do")
	public String taskProjectList(Model model, Project project, HttpServletRequest request) {
		model.addAttribute("projectlist", projectManageService.projectList(project, request));
		model.addAttribute("applicationlist", projectManageService.projectApplication(request));
		model.addAttribute("project", project);
		return "task/taskprojectlist";
	}

	/**
	 * 创建任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskProjectList.do")
	public String taskstartcreat(Model model, Project project, String msg) {
		model.addAttribute("project", projectManageService.getProjectById(project.getProjid()));
		model.addAttribute("tasklist",
				baseTaskMapper.selectByPrimaryAll(new BaseTask(project.getProjid(), project.getProjemail())));
		model.addAttribute("msg", msg);
		model.addAttribute("defaultTaskview", ConfigStr.defaultTaskview);
		return "task/taskstartcreat";
	}

	@RequestMapping("/addTask.do")
	@ResponseBody
	public StateResult addTask(StateResult stateResult, BaseTask baseTask,
			@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		taskManagerService.addTask(stateResult, baseTask, file, request);
		return stateResult;
	}

	@RequestMapping("/delHandle.do")
	@ResponseBody
	public StateResult delHandle(StateResult stateResult, Integer id, HttpServletRequest request) {
		taskManagerService.delHandle(stateResult, id, request);
		return stateResult;
	}

	/**
	 * 分配任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskDistribution.do")
	public String taskDistribution(Model model, Project project) {
		Map<String, String> map = new HashMap<String, String>();
		List<BaseTask> list1 = baseTaskMapper.selectByPrimaryAll(new BaseTask(project.getProjid()));
		for (BaseTask baseTask : list1) {
			map.put(baseTask.getEmail(), baseTask.getName());
		}
		model.addAttribute("map", map);
		List<BaseTask> list = baseTaskMapper.selectByPrimaryAll(new BaseTask(project.getProjid(), project
				.getProjemail()));
		model.addAttribute("tasklist", list);
		model.addAttribute("backemail", project.getProjemail());
		model.addAttribute("project", projectManageService.getProjectById(project.getProjid()));
		return "task/taskdistribution";
	}

	@RequestMapping("/taskDistributionHandle.do")
	@ResponseBody
	public StateResult taskDistributionHandle(StateResult stateResult, BaseTask baseTask,
			@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		taskManagerService.taskDistributionHandle(stateResult, baseTask, file, request);
		return stateResult;
	}

	/**
	 * 查看任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskChakan.do")
	public String taskChakan(Model model, Project project) {
		System.out.println(project);
		return "task/taskchakan";
	}

	/**
	 * 修改任务
	 * 
	 * @return
	 */
	@RequestMapping("/taskAlter.do")
	public String taskAlter(Model model, Project project) {
		System.out.println(project);
		return "task/taskalter";
	}

	@RequestMapping("download.do")
	public void download(HttpServletResponse response, String filePath) {
		try {
			if (new File(filePath).isDirectory()) {
				FileDealWith.iteratorDirdownjoad(response, filePath);
			} else {
				FileDealWith.downloadFile(response, filePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ModelAttribute
	public void populateModel(HttpServletRequest request, Model model) throws ControllerException, ParseException {
		projectManageService.setProjstatus();
		SessionController.noSeeiondelwith(request);
	};
}
