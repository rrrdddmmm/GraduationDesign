package com.xkd.mybatisgenerator.model;

import java.util.Date;

public class BaseTask {
	private Integer	id;

	private String	projectid;

	private String	email;

	private String	name;

	private Date	startuptime;

	private Date	updatetime;

	private Date	endtime;

	private String	description;

	private String	taskfile;

	private String	resultdescription;

	private String	resultfile;

	private String	resultevaluation;

	private Integer	status;

	public BaseTask(String projectid, String email) {
		this.projectid = projectid;
		this.email = email;
	}

	public BaseTask() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Date getStartuptime() {
		return startuptime;
	}

	public void setStartuptime(Date startuptime) {
		this.startuptime = startuptime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getTaskfile() {
		return taskfile;
	}

	public void setTaskfile(String taskfile) {
		this.taskfile = taskfile == null ? null : taskfile.trim();
	}

	public String getResultdescription() {
		return resultdescription;
	}

	public void setResultdescription(String resultdescription) {
		this.resultdescription = resultdescription == null ? null : resultdescription.trim();
	}

	public String getResultfile() {
		return resultfile;
	}

	public void setResultfile(String resultfile) {
		this.resultfile = resultfile == null ? null : resultfile.trim();
	}

	public String getResultevaluation() {
		return resultevaluation;
	}

	public void setResultevaluation(String resultevaluation) {
		this.resultevaluation = resultevaluation == null ? null : resultevaluation.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}