package com.xkd.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkd.dao.ProjectHomeDaoMapper;
import com.xkd.entity.Project;
import com.xkd.service.MyProjectService;

/**
 * 我的项目服务
 * @author RBB
 *
 */
@Service(value="MyProjectService")
public class MyProjectImpl implements MyProjectService{
	
	
	@Autowired
	private ProjectHomeDaoMapper projectHomeDaoMapper;

	public List<Project> findMyProject(String email) {
		List<Project> list=new ArrayList<Project>();
		list=projectHomeDaoMapper.findByEmail(email);
		
		return list;
	}

}
