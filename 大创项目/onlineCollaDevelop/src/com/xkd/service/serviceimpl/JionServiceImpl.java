package com.xkd.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkd.dao.ProjectDaoMapper;
import com.xkd.dao.ProjectHomeDaoMapper;
import com.xkd.entity.Project;
import com.xkd.entity.ProjectHome;
import com.xkd.service.JionService;


@Service("JionService")
public class JionServiceImpl implements JionService {

	

	@Autowired
	private ProjectDaoMapper projectDao;
	@Autowired
	private ProjectHomeDaoMapper projectHomeDaoMapper;
	
	public List<Project> findJion() {
		List<Project> list=new ArrayList<Project>();
		list=projectDao.findProject();
		
		return list;
	}
	
	public Project findProjectByid(int id) {
		Project p=new Project();
		p=projectDao.findByid(id);
		return p;
	}

	public void updateJion(int id,String email) {
		ProjectHome p=new ProjectHome();
		p.setEmail(email);
		p.setProject_no(id);
		projectHomeDaoMapper.insertData(p);
		projectDao.updateProject(id);
	}

}
