package com.xkd.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.dao.BaseUserMapper;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.util.ConfigStr;

/**
 * 登陆服务
 * 
 * @author RBB
 *
 */
@Service("userLoginService")
@Scope("prototype")
public class UserLoginService {

	@Resource(name = "baseUserMapper")
	private BaseUserMapper	baseUserMapper;

	public BaseUser loginHandle(BaseUser user, StateResult stateResult) {
		if (user.getEmail().equals("") || user.getRole().equals("") || user.getPassword().equals("")) {
			stateResult.setStatus(-1);
			stateResult.setMsg("服务器端:用户名和密码和角色不为空");
			return null;
		} else {
			BaseUser baseUser = new BaseUser();
			baseUser.setEmail(user.getEmail());
			BaseUser dbuser = baseUserMapper.selectByEmailRolePwd(baseUser);
			if (dbuser != null) {
				baseUser.setPassword(user.getPassword());
				dbuser = baseUserMapper.selectByEmailRolePwd(baseUser);
				if (dbuser != null) {
					dbuser = baseUserMapper.selectByEmailRolePwd(user);
					if (dbuser != null) {
						if (ConfigStr.start.equals(dbuser.getState())) {
							stateResult.setStatus(0);
							stateResult.setMsg("服务器端:登陆成功");
							return dbuser;
						} else {
							stateResult.setStatus(4);
							stateResult.setMsg("服务器端:账号未启用，请联系管理员!");
							return dbuser;
						}
					} else {
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端:请正确输入角色!");
					}
				} else {
					stateResult.setStatus(2);
					stateResult.setMsg("服务器端:请正确输入密码！");
				}
			} else {
				stateResult.setStatus(3);
				stateResult.setMsg("服务器端:请正确输入邮箱！");
			}
			return null;
		}
	}
}
