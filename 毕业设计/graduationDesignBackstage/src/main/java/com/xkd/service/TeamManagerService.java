package com.xkd.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.controller.SessionController;
import com.xkd.dao.BaseHomeMapper;
import com.xkd.dao.BaseProjectMapper;
import com.xkd.dao.BaseUserMapper;
import com.xkd.entity.BaseHome;
import com.xkd.entity.BaseProject;
import com.xkd.entity.BaseUser;
import com.xkd.entity.Page.Home;
import com.xkd.entity.Page.Project;

@Service("teamManagerService")
@Scope("prototype")
public class TeamManagerService {
	/**
	 * 团队表
	 */
	@Resource(name = "baseHomeMapper")
	private BaseHomeMapper		baseHomeMapper;
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;
	@Resource(name = "baseUserMapper")
	private BaseUserMapper		baseUserMapper;

	/**
	 * 通过email查找自己创建的项目的全部团队人员
	 * 
	 * @param request
	 * @return
	 */
	public List<BaseHome> teamList(Home home, HttpServletRequest request) {
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		List<BaseProject> list = baseProjectMapper.selectByPrimaryAll(new Project(sessionUser.getEmail(), null));
		List<BaseHome> homelistall = new ArrayList<BaseHome>();
		if (home.getProjectid() != null && !"-1".equals(home.getProjectid())) {
			List<BaseHome> homelist = baseHomeMapper.selectByPrimaryAll(new Home(home.getProjectid()));
			for (BaseHome homeobj : homelist) {
				homeobj.setUse(baseUserMapper.selectByEmailRolePwd(new BaseUser(homeobj.getEmail())));
				homeobj.setProjectname(home.getProjectname());
				homelistall.add(homeobj);
			}
		} else {
			for (BaseProject obj : list) {
				List<BaseHome> homelist = baseHomeMapper.selectByPrimaryAll(new Home(obj.getProjid()));
				for (BaseHome homeobj : homelist) {
					homeobj.setUse(baseUserMapper.selectByEmailRolePwd(new BaseUser(homeobj.getEmail())));
					homeobj.setProjectname(obj.getProjname());
					homelistall.add(homeobj);
				}
			}
		}
		return homelistall;
	}
}
