package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseUser;

public interface BaseUserMapper {
    int deleteByPrimaryKey(String email);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(String email);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);
}