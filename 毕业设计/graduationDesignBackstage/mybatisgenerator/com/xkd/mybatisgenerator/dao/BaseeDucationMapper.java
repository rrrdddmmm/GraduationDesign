package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseeDucation;

public interface BaseeDucationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseeDucation record);

    int insertSelective(BaseeDucation record);

    BaseeDucation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseeDucation record);

    int updateByPrimaryKey(BaseeDucation record);
}