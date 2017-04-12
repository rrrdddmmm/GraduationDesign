package guolu.accdata;

import guolu.entity.Machinemtmodal;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 接收维修保养知识添加数据
 * @author RBB
 *
 */
public class GetMaintainAddData {

	public static Machinemtmodal getdata(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String Maintaincycle=request.getParameter("Maintaincycle");
		String Maintaincontent=request.getParameter("Maintaincontent");
		String Tablename=request.getParameter("Tablename");
		Machinemtmodal modul=new Machinemtmodal();
		modul.setInspect_content(Maintaincontent);
		modul.setInspect_cycle(Maintaincycle);
		modul.setInspect_number("123123321123");
		modul.setTablename(Tablename);
		return modul;
	}
}
