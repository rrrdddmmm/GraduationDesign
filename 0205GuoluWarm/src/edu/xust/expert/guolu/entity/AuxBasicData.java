package edu.xust.expert.guolu.entity;

public class AuxBasicData {
	private int  GuoLuNum;                     //锅炉号
	private	double W1_SBSDGD;				//给水泵速度给定
	private	double W1_SBYXSD;				//给水泵运行速度
	private	double W1_SBYXDL;				//给水泵运行电流
	private	double W2_SBSDGD;				//给水泵速度给定
	private	double W2_SBYXSD;				//给水泵运行速度
	private	double W2_SBYXDL;				//给水泵运行电流
	private	double W_YFJSDGD;				//引风机速度给定
	private	double W_YFJYXDL;				//引风机运行电流
	private	double W_YFJYXSD;				//引风机运行速度
	private	double W_GFJSDGD;				//鼓风机速度给定
	private	double W_GFJYXDL;				//鼓风机运行电流
	private	double W_GFJYXSD;				//鼓风机运行速度
	private	String W_CJSJ;				//采集时间
	private	int State;	                  // 标识位
	
	
	public AuxBasicData() {
		super();
	}

	public AuxBasicData(int guoLuNum,double w1_SBSDGD, double w1_SBYXSD, double w1_SBYXDL,
			double w2_SBSDGD, double w2_SBYXSD, double w2_SBYXDL,
			double w_YFJSDGD, double w_YFJYXDL, double w_YFJYXSD,
			double w_GFJSDGD, double w_GFJYXDL, double w_GFJYXSD,
			String w_CJSJ, int state) {
		super();
		GuoLuNum=guoLuNum;
		W1_SBSDGD = w1_SBSDGD;
		W1_SBYXSD = w1_SBYXSD;
		W1_SBYXDL = w1_SBYXDL;
		W2_SBSDGD = w2_SBSDGD;
		W2_SBYXSD = w2_SBYXSD;
		W2_SBYXDL = w2_SBYXDL;
		W_YFJSDGD = w_YFJSDGD;
		W_YFJYXDL = w_YFJYXDL;
		W_YFJYXSD = w_YFJYXSD;
		W_GFJSDGD = w_GFJSDGD;
		W_GFJYXDL = w_GFJYXDL;
		W_GFJYXSD = w_GFJYXSD;
		W_CJSJ = w_CJSJ;
		State = state;
	}
	
	public int getGuoLuNum() {
		return GuoLuNum;
	}

	public void setGuoLuNum(int guoLuNum) {
		GuoLuNum = guoLuNum;
	}

	public double getW1_SBSDGD() {
		return W1_SBSDGD;
	}


	public void setW1_SBSDGD(double w1_SBSDGD) {
		W1_SBSDGD = w1_SBSDGD;
	}


	public double getW1_SBYXSD() {
		return W1_SBYXSD;
	}


	public void setW1_SBYXSD(double w1_SBYXSD) {
		W1_SBYXSD = w1_SBYXSD;
	}


	public double getW1_SBYXDL() {
		return W1_SBYXDL;
	}


	public void setW1_SBYXDL(double w1_SBYXDL) {
		W1_SBYXDL = w1_SBYXDL;
	}


	public double getW2_SBSDGD() {
		return W2_SBSDGD;
	}


	public void setW2_SBSDGD(double w2_SBSDGD) {
		W2_SBSDGD = w2_SBSDGD;
	}


	public double getW2_SBYXSD() {
		return W2_SBYXSD;
	}


	public void setW2_SBYXSD(double w2_SBYXSD) {
		W2_SBYXSD = w2_SBYXSD;
	}


	public double getW2_SBYXDL() {
		return W2_SBYXDL;
	}


	public void setW2_SBYXDL(double w2_SBYXDL) {
		W2_SBYXDL = w2_SBYXDL;
	}


	public double getW_YFJSDGD() {
		return W_YFJSDGD;
	}


	public void setW_YFJSDGD(double w_YFJSDGD) {
		W_YFJSDGD = w_YFJSDGD;
	}


	public double getW_YFJYXDL() {
		return W_YFJYXDL;
	}


	public void setW_YFJYXDL(double w_YFJYXDL) {
		W_YFJYXDL = w_YFJYXDL;
	}


	public double getW_YFJYXSD() {
		return W_YFJYXSD;
	}


	public void setW_YFJYXSD(double w_YFJYXSD) {
		W_YFJYXSD = w_YFJYXSD;
	}


	public double getW_GFJSDGD() {
		return W_GFJSDGD;
	}


	public void setW_GFJSDGD(double w_GFJSDGD) {
		W_GFJSDGD = w_GFJSDGD;
	}


	public double getW_GFJYXDL() {
		return W_GFJYXDL;
	}


	public void setW_GFJYXDL(double w_GFJYXDL) {
		W_GFJYXDL = w_GFJYXDL;
	}


	public double getW_GFJYXSD() {
		return W_GFJYXSD;
	}


	public void setW_GFJYXSD(double w_GFJYXSD) {
		W_GFJYXSD = w_GFJYXSD;
	}


	public String getW_CJSJ() {
		return W_CJSJ;
	}


	public void setW_CJSJ(String w_CJSJ) {
		W_CJSJ = w_CJSJ;
	}


	public int getState() {
		return State;
	}


	public void setState(int state) {
		State = state;
	}

}
