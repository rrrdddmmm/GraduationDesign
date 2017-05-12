package com.xkd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
//java程序控制tomcat启动
//@author FKZ
//如不能运行，请正确配置tomcat环境

public class Appliaction{
  public void close() throws IOException{
  Process process = Runtime.getRuntime().exec("cmd /c  D:\\apache-tomcat-7.0.16\\bin\\shutdown.bat"); // 调用外部程序
    final InputStream in = process.getInputStream();
    BufferedReader br=new BufferedReader(new InputStreamReader(in));
    StringBuilder buf = new StringBuilder();
    String line = null;
    while((line = br.readLine()) != null) buf.append(line);
    System.out.println("输出结果为：" + buf);
 }
 public void start() throws IOException{
    Process process = Runtime.getRuntime().exec("cmd /c  E:\\apache-tomcat-6.0.41\\bin\\startup.bat"); // 调用外部程序
    final InputStream in = process.getInputStream();
    BufferedReader br=new BufferedReader(new InputStreamReader(in));
    StringBuilder buf = new StringBuilder();
    String line = null;
    while((line = br.readLine()) != null)
    buf.append(line);
    System.out.println("输出结果为：" + buf);
 }
 public static void main(String[] args) throws Exception{
  // TODO Auto-generated method stub
	 Appliaction con=new Appliaction();
	 con.start();
 
 }
}