package com.xkd.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkd.dao.ProjectDaoMapper;
import com.xkd.entity.Project;
import com.xkd.service.CreatProjectService;

/**
 * 创建项目服务
 * @author RBB
 *
 */
@Service(value="CreatProjectService")
public class CreatProjectImpl  implements CreatProjectService{
	/**
	 * 
	 */
	@Autowired
	private ProjectDaoMapper projectDao;
	/**
	 * 数据插入
	 */
	public void toSave(Project project) {
		// TODO Auto-generated method stub
		java.sql.Date sqlDate=java.sql.Date.valueOf(project.getCrt_time_str());
		project.setCrt_time(sqlDate);
		sqlDate=java.sql.Date.valueOf(project.getUpdate_time_str());
		project.setUpdate_time(sqlDate);
		System.out.println(project);
		projectDao.insertData(project);
		
	}

}
