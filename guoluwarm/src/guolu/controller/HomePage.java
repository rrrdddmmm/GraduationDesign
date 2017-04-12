package guolu.controller;


import guolu.util.Util_PathUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 实现访问本网站的接口，实现登陆页面的跳转
 * @author RBB
 *
 */
public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;

		public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");			
			response.sendRedirect(Util_PathUtil.getPath_jsp(request,"login"));
	}
}