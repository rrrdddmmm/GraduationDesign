package guolu.controller;

import guolu.accdata.GetOperationData;
import guolu.entity.GuoluSearchmodul;
import guolu.entity.Nanlaingdatamodal;
import guolu.service.NanlaingdatashowService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NanliangshowController extends HttpServlet {

	
	/**
	 * 锅炉主体时时数据显示
	 */
	private static final long serialVersionUID = 1L;
/**
 * 如果service写错了会报HTTP Status 405 - HTTP method GET is not supported by this URL错误
 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		List<Nanlaingdatamodal> dd;
		try {
			GuoluSearchmodul  modul=GetOperationData.getdata(request, response);
			dd = NanlaingdatashowService.service(request, response);
			if(dd.size()==0){
				request.getRequestDispatcher("/jsp/error.jsp").forward(request,response);
			}else{
				session.setAttribute("data", dd);
				session.setAttribute("GuoluSearchmodul", modul);
				
				request.getRequestDispatcher("/jsp/warndatashow/guoludatashow.jsp").forward(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//当把转发加到finally中后会报错：HTTP Status 500 - Cannot forward after response has been committed
	}
}
