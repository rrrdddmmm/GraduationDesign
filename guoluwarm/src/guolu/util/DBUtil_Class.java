package guolu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 通过配置类配置连接数据库参数
 * @author RBB
 *
 */
public class DBUtil_Class {
	
	private static Connection conn;
	private static final String driver=
		"com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String url=
		"jdbc:sqlserver://localhost:1433;databaseName=boiler_falut";
	private static final String user="sa";
	private static final String password="123456";
	/**
	 * 驱动程序加载
	 */
	static{
		try {
			Class.forName(driver);
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
