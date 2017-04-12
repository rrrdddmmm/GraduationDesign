package guolu.accdata;

import guolu.entity.Adviceinfomodal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取审核建议之后的数据，将其数据更新数据库
 * @author RBB
 *
 */
public class GetAdviceInsData {

	public static Adviceinfomodal getdata(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String number=request.getParameter("number");
		String tablename=request.getParameter("tablename");
		String content=request.getParameter("content");
		Adviceinfomodal dd=new Adviceinfomodal();
		dd.setNumber(number);
		dd.setTablename(tablename);
		dd.setText(content);
		return dd;
	}
}
