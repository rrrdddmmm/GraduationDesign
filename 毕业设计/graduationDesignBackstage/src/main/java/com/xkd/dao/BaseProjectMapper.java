package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseProject;

public interface BaseProjectMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseProject record);

	int insertSelective(BaseProject record);

	BaseProject selectByPrimaryKey(Integer id);

	List<BaseProject> selectAll();

	int updateByPrimaryKeySelective(BaseProject record);

	int updateByPrimaryKey(BaseProject record);
}