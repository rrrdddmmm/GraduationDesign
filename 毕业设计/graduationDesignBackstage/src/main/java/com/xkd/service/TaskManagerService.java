package com.xkd.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.dao.BaseTaskMapper;

@Service("taskManagerService")
@Scope("prototype")
public class TaskManagerService {
	/**
	 * 任务表
	 */
	@Resource(name = "baseTaskMapper")
	private BaseTaskMapper	baseTaskMapper;
}
