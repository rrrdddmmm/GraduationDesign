package guolu.accdata;

import guolu.entity.Adviceinfomodal;
import guolu.entity.Usermodal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetAdviceData {
/**
 * 获取建议表单数据
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
	public static Adviceinfomodal getdata(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Adviceinfomodal modul=new Adviceinfomodal();
		String number=request.getParameter("Faultnumber");
		String keyword=request.getParameter("keyword");
		String text=request.getParameter("content");
		String tablename=request.getParameter("tablename");
		HttpSession session=request.getSession();
		Usermodal user=(Usermodal) session.getAttribute("user");
		String username=user.getUser_name();
		modul.setNumber(number);
		modul.setKeyword(keyword);
		modul.setState("否");
		modul.setTablename(tablename);
		modul.setText(text);
		modul.setUsername(username);
		return modul;
		
	}
}
