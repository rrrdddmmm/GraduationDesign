package com.xkd.entity.Page;

import com.xkd.entity.BaseProject;

public class Project extends BaseProject {

	private String	application;
	private String	auditstate;
	private String	jointype;
	private String	advice;
	private Integer	values;

	@Override
	public String toString() {
		return "Project [projid=" + super.getProjid() + ",application=" + application + ", auditstate=" + auditstate
				+ ", jointype=" + jointype + ", advice=" + advice + ", values=" + values + "]";
	}

	public Project() {

	}

	public Project(String projtutor) {
		super.setProjtutor(projtutor);
	}

	public Project(String email, Integer projstatus, String projid) {
		super.setProjstatus(projstatus);
		super.setProjemail(email);
		super.setProjid(projid);
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

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Integer getValues() {
		return values;
	}

	public void setValues(Integer values) {
		this.values = values;
	}
}
