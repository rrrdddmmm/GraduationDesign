package guolu.accdata;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guolu.entity.Adviceinfolistmodul;

public class GetPageAdviceData {

	public static Adviceinfolistmodul getdata(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		String flag=request.getParameter("flag");//currentPage
		String currentPage=request.getParameter("page");//
		Adviceinfolistmodul mod=new Adviceinfolistmodul();
		mod.setFlag(flag);
		mod.setCurrentPage(Integer.parseInt(currentPage));
		return mod;
	}
}
