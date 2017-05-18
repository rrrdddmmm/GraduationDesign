package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseLanguage;

public interface BaseLanguageMapper extends BaseConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseLanguage record);

	int insertSelective(BaseLanguage record);

	BaseLanguage selectByPrimaryKey(Integer id);

	BaseLanguage selectByName(String name);

	List<BaseLanguage> selectAll();

	int updateByPrimaryKeySelective(BaseLanguage record);

	int updateByPrimaryKey(BaseLanguage record);
}