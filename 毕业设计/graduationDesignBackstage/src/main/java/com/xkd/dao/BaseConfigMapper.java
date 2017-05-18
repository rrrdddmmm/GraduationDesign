package com.xkd.dao;

import com.xkd.entity.BaseConfig;

public interface BaseConfigMapper {
	BaseConfig selectByName(String name);

	int insertSelective(BaseConfig baseConfig);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(BaseConfig baseConfig);
}
