package guolu.accdata;

import guolu.entity.Machinefaultmodal;
import guolu.service.ProductNumService;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFaultAddData {

	public static Machinefaultmodal getdata(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String Faulttype=request.getParameter("Faulttype");
		String Faultcause=request.getParameter("Faultcause");
		String Tablename=request.getParameter("Tablename");
		String Dealhand=request.getParameter("Dealhand");
		Machinefaultmodal dd=new Machinefaultmodal();
		dd.setFalut_cause(Faultcause);
		dd.setFalut_handle(Dealhand);
		String number = null;
		try {
			number = ProductNumService.getnumber(Tablename, "falut_Number");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dd.setFalut_Number(number);//工具类产生唯一编号
		dd.setFalut_type(Faulttype);
		dd.setTablename(Tablename);
		return dd;
	}
}
