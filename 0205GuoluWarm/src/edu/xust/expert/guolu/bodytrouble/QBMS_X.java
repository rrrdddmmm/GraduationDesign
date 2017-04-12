package edu.xust.expert.guolu.bodytrouble;
import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.EachMembership;
import edu.xust.expert.guolu.Judge;
import edu.xust.expert.guolu.entity.Condition;
import edu.xust.expert.guolu.getData.SetConditionValues;

public class QBMS_X {
	double a[]=new double[8];
	public double getrate(){
		SetConditionValues saValues = new SetConditionValues();
		List<Condition> cd1 = new ArrayList<Condition>();
		String sql = "SELECT * FROM GL_confidence WHERE R_Result = '汽包满水故障'";
		cd1 = saValues.setconditionValues(sql);
		int i = 0;
		double sumRcf = 0;
		while (i < cd1.size()) {
			sumRcf += cd1.get(i).getR_CF();
			i++;
		}
		for(i=0;i<cd1.size();i++){
			//增加查找功能
			a[i]=cd1.get(i).getR_CF()/sumRcf;
		}
		return sumRcf;
	}
	double QBMS_X=0;
	public double getResult(){
		EachMembership each = new EachMembership();
//		QBMS_X=a[0]*each.getQBSW_upMembership()//气包水位上升
//		+a[1]*each.getQBSW_UPMembership()//汽包水位高
//		+a[2]*each.getPCDMembership()//给水流量与蒸汽流量偏差大
//		+a[3]*each.getGSLLMembership()//给水流量增大
//		+a[4]*each.getQBYLMembership()//汽包压力低
//		+a[5]*each.getZQWDxjMembership()//蒸汽温度下降
//		+a[6]*each.getZQYLMembership()//蒸汽压力下降
//		+a[7]*each.getQBSW_upMembership();//汽包水位上升
//	System.out.println("汽包满水故障的置信度="+QBMS_X);
		return each.getZQWDxjMembership();
	}
	public void  insert(int num){
		String flag=new Judge().judge(getResult());
		String sql="insert into GL_OutPut(Name,Number,Time,State,Remark,GUOLUNUM)values('汽包满水故障',3,getdate(),"+getResult()+",'"+flag+"',"+num+")";
		MyDB.executeSql(sql);	
	}	
	
}
