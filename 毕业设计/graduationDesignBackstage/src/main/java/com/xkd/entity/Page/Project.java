package com.xkd.entity.Page;

import com.xkd.entity.BaseProject;

public class Project extends BaseProject {

	private String	application;
	private String	auditstate;
	private String	jointype;

	public Project() {

	}

	public Project(String projtutor) {
		super.setProjtutor(projtutor);
	}

	public Project(String email, Integer projstatus) {
		super.setProjstatus(projstatus);
		super.setProjemail(email);
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getAuditstate() {
		return auditstate;
	}

	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}

	public String getJointype() {
		return jointype;
	}

	public void setJointype(String jointype) {
		this.jointype = jointype;
	}
}
