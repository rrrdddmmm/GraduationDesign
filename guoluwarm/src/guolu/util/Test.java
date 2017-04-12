package guolu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	/**
	 * 测试DBUtil_file连接数据库
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/**
		 * DBUtil_Class利用配置类读取JDBC的配置信息
		 * DBUtil_properties利用properties属性文件读取JDBC的配置信息
		 * DBUtil_file从任意类型配置文件读取JDBC的配置信息
		 */
		 //link(DBUtil_properties.getconn());
		//
		
	}
	public static void link(Connection _conn){
		String Sql="select * from user_information";
			 if(_conn!=null){
				 System.out.println("success!!!");
				 Statement stmt;
				try {
					stmt = _conn.createStatement();
					ResultSet re= stmt.executeQuery(Sql);
					while(re.next()){
						System.out.println(re.getString("user_password"));
					}
					re.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					try {
						_conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			}
	}
}
