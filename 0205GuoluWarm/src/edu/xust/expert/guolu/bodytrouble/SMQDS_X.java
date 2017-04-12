package edu.xust.expert.guolu.bodytrouble;

import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.EachMembership;
import edu.xust.expert.guolu.Judge;
import edu.xust.expert.guolu.entity.Condition;
import edu.xust.expert.guolu.getData.SetConditionValues;

public class SMQDS_X {
	double a[]=new double[8];
	public double getrate(){
		SetConditionValues saValues = new SetConditionValues();
		List<Condition> cd1 = new ArrayList<Condition>();
		String sql = "SELECT * FROM GL_confidence WHERE R_Result = '省煤器堵塞'";
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
	double SMQDS_X =0;
	public double getResult(){
		
		EachMembership each = new EachMembership();
		SMQDS_X =a[0]*each.getSMQJCKSWMembership()/*求省煤器进出口水温偏差大的隶属值ֵ*/
			+a[1]*each.getGSYLMembership()///*求给水压力增加的隶属值ֵ*/
			+a[2]*each.getQBYLXJMembership();/*求汽包压力下降的隶属ֵ*/
		System.out.println("省煤器堵塞的置信度="+SMQDS_X);
		return SMQDS_X ;
	}
	public void  insert(int num){
		String flag=new Judge().judge(getResult());
		String sql="insert into GL_OutPut(Name,Number,Time,State,Remark,GUOLUNUM)values('省煤器堵塞',5,getdate(),"+getResult()+",'"+flag+"',"+num+")";
		MyDB.executeSql(sql);	
	}	
	
}
