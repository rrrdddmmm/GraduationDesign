package guolu.entity;

import java.util.List;

/*
 * 预警数据包
 */

public class WarmDataPakeage {
	public List<WarmResult> modul;
	public int allpage;
	private int currentPage;
	
	public List<WarmResult> getModul() {
		return modul;
	}
	public void setModul(List<WarmResult> modul) {
		this.modul = modul;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
