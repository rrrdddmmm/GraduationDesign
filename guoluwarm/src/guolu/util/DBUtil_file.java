package guolu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil_file {
	
	private static Connection conn;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	/**
	 * 从任意类型配置文件读取JDBC的配置信息，包括DBdriver、url等。
	 */
	static{
		try{
			java.util.Properties prop=new java.util.Properties();
			/**读取配置文件内容，配置文件记录了数据库连接的信息包括driver、url等。
			 * 在本实例中，配置文件放在程序的跟目录下的config文件夹中。
			 */
			String path=new java.io.File("config"+
					java.io.File.separator+"database.cfg").getAbsolutePath();
			java.io.FileInputStream fin=new java.io.FileInputStream(path);
			prop.load(fin);
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			user=prop.getProperty("user");
			password=prop.getProperty("password");
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getconn(){
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//数据库连接
		return conn;
	}
	
	
	public static void closeconn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭数据库conn连接
	}
}
