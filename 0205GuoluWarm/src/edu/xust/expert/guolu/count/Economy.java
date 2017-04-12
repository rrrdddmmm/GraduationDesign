package edu.xust.expert.guolu.count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.db.MyDB;
public class Economy {//本方法基于每秒来一次数据
	private static Logger log = LoggerFactory.getLogger(Reliability.class);
	public void fenglei(){
		//int m=F_kekaodu;
		AcceptData a=new AcceptData();
		datatime a1=new datatime();
		int year=a1.gateyear();
		int month=a1.gatemonth();
		try{
			String sql_insert="insert into GL_jingjixing_data(value,year,month,bh) values("+a.t+","+year+","+month+",1)";
		    boolean flag=MyDB.executeSql(sql_insert); 
		    log.info(flag?"插入成功":"插入失败");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
}
