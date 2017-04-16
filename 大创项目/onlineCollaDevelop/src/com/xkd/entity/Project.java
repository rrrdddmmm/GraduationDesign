package com.xkd.entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
@Repository("project")
@Scope("prototype")//非单例模式
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer project_no;
	private String project_name;
	private Integer home_no;
	private String  email;
	private String project_data;
	private String project_language;
	private String develop_platform;
	private Integer all_number;
	private Integer pronser_number;
	private String crt_time_str; 
	private String update_time_str; 
	private Date crt_time; 
	private Date update_time;
	private Integer status;
	private String leader;
	private String approver;
	private Double projectbudget;
	private String describeproject;
	
	@Override
	public String toString() {
		return "Project [project_no=" + project_no + ", project_name="
				+ project_name + ", home_no=" + home_no + ", email=" + email
				+ ", project_data=" + project_data + ", project_language="
				+ project_language + ", develop_platform=" + develop_platform
				+ ", all_number=" + all_number + ", pronser_number="
				+ pronser_number + ", crt_time_str=" + crt_time_str
				+ ", update_time_str=" + update_time_str + ", crt_time="
				+ crt_time + ", update_time=" + update_time + ", status="
				+ status + ", leader=" + leader + ", approver=" + approver
				+ ", projectbudget=" + projectbudget + ", describeproject=" + describeproject + "]";
	}
	public Integer getProject_no() {
		return project_no;
	}
	public void setProject_no(Integer project_no) {
		this.project_no = project_no;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Integer getHome_no() {
		return home_no;
	}
	public void setHome_no(Integer home_no) {
		this.home_no = home_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProject_data() {
		return project_data;
	}
	public void setProject_data(String project_data) {
		this.project_data = project_data;
	}
	public String getProject_language() {
		return project_language;
	}
	public void setProject_language(String project_language) {
		this.project_language = project_language;
	}
	public String getDevelop_platform() {
		return develop_platform;
	}
	public void setDevelop_platform(String develop_platform) {
		this.develop_platform = develop_platform;
	}
	public Integer getAll_number() {
		return all_number;
	}
	public void setAll_number(Integer all_number) {
		this.all_number = all_number;
	}
	public Integer getPronser_number() {
		return pronser_number;
	}
	public void setPronser_number(Integer pronser_number) {
		this.pronser_number = pronser_number;
	}
	public Date getCrt_time() {
		return crt_time;
	}
	public void setCrt_time(Date crt_time) {
		this.crt_time = crt_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Double getProjectbudget() {
		return projectbudget;
	}
	public void setProjectbudget(Double projectbudget) {
		this.projectbudget = projectbudget;
	}
	public String getDescribeproject() {
		return describeproject;
	}
	public void setDescribeproject(String describeproject) {
		this.describeproject = describeproject;
	}
	public String getCrt_time_str() {
		return crt_time_str;
	}
	public void setCrt_time_str(String crt_time_str) {
		this.crt_time_str = crt_time_str;
	}
	public String getUpdate_time_str() {
		return update_time_str;
	}
	public void setUpdate_time_str(String update_time_str) {
		this.update_time_str = update_time_str;
	}
	
	

}
