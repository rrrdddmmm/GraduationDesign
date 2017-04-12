package guolu.entity;

import java.util.List;
/**
 * 建议审核页面所需要的所有数据
 * @author RBB
 *
 */
public class Adviceinfolistmodul {

	public List<Adviceinfomodal> modul;
	public int allpage;
	private int currentPage;
	
	public String flag;//用来标记用户需要取得数据是维修保养的建议还是故障知识的建议
	public List<Adviceinfomodal> getModul() {
		return modul;
	}
	public void setModul(List<Adviceinfomodal> modul) {
		this.modul = modul;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
}
