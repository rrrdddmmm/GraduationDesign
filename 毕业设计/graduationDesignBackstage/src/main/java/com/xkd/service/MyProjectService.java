package com.xkd.service;

import java.util.List;

import com.xkd.entity.Project;

/**
 * 我的项目服务接口
 * 
 * @author RBB
 *
 */
public interface MyProjectService {
	List<Project> findMyProject(String email);

}
