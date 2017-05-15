package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseDirection;

public interface BaseDirectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseDirection record);

    int insertSelective(BaseDirection record);

    BaseDirection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseDirection record);

    int updateByPrimaryKey(BaseDirection record);
}