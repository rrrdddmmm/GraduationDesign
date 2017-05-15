package com.xkd.dao;

import com.xkd.entity.BaseTitle;

public interface BaseTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseTitle record);

    int insertSelective(BaseTitle record);

    BaseTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseTitle record);

    int updateByPrimaryKey(BaseTitle record);
}