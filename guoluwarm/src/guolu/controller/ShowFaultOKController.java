package guolu.controller;

import guolu.entity.Machinefaultmodal;
import guolu.service.FaultPageListService;
import guolu.util.Util_PathUtil;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowFaultOKController extends HttpServlet {

	
	/**
	 * 查看故障知识详情的控制层，实现根据表名、列名查找一条数据的服务的控制
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			Machinefaultmodal modul=FaultPageListService.FaultShowService(request, response);
			if(modul!=null){
				//转发到查看一条记录页面，将数据存储在request中
				//将数据存入request中转发给show.jsp
				request.setAttribute("Faultonedata", modul);
				request.getRequestDispatcher("/jsp/faultkonwshow.jsp").forward(request,response);
			}else{
				//出现错误，重定向到错误处理界面
				response.sendRedirect(Util_PathUtil.getPath_jsp(request,"error"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(Util_PathUtil.getPath_jsp(request,"error"));
			e.printStackTrace();
		}
	}

}
