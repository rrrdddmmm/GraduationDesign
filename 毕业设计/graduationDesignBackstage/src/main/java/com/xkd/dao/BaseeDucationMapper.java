package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseeDucation;

public interface BaseeDucationMapper extends BaseConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseeDucation record);

	int insertSelective(BaseeDucation record);

	BaseeDucation selectByPrimaryKey(Integer id);

	BaseeDucation selectByName(String name);

	List<BaseeDucation> selectAll();

	int updateByPrimaryKeySelective(BaseeDucation record);

	int updateByPrimaryKey(BaseeDucation record);
}