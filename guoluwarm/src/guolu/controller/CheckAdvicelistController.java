package guolu.controller;

import guolu.entity.Adviceinfolistmodul;
import guolu.service.AdviceService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckAdvicelistController extends HttpServlet {

	
	/**
	 * 管理员对职工建议审核控制
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			Adviceinfolistmodul Adicelist=AdviceService.servicePageshow(request, response);
			if(Adicelist!=null){
				request.setAttribute("Adicelist",Adicelist);
				request.getRequestDispatcher("/jsp/checkadvicelist.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
