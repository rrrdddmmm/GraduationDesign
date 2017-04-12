package guolu.accdata;

import guolu.entity.Accsholist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取left界面的，故障知识数据,维修保养知识数据
 * 获取faultlist页面和miantainlist的数据为分页服务
 * @author RBB
 */
public class GetPageData {
	
	public static Accsholist getdata(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),
				"utf-8");
		String page=request.getParameter("page");
		String cycle=request.getParameter("cycle");
		//控制周期，变量，当点击班检是cycle返回1、点击日检是cycle返回2、
		//点击周检是cycle返回3、点击月检是cycle返回4、点半年班检是cycle返回5、点击年检是cycle返回6
		Accsholist accshlist=new Accsholist();
		accshlist.setName(name);
		accshlist.setPage(page);
		accshlist.setT(cycle);
		return accshlist;
	}

}
