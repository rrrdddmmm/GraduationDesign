package guolu.util;
/*
 * 根据用户名生成用户权限
 */
public class Util_Competence {

	public static String Competence(String username){
		if(username!=null && username.startsWith("123")){
			return "职工";
		}else{
			return "管理员";
		}
	}
}
