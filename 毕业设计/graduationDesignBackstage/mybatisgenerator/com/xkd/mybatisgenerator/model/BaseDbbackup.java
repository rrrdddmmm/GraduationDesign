package com.xkd.mybatisgenerator.model;

import java.util.Date;

public class BaseDbbackup {
    private String id;

    private Date creattime;

    private String creattimestr;

    private String backuppath;

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
}