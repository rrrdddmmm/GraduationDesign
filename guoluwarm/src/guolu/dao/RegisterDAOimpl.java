package guolu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.poolsample.ConnManager;
import dbutil.poolsample.ConnectionPool;
import guolu.entity.Registermodal;
import guolu.entity.Usermodal;
import guolu.util.Util_Competence;

public class RegisterDAOimpl implements RegisterDAO {

	/**
	 * 仅让本包内的类创建此对象
	 */
	RegisterDAOimpl(){}
	/**
	 * 注册时检查用户输入的用户名和密码是否有重复处理
	 * @param account
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 */
	public boolean checkAccount(String username)
			throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		Usermodal user=null;
		String Sql="select * from user_information where " +
				"user_name='"+username+"' ";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						user=new Usermodal();			
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
		//如果返回true说明可以注册，否则用户名密码重复
		if(user==null){
			return true;
		}else{
			return false;
		}	
	}

	/**
	 * 用户注册保存处理
	 * @param account
	 * @throws DAOException
	 */
	public void saveAccount(Registermodal modul)throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		String Sql="insert into user_information(user_name,user_password,user_email,user_competence) " +
				"values('"+modul.getUsername()+"','"+modul.getPasswd()+"','"+modul.getEmil()+
				"','"+Util_Competence.Competence(modul.getUsername())+"')";
		if(CONN!=null){//Util_Competence
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					stmt.executeUpdate(Sql);
					System.out.println("insert success!!!");
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw e;
				} finally{
					CONN.release();
				} 
			 }
		}
	}
}
