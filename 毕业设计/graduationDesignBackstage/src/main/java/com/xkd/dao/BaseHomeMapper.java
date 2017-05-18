package com.xkd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkd.entity.BaseHome;

public interface BaseHomeMapper {
	int deleteByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email);

	int insert(BaseHome record);

	int insertSelective(BaseHome record);

	BaseHome selectByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email);

	List<BaseHome> selectAll();

	int updateByPrimaryKeySelective(BaseHome record);

	int updateByPrimaryKey(BaseHome record);
}