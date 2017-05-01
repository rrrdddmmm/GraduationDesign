package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseProject;

public interface BaseProjectMapper {
    int deleteByPrimaryKey(Integer projectNo);

    int insert(BaseProject record);

    int insertSelective(BaseProject record);

    BaseProject selectByPrimaryKey(Integer projectNo);

    int updateByPrimaryKeySelective(BaseProject record);

    int updateByPrimaryKey(BaseProject record);
}