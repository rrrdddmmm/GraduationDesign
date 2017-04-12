package guolu.entity;
/**
 * 故障知识库的模型
 * @author RBB
 *
 */
public class Machinefaultmodal {
	
	private String tablename;
	private String falut_cause;
	private String falut_type;
	private String falut_handle;
	private int ID;
	private String falut_Number;
	
	public String getFalut_cause() {
		return falut_cause;
	}
	public void setFalut_cause(String falutCause) {
		falut_cause = falutCause;
	}
	public String getFalut_type() {
		return falut_type;
	}
	public void setFalut_type(String falutType) {
		falut_type = falutType;
	}
	public String getFalut_handle() {
		return falut_handle;
	}
	public void setFalut_handle(String falutHandle) {
		falut_handle = falutHandle;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFalut_Number() {
		return falut_Number;
	}
	public void setFalut_Number(String falutNumber) {
		falut_Number = falutNumber;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getTablename() {
		return tablename;
	}
}
