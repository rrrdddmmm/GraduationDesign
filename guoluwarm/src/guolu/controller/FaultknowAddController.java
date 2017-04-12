package guolu.controller;

import guolu.service.FaultAddAltDelService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FaultknowAddController extends HttpServlet {

	/**
	 *  管理员对故障知识添加控制
	 */
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			if(true==FaultAddAltDelService.addService(request, response)){
				out.print("添加成功!");
			}else{
				out.print("添加失败，请重新添加!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//异常处理
			out.print("数据库连接出现异常啦！");
			 e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}
}
