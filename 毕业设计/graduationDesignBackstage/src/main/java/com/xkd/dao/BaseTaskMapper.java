package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseTask;

public interface BaseTaskMapper {

	int deleteByTaskId(Integer taskid);

	int deleteByProjectId(String projectid);

	int insert(BaseTask record);

	int insertSelective(BaseTask record);

	BaseTask selectByPrimaryKey(Integer id);

	List<BaseTask> selectByPrimaryAll(BaseTask baseTask);

	int updateByPrimaryKeySelective(BaseTask record);

	int updateByPrimaryKey(BaseTask record);
}