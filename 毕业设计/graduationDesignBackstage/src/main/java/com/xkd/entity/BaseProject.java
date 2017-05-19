package com.xkd.entity;

import java.util.Date;

public class BaseProject {
	private String	id;

	private String	name;

	private String	email;

	private String	phone;

	private String	language;

	private String	platform;

	private Integer	allnumber;

	private Integer	currentnumber;

	private String	tutor;

	private Double	budget;

	private String	budgetfile;

	private String	progectfile;

	private String	describe;

	private String	logo;

	private Date	creattime;

	private Date	startuptime;

	private Date	updatetime;

	private Date	endtime;

	private String	startupevaluation;

	private String	resultevaluation;

	private String	grade;

	private Integer	status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language == null ? null : language.trim();
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform == null ? null : platform.trim();
	}

	public Integer getAllnumber() {
		return allnumber;
	}

	public void setAllnumber(Integer allnumber) {
		this.allnumber = allnumber;
	}

	public Integer getCurrentnumber() {
		return currentnumber;
	}

	public void setCurrentnumber(Integer currentnumber) {
		this.currentnumber = currentnumber;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor == null ? null : tutor.trim();
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getBudgetfile() {
		return budgetfile;
	}

	public void setBudgetfile(String budgetfile) {
		this.budgetfile = budgetfile == null ? null : budgetfile.trim();
	}

	public String getProgectfile() {
		return progectfile;
	}

	public void setProgectfile(String progectfile) {
		this.progectfile = progectfile == null ? null : progectfile.trim();
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
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

	public String getStartupevaluation() {
		return startupevaluation;
	}

	public void setStartupevaluation(String startupevaluation) {
		this.startupevaluation = startupevaluation == null ? null : startupevaluation.trim();
	}

	public String getResultevaluation() {
		return resultevaluation;
	}

	public void setResultevaluation(String resultevaluation) {
		this.resultevaluation = resultevaluation == null ? null : resultevaluation.trim();
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade == null ? null : grade.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}