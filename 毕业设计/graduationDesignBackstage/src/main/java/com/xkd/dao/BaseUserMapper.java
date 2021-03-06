package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseUser;

public interface BaseUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseUser record);

	int insertSelective(BaseUser record);

	BaseUser selectByPrimaryKey(Integer id);

	BaseUser selectByEmailRolePwd(BaseUser record);

	List<BaseUser> selectAll();

	List<BaseUser> selectAllRoleList(String role);

	List<BaseUser> selectBystate(String state);

	List<BaseUser> selectByBaseDirection(String direction);

	int updateByPrimaryKeySelective(BaseUser record);

	int updateByPrimaryKey(BaseUser record);
}