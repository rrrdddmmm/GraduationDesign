package com.xkd.dao;

import com.xkd.entity.BaseProject;

public interface BaseProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseProject record);

    int insertSelective(BaseProject record);

    BaseProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseProject record);

    int updateByPrimaryKey(BaseProject record);
}