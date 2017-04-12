package edu.xust.expert.guolu.bodytrouble;

import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.EachMembership;
import edu.xust.expert.guolu.Judge;
import edu.xust.expert.guolu.entity.Condition;
import edu.xust.expert.guolu.getData.SetConditionValues;

public class QSGT_X {
	double a[]=new double[8];
	public double getrate(){
		SetConditionValues saValues = new SetConditionValues();
		List<Condition> cd1 = new ArrayList<Condition>();
		String sql = "SELECT * FROM GL_confidence WHERE R_Result = '汽水共腾'";
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
	double QSGT_X=0;
	public double getResult(){
		EachMembership each = new EachMembership();
		QSGT_X=a[0]*each.getQBSWMembership()/*求汽包水位下降的隶属值*/
				//汽包水位发生剧烈波动???????
			+a[1]*each.getZQYLMembership()//蒸汽压力下降
			+a[2]*each.getZQWDxjMembership();//蒸汽温度下降
//		System.out.println("汽水共腾的置信度="+QSGT_X);
		return QSGT_X;
	}
	public void  insert(int num){
		String flag=new Judge().judge(getResult());
		String sql="insert into GL_OutPut(Name,Number,Time,State,Remark,GUOLUNUM)values('汽水共腾',4,getdate(),"+getResult()+",'"+flag+"',"+num+")";
		MyDB.executeSql(sql);	
	}	
	
}
