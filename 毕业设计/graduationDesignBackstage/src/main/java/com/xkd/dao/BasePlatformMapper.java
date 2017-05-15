package com.xkd.dao;

import com.xkd.entity.BasePlatform;

public interface BasePlatformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasePlatform record);

    int insertSelective(BasePlatform record);

    BasePlatform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasePlatform record);

    int updateByPrimaryKey(BasePlatform record);
}