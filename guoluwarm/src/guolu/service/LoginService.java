package guolu.service;

import guolu.accdata.GetLoginData;
import guolu.dao.Factoryimpl;
import guolu.dao.LoginDAOimpl;
import guolu.entity.Loginmodal;
import guolu.entity.Usermodal;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginService {
/**
 * 服务层的登陆功能的实现：将数据接收，数据打包，数据处理功能集合与此构造出登陆功能
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
	public static Usermodal service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Usermodal user;
		/**
		 * 获取数据后将数据打包
		 */
		Loginmodal Modul=GetLoginData.getdata(request, response);
		try {
			//获取dao层对登陆的数据库访问
			user=((LoginDAOimpl) Factoryimpl.getInstance("LoginDAOimpl")).finduserinfo(
			Modul.getUsername(), Modul.getPasswd(), Modul.getCompetence());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接数据库出现错误！");
			throw new ServletException(e);
		}
		return user;
	}
}
