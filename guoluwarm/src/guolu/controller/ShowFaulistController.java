package guolu.controller;

import guolu.entity.Showlistmodal;
import guolu.service.FaultPageListService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowFaulistController extends HttpServlet {
	/**
	 * 实现fault.jsp页面分页显示数据的控制，以及数据的反馈
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Showlistmodal modul=FaultPageListService.service(request, response);
		if(modul!=null){
			//将数据存入request中转发给show.jsp
			request.setAttribute("Fault", modul);
			request.getRequestDispatcher("/jsp/flautlist.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
		}
	}
}
