package guolu.entity;
/**
 * 职工反馈建议的数据模型
 * @author RBB
 *
 */
public class Adviceinfomodal {

	private String username;//用户名
	private String tablename;//表名
	private String number;//故障编号
	private String keyword;//故障关键字
	private String text;//反馈内容
	private String state="否";//审核状态
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getTablename() {
		return tablename;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}

	
}
