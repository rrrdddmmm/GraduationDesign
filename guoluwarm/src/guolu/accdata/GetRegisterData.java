package guolu.accdata;

import guolu.entity.Registermodal;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 从注册jsp页面获取需要的数据将其打包后返回给控制层
 * @author RBB
 *
 */
public class GetRegisterData {


	public static Registermodal getdata(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Registermodal dd=new Registermodal();
		dd.setUsername(request.getParameter("user_name"));
		dd.setPasswd(request.getParameter("user_password"));
		dd.setNewpasswd(request.getParameter("user_password_confirm"));
		return dd;
	}
 
}
