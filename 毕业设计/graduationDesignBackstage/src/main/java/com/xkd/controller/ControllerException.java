package com.xkd.controller;

public class ControllerException extends Exception {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	public String				message;

	public ControllerException(String message) {
		// 第一个参数是异常的信息，第二的参数是哪个异常引起了这个异常
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
