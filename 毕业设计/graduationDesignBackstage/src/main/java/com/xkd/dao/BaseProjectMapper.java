package com.xkd.dao;

import java.util.List;
import java.util.Map;

import com.xkd.entity.BaseProject;
import com.xkd.entity.Page.Project;

public interface BaseProjectMapper {
	int deleteByPrimaryKey(String projid);

	int insert(BaseProject record);

	int insertSelective(BaseProject record);

	BaseProject selectByPrimaryKey(String projid);

	List<BaseProject> selectByPrimaryAll(Project record);

	List<BaseProject> selectByPrimaryTaskAll(Project record);

	List<BaseProject> selectByPrimaryHome(Map<String, Object> map);

	List<BaseProject> selectAllApplication(Project record);

	int updateByPrimaryKeySelective(BaseProject record);

	int updateByPrimaryKey(BaseProject record);
}