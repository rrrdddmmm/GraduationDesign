package guolu.accdata;

import guolu.entity.EvaluateResult;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *对锅炉经济性，关键重要度，故障比，安全性评价结果显示界面的数据接收以及部分界面的反馈
 * @author RBB
 *
 */
public class GetReaultData {
	public static EvaluateResult getdata(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String num=request.getParameter("num");
		String radio=request.getParameter("radio");
		
		EvaluateResult modul=new EvaluateResult();
		if(year==null && month==null && num==null && radio==null){
			modul.setMonth("1");
			modul.setMun("1");
			modul.setRadio("safety");
			modul.setYear("2015");
		}else{
			modul.setMonth(month);
			modul.setMun(num);
			modul.setRadio(radio);
			modul.setYear(year);
		}
		if("pivotal".equals(modul.getRadio()) || "component".equals(modul.getRadio())){
			modul.setStyle("\"block\"");
		}else{
			modul.setStyle("\"display:none;\"");//默认隐藏
		}
		return modul;
	}
}
