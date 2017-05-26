package com.xkd.service;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.controller.SessionController;
import com.xkd.dao.BaseHomeMapper;
import com.xkd.dao.BaseProjectMapper;
import com.xkd.dao.BaseTaskMapper;
import com.xkd.dao.BaseUserMapper;
import com.xkd.entity.BaseHome;
import com.xkd.entity.BaseProject;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Home;
import com.xkd.entity.Page.Project;
import com.xkd.util.ConfigStr;
import com.xkd.util.DateDealwith;
import com.xkd.util.FileDealWith;

/**
 * 
 * @author RBB
 *
 */
@Service("projectManageService")
@Scope("prototype")
public class ProjectManageService {
	/**
	 * 项目表
	 */
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;
	@Resource(name = "baseUserMapper")
	private BaseUserMapper		baseUserMapper;
	@Resource(name = "baseHomeMapper")
	private BaseHomeMapper		baseHomeMapper;
	/**
	 * 任务表
	 */
	@Resource(name = "baseTaskMapper")
	private BaseTaskMapper		baseTaskMapper;

	/**
	 * 通过账号email查询参与项目
	 * 
	 * @param home
	 * @param request
	 * @return
	 */
	public List<BaseProject> teamProjectList(Home home, HttpServletRequest request) {
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		home.setEmail(sessionUser.getEmail());
		List<BaseHome> list = new ArrayList<BaseHome>();
		list = baseHomeMapper.selectByPrimaryAll(home);
		list.add(new Home("-1"));
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("list", list);
		return baseProjectMapper.selectByPrimaryHome(map);
	}

	/**
	 * 通过账号email查询创建的项目
	 * 
	 * @return
	 */
	public List<BaseProject> getCreatProject(HttpServletRequest request) {
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		List<BaseProject> list = baseProjectMapper.selectByPrimaryAll(new Project(sessionUser.getEmail(), null, null));
		return list;
	}

	/**
	 * 通过账号email查询当前人数等于总人数的项目
	 * 
	 * @return
	 */
	public List<BaseProject> getTaskCreatProject(HttpServletRequest request) {
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		List<BaseProject> list = baseProjectMapper.selectByPrimaryTaskAll(new Project(sessionUser.getEmail()));
		return list;
	}

	public BaseProject getProjectById(String projid) {
		BaseProject obj = baseProjectMapper.selectByPrimaryKey(projid);
		return obj;
	}

	/**
	 * @1、根据启动审核状态、结题审核状态、结题时间、当前时间计算当前项目的结果状态，并修改项目结果状态。
	 * 
	 * @待启动审核（projstatus=0）:
	 * @（projresultEvaluationstate=0 && projstartupEvaluationstate=0）
	 * 
	 * @开发中（projstatus=1）:
	 * @（projstartupEvaluationstate=1 and endtime>当前时间）
	 * 
	 * @待结题审核（projstatus=2）:
	 * @(projstartupEvaluationstate=1 and projstartupEvaluationstate=0 and
	 *                                endtime<当前时间)，
	 * @已完成项目（projstatus=3）:
	 * @（projresultEvaluationstate=1 && projstartupEvaluationstate =1）
	 * @throws ParseException
	 * 
	 **/
	public void setProjstatus() throws ParseException {
		List<BaseProject> list = baseProjectMapper.selectByPrimaryAll(new Project());
		for (BaseProject baseProject : list) {
			if (baseProject.getProjstartupevaluationstate() == 1 && baseProject.getProjresultevaluationstate() == 0
					&& DateDealwith.getshijiancha(baseProject.getProjendtime()) < 0) {
				if (baseProject.getProjstatus() != 1) {
					baseProject.setProjstatus(1);
					baseProjectMapper.updateByPrimaryKey(baseProject);
				}
			}
			if (baseProject.getProjstartupevaluationstate() == 1 && baseProject.getProjresultevaluationstate() == 0
					&& DateDealwith.getshijiancha(baseProject.getProjendtime()) > 0) {
				if (baseProject.getProjstatus() != 2) {
					baseProject.setProjstatus(2);
					baseProjectMapper.updateByPrimaryKey(baseProject);
				}
			}
			if (baseProject.getProjstartupevaluationstate() == 1 && baseProject.getProjresultevaluationstate() == 1
					&& DateDealwith.getshijiancha(baseProject.getProjendtime()) > 0) {
				if (baseProject.getProjstatus() != 3) {
					baseProject.setProjstatus(3);
					baseProjectMapper.updateByPrimaryKey(baseProject);
				}
			}
		}
	}

	/**
	 * @2、查找出自己满足条件的项目：
	 * @教师(2)：
	 * @学生(1)：创建项目的学生， 参与项目的学生
	 * @application : 申请人email
	 * @auditstate : 1 启动审核 2 结题审核 3已完成(启动和结题均完成)审核
	 * @jointype: 1参与项目 2创建项目
	 * 
	 */
	public List<BaseProject> projectList(Project project, HttpServletRequest request) {
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		List<BaseProject> list = null;

		if ("1".equals(sessionUser.getRole())) {// 学生登陆情况
			/**
			 * 参与和创建的项目
			 */
			project.setProjemail(sessionUser.getEmail().trim());
			if ("1".equals(project.getJointype())) {// 参与的
				Home home = new Home();
				home.setEmail(sessionUser.getEmail().trim());
				list = teamProjectList(home, request);
			} else if ("2".equals(project.getJointype())) {// 创建的
				list = getCreatProject(request);
			} else {// 全部
				Home home = new Home();
				home.setEmail(sessionUser.getEmail().trim());
				list = teamProjectList(home, request);
				List<BaseProject> list1 = getCreatProject(request);
				for (BaseProject baseProject : list1) {
					list.add(baseProject);
				}
			}
		} else if ("2".equals(sessionUser.getRole())) {// 教师登陆情况
			if (project.getProjstatus() != null && project.getProjstatus() == -1) {
				project.setProjstatus(null);
			}
			if (project.getProjemail() != null && "-1".equals(project.getProjemail())) {
				project.setProjemail(null);
			}
			project.setProjtutor(sessionUser.getId().toString().trim());
			list = baseProjectMapper.selectByPrimaryAll(project);
		} else if ("3".equals(sessionUser.getRole())) {// 管理员
			list = baseProjectMapper.selectByPrimaryAll(null);
		} else {
		}
		return list;
	}

	public List<BaseProject> projectApplication(HttpServletRequest request) {
		// 自己所指导的所有项目申请人
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		List<BaseProject> list = null;
		list = baseProjectMapper.selectAllApplication(new Project(sessionUser.getId().toString()));
		return list;
	}

	public StateResult delHandle(String projid, StateResult stateResult, HttpServletRequest request) {
		BaseUser baseUser = SessionController.getLoginInfomation(request);
		if (baseProjectMapper.deleteByPrimaryKey(projid) > 0) {
			// 删除项目相关的所有文件
			FileDealWith.deleteAllFilesOfDir(new File(ConfigStr.ResourcesPath + baseUser.getId() + "/" + projid));
			// 删除项目所有相关的任务
			baseTaskMapper.deleteByProjectId(projid);
			// 删除项目所有相关的团队
			baseHomeMapper.deleteHomeByprojId(projid);
			stateResult.setStatus(0);
			stateResult.setMsg("服务器端：del success");
		} else {
			stateResult.setStatus(2);
			stateResult.setMsg("服务器端：del fail");
		}
		return stateResult;
	}
}
