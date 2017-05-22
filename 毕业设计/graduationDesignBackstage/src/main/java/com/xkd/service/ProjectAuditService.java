package com.xkd.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.xkd.controller.SessionController;
import com.xkd.dao.BaseProjectMapper;
import com.xkd.entity.BaseProject;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Project;
import com.xkd.util.DateDealwith;
import com.xkd.util.GetResousePath;

/**
 * 
 * @author RBB
 *
 */
@Service("projectAuditService")
@Scope("prototype")
public class ProjectAuditService {
	/**
	 * 项目表
	 */
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;

	/**
	 * @1、根据启动审核状态、结题审核状态、结题时间、当前时间计算当前项目的结果状态，并修改项目结果状态。
	 * 
	 * @待启动审核（projstatus=0）:
	 * @（projresultEvaluationstate=0 && projstartupEvaluationstate=0）
	 * @开发中（projstatus=1）:
	 * @（projstartupEvaluationstate=1 and endtime>当前时间）
	 * @待结题审核（projstatus=2）:
	 * @(projstartupEvaluationstate=1 and projstartupEvaluationstate=0 and
	 *                                endtime<当前时间)，
	 * @已完成项目（projstatus=3）:
	 * @（projresultEvaluationstate=1 && projstartupEvaluationstate =1）
	 * @throws ParseException
	 * 
	 **/
	public StateResult auditHandle(Project project, StateResult stateResult) throws ParseException {
		BaseProject pro = baseProjectMapper.selectByPrimaryKey(project.getProjid());
		long ll = DateDealwith.getshijiancha(pro.getProjendtime());
		project.setProjstartuptime(DateDealwith.getCurrDate());
		project.setProjupdatetime(DateDealwith.getCurrDate());
		if (ll < 0) {
			project.setProjstartupevaluationvalue(project.getValues());
			project.setProjstartupevaluation(project.getAdvice());
			project.setProjstartupevaluationstate(1);
			Integer re = project.getValues() * 3;
			if (re == 12) {
				project.setProjgrade("初审：优");
			} else if (re == 9) {
				project.setProjgrade("初审：良");
			} else if (re == 6) {
				project.setProjgrade("初审：中");
			} else if (re == 3) {
				project.setProjgrade("初审：差");
			} else {
				project.setProjgrade("初审：未通过");
			}
		} else {
			project.setProjresultevaluation(project.getValues());
			project.setProjresultevaluationstate(1);
			project.setProjresultevaluationvalue(project.getAdvice());
			Integer re = project.getValues() * 7 + project.getProjstartupevaluationvalue() * 3;
			if (re > 30) {
				project.setProjgrade("综合：优");
			} else if (re > 20) {
				project.setProjgrade("综合：良");
			} else if (re > 10) {
				project.setProjgrade("综合：中");
			} else {
				project.setProjgrade("综合：差");
			}
		}
		if (baseProjectMapper.updateByPrimaryKeySelective(project) > 0) {
			stateResult.setMsg("审核成功，重新进入审核页面立即生效!");
			stateResult.setStatus(0);
		} else {
			stateResult.setMsg("审核失败!");
			stateResult.setStatus(1);
		}
		return stateResult;
	}

	public StateResult alterProjectHandle(BaseProject baseProject, StateResult stateResult, HttpServletRequest request)
			throws ParseException, IllegalStateException, IOException {
		MultipartFile progectfile = null;
		MultipartFile budgetfile = null;
		BaseUser users = SessionController.getLoginInfomation(request);
		String uuid0 = UUID.randomUUID().toString();
		String uuid1 = UUID.randomUUID().toString();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request,
					MultipartHttpServletRequest.class);
			progectfile = multipartRequest.getFile("progectfile");
			budgetfile = multipartRequest.getFile("budgetfile");
			if (progectfile != null) {
				// 立项书物理地址
				String ProgectfilePath = GetResousePath.getUserProjectFilePath(users.getId().toString(),
						baseProject.getProjid(), uuid0 + progectfile.getOriginalFilename());
				baseProject.setProjprogectfile(ProgectfilePath);
				if (!upload(stateResult, progectfile, ProgectfilePath)) {
					stateResult.setMsg(stateResult.getMsg());
					return stateResult;
				}
			}
			if (budgetfile != null) {
				// 预算文件物理地址
				String BudgetfilePath = GetResousePath.getUserProjectFilePath(users.getId().toString(),
						baseProject.getProjid(), uuid1 + budgetfile.getOriginalFilename());
				baseProject.setProjbudgetfile(BudgetfilePath);
				if (!upload(stateResult, budgetfile, BudgetfilePath)) {
					stateResult.setMsg(stateResult.getMsg());
					return stateResult;
				}
			}
		}
		if (baseProjectMapper.updateByPrimaryKeySelective(baseProject) > 0) {
			stateResult.setMsg("修改成功!");
			stateResult.setStatus(0);
		} else {
			stateResult.setMsg("审核失败!");
			stateResult.setStatus(1);
		}
		return stateResult;
	}

	private boolean upload(StateResult stateResult, MultipartFile file, String absPath) throws IllegalStateException,
			IOException {
		if (file != null) {
			if (file.getName() != null || "".equals(file.getName())) {
				System.out.println(file.getOriginalFilename());
				String[] name = file.getOriginalFilename().split("\\.");
				System.out.println(name[0]);
				if ("txt".equals(name[name.length - 1]) || "doc".equals(name[name.length - 1])
						|| "docx".equals(name[name.length - 1]) || "pdf".equals(name[name.length - 1])) {
					File f = new File(absPath);
					if (!f.exists()) {
						f.mkdirs();
					}
					file.transferTo(f);
					return true;
				} else {
					stateResult.setStatus(1);
					stateResult.setMsg("服务器端：请上传规定格式!");
				}
			} else {
				stateResult.setStatus(2);
				stateResult.setMsg("服务器端：文件名不能为空!");
			}
		} else {
			stateResult.setStatus(3);
			stateResult.setMsg("服务器端：请选择文件!");
		}
		return false;
	}
}
