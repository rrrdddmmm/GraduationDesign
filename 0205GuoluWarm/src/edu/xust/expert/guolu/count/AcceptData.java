package edu.xust.expert.guolu.count;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.db.MyDB;
import edu.xust.warn.Core;
public class AcceptData {
	private static Logger log = LoggerFactory.getLogger(Core.class);
	//KeyFactor K1=new KeyFactor();
	int a[]=new int[20];
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
		//a[13]//1#蒸汽压力高停炉次数
		//a[14]//1#蒸汽压力高报警次数
		//a[15]//1#汽包液位高报警次数
		//a[16]//1#汽包液位低报警次数
		//a[17]//1#汽包液位低停炉次数
	int t;//统计的时间（150--270区域中的总时间：通过在区间内的次数加和即可得到大概的总秒数）
	String s;
	public AcceptData(){
		this.t=0;
	}
	public void datajieshou(){
		 try 
		    { /*
			   long now=System.currentTimeMillis();
			    Date date=new Date(now);
			    Calendar cal=new GregorianCalendar(); 
		        cal.setTime(date);//设置为当前时间
		        int  year=cal.get(Calendar.YEAR );
		        int month=cal.get(Calendar.MONTH )+1;
		        if(month==1){
		        	year=year-1;
		        	month=12;
		        }else{
		        	month=month-1;
		        }*/
		        //System.out.println(year);
		        //System.out.println(month);
			 	datatime D=new datatime();
		        int year=D.gateyear();
		        int month=D.gatemonth();
		        
			    String sql_faultalam="select * from GL_faultalam where  YEAR(TIME)="+year+" and  MONTH(TIME)="+month+" ";	
			    ResultSet re= MyDB.executeQuerySql(sql_faultalam);
				while(re.next())
				{
					if(re.getInt("PSJ_FAULT")==1){
						a[0]++;
						//破碎机故障次数
					}	
					if(re.getInt("GMJ_FAULT")==1){
						a[1]++;
						//？？？？？GMJ_FAULT
					}
					if(re.getInt("GMJ_FAULT")==1){
						a[2]++;
						//皮带机故障次数
					}
					if(re.getInt("GBJ_FAULT")==1){
						a[3]++;
						//刮板机故障次数
					}
					if(re.getInt("YFJ_FAULT")==1){
						a[4]++;
						//1#锅炉引风机故障次数
					}
					if(re.getInt("LPJ_FAULT")==1){
						a[5]++;//1#炉排机故障次数
					}
					if(re.getInt("GFJ_FAULT")==1){
						a[6]++;
						//1#炉鼓风机故障次
					}
					if(re.getInt("SB2_FAULT")==1){
						a[7]++;
						//2#水泵故障次数
					}
					if(re.getInt("SB1_FAULT")==1){
						a[8]++;
						//1#水泵故障次数
					}
					if(re.getInt("CZJ_FAULT")==1){
						a[9]++;
						////出渣机故障次数
					}
					if(re.getInt("RHSXYWDBJ")==1){
						a[10]++;
						//软化水箱液位低报警次数
					}
					if(re.getInt("CZJ_DZ")==1){
						a[11]++;
						////出渣机堵转次数
					}
					if(re.getInt("ZMXT_JT")==1){
						a[12]++;
						////输煤系统急停次数
					}
					if(re.getInt("ZQYLGTL")==1){
						a[13]++;//1#蒸汽压力高停炉次数
					}
					if(re.getInt("ZQYLG")==1){
						a[14]++;
						//1#蒸汽压力高报警次数
					}
					if(re.getInt("QBYWG")==1){
						a[15]++;
						//1#汽包液位高报警次数
					}
					if(re.getInt("QBYED")==1){
						a[16]++;
						//1#汽包液位低报警次数
					}
					if(re.getInt("QBYWDTL")==1){
						a[17]++;
						//1#汽包液位低停炉次数
						
					}
				}
				//for(int i=0;i<18;i++)
					//K1.d[i]=a[i];
				
				String sql_paiyant="select * from GL_MainBasicData where  YEAR(CJSJ)="+year+" and  MONTH(CJSJ)="+month+" ";			
				ResultSet PYWD= MyDB.executeQuerySql(sql_paiyant);
				while(PYWD.next())
					if((PYWD.getFloat("PYWD")>=150)&&(PYWD.getFloat("PYWD")<=270))
						t++;//满足条件温度的次数
				//t=t/24*3600;数据要达到一定值的前提下能测，真正测试时打开此换算    秒换算成天    
				String sql_insert="insert into GL_jingjixing_data(value,year,month) values("+t+","+year+","+month+")";
		        boolean flag=MyDB.executeSql(sql_insert); 
		        log.info(flag?"插入成功":"插入失败");  
		    }catch (Exception e) 
		    { 
		    	System.out.print("get data error!"); 
		    	e.printStackTrace(); 
		    } 
	}
}
	



