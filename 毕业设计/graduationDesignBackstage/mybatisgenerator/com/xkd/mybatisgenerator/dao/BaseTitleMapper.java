package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseTitle;

public interface BaseTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseTitle record);

    int insertSelective(BaseTitle record);

    BaseTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseTitle record);

    int updateByPrimaryKey(BaseTitle record);
}