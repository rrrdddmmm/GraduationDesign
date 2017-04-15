package com.xkd.util;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserState {
	private Integer stateNo;   //状态码
	private String stateName;   //状态值
	
	public UserState(){}
	public UserState(Integer stateNo, String stateName){
		this.stateNo = stateNo;
		this.stateName = stateName;
	}
	public Integer getStateNo() {
		return stateNo;
	}
	public void setStateNo(Integer stateNo) {
		this.stateNo = stateNo;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
}
