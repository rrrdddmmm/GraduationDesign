package com.xkd.util;

import java.io.*;   
import java.nio.charset.Charset;
import java.sql.DriverManager;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.tools.*;   

import com.mysql.jdbc.Connection;
 

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//	            Configuration configuration = new PropertiesConfiguration(ScriptRunnerExecSql.class.getClassLoader().getResource("")
//	                    + "META-INF/spring/db.properties");
//	            String url = configuration.getString("jdbc.url");
//	            String driver = configuration.getString("jdbc.driver");
//	            String username = configuration.getString("jdbc.user");
//	            String password = configuration.getString("jdbc.password");
//
//	            Class.forName(driver).newInstance();
//	            Connection conn =(Connection) DriverManager.getConnection(url, username, password);
//	            ScriptRunner runner = new ScriptRunner(conn);
//	            Resources.setCharset(Charset.forName("GBK")); //设置字符集,不然中文乱码插入错误
//	            runner.setLogWriter(null);//设置是否输出日志
//	            runner.runScript(Resources.getResourceAsReader("sql/CC20-01.sql"));
//	            runner.runScript(Resources.getResourceAsReader("sql/CC21-01.sql"));
//	            runner.closeConnection();
//	            conn.close();

	}

}
