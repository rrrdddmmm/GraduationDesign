package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseProject;

public interface BaseProjectMapper {
    int deleteByPrimaryKey(String projid);

    int insert(BaseProject record);

    int insertSelective(BaseProject record);

    BaseProject selectByPrimaryKey(String projid);

    int updateByPrimaryKeySelective(BaseProject record);

    int updateByPrimaryKey(BaseProject record);
}