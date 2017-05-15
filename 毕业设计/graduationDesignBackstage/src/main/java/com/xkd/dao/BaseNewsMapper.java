package com.xkd.dao;

import com.xkd.entity.BaseNews;

public interface BaseNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseNews record);

    int insertSelective(BaseNews record);

    BaseNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseNews record);

    int updateByPrimaryKey(BaseNews record);
}