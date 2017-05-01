package com.xkd.dao;

import java.util.List;

import com.xkd.entity.Project;

public interface ProjectDaoMapper {
	List<Project> findProject();

	Project findByid(int id);

	void updateProject(int id);

	void insertData(Project project);
}
