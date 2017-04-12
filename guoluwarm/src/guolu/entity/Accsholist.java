package guolu.entity;
/**
 * showlist页面进行翻页和访问时的数据模型
 * @author RBB
 *
 */
public class Accsholist {

	private String name;
	private String t;
	private String page;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getT() {
		return t;
	}
}
