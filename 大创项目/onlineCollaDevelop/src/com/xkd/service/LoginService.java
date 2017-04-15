package com.xkd.service;

import com.xkd.entity.StateResult;
import com.xkd.entity.User;
/**
 * 
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
	/**
	 * 
	 * @param user
	 * @return
	 */
	public StateResult registUser(User user);
}
