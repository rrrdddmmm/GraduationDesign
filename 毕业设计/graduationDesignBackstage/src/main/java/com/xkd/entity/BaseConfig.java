package com.xkd.entity;

import java.util.Date;

public class BaseConfig {

	private Integer	id;

	private String	name;

	private Date	creattime;

	private Date	updatetime;

	private String	state;
	private Integer	flage;
	private Integer	handle;

	@Override
	public String toString() {
		return "BaseConfig [id=" + id + ", name=" + name + ", creattime=" + creattime + ", updatetime=" + updatetime
				+ ", state=" + state + ", flage=" + flage + ", handle=" + handle + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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

	public Integer getFlage() {
		return flage;
	}

	public void setFlage(Integer flage) {
		this.flage = flage;
	}

	public Integer getHandle() {
		return handle;
	}

	public void setHandle(Integer handle) {
		this.handle = handle;
	}

}
