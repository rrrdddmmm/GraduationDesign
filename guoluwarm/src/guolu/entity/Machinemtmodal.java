package guolu.entity;
/**
 * 维修保养知识库的模型
 * @author RBB
 *
 */
public class Machinemtmodal {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "inspect_number="+inspect_number+"";
	}
	private String tablename;
	private String inspect_number;
	private String inspect_cycle;
	private String inspect_content;
	public String getInspect_number() {
		return inspect_number;
	}
	public void setInspect_number(String inspectNumber) {
		inspect_number = inspectNumber;
	}
	public String getInspect_cycle() {
		return inspect_cycle;
	}
	public void setInspect_cycle(String inspectCycle) {
		inspect_cycle = inspectCycle;
	}
	public String getInspect_content() {
		return inspect_content;
	}
	public void setInspect_content(String inspectContent) {
		inspect_content = inspectContent;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getTablename() {
		return tablename;
	}
	
	
}
