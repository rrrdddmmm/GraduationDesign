package edu.xust.expert.guolu.count;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.db.MyDB;
public class KeyFactor {
	private static Logger log = LoggerFactory.getLogger(Reliability.class);
	private static final String JINGJINXINGDATA = null;
	double zonggong;
	double p;//顶事件概率
	double p1;
	double b[]=new double[18];
	double c[]=new double[18];
	//int d[]=new int[18];
	double x;
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
		//a[13]//1#蒸汽压力高停炉次数//不考虑
		//a[14]//1#蒸汽压力高报警次数//不考虑
		//a[15]//1#汽包液位高报警次数//不考虑
		//a[16]//1#汽包液位低报警次数//不考虑
		//a[17]//1#汽包液位低停炉次数//不考虑
	
	
	//c[0]////破碎机关键重要度
	//c[1]//？？？？？关键重要度
	//c[2]//皮带机关键重要度
	//c[3]//刮板机关键重要度
	//c[4]//1#锅炉引风机关键重要度
	//c[5]//1#炉排机关键重要度
	//c[6]//1#炉鼓风机故障关键重要度
	//c[7]//2#水泵故障关键重要度
	//c[8]//1#水泵故障关键重要度
	//c[9]////出渣机故障关键重要度
	//c[10]//软化水箱液位低报警关键重要度
	//c[11]////出渣机堵转关键重要度
	//c[12]////输煤系统急停关键重要度
	//将C[1],C[2],C[3]......放入表中
	//System.out.println("关键"+k+":"+c[k]);
	//System.out.println(c[k]);
//public void ff(){
	//k++;
	public KeyFactor()
	{
		p1=1;
		zonggong=0;
	}
	public void guanianzhongyaodu() throws SQLException
	{
		AcceptData A1 = new AcceptData();
		A1.datajieshou();
		
		for(int m=0;m<13;m++)
			zonggong+=A1.a[m];//总次数
		
		//System.out.println(zonggong);
		for(int n=0;n<13;n++)
		{
			c[n]=A1.a[n]/zonggong;//各基本事件概率//故障率
			//实现锅炉故障率数据的插入
		//System.out.println(c[n]);
		}
		//利用顶事件 相交，或的公式 求出顶事件概率   55--60行
		//偏导公式是通过65行  
		x=c[7]*c[8];//考虑到两个水泵相交       水泵发生故障概率
		
		for(int i=0;i<13;i++)
			p1*=(1-c[i]); //中间数组变量
		p1=(p1/((1-c[7])*(1-c[8])))*(1-x);//考虑到两个水泵相交
		p=1-p1;//顶事件概率
		//System.out.println(p1);
		for(int i=0;i<13;i++){
			b[i]=p1/(1-c[i]);//结构重要度   求偏导
		
		}
		b[7]=(p1/(1-x))*b[8];//考虑到两个水泵相交
		b[8]=(p1/(1-x))*b[7];//考虑到两个水泵相交
		for(int k=0;k<13;k++){
			c[k]=c[k]/p;
			datatime a1=new datatime();
			int year=a1.gateyear();//调用函数实现获取年
			int month=a1.gatemonth();//调用函数实现获取月
			try{
				String sql_insert="insert into GL_gjzyd_data(value,year,month,bh)"
						+ " values("+c[k]+","+year+","+month+","+k+")";
			    boolean flag=true;
			    //MyDB.executeSql(sql_insert); 
			    log.info(flag?"插入成功"+k:"插入失败");
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
	}
}

