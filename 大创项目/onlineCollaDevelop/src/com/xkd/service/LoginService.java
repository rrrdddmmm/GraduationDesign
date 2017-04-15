package com.xkd.service;

import com.xkd.entity.StateResult;
import com.xkd.entity.User;
/**
 * 登陆服务接口
 * @author RBB
 *
 */
public interface LoginService {
	/**
	 * 
	 * @param user
	 * @return
	 */
	public StateResult checkLogin(User user);
	
}
