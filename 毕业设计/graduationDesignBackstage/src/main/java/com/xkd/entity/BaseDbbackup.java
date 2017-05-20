package com.xkd.entity;

import java.util.Date;

public class BaseDbbackup {
	private String	id;

	private Date	creattime;

	private String	creattimestr;

	private String	backuppath;
	private String	msg;
	private String	state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getCreattimestr() {
		return creattimestr;
	}

	public void setCreattimestr(String creattimestr) {
		this.creattimestr = creattimestr == null ? null : creattimestr.trim();
	}

	public String getBackuppath() {
		return backuppath;
	}

	public void setBackuppath(String backuppath) {
		this.backuppath = backuppath == null ? null : backuppath.trim();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}