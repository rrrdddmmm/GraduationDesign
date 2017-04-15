package com.xkd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;




/**
 * 
 * @author RBB
 *
 */
public class MainTest {
/**
 * 
 * @param args
 */
	public static void main(String[] args){
//		//获取系统当前时间
//		SimpleDateFormat std=new SimpleDateFormat("yyyy");
//			//将字符串转换为Date格式
//		System.out.println(std.format(new Date()).toString());
//	System.out.println(Calendar.getInstance().getTimeInMillis());
//		try{
//			nn();
//		}catch(Exception e){
//			System.out.println("2");
//		}finally{
//			                                System.out.println("3");
//		}
//		
//	}
//	public static void nn()throws Exception{
//		try{
//			throw new Exception();
//		}finally{
//			System.out.println("1");
//		}
		ApplicationContext context=new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
		  JavaMailSenderImpl jmsi=(JavaMailSenderImpl)context.getBean("mailSender");
		  SimpleMailMessage smm=(SimpleMailMessage)context.getBean("mailMessage");
		  java.util.Properties pro=new java.util.Properties();
		  pro.put("mail.smtp.auth", "true");
		  jmsi.setJavaMailProperties(pro);
		  jmsi.send(smm);
	}
}
