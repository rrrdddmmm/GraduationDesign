package com.xkd.entity;

import java.util.Date;

public class BaseProject {
	private String	projid;

	private String	projname;

	private String	projemail;

	private String	creatpersionname;

	private String	projphone;

	private String	projlanguage;

	private String	projplatform;

	private Integer	projallnumber;

	private Integer	projcurrentnumber;

	private String	projtutor;

	private String	projtutorname;

	private Double	projbudget;

	private String	projbudgetfile;

	private String	projprogectfile;

	private String	projdescribe;

	private String	projlogo;

	private Date	projcreattime;

	private Date	projstartuptime;

	private Date	projupdatetime;

	private Date	projendtime;

	private String	projstartupevaluation;

	private Integer	projstartupevaluationvalue;

	private Integer	projstartupevaluationstate;

	private String	projresultevaluationvalue;

	private Integer	projresultevaluation;

	private Integer	projresultevaluationstate;

	private String	projgrade;

	private Integer	projstatus;

	@Override
	public String toString() {
		return "BaseProject [projid=" + projid + ", projname=" + projname + ", projemail=" + projemail
				+ ", creatpersionname=" + creatpersionname + ", projphone=" + projphone + ", projlanguage="
				+ projlanguage + ", projplatform=" + projplatform + ", projallnumber=" + projallnumber
				+ ", projcurrentnumber=" + projcurrentnumber + ", projtutor=" + projtutor + ", projtutorname="
				+ projtutorname + ", projbudget=" + projbudget + ", projbudgetfile=" + projbudgetfile
				+ ", projprogectfile=" + projprogectfile + ", projdescribe=" + projdescribe + ", projlogo=" + projlogo
				+ ", projcreattime=" + projcreattime + ", projstartuptime=" + projstartuptime + ", projupdatetime="
				+ projupdatetime + ", projendtime=" + projendtime + ", projstartupevaluation=" + projstartupevaluation
				+ ", projstartupevaluationvalue=" + projstartupevaluationvalue + ", projstartupevaluationstate="
				+ projstartupevaluationstate + ", projresultevaluationvalue=" + projresultevaluationvalue
				+ ", projresultevaluation=" + projresultevaluation + ", projresultevaluationstate="
				+ projresultevaluationstate + ", projgrade=" + projgrade + ", projstatus=" + projstatus + "]";
	}

	public String getProjid() {
		return projid;
	}

	public void setProjid(String projid) {
		this.projid = projid == null ? null : projid.trim();
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname == null ? null : projname.trim();
	}

	public String getProjemail() {
		return projemail;
	}

	public void setProjemail(String projemail) {
		this.projemail = projemail == null ? null : projemail.trim();
	}

	public String getCreatpersionname() {
		return creatpersionname;
	}

	public void setCreatpersionname(String creatpersionname) {
		this.creatpersionname = creatpersionname == null ? null : creatpersionname.trim();
	}

	public String getProjphone() {
		return projphone;
	}

	public void setProjphone(String projphone) {
		this.projphone = projphone == null ? null : projphone.trim();
	}

	public String getProjlanguage() {
		return projlanguage;
	}

	public void setProjlanguage(String projlanguage) {
		this.projlanguage = projlanguage == null ? null : projlanguage.trim();
	}

	public String getProjplatform() {
		return projplatform;
	}

	public void setProjplatform(String projplatform) {
		this.projplatform = projplatform == null ? null : projplatform.trim();
	}

	public Integer getProjallnumber() {
		return projallnumber;
	}

	public void setProjallnumber(Integer projallnumber) {
		this.projallnumber = projallnumber;
	}

	public Integer getProjcurrentnumber() {
		return projcurrentnumber;
	}

	public void setProjcurrentnumber(Integer projcurrentnumber) {
		this.projcurrentnumber = projcurrentnumber;
	}

	public String getProjtutor() {
		return projtutor;
	}

	public void setProjtutor(String projtutor) {
		this.projtutor = projtutor == null ? null : projtutor.trim();
	}

	public String getProjtutorname() {
		return projtutorname;
	}

	public void setProjtutorname(String projtutorname) {
		this.projtutorname = projtutorname == null ? null : projtutorname.trim();
	}

	public Double getProjbudget() {
		return projbudget;
	}

	public void setProjbudget(Double projbudget) {
		this.projbudget = projbudget;
	}

	public String getProjbudgetfile() {
		return projbudgetfile;
	}

	public void setProjbudgetfile(String projbudgetfile) {
		this.projbudgetfile = projbudgetfile == null ? null : projbudgetfile.trim();
	}

	public String getProjprogectfile() {
		return projprogectfile;
	}

	public void setProjprogectfile(String projprogectfile) {
		this.projprogectfile = projprogectfile == null ? null : projprogectfile.trim();
	}

	public String getProjdescribe() {
		return projdescribe;
	}

	public void setProjdescribe(String projdescribe) {
		this.projdescribe = projdescribe == null ? null : projdescribe.trim();
	}

	public String getProjlogo() {
		return projlogo;
	}

	public void setProjlogo(String projlogo) {
		this.projlogo = projlogo == null ? null : projlogo.trim();
	}

	public Date getProjcreattime() {
		return projcreattime;
	}

	public void setProjcreattime(Date projcreattime) {
		this.projcreattime = projcreattime;
	}

	public Date getProjstartuptime() {
		return projstartuptime;
	}

	public void setProjstartuptime(Date projstartuptime) {
		this.projstartuptime = projstartuptime;
	}

	public Date getProjupdatetime() {
		return projupdatetime;
	}

	public void setProjupdatetime(Date projupdatetime) {
		this.projupdatetime = projupdatetime;
	}

	public Date getProjendtime() {
		return projendtime;
	}

	public void setProjendtime(Date projendtime) {
		this.projendtime = projendtime;
	}

	public String getProjstartupevaluation() {
		return projstartupevaluation;
	}

	public void setProjstartupevaluation(String projstartupevaluation) {
		this.projstartupevaluation = projstartupevaluation == null ? null : projstartupevaluation.trim();
	}

	public Integer getProjstartupevaluationvalue() {
		return projstartupevaluationvalue;
	}

	public void setProjstartupevaluationvalue(Integer projstartupevaluationvalue) {
		this.projstartupevaluationvalue = projstartupevaluationvalue;
	}

	public Integer getProjstartupevaluationstate() {
		return projstartupevaluationstate;
	}

	public void setProjstartupevaluationstate(Integer projstartupevaluationstate) {
		this.projstartupevaluationstate = projstartupevaluationstate;
	}

	public String getProjresultevaluationvalue() {
		return projresultevaluationvalue;
	}

	public void setProjresultevaluationvalue(String projresultevaluationvalue) {
		this.projresultevaluationvalue = projresultevaluationvalue == null ? null : projresultevaluationvalue.trim();
	}

	public Integer getProjresultevaluation() {
		return projresultevaluation;
	}

	public void setProjresultevaluation(Integer projresultevaluation) {
		this.projresultevaluation = projresultevaluation;
	}

	public Integer getProjresultevaluationstate() {
		return projresultevaluationstate;
	}

	public void setProjresultevaluationstate(Integer projresultevaluationstate) {
		this.projresultevaluationstate = projresultevaluationstate;
	}

	public String getProjgrade() {
		return projgrade;
	}

	public void setProjgrade(String projgrade) {
		this.projgrade = projgrade == null ? null : projgrade.trim();
	}

	public Integer getProjstatus() {
		return projstatus;
	}

	public void setProjstatus(Integer projstatus) {
		this.projstatus = projstatus;
	}
}