package guolu.controller;

import guolu.entity.Showmainlistmodal;
import guolu.service.MaintainPageListService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMainlistController extends HttpServlet {

	/**
	 * 锅炉维修保养知识数据的显示
	 */
	private static final long serialVersionUID = 1L;

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Showmainlistmodal modul=MaintainPageListService.service(request, response);
		if(modul!=null){
			//将数据存入request中转发给show.jsp
			request.setAttribute("Main", modul);
			request.getRequestDispatcher("/jsp/maintainlist.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
		}
	}			
}
