package guolu.accdata;

import guolu.entity.GuoluSearchmodul;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 得到用户给予的参数，从而知道用户需要几号锅炉的哪一些属性数据
 * @author RBB
 *
 */
public class GetOperationData {

	public static GuoluSearchmodul getdata(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String rowname=request.getParameter("dataname");
		String guoluid=request.getParameter("guoluid");
		GuoluSearchmodul modul=new GuoluSearchmodul();
		modul.setGuoluid(guoluid);
		modul.setRowname(rowname);
		return modul;
	}
}
