package com.xkd.mybatisgenerator.model;

import java.util.Date;

public class BaseNews {
    private Integer id;

    private String newstitle;

    private String newsexplain;

    private String newslogo;

    private String newsdetails;

    private Date creattime;

    private Date updatetime;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle == null ? null : newstitle.trim();
    }

    public String getNewsexplain() {
        return newsexplain;
    }

    public void setNewsexplain(String newsexplain) {
        this.newsexplain = newsexplain == null ? null : newsexplain.trim();
    }

    public String getNewslogo() {
        return newslogo;
    }

    public void setNewslogo(String newslogo) {
        this.newslogo = newslogo == null ? null : newslogo.trim();
    }

    public String getNewsdetails() {
        return newsdetails;
    }

    public void setNewsdetails(String newsdetails) {
        this.newsdetails = newsdetails == null ? null : newsdetails.trim();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}