package guolu.entity;

import java.util.List;
/**
 * view层的showlist页面需要的数据模型
 * @author RBB
 *
 */
public class Showlistmodal {

	private String table_name;
	private List<Machinefaultmodal> list;
	private int currentPage;
	private int allpage;
	
	public String getTable_name(){
		return table_name;
	}
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	public List<Machinefaultmodal> getList() {
		return list;
	}
	public void setList(List<Machinefaultmodal> list) {
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

}
