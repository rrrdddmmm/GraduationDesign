package guolu.entity;
/**
 * 用户信息表模型
 * @author RBB
 *
 */
public class Usermodal {
	private int user_ID;
	private String user_name;
	private String user_password;
	private String user_email;
	private String user_competence;//权限
	
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int userID) {
		user_ID = userID;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}
	public String getUser_competence() {
		return user_competence;
	}
	public void setUser_competence(String userCompetence) {
		user_competence = userCompetence;
	}
}
