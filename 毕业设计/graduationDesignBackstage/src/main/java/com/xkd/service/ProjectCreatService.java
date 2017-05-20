package com.xkd.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.controller.SessionController;
import com.xkd.dao.BaseProjectMapper;
import com.xkd.entity.BaseProject;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.util.ConfigStr;
import com.xkd.util.DateDealwith;
import com.xkd.util.GetResousePath;

/**
 * 创建项目服务
 * 
 * @author RBB
 *
 */
@Service("projectCreatService")
@Scope("prototype")
public class ProjectCreatService {
	/**
	 * 项目表
	 */
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;

	public StateResult creatProjectHandle(BaseProject baseProject, StateResult stateResult,
			@RequestParam(value = "file", required = true) MultipartFile[] file, HttpServletRequest request) {
		try {
			BaseUser users = SessionController.getLoginInfomation(request);
			String projectid = DateDealwith.getSHC();
			String uuid0 = UUID.randomUUID().toString();
			String uuid1 = UUID.randomUUID().toString();
			// 预算文件物理地址
			String BudgetfilePath = GetResousePath.getUserProjectFilePath(users.getId().toString(), projectid, uuid1
					+ file[1].getOriginalFilename());
			// 预算文件网络地址
			String BudgetfileNetPath = GetResousePath.getUserNetProjectFilePath(users.getId().toString(), projectid,
					uuid1 + file[1].getOriginalFilename());

			// 立项书物理地址
			String ProgectfilePath = GetResousePath.getUserProjectFilePath(users.getId().toString(), projectid, uuid0
					+ file[0].getOriginalFilename());
			// 立项书网络地址
			String ProgectfileNetPath = GetResousePath.getUserNetProjectFilePath(users.getId().toString(), projectid,
					uuid0 + file[0].getOriginalFilename());

			if (!upload(stateResult, file[0], ProgectfilePath)) {
				stateResult.setMsg("0" + stateResult.getMsg());
				return stateResult;
			}
			if (!upload(stateResult, file[1], BudgetfilePath)) {
				stateResult.setMsg("1" + stateResult.getMsg());
				return stateResult;
			}
			baseProject.setProjid(projectid);
			// 设置网络地址
			baseProject.setProjbudgetfile(BudgetfileNetPath);
			baseProject.setProjbudgetfile(ProgectfileNetPath);
			baseProject.setProjcreattime(DateDealwith.getCurrDate());
			baseProject.setProjcurrentnumber(ConfigStr.currentnumber);
			baseProject.setProjemail(users.getEmail());
			baseProject.setProjphone(users.getPhone());
			baseProject.setProjstatus(Integer.parseInt(ConfigStr.close));
			baseProject.setProjupdatetime(DateDealwith.getCurrDate());
			baseProject.setProjgrade("0");
			baseProjectMapper.insert(baseProject);
			stateResult.setMsg("服务器端：项目创建成功!");
			stateResult.setStatus(0);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
