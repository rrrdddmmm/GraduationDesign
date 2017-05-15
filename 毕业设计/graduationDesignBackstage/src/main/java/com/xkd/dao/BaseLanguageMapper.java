package com.xkd.dao;

import com.xkd.entity.BaseLanguage;

public interface BaseLanguageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseLanguage record);

    int insertSelective(BaseLanguage record);

    BaseLanguage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseLanguage record);

    int updateByPrimaryKey(BaseLanguage record);
}