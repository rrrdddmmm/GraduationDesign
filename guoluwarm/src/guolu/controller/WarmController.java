package guolu.controller;

import guolu.entity.WarmDataPakeage;
import guolu.entity.WarmResult;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WarmController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在session中查找一条数据
		int id=Integer.parseInt(request.getParameter("ID"));
		System.out.println("jckasjk:"+id);
		HttpSession session=request.getSession();
		WarmDataPakeage Warmdata=(WarmDataPakeage) session.getAttribute("Warmdata");
		List<WarmResult> Warmlist=Warmdata.getModul();
		//System.out.println(Warmlist.get(id));
				for(WarmResult li:Warmlist){
			if(li.getId()==id){
				session.setAttribute("onewarm", li);
				break;
			}
		}
		request.getRequestDispatcher("/jsp/warmresultshow.jsp").forward(request,response);
	}

}
