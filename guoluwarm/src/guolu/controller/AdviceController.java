package guolu.controller;

import guolu.service.AdviceService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdviceController extends HttpServlet {

	
	/**
	 * 实现故障知识职工反馈表数据提交的控制
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			if(true==AdviceService.service(request, response)){
				//给页面反馈数据插入成功
				out.print("成功插入数据 !");
			}else{
				//给页面反馈数据插入失败，请重新填写表单
				out.print("插入数据失败，请重亲填入数据 !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
		
	}

}
