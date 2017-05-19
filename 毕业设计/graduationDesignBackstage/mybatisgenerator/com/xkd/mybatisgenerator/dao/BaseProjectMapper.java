package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseProject;

public interface BaseProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(BaseProject record);

    int insertSelective(BaseProject record);

    BaseProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseProject record);

    int updateByPrimaryKey(BaseProject record);
}