package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseDirection;

public interface BaseDirectionMapper extends BaseConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseDirection record);

	int insertSelective(BaseDirection record);

	BaseDirection selectByPrimaryKey(Integer id);

	BaseDirection selectByName(String name);

	List<BaseDirection> selectAll();

	int updateByPrimaryKeySelective(BaseDirection record);

	int updateByPrimaryKey(BaseDirection record);
}