package guolu.controller;

import guolu.service.FaultAddAltDelService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FaultknowAlterController extends HttpServlet {

	
	/**
	 * 管理员对故障知识修改控制
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			if(FaultAddAltDelService.alterService(request, response)==true){
				out.print("数据修改成功！");
			}else{
				out.print("数据修改失败，请重新填写数据！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("进行异常处理！");
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
		
	}
}
