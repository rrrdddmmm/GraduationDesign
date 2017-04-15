package com.xkd.dao;

import com.xkd.entity.User;

public interface UserDaoMapper {
	User findByName(String username);
	void save(User usr);
}
