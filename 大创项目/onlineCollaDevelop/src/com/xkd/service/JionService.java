package com.xkd.service;

import java.util.List;

import com.xkd.entity.Project;

public interface JionService {
	List<Project> findJion();
	Project findProjectByid(int id);
	void updateJion(int id);

}
