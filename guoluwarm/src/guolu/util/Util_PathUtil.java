package guolu.util;

import javax.servlet.http.HttpServletRequest;

public class Util_PathUtil {
/**
 * 获取"WebRoot/jsp/"路径
 * @param request
 * @param str
 * @return
 */
	public static String getPath_jsp(HttpServletRequest request,String filename){
		String path = request.getContextPath();
		String basePath = request.getScheme()+
		"://"+request.getServerName()+":"+
		request.getServerPort()+path+
		"/jsp/"+filename+".jsp";//login.jsp
		return basePath;
		
	}
	/**
	 * 获取"WebRoot/html/"路径
	 * @param request
	 * @param str
	 * @return
	 */
	public static String getPath_html(HttpServletRequest request,String filename){
		String path = request.getContextPath();
		String basePath = request.getScheme()+
		"://"+request.getServerName()+":"+
		request.getServerPort()+path+
		"/html/"+filename+".html";
		return basePath;
		
	}
	/**
	 * 获取"WebRoot/"路径
	 * @param request
	 * @param str
	 * @return
	 */
	public static String getPath(HttpServletRequest request,String str){
		String path = request.getContextPath();
		String basePath = request.getScheme()+
		"://"+request.getServerName()+":"+
		request.getServerPort()+path+
		"/jsp/";
		return basePath;
		
	}
}
