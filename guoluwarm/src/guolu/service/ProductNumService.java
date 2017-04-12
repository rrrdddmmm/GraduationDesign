package guolu.service;

import java.sql.SQLException;
import java.util.List;

import guolu.dao.Factoryimpl;
import guolu.dao.FaultDAOimpl;
import guolu.util.DBUtil_number;
/**
 * 获取编号服务
 * @author RBB
 *
 */
public class ProductNumService {

	public static String getnumber(String tablename,String fault_Number) throws SQLException{
		FaultDAOimpl Fault=(FaultDAOimpl)(Factoryimpl.getInstance("FaultDAOimpl"));
		List<String> list=Fault.findAllnum(tablename, fault_Number);
		String str=DBUtil_number.getuniqueNumber(list, tablename);
		return str;
		
	}
}
