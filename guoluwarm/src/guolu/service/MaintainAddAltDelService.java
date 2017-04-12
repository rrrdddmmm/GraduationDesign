package guolu.service;

import guolu.accdata.GetMaintainAddData;
import guolu.dao.Factoryimpl;
import guolu.dao.MaintainDAOimpl;
import guolu.entity.Machinemtmodal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 管理员对维修保养知识库的增删改服务
 * @author RBB
 *
 */
public class MaintainAddAltDelService {
/**
 * 管理员修改服务
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws SQLException
 * @throws IOException
 */
	public static boolean alterService(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException {
		Machinemtmodal modul=GetMaintainAddData.getdata(request, response);
		MaintainDAOimpl Main=(MaintainDAOimpl)(Factoryimpl.getInstance("MaintainDAOimpl"));
		return Main.alterinfor(modul);
		
	}
	/**
	 * 管理员添加服务
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static boolean addService(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException {
		Machinemtmodal modul=GetMaintainAddData.getdata(request, response);
		MaintainDAOimpl Main=(MaintainDAOimpl)(Factoryimpl.getInstance("MaintainDAOimpl"));
		return Main.addinfor(modul);
	}
	
	/**
	 * 管理员删除服务
	 * @param modul
	 * @return
	 */
	public static boolean delService(Machinemtmodal modul){
		return false;
				
	}
}
