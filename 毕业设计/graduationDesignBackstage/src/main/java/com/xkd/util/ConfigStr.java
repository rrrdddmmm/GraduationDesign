package com.xkd.util;

public interface ConfigStr {
	// 分页配置
	public static String	listdate		= "list";
	public static String	pagedate		= "page";
	// session配置
	public static String	userInfomation	= "userInfomation";
	// 状态配置
	public static String	start			= "1";
	public static String	close			= "2";
	// 项目状态
	public static String	projectstate	= "0 1 2";
	// 待启动审核（0）:（projectstate=0）,
	// 开发中（1）:（projectstate=1 and endtime>当前时间），
	// 待结题审核（2）:(projectstate=1 and endtime<当前时间)，
	// 已完成项目（3）:（projectstate=2）

	// 文件配置
	public static String	ResourcesPath	= "F:/resource/";
	public static String	netPathAbs		= "/resource/";
	public static String	newsAbsPathAbs	= "F:/resource/news/";
	public static String	newsNetPathAbs	= "/resource/news/";
	public static Integer	currentnumber	= 1;							// 项目创建后当前人数
	// 数据库备份配置
	public static String	mysqlbinPath	= "E:/MySQL Server 5.5/bin/";
	public static String	user			= "root";
	public static String	pwd				= "123456";
	public static String	dbName			= "simulation_laboratory";
	public static String	sqlPath			= "F:/resource" + "/db/";
	public static String	ip				= "localhost";
}
