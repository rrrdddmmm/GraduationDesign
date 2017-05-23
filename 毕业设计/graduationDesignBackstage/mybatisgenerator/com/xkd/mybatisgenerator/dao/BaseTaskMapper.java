package com.xkd.mybatisgenerator.dao;

import java.util.List;

import com.xkd.mybatisgenerator.model.BaseTask;

public interface BaseTaskMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseTask record);

	int insertSelective(BaseTask record);

	BaseTask selectByPrimaryKey(Integer id);

	List<BaseTask> selectByPrimaryAll(BaseTask baseTask);

	int updateByPrimaryKeySelective(BaseTask record);

	int updateByPrimaryKey(BaseTask record);
}