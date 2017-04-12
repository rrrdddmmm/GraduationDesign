package guolu.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guolu.accdata.GetFaultAddData;
import guolu.accdata.GetFaultAlterData;
import guolu.dao.Factoryimpl;
import guolu.dao.FaultDAOimpl;
import guolu.entity.Machinefaultmodal;

public class FaultAddAltDelService {
/**
 * 管理员修改故障知识库服务
 * @param modul
 * @return
 * @throws SQLException 
 * @throws SQLException 
 * @throws IOException 
 */
	public static boolean alterService(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException {
		Machinefaultmodal modul=GetFaultAlterData.getdata(request, response);
		FaultDAOimpl Fault=(FaultDAOimpl)(Factoryimpl.getInstance("FaultDAOimpl"));
		return Fault.alterinfor(modul);
	}
	/**
	 * 管理员添加故障知识库服务
	 * @param modul
	 * @return
	 */
	public static boolean addService(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, SQLException, IOException {
		Machinefaultmodal modul=GetFaultAddData.getdata(request, response);		
		FaultDAOimpl Fault=(FaultDAOimpl)(Factoryimpl.getInstance("FaultDAOimpl"));
		if(true==Fault.addinfor(modul)){
			return true;
		}else{
			return false;
		}	
	}
	/**
	 * 管理员删除故障知识库服务
	 * @param modul
	 * @return
	 */
	public static boolean delService(Machinefaultmodal modul){
		return false;
				
	}
}
