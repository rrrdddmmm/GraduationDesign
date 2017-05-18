package com.xkd.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkd.entity.BaseTask;

public interface BaseTaskMapper {
	int deleteByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email,
			@Param("startuptime") Date startuptime);

	int insert(BaseTask record);

	int insertSelective(BaseTask record);

	BaseTask selectByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email,
			@Param("startuptime") Date startuptime);

	List<BaseTask> selectAll();

	int updateByPrimaryKeySelective(BaseTask record);

	int updateByPrimaryKey(BaseTask record);
}