package com.xkd.dao;

import java.util.List;

import com.xkd.entity.Project;
import com.xkd.entity.ProjectHome;

public interface ProjectHomeDaoMapper {
	void insertData(ProjectHome projectHome);
	ProjectHome findById(ProjectHome projectHome);
	List<Project> findByEmail(String email);
}
