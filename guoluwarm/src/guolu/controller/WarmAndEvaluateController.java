package guolu.controller;

import guolu.accdata.GetReaultData;
import guolu.dao.Factoryimpl;
import guolu.dao.WarnDAOimpl;
import guolu.entity.Nanlaingdatamodal;
import guolu.entity.EvaluateResult;
import guolu.entity.WarmDataPakeage;
import guolu.entity.WarmResult;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WarmAndEvaluateController extends HttpServlet {

	
	/**
	 * 安全预警及评价结果显示数据
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		EvaluateResult modul=GetReaultData.getdata(request, response);
		WarnDAOimpl EvaluateAndWarm=(WarnDAOimpl)(Factoryimpl.getInstance("WarnDAOimpl"));
		try {
			//评价数据打包
			List<Nanlaingdatamodal> list=EvaluateAndWarm.findresultdata(modul);
			session.setAttribute("barcharselect", modul);
			session.setAttribute("barcharsdata", list);
			
			//预警数据打包
			//获取要显示的页数
			int currPage=1;
			int allpage=EvaluateAndWarm.findwarnallpage();
			if(request.getParameter("page")!=null){
				currPage=Integer.parseInt(request.getParameter("page"));
			}
			if(currPage<1){
				currPage=1;
			}else if(currPage>allpage){
				currPage=allpage;
			}
			List<WarmResult> Warmlist=EvaluateAndWarm.findwarnresult(currPage,9);
			WarmDataPakeage Warmdata =new WarmDataPakeage();
			Warmdata.setModul(Warmlist);
			
			Warmdata.setAllpage(EvaluateAndWarm.findwarnallpage());
			Warmdata.setCurrentPage(currPage);
			session.setAttribute("Warmdata", Warmdata);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/jsp/warndatashow/warmdatashow.jsp").forward(request,response);
	}

}
