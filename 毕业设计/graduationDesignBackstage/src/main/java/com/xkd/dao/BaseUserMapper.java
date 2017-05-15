package com.xkd.dao;

import com.xkd.entity.BaseUser;

public interface BaseUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseUser record);

	int insertSelective(BaseUser record);

	BaseUser selectByPrimaryKey(Integer id);

	BaseUser selectByEmailRolePwd(BaseUser record);

	int updateByPrimaryKeySelective(BaseUser record);

	int updateByPrimaryKey(BaseUser record);
}