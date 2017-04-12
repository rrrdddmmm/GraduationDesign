package guolu.entity;
/**
 * 登陆从数据库所需要的数据用来验证模型
 * @author RBB
 *
 */
public class Loginmodal {

	private String username;
	private String passwd;
	private String competence;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
}
