package com.xkd.dao;

import java.util.List;

import com.xkd.entity.BaseNews;

public interface BaseNewsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(BaseNews record);

	int insertSelective(BaseNews record);

	BaseNews selectByPrimaryKey(Integer id);

	List<BaseNews> selectAll();

	int updateByPrimaryKeySelective(BaseNews record);

	int updateByPrimaryKey(BaseNews record);
}