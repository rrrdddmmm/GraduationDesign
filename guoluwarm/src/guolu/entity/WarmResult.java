package guolu.entity;
/**
 * 预警结果模型
 * @author RBB
 *
 */
public class WarmResult {

	private int id;
	private int guolunum;//锅炉编号
	private String time;//报警时间
	private String faultname;//故障名称
	private String faultcause;//故障原因
	private String dealhandl;//处理对策
	public int getGuolunum() {
		return guolunum;
	}
	public void setGuolunum(int guolunum) {
		this.guolunum = guolunum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFaultname() {
		return faultname;
	}
	public void setFaultname(String faultname) {
		this.faultname = faultname;
	}
	public String getFaultcause() {
		return faultcause;
	}
	public void setFaultcause(String faultcause) {
		this.faultcause = faultcause;
	}
	public String getDealhandl() {
		return dealhandl;
	}
	public void setDealhandl(String dealhandl) {
		this.dealhandl = dealhandl;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	

}
