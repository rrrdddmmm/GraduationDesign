package com.xkd.dao;

import com.xkd.entity.User;

public interface UserDaoMapper {
	User findByEmail(String email);
	void save(User usr);
}
