package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseDbbackup;

public interface BaseDbbackupMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseDbbackup record);

    int insertSelective(BaseDbbackup record);

    BaseDbbackup selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseDbbackup record);

    int updateByPrimaryKey(BaseDbbackup record);
}