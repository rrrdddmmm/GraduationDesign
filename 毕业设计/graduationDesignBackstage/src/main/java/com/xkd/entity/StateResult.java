package com.xkd.entity;

public class StateResult {
	private int			status;
	private String		msg;
	private String		newpath;
	private BaseProject	baseProject;
	private BaseTask	baseTask;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNewpath() {
		return newpath;
	}

	public void setNewpath(String newpath) {
		this.newpath = newpath;
	}

	public BaseProject getBaseProject() {
		return baseProject;
	}

	public void setBaseProject(BaseProject baseProject) {
		this.baseProject = baseProject;
	}

	public BaseTask getBaseTask() {
		return baseTask;
	}

	public void setBaseTask(BaseTask baseTask) {
		this.baseTask = baseTask;
	}

}
