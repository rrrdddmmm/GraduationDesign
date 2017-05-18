package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BasePlatform;

public interface BasePlatformMapper extends BaseConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BasePlatform record);

	int insertSelective(BasePlatform record);

	BasePlatform selectByPrimaryKey(Integer id);

	BasePlatform selectByName(String name);

	List<BasePlatform> selectAll();

	int updateByPrimaryKeySelective(BasePlatform record);

	int updateByPrimaryKey(BasePlatform record);
}