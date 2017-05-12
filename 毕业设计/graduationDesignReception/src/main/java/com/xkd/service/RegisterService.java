package com.xkd.service;

import com.xkd.entity.StateResult;
import com.xkd.entity.User;

/**
 * 注册服务接口
 * 
 * @author RBB
 *
 */
public interface RegisterService {
	/**
	 * 
	 * @param user
	 * @return
	 */
	public StateResult registUser(User user);
}
