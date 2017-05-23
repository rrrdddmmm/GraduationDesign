package com.xkd.util;

public class GetResousePath {
	/**
	 * 获取用户资源物理根路径
	 * 
	 * @author RBB
	 *
	 */
	public static String getUserResouresPath(String id) {
		return ConfigStr.ResourcesPath + id + "/";
	}

	/**
	 * 获取用户资源网络根路径
	 * 
	 * @author RBB
	 *
	 */
	public static String getUserResouresNetPath(String id) {
		return ConfigStr.netPathAbs + id + "/";
	}

	/**
	 * 获取用户存放头像的物理文件夹目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserTopImagesPath(String id, String imagsname) {
		return getUserResouresPath(id) + "TopImages/" + imagsname;
	}

	/**
	 * 获取用户存放头像的网络根路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserTopNetImagesPath(String id, String imagsname) {
		return getUserResouresNetPath(id) + "TopImages/" + imagsname;
	}

	/**
	 * 获取用户存放项目文件的物理文件夹目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserProjectFilePath(String id, String projectid, String filename) {
		return getUserResouresPath(id) + projectid + "/" + filename;
	}

	/**
	 * 获取用户存放项目任务文件的物理文件夹目录文件
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserProjectTaskFilePath(String id, String projectid, String filename) {
		return getUserResouresPath(id) + projectid + "/task/" + filename;
	}

	/**
	 * 获取用户存放项目任务文件的物理目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserProjectTaskDirPath(String id, String projectid) {
		return getUserResouresPath(id) + projectid + "/task/";
	}

	/**
	 * 获取用户存放项目文件的网络根路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserNetProjectFilePath(String id, String projectid, String filename) {
		return getUserResouresNetPath(id) + projectid + "/" + filename;
	}

	/**
	 * 获取新闻图像的物理文件夹目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getNewsImagesAbsPath(String imagsname) {
		return ConfigStr.newsAbsPathAbs + imagsname;
	}

	/**
	 * 获取新闻图像的网络地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getNewsImagesNetPath(String imagsname) {
		return ConfigStr.newsNetPathAbs + imagsname;
	}

}
