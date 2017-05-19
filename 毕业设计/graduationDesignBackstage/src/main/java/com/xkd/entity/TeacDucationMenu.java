package com.xkd.entity;

import java.util.List;

public class TeacDucationMenu {

	private String			duactionName;
	private List<BaseUser>	userList;
	public String getDuactionName() {
		return duactionName;
	}
	public void setDuactionName(String duactionName) {
		this.duactionName = duactionName;
	}
	public List<BaseUser> getUserList() {
		return userList;
	}
	public void setUserList(List<BaseUser> userList) {
		this.userList = userList;
	}
}
