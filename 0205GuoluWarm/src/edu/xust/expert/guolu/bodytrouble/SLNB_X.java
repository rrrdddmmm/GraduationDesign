package edu.xust.expert.guolu.bodytrouble;
import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.EachMembership;
import edu.xust.expert.guolu.Judge;
import edu.xust.expert.guolu.entity.Condition;
import edu.xust.expert.guolu.getData.SetConditionValues;

public class SLNB_X {
	double a[]=new double[8];
	//定义为本类的属性,存放的第i个对应置信度所占总置信度的百分比 
	//表中到时顺序务必和程序保持一致
	
	/*实现"水冷凝壁泄漏"获得总的前提置信度总和,计算每个置信度所占比例并
	 * 存入数组a[8]中以便函数getResult()使用
	 * 
	 * */
	 
	public double getrate(){
		SetConditionValues saValues = new SetConditionValues();
		//定义接收数据R_Condition，R_Result，R_CF的对象saValues
		//以便再后面调用获得数据函数setconditionValues(sql)
		List<Condition> cd1 = new ArrayList<Condition>();
		String sql = "SELECT * FROM GL_confidence WHERE R_Result ='水冷凝壁泄漏'";
		cd1 = saValues.setconditionValues(sql);
		//数据以集合的形式返回新的集合cd1,以便后面使用
		int i = 0;
		double sumRcf = 0;
		while (i < cd1.size()) {
			sumRcf += cd1.get(i).getR_CF();//'水冷凝壁泄漏各置信度的总和
			i++;
		}
		for(i=0;i<cd1.size();i++){
			if(cd1.get(i).getR_Condition().equals("QBSW")){
			a[i]=cd1.get(i).getR_CF()/sumRcf;
			//存放对应置信度所占总置信度的百分比
			}
		}
		return sumRcf;//返回'水冷凝壁泄漏各置信度的总和
	}
	
	double SLNB_X=0;
	public double getResult(){//计算'水冷凝壁泄漏'最终置信度函数
		
		EachMembership each = new EachMembership();
		SLNB_X=a[0]*each.getQBSWMembership()//气包水位下降
					+a[1]*each.getLTYLMembership()//炉膛压力上升
					+a[2]*each.getGSLLMembership()//给水流量增大
					+a[3]*(each.getPCDMembership())
					//考虑到负数需要增加取绝对值，待增加
					//给水流量和蒸汽流量偏差大getGSLL_PJZ()
					+a[4]*each.getPYWDMembership();//排烟温度下降
//		System.out.println("水冷凝壁泄漏的置信度="+SLNB_X);
		return SLNB_X;//返回最终置信度
	}
	
	
	
	
	public void  insert(int num){//将数据插入表中
		String flag=new Judge().judge(getResult());
		//调用评判函数:0安全1预警
		String sql="insert into GL_OutPut(Name,Number,Time,State,Remark,GUOLUNUM) values ('水冷凝壁泄漏',1,getdate(),"+getResult()+",'"+flag+"',"+num+")";
		MyDB.executeSql(sql);	
		//连接数据库将数据插入对于表中
	}
}
