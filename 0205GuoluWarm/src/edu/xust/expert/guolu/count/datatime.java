package edu.xust.expert.guolu.count;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class datatime {//获取系统上一月的系统时间
	int year;
	int month;
	int gateyear()//获取上一月的year函数
	{
		long now=System.currentTimeMillis();
	    Date date=new Date(now);
	    Calendar cal=new GregorianCalendar(); 
        cal.setTime(date);//设置为当前时间
        int  year=cal.get(Calendar.YEAR );
        int month=cal.get(Calendar.MONTH )+1;
        if(month==1){//若是今年一月则返回去年12月
        	year=year-1;
        	month=12;
        }else{
        	month=month-1;
        }
        return year;
	}
	int gatemonth()//获取上一月的month函数
	{
		long now=System.currentTimeMillis();
	    Date date=new Date(now);
	    Calendar cal=new GregorianCalendar(); 
        cal.setTime(date);//设置为当前时间
        int  year=cal.get(Calendar.YEAR );
        int month=cal.get(Calendar.MONTH )+1;
        if(month==1){//若是今年一月则返回去年12月
        	year=year-1;
        	month=12;
        }else{
        	month=month-1;
        }
        return month;
	}
	

}
