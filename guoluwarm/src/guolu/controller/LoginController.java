package guolu.controller;

import guolu.entity.Usermodal;
import guolu.service.LoginService;
import guolu.util.Util_PathUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	/**
	 * 实现登陆控制
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		Usermodal user=LoginService.service(request, response);
		if(user!=null){
			//将用户信息存入session中，贯穿整个网站
			//转发到主页面,顺便将用户信息数据存入session中发送到主页面中。
			session.setAttribute("user",user);
			session.setAttribute("aaAA", "1");//
			request.getRequestDispatcher("jsp/main.jsp").forward(request,response);
		}else{
			session.setAttribute("login", "您输入的信息有误！请重新输入！！！！");
			//用户名或者密码错误重定向到登陆界面
			response.sendRedirect(Util_PathUtil.getPath_jsp(request,"login"));
		}		
	}
	

}
