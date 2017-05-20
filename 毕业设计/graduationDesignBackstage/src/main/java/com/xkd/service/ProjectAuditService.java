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
@Service("projectAuditService")
@Scope("prototype")
public class ProjectAuditService {
	/**
	 * 项目表
	 */
	@Resource(name = "baseProjectMapper")
	private BaseProjectMapper	baseProjectMapper;
}
