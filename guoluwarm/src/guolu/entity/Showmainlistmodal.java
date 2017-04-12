package guolu.entity;

import java.util.List;

public class Showmainlistmodal {

	private String table_name;
	private List<Machinemtmodal> list;
	private String cycle;
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	public List<Machinemtmodal> getList() {
		return list;
	}
	public void setList(List<Machinemtmodal> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getCycle() {
		return cycle;
	}
	private int currentPage;
	private int allpage;
}
