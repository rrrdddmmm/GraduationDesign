package com.xkd.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.dao.BaseProjectMapper;

/**
 * 
 * @author RBB
 *
 */
@Service("projectManageService")
@Scope("prototype")
public class ProjectManageService {
	/**
	 * 项目表
	 */
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;
}
