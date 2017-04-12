package guolu.controller;

import guolu.service.RegisterService;
import guolu.util.Util_PathUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController extends HttpServlet {
	/**
	 * 注册的逻辑控制
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		boolean flag=RegisterService.service(request, response);
		if(flag==true){
			//不重复，重定向登陆页面提示注册成功
			response.sendRedirect(Util_PathUtil.getPath_jsp(request,"login"));
		}else{
			//失败跳转到注册界面
			response.sendRedirect(Util_PathUtil.getPath_jsp(request,"regist"));
			//给页面提示什么错误
		}
	}

}
