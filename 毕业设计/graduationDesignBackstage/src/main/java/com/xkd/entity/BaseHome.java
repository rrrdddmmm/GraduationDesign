package com.xkd.entity;

import java.util.Date;

public class BaseHome {
	private String		projectid;
	private String		projectname;

	private String		email;

	private Date		creattime;

	private Date		updatetime;

	private Integer		status;

	private BaseUser	use;

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid == null ? null : projectid.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public BaseUser getUse() {
		return use;
	}

	public void setUse(BaseUser use) {
		this.use = use;
	}
}