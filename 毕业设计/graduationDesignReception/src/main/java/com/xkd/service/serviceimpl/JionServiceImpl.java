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
		ProjectHome projecthome=new ProjectHome();
		projecthome.setEmail(email);
		projecthome.setProject_no(id);
		ProjectHome result=projectHomeDaoMapper.findById(projecthome);
		if(result!=null){
			return;
		}
		projectHomeDaoMapper.insertData(projecthome);
		projectDao.updateProject(id);
	}

}
