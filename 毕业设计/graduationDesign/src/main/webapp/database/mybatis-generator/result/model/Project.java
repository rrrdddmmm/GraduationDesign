package model;

import java.util.Date;

public class Project {
    private Integer projectNo;

    private String projectName;

    private Integer homeNo;

    private String email;

    private String projectData;

    private String projectLanguage;

    private String developPlatform;

    private Integer allNumber;

    private Integer pronserNumber;

    private Date crtTime;

    private Date updateTime;

    private Integer status;

    private String leader;

    private String approver;

    private Double projectbudget;

    private String describeproject;

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(Integer homeNo) {
        this.homeNo = homeNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProjectData() {
        return projectData;
    }

    public void setProjectData(String projectData) {
        this.projectData = projectData == null ? null : projectData.trim();
    }

    public String getProjectLanguage() {
        return projectLanguage;
    }

    public void setProjectLanguage(String projectLanguage) {
        this.projectLanguage = projectLanguage == null ? null : projectLanguage.trim();
    }

    public String getDevelopPlatform() {
        return developPlatform;
    }

    public void setDevelopPlatform(String developPlatform) {
        this.developPlatform = developPlatform == null ? null : developPlatform.trim();
    }

    public Integer getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(Integer allNumber) {
        this.allNumber = allNumber;
    }

    public Integer getPronserNumber() {
        return pronserNumber;
    }

    public void setPronserNumber(Integer pronserNumber) {
        this.pronserNumber = pronserNumber;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        this.leader = leader == null ? null : leader.trim();
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
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
        this.describeproject = describeproject == null ? null : describeproject.trim();
    }
}