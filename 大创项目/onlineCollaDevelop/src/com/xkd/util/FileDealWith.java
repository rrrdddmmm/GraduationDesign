package com.xkd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileDealWith {
	 /**
	  * 该方法实现配置一个property文件属性
	  * @param key 需设置的键
	  * @param value 键对应的值
	  */
	 public static void setProperties(String key, String value) {
	  FileOutputStream outStream = null;
	  File file = null;
	  try {
	   //读取文件
	   file = new File("config/properties.properties");
	   //判断文件是否存在，不存在则创建一个properties属性文件
	   if(!file.exists()){
	    file.createNewFile();
	   }
	   //声明并实例化一个properties对象
	   Properties  properties = new Properties();
	   //使用setter方法设置键值对 key value
	   properties.setProperty(key, value);
	   //实例化输出流对象
	   outStream = new FileOutputStream(file);
	   //使用store方法将properties送到输入流
	   properties.store(outStream, null);
	  } catch (FileNotFoundException e) {
	   // TODO 自动生成 catch 块
	   e.printStackTrace();
	  } catch (IOException e) {
	   // TODO 自动生成 catch 块
	   e.printStackTrace();
	   //确保出异常之前把流关闭
	  }finally{
	   try {
	    //关闭流文件
	    //判断流是否打开
	    if(outStream != null){
	     outStream.close();
	    } 
	   } catch (IOException e) {
	    // TODO 自动生成 catch 块
	    e.printStackTrace();
	   }
	  }
	 }
	 /**
	  * 通过键来查询对应的值
	  * @param key 键
	  * @return value的值是key对应的值
	  */
	 public static String getProperties(String key) {
	  FileInputStream inStream = null;
	  File file = null;
	  String value = null;  
	  try {
	   //读取文件
	   file = new File("config/properties.properties");
	   //判断文件是否存在，不存在则返回
	   if(!file.exists()){
	    return value = "2013/01/02 14:36:00";
	   }
	   //将文件读取到输入流
	   inStream = new FileInputStream(file);
	   //声明并实例化一个properties对象
	   Properties  properties = new Properties();
	   //使用properties类中load方法将io流内容导入
	   properties.load(inStream);
	   //根据键使用geter方法得到值，并将值赋值给value
	   value = properties.getProperty(key);
	  } catch (FileNotFoundException e) {
	   // TODO 自动生成 catch 块
	   e.printStackTrace();
	  } catch (IOException e) {
	   // TODO 自动生成 catch 块
	   e.printStackTrace();
	   //确保程序出异常能保证流的关闭
	  }finally{
	   try {
	   // 关闭输入流 
	    //判断流是否打开
	    if(inStream != null){
	     inStream.close();
	    } 
	   } catch (IOException e) {
	    // TODO 自动生成 catch 块
	    e.printStackTrace();
	   }
	  }
	  //返回value值
	   return value;
	 }
}
