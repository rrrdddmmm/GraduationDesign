package com.xkd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDealwith {
/**
 * 获取系统当前时间
 * @return
 */
	public static Date getCurrDate(){
		//获取系统当前时间
		SimpleDateFormat std=new SimpleDateFormat("yyyy-MM-dd");
			//将字符串转换为Date格式
		Date date=null;
			 try {
				date=std.parse(std.format(new Date()).toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//给定格式和参数格式要统一不然就会抛出异常
			return date;
	}
	/**
	 * 获取系统当前年份
	 * @return
	 */
		public static String getCurrYear(){
			//获取系统当前时间
			SimpleDateFormat std=new SimpleDateFormat("yyyy");
				//将字符串转换为Date格式
			System.out.println(std.format(new Date()).toString());
			return std.format(new Date()).toString();
		}
		/**
		 * 获取两时间差
		 * @throws ParseException 
		 */
		public static void getshijiancha() throws ParseException{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date now = df.parse(df.format(new Date()).toString());
			java.util.Date date=df.parse("2004-01-02 11:30:24");
			long l=now.getTime()-date.getTime();
			long day=l/(24*60*60*1000);
			long hour=(l/(60*60*1000)-day*24);
			long min=((l/(60*1000))-day*24*60-hour*60);
			long s=(l/1000-day*24*60*60-hour*60*60-min*60);
			System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
		}
		
}
