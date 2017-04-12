package guolu.accdata;

import guolu.entity.Machinefaultmodal;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetFaultAlterData {

	public static Machinefaultmodal getdata(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String Faulttype=request.getParameter("Faulttype");
		String Faultnumber=request.getParameter("Faultnumber");
		String Faultcause=request.getParameter("Faultcause");
		String Tablename=request.getParameter("Tablename");
		String Dealhand=request.getParameter("Dealhand");
		Machinefaultmodal dd=new Machinefaultmodal();
		dd.setFalut_cause(Faultcause);
		dd.setFalut_handle(Dealhand);
		dd.setFalut_Number(Faultnumber);
		dd.setFalut_type(Faulttype);
		dd.setTablename(Tablename);
		return dd;
	}
}
