package guolu.controller;

import guolu.dao.Factoryimpl;
import guolu.dao.FaultDAOimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController extends HttpServlet {

	
	/**
	 * 实现删除的功能，各种数据的删除
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String delete=request.getParameter("pow");
		String tablename=request.getParameter("tablename");
		String flag=request.getParameter("flag");
		String sql=null;
		boolean fn = false;
		if("1".equals(flag)){
			sql="delete from "+tablename+" where falut_Number='"+delete+"'";
		}else{
			sql="delete from "+tablename+" where inspect_number='"+delete+"'";
		}
		FaultDAOimpl dd=(FaultDAOimpl) Factoryimpl.getInstance("FaultDAOimpl");
		try {
			fn=dd.alterone(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fn==true){
			out.print("删除成功!");
		}else{
			out.print("删除失败!");
		}
			
		out.flush();
		out.close();
	}

}
