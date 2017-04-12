package guolu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AA extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		System.out.println("456465:"+request.getParameter("aaAA"));
		if(request.getParameter("aaAA")==null){
			session.setAttribute("aaAA", "1");//
		}else{
			session.setAttribute("aaAA", request.getParameter("aaAA"));//
		}
		out.print("添加成功!");
		out.flush();
		out.close();
	}

}
