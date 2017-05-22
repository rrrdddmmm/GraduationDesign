package com.xkd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkd.entity.BaseHome;
import com.xkd.entity.Page.Home;

public interface BaseHomeMapper {
	int deleteByPrimaryKey(@Param("projectid") String projectid, @Param("email") String email);

	int insert(BaseHome record);

	int insertSelective(BaseHome record);

	BaseHome selectByPrimaryKey(@Param("projectid") String projectid, @Param("email") String email);

	List<BaseHome> selectByPrimaryAll(Home home);

	List<BaseHome> selectAll();

	int updateByPrimaryKeySelective(BaseHome record);

	int updateByPrimaryKey(BaseHome record);
}