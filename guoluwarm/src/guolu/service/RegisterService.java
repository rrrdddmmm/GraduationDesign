package guolu.service;

import guolu.accdata.GetRegisterData;
import guolu.dao.Factoryimpl;
import guolu.dao.RegisterDAOimpl;
import guolu.entity.Registermodal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterService {
/**
 * 服务层：实现注册功能的组装
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
	public static boolean service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Registermodal modul=GetRegisterData.getdata(request, response);
		RegisterDAOimpl registerDAOimpl=((RegisterDAOimpl) Factoryimpl.getInstance("RegisterDAOimpl"));
		try {
			//利用工场类得到RegisterDAOimpl类，RegisterDAOimpl类的checkAccount方法提供
			//检查用户名是否重复
			boolean flag = registerDAOimpl.checkAccount(modul.getUsername());
			//属性不可能为null所以不用检查null，要检查"",但是页面已经控制
			//如果返回true说明可以注册，否则用户名密码重复
			if(modul.getNewpasswd().equals(modul.getPasswd()) && flag==true){
			//不重复，实现将modul中的数据写入数据库
				System.out.println("开始写入数据库！");
				registerDAOimpl.saveAccount(modul);
				return true;
			}else{
				System.out.println("新旧密码不匹配或者该用户已经注册");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("连接数据库出现错误！");
			throw new ServletException(e);
		}
	}
}
