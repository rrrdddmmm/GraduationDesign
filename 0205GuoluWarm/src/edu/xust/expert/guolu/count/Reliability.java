/*package edu.xust.expert.count;
import java.sql.SQLException;
import java.util.Scanner;
public class Reliability {
	double q[]=new double[18];
	double F_kekaodu;
	//a[0]////破碎机故障次数
	//a[1]//？？？？？
	//a[2]//皮带机故障次数
	//a[3]//刮板机故障次数
	//a[4]//1#蒸汽压力高停炉次数
	//a[5]//1#蒸汽压力高报警次数
	//a[6]//1#锅炉引风机故障次数
	//a[7]//1#汽包液位高报警次数
	//a[8]//1#汽包液位低报警次数
	//a[9]//1#汽包液位低停炉次数
	//a[10]//1#炉鼓风机故障次数
	//a[11]//1#炉排机故障次数
	//a[12]//1#水泵故障次数
	//a[13]//软化水箱液位低报警次数
	//a[14]//2#水泵故障次数
	//a[15]////出渣机故障次数
	//a[16]////出渣机堵转次数
	//a[17]////输煤系统急停次数
	Reliability(){
		F_kekaodu=0;
	}
	void kekaodu()throws SQLException{
		AcceptData w1 = new AcceptData();
		w1.datajieshou();
		for(int i=0;i<18;i++)
			F_kekaodu+=Math.pow(2.7183,-w1.a[i]);//系统可靠度a[12]   a[14]特殊
		//for(int i=0;i<18;i++)
			//F_kekaodu+=q[i];//系统可靠度????换算成百分百比？？？
		//F_kekaodu=F_kekaodu/18;
		if(F_kekaodu>10)
			System.out.println("相当安全");
		//if(F_kekaodu>10)
		//	System.out.println(F_kekaodu);
		//if(F_kekaodu>10)
		//	System.out.println(F_kekaodu);
		//if(F_kekaodu>10)
		//	System.out.println(F_kekaodu);
		System.out.println(F_kekaodu);
	}
}*/
package edu.xust.expert.guolu.count;
import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.db.MyDB;


public class Reliability {
	private static Logger log = LoggerFactory.getLogger(Reliability.class);
	private static final String JINGJINXINGDATA = null;
	float q[]=new float[15];//单元可靠度
	//float q1[]=new double[15];
	float F_kekaodu;
		//a[0]////破碎机故障次数
		//a[1]//？？？？？
		//a[2]//皮带机故障次数
		//a[3]//刮板机故障次数
		//a[4]//1#锅炉引风机故障次数
		//a[5]//1#炉排机故障次数
		//a[6]//1#炉鼓风机故障次数
		//a[7]//2#水泵故障次数
		//a[8]//1#水泵故障次数虑
		//a[9]////出渣机故障次数
		//a[10]//软化水箱液位低报警次数
		//a[11]////出渣机堵转次数
		//a[12]////输煤系统急停次数
		//a[13]//1#蒸汽压力高停炉次数//合并 13  14
		//a[14]//1#蒸汽压力高报警次数//
		//a[15]//1#汽包液位高报警次数//合并15  16  17
		//a[16]//1#汽包液位低报警次数//
		//a[17]//1#汽包液位低停炉次数//
	public Reliability(){
		F_kekaodu=0;
	}

	public float kekaodu()throws SQLException{
		
		AcceptData w1 = new AcceptData();
		w1.datajieshou();
		for(int i=0;i<13;i++)
			q[i]=(float) Math.pow(2.7183,-w1.a[i]);
		
		q[13]=(float) Math.pow(2.7183,-(w1.a[13]+w1.a[14]));//e的负次数指数
		//q1[5]=Math.pow(2.7183,-(w1.a[6]));
		q[14]=(float) Math.pow(2.7183,-(w1.a[15]+w1.a[16]+w1.a[17]));
		//单元可靠度
				//a[0]////破碎机单元可靠度
				//q[1]//？？？？？单元可靠度
				//q[2]//皮带机单元可靠度
				//q[3]//刮板机单元可靠度
				//q[4]//1#锅炉单元可靠度
				//q[5]//1#炉排机单元可靠度
				//q[6]//1#炉鼓风机单元可靠度
				//q[7]//2#水泵单元可靠度
				//q[8]//1#水泵单元可靠度
				//q[9]////出渣机单元可靠度
				//q[10]//软化水箱液位低报警单元可靠度
				//q[11]////出渣机堵转单元可靠度
				//q[12]////输煤系统急停单元可靠度
				//q[13]//1#蒸汽压力高停炉单元可靠度//合并 a[13]  a[14]
				//q[14]//1#蒸汽压力高报警单元可靠度//合并 a[15]  a[16]  a[17]
		
		//for(int i=0;i<18;i++)
			//q[i]=Math.pow(2.7183,-w1.a[i]);//系统可靠度a[12]   a[14]特殊
		for(int i=0;i<15;i++)//本系统需要
		{
			if(q[i]>=50/15);
				//System.out.println("相当安全");
			if(q[i]>=40/15 && F_kekaodu<50/15);
				//System.out.println("安全");
			if(q[i]>=20/15 && F_kekaodu<40/15);
				//System.out.println("一般安全");
			if(q[i]<20/15);
				//System.out.println("差");
		}
		for(int i=0;i<15;i++)
			F_kekaodu+=q[i];//系统可靠度????换算成百分百比？？？
		//F_kekaodu=F_kekaodu/18;
		System.out.println(F_kekaodu);
		if(F_kekaodu>=50)
			System.out.println("相当安全");//
		if(F_kekaodu>=40&&F_kekaodu<50)
			System.out.println("安全");//
		if(F_kekaodu>=20&&F_kekaodu<40)
			System.out.println("一般安全");//
		if(F_kekaodu<20)
			System.out.println("差");//
		return F_kekaodu;
	}
	public void ff(){
		//int m=F_kekaodu;
		datatime a1=new datatime();
		int year=a1.gateyear();
		int month=a1.gatemonth();
		try{
			String sql_insert="insert into GL_kekaodu_data(value,year,month,bh) values("+kekaodu()+","+year+","+month+",1)";
		    boolean flag=MyDB.executeSql(sql_insert); 
		    log.info(flag?"插入成功":"插入失败");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
}

