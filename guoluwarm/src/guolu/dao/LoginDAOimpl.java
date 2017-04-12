package guolu.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.poolsample.ConnManager;
import dbutil.poolsample.ConnectionPool;

import guolu.entity.Usermodal;

public class LoginDAOimpl implements LoginDAO {
	/**
	 * 仅让本包内的类创建此对象
	 */
	LoginDAOimpl(){}
	/**
	 * 实现用户登陆处理
	 * 如果发生DAOException异常没有找到
	 * 如果发生SQLException异常则连接数据库异常
	 * @throws SQLException 
	 */
	public Usermodal finduserinfo(String username, String passwd,String competence) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		Usermodal user=null;
		String Sql="select * from user_information where " +
				"user_name='"+username+"' and " +
		"user_password='"+passwd+"' and user_competence='"+competence+"'";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						user=new Usermodal();			
						user.setUser_competence(re.getString("user_competence"));
						user.setUser_email(re.getString("user_email"));
						user.setUser_ID(re.getInt("user_ID"));
						user.setUser_name(username);
						user.setUser_password(passwd);
					}
					re.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw e;
				} finally{
					CONN.release();
				} 
			 }
		}
		return user;
	}
	
	/**
	 * 找回密码
	 */
	public Usermodal SearchPasswd(int ID) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
