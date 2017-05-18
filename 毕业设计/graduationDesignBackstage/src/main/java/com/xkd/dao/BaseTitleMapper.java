package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseTitle;

public interface BaseTitleMapper extends BaseConfigMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseTitle record);

	int insertSelective(BaseTitle record);

	BaseTitle selectByPrimaryKey(Integer id);

	BaseTitle selectByName(String name);

	List<BaseTitle> selectAll();

	int updateByPrimaryKeySelective(BaseTitle record);

	int updateByPrimaryKey(BaseTitle record);
}