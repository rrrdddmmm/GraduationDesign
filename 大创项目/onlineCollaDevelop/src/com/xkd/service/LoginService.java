package com.xkd.service;

import com.xkd.entity.StateResult;
import com.xkd.entity.User;



public interface LoginService {
	public StateResult checkLogin(User user);
	public StateResult registUser(User user);
}
