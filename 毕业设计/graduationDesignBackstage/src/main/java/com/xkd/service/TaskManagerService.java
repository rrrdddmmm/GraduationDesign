package com.xkd.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.controller.SessionController;
import com.xkd.dao.BaseHomeMapper;
import com.xkd.dao.BaseProjectMapper;
import com.xkd.dao.BaseTaskMapper;
import com.xkd.dao.BaseUserMapper;
import com.xkd.entity.BaseHome;
import com.xkd.entity.BaseTask;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Home;
import com.xkd.entity.Page.Project;
import com.xkd.util.DateDealwith;
import com.xkd.util.FileDealWith;
import com.xkd.util.GetResousePath;

@Service("taskManagerService")
@Scope("prototype")
public class TaskManagerService {
	/**
	 * 任务表
	 */
	@Resource(name = "baseTaskMapper")
	private BaseTaskMapper		baseTaskMapper;
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;
	@Resource(name = "baseHomeMapper")
	private BaseHomeMapper		baseHomeMapper;
	@Resource(name = "baseUserMapper")
	private BaseUserMapper		baseUserMapper;

	public List<BaseTask> taskChakan(Model model, Project project, HttpServletRequest request) {
		BaseUser users = SessionController.getLoginInfomation(request);
		List<BaseTask> list = null;
		if (project.getProjemail().equals(users.getEmail())) {
			list = baseTaskMapper.selectByPrimaryAll(new BaseTask(project.getProjid()));
		} else {
			list = baseTaskMapper.selectByPrimaryAll(new BaseTask(project.getProjid(), users.getEmail()));
		}
		return list;
	}

	/**
	 * 给创建者添加
	 * 
	 * @param stateResult
	 * @param baseTask
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public StateResult addTask(StateResult stateResult, BaseTask baseTask, MultipartFile file,
			HttpServletRequest request) throws IllegalStateException, IOException {
		BaseUser users = SessionController.getLoginInfomation(request);
		String uuid = UUID.randomUUID().toString();
		// 任务文件物理地址
		String Taskfile = GetResousePath.getUserProjectTaskFilePath(users.getId().toString(), baseTask.getProjectid(),
				uuid + file.getOriginalFilename());
		if (!FileDealWith.upload(stateResult, file, Taskfile)) {
			return stateResult;
		}
		baseTask.setTaskfile(Taskfile);
		baseTask.setUpdatetime(DateDealwith.getCurrDate());
		baseTask.setStatus(0);
		if (baseTaskMapper.insert(baseTask) > 0) {
			List<BaseHome> list = baseHomeMapper.selectByPrimaryAll(new Home(baseTask.getProjectid()));
			for (BaseHome hom : list) {
				baseTask.setEmail(hom.getEmail());
				baseTask.setTaskfile(null);
				baseTask.setDescription(null);
				BaseUser baseUser = baseUserMapper.selectByEmailRolePwd(new BaseUser(hom.getEmail()));
				baseTask.setName(baseUser.getName());
				baseTaskMapper.insert(baseTask);
			}
			stateResult.setStatus(0);
			stateResult.setMsg("创建成功!");
		} else {
			stateResult.setStatus(1);
			stateResult.setMsg("创建失败!");
		}
		return stateResult;
	}

	public StateResult taskDistributionHandle(StateResult stateResult, BaseTask baseTask, MultipartFile file,
			HttpServletRequest request) throws IllegalStateException, IOException {
		BaseUser users = SessionController.getLoginInfomation(request);
		String uuid1 = UUID.randomUUID().toString();
		String absPath = GetResousePath.getUserProjectTaskFilePath(users.getId().toString(), baseTask.getProjectid(),
				uuid1 + file.getOriginalFilename());
		if (FileDealWith.upload(stateResult, file, absPath)) {
			baseTask.setTaskfile(absPath);
			baseTask.setUpdatetime(DateDealwith.getCurrDate());
			if (baseTaskMapper.updateByPrimaryKeySelective(baseTask) > 0) {
				stateResult.setStatus(0);
				stateResult.setMsg("任务分配成功，重新进入将会生效哦!");
			} else {
				stateResult.setStatus(1);
				stateResult.setMsg("数据更新，任务分配失败!");
			}
		} else {
			stateResult.setStatus(2);
			stateResult.setMsg("文档上传，任务分配失败!");
		}
		return stateResult;
	}

	public StateResult taskSubmitHandle(StateResult stateResult, BaseTask baseTask, MultipartFile file,
			HttpServletRequest request) throws IllegalStateException, IOException {
		BaseUser users = SessionController.getLoginInfomation(request);
		String uuid1 = UUID.randomUUID().toString();
		String absPath = GetResousePath.getUserProjectTaskFilePath(users.getId().toString(), baseTask.getProjectid(),
				uuid1 + file.getOriginalFilename());
		if (FileDealWith.upload(stateResult, file, absPath)) {
			baseTask.setResultfile(absPath);
			baseTask.setUpdatetime(DateDealwith.getCurrDate());
			if (baseTaskMapper.updateByPrimaryKeySelective(baseTask) > 0) {
				stateResult.setStatus(0);
				stateResult.setMsg("任务提交成功，重新进入将会生效哦!");
			} else {
				stateResult.setStatus(1);
				stateResult.setMsg("数据更新，任务提交失败!");
			}
		} else {
			stateResult.setStatus(2);
			stateResult.setMsg("文档上传，任务提交失败!");
		}
		return stateResult;
	}

	/**
	 * 
	 * @param stateResult
	 * @param id
	 * @return
	 */
	public StateResult delHandle(StateResult stateResult, Integer id, HttpServletRequest request) {
		BaseTask baseTask = baseTaskMapper.selectByPrimaryKey(id);
		FileDealWith.deleteAllFilesOfDir(new File(baseTask.getTaskfile()));
		if (baseTaskMapper.deleteByall(new BaseTask(baseTask.getProjectid(), baseTask.getStartuptime(), baseTask
				.getEndtime())) > 0) {
			stateResult.setMsg("服务器端：该项目相关任务全部删除!");
			stateResult.setStatus(0);
		} else {
			stateResult.setMsg("服务器端：删除失败!");
			stateResult.setStatus(1);
		}
		return stateResult;
	}
}
