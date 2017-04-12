package guolu.entity;
/**
 * 为查找锅炉实时数据所需要从页面获取的参数
 * rowname：实时数据的那一列数据
 * gouluid：锅炉编号
 * @author RBB
 *
 */
public class GuoluSearchmodul {

	private String rowname;
	private String guoluid;
	public void setGuoluid(String guoluid) {
		this.guoluid = guoluid;
	}
	public String getGuoluid() {
		return guoluid;
	}
	public void setRowname(String rowname) {
		this.rowname = rowname;
	}
	public String getRowname() {
		return rowname;
	}
}
