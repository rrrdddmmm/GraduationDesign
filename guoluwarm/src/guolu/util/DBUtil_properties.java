package guolu.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil_properties {

	private static Connection conn;
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	/**
	 * 利用properties属性文件配置连接数据库
	 */
	static{
		Properties props=new Properties();
		try {
			props.load(DBUtil_properties.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			user=props.getProperty("user");
			password=props.getProperty("password");
			Class.forName(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
	
	public static void closeconn(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//关闭数据库conn连接
	}
}
