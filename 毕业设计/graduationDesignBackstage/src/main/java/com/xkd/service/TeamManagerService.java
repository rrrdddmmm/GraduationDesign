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
import com.xkd.entity.StateResult;
import com.xkd.entity.Page.Home;
import com.xkd.entity.Page.Project;
import com.xkd.util.DateDealwith;

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
		List<BaseProject> list = baseProjectMapper.selectByPrimaryAll(new Project(sessionUser.getEmail(), null, null));
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

	public StateResult delHandle(Home home, StateResult stateResult) {
		BaseProject pp = baseProjectMapper.selectByPrimaryKey(home.getProjectid());// 不能添加项目负责人
		if (baseHomeMapper.deleteByPrimaryKey(home.getProjectid(), home.getEmail()) > 0) {
			if (pp.getProjstatus() != 3) {
				// 更新当前人数
				pp.setProjcurrentnumber(pp.getProjcurrentnumber() - 1);
				baseProjectMapper.updateByPrimaryKeySelective(pp);
			}
			stateResult.setStatus(0);
			stateResult.setMsg("服务器端:数据删除成功!");
		} else {
			stateResult.setStatus(0);
			stateResult.setMsg("服务器端:数据删除失败!");
		}
		return stateResult;
	}

	public StateResult addHandle(Home home, StateResult stateResult) {
		home.setCreattime(DateDealwith.getCurrDate());
		home.setUpdatetime(DateDealwith.getCurrDate());
		home.setStatus(0);
		BaseProject pp = baseProjectMapper.selectByPrimaryKey(home.getProjectid());// 不能添加项目负责人
		if (pp.getProjstatus() != 3) {
			if (pp.getProjcurrentnumber() < pp.getProjallnumber()) {
				BaseHome hh = baseHomeMapper.selectByPrimaryKey(home.getProjectid(), home.getEmail());// 不能重复添加
				if (hh != null || home.getEmail().equals(pp.getProjemail())) {
					if (hh != null) {
						stateResult.setStatus(4);
						stateResult.setMsg("服务器端:不能重复添加!");
					}
					if (home.getEmail().equals(pp.getProjemail())) {
						stateResult.setStatus(5);
						stateResult.setMsg("服务器端:不能添加创建者!");
					}
					return stateResult;
				} else {
					if (baseHomeMapper.insert(home) > 0) {
						// 更新当前人数
						pp.setProjcurrentnumber(pp.getProjcurrentnumber() + 1);
						baseProjectMapper.updateByPrimaryKeySelective(pp);
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端:数据添加成功!");
					} else {
						stateResult.setStatus(2);
						stateResult.setMsg("服务器端:数据添加失败!");
					}
					return stateResult;
				}
			} else {
				stateResult.setStatus(3);
				stateResult.setMsg("服务器端:该项目所需人数已满!");
				return stateResult;
			}
		} else {
			stateResult.setStatus(4);
			stateResult.setMsg("服务器端:该项目已结题!");
			return stateResult;
		}
	}
}
