package edu.xust.expert.guolu.bodytrouble;

import java.util.ArrayList;
import java.util.List;



import edu.xust.db.MyDB;
import edu.xust.expert.guolu.EachMembership;
import edu.xust.expert.guolu.Judge;
import edu.xust.expert.guolu.entity.Condition;
import edu.xust.expert.guolu.getData.SetConditionValues;

public class SMQG_X {
	double a[]=new double[8];
	public double getrate(){
		SetConditionValues saValues = new SetConditionValues();
		List<Condition> cd1 = new ArrayList<Condition>();
		String sql = "SELECT * FROM GL_confidence WHERE R_Result = '省煤气罐泄漏'";
		cd1 = saValues.setconditionValues(sql);
		int i = 0;
		double sumRcf = 0;
		while (i < cd1.size()) {
			sumRcf += cd1.get(i).getR_CF();
			i++;
		}
		for(i=0;i<cd1.size();i++){
			a[i]=cd1.get(i).getR_CF()/sumRcf;
		}
		return sumRcf;
	}
	double SMQG_X=0;
	public double getResult(){
		EachMembership each = new EachMembership();
		SMQG_X=a[0]*each.getLTYLMembership()/*求炉膛压力上升的隶属值ֵ*/
			+a[1]*each.getQBSWMembership()/*求汽包水位下降的隶属值*/
			+a[2]*each.getGSLLMembership()/*求给水流量增大的隶属值ֵ*/
			+a[3]*each.getPYWDMembership()/*求排烟温度下降的隶属值ֵ*/
			+a[4]*(each.getPCDMembership());/*求给水流量与蒸汽流量偏差大的隶属值*/
//		System.out.println("省煤气罐泄漏的置信度="+SMQG_X);
		return SMQG_X;
	}
	public void  insert(int num){
		String flag=new Judge().judge(getResult());
		String sql="insert into GL_OutPut(Name,Number,Time,State,Remark,GUOLUNUM)values('省煤气罐泄漏',6,getdate(),"+getResult()+",'"+flag+"',"+num+")";
		MyDB.executeSql(sql);	
	}	
}
