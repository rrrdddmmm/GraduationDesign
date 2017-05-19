package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseLanguage;

public interface BaseLanguageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseLanguage record);

    int insertSelective(BaseLanguage record);

    BaseLanguage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseLanguage record);

    int updateByPrimaryKey(BaseLanguage record);
}