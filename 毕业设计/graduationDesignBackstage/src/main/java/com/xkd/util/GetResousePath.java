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
	 * 获取用户存放头像的物理文件夹目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserTopImagesPath(String id, String imagsname) {
		return getUserResouresPath(id) + "TopImages/" + imagsname;
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
	 * 获取用户存放头像的网络根路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getUserTopNetImagesPath(String id, String imagsname) {
		return getUserResouresNetPath(id) + "TopImages/" + imagsname;
	}
}
