package com.xkd.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.dao.BaseHomeMapper;

@Service("teamManagerService")
@Scope("prototype")
public class TeamManagerService {
	/**
	 * 团队表
	 */
	@Resource(name = "baseHomeMapper")
	private BaseHomeMapper	baseHomeMapper;
}
