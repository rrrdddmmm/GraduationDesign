package com.xkd.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.controller.SessionController;
import com.xkd.entity.BaseProject;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
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

	public StateResult creatProjectHandle(BaseProject baseProject, StateResult stateResult,
			@RequestParam(value = "file", required = true) MultipartFile[] file, HttpServletRequest request) {
		try {
			BaseUser users = SessionController.getLoginInfomation(request);
			String projectid = UUID.randomUUID().toString();
			String uuid0 = UUID.randomUUID().toString();
			String uuid1 = UUID.randomUUID().toString();
			if (!verifyfile(stateResult, file[0], users.getId().toString(), uuid0)) {
				stateResult.setMsg(stateResult.getMsg());
				return stateResult;
			}
			if (!verifyfile(stateResult, file[1], users.getId().toString(), uuid1)) {
				stateResult.setMsg(stateResult.getMsg());
				return stateResult;
			}
			// 设置网络地址
			baseProject.setBudgetfile(GetResousePath.getUserResouresNetPath(users.getId().toString()) + uuid0
					+ file[1].getOriginalFilename());
			baseProject.setProgectfile(GetResousePath.getUserResouresNetPath(users.getId().toString()) + uuid1
					+ file[0].getOriginalFilename());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(baseProject);
		stateResult.setMsg("ok");
		stateResult.setStatus(0);
		return stateResult;
	}

	private boolean verifyfile(StateResult stateResult, MultipartFile file, String id, String uuid)
			throws IllegalStateException, IOException {
		if (file != null) {
			if (file.getName() != null || "".equals(file.getName())) {
				String[] name = file.getContentType().split("/");
				if ("txt".equals(name[name.length - 1]) || "doc".equals(name[name.length - 1])
						|| "docx".equals(name[name.length - 1]) || "pdf".equals(name[name.length - 1])) {
					file.transferTo(new File(GetResousePath.getUserResouresPath(id) + uuid + file.getOriginalFilename()));
					stateResult.setStatus(0);
					stateResult.setMsg("服务器端：上传成功!");
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
