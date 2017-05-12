package com.xkd.dao;

import com.xkd.entity.BaseeDucation;

public interface BaseeDucationMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseeDucation record);

	int insertSelective(BaseeDucation record);

	BaseeDucation selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(BaseeDucation record);

	int updateByPrimaryKey(BaseeDucation record);
}