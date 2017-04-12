package guolu.accdata;

import java.io.IOException;
import guolu.entity.Loginmodal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 从登陆jsp页面获取需要的数据将其打包后返回给控制层
 * @author RBB
 */
public class GetLoginData {

	public static Loginmodal getdata(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		Loginmodal dd=new Loginmodal();
		dd.setUsername(request.getParameter("user_name"));
		dd.setPasswd(request.getParameter("user_password"));
		dd.setCompetence(request.getParameter("user_competence"));
		return dd;
		
	}
}
