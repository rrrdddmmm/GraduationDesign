package guolu.service;

import guolu.accdata.GetOperationData;
import guolu.dao.Factoryimpl;
import guolu.dao.WarnDAOimpl;
import guolu.entity.GuoluSearchmodul;
import guolu.entity.Nanlaingdatamodal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 南梁时时数据显示服务
 * @author RBB
 *
 */
public class NanlaingdatashowService {

	public static List<Nanlaingdatamodal> service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, SQLException {
		WarnDAOimpl dd=((WarnDAOimpl) Factoryimpl.getInstance("WarnDAOimpl"));
		GuoluSearchmodul  modul=GetOperationData.getdata(request, response);
		List<Nanlaingdatamodal> list =dd.findnanliangdata(modul);
		return list;
		
	}
}
