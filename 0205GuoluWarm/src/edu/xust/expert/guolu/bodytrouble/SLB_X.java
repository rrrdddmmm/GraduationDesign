package edu.xust.expert.guolu.bodytrouble;

import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.EachMembership;
import edu.xust.expert.guolu.Judge;
import edu.xust.expert.guolu.entity.Condition;
import edu.xust.expert.guolu.getData.SetConditionValues;

public class SLB_X {
	double a[]=new double[8];
	public double getrate(){
		SetConditionValues saValues = new SetConditionValues();
		List<Condition> cd1 = new ArrayList<Condition>();
		String sql = "SELECT * FROM GL_confidence WHERE R_Result = '水冷壁结焦'";
		cd1 = saValues.setconditionValues(sql);//连接数据库并取数据R_Condition，R_Result，R_CF
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
	double SLB_X=0;
	public double getResult(){
		EachMembership each = new EachMembership();
		SLB_X=a[0]*each.getPYWDMembership()
			+a[1]*each.getZQYLMembership()
			+a[2]*each.getZQWDMembership()
			+a[3]*each.getQBYLMembership()
			+a[4]*each.getZQLLMembership();
//		System.out.println("水冷壁结焦的置信度="+SLB_X);
		return SLB_X;
	}
	public void  insert(){
		String flag=new Judge().judge(getResult());
		String sql="insert into GL_OutPut(Name,Number,State)values('水冷壁结焦',2,"+flag+")";
		MyDB.executeSql(sql);	
	}	
	
}
