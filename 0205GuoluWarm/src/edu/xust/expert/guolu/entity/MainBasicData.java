package edu.xust.expert.guolu.entity;

public class MainBasicData {
	private int  GuoLuNum;              //锅炉号
	private	double W_ZQYL;  				//蒸汽压力
	private	double W_ZQWD;  				//蒸汽温度
	private	double W_ZQLL; 				  	//蒸汽流量
	private	double W_GSLL;					//给水流量
	private	double W_GSWD;					//给水温度
	private	double W_GSYL; 					//给水压力
	private	double W_SMQCKSW; 	    	 //省煤器出口水温
	private	double W_SMQJKSW;          //省煤器进口水温
	private	double W_PYWD;     				//排烟温度
	private	double W_LTYL;					//炉膛压力
	private	double W_QBYL;					//汽包压力
	private	double W_QBSW;					//汽包水位
	
	private	String W_CJSJ;				//采集时间
	private	int State;	                    // 标识位
	
	public MainBasicData() {
		super();
	}
	
	public MainBasicData(int guoLuNum,double w_ZQYL, double w_ZQWD, double w_ZQLL,
			double w_GSLL, double w_GSWD, double w_GSYL, double w_SMQCKSW,
			double w_PYWD, double w_LTYL, double w_QBYL, double w_QBSW,
			String w_CJSJ, int state) {
		super();
		GuoLuNum=guoLuNum;
		W_ZQYL = w_ZQYL;
		W_ZQWD = w_ZQWD;
		W_ZQLL = w_ZQLL;
		W_GSLL = w_GSLL;
		W_GSWD = w_GSWD;
		W_GSYL = w_GSYL;
		W_SMQCKSW = w_SMQCKSW;
		W_PYWD = w_PYWD;
		W_LTYL = w_LTYL;
		W_QBYL = w_QBYL;
		W_QBSW = w_QBSW;
		W_CJSJ = w_CJSJ;
		State = state;
	}
	
	
	public int getGuoLuNum() {
		return GuoLuNum;
	}

	public void setGuoLuNum(int guoLuNum) {
		GuoLuNum = guoLuNum;
	}

	public double getW_ZQYL() {
		return W_ZQYL;
	}
	public void setW_ZQYL(double w_ZQYL) {
		W_ZQYL = w_ZQYL;
	}
	public double getW_ZQWD() {
		return W_ZQWD;
	}
	public void setW_ZQWD(double w_ZQWD) {
		W_ZQWD = w_ZQWD;
	}
	public double getW_ZQLL() {
		return W_ZQLL;
	}
	public void setW_ZQLL(double w_ZQLL) {
		W_ZQLL = w_ZQLL;
	}
	public double getW_GSLL() {
		return W_GSLL;
	}
	public void setW_GSLL(double w_GSLL) {
		W_GSLL = w_GSLL;
	}
	public double getW_GSWD() {
		return W_GSWD;
	}
	public void setW_GSWD(double w_GSWD) {
		W_GSWD = w_GSWD;
	}
	public double getW_GSYL() {
		return W_GSYL;
	}
	public void setW_GSYL(double w_GSYL) {
		W_GSYL = w_GSYL;
	}
	public double getW_SMQCKSW() {
		return W_SMQCKSW;
	}
	public void setW_SMQCKSW(double w_SMQCKSW) {
		W_SMQCKSW = w_SMQCKSW;
	}
	public double getW_PYWD() {
		return W_PYWD;
	}
	public void setW_PYWD(double w_PYWD) {
		W_PYWD = w_PYWD;
	}
	public double getW_LTYL() {
		return W_LTYL;
	}
	public void setW_LTYL(double w_LTYL) {
		W_LTYL = w_LTYL;
	}
	public double getW_QBYL() {
		return W_QBYL;
	}
	public void setW_QBYL(double w_QBYL) {
		W_QBYL = w_QBYL;
	}
	public double getW_QBSW() {
		return W_QBSW;
	}
	public void setW_QBSW(double w_QBSW) {
		W_QBSW = w_QBSW;
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

	public double getW_SMQJKSW() {
		// TODO Auto-generated method stub
		return W_SMQJKSW;
	}	
	public  void setW_SMQJKSW(double w_SMQJKSW) {
		// TODO Auto-generated method stub
		 W_SMQJKSW=w_SMQJKSW;
	}	
}
