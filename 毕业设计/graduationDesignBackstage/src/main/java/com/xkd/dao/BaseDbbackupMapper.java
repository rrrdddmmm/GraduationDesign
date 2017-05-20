package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseDbbackup;

public interface BaseDbbackupMapper {
	int deleteByPrimaryKey(String id);

	int insert(BaseDbbackup record);

	int insertSelective(BaseDbbackup record);

	List<BaseDbbackup> selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(BaseDbbackup record);

	int updateByPrimaryKey(BaseDbbackup record);
}