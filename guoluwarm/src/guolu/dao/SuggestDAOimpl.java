package guolu.dao;

import guolu.entity.Adviceinfomodal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.poolsample.ConnManager;
import dbutil.poolsample.ConnectionPool;

public class SuggestDAOimpl implements SuggestDAO {
	//只让本包内创建对象
	protected SuggestDAOimpl(){}
	/**
	 * 获得总页数
	 * @return
	 * @throws SQLException 
	 */
	public int Allpage(int perPageRows, String flag) throws SQLException {
		// TODO Auto-generated method stub
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		String Sql="select * from suggest where tablename not like 'boiler%'";
		int t=0;
		if("boiler".equals(flag)){
			Sql="select * from suggest where tablename like 'boiler%'";
		}
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						t++;
					}
					System.out.println("qqqqqqqqqq"+t);
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
		if(t%perPageRows==0){
			return t/perPageRows;
		}else{
			return t/perPageRows+1;
		}
	}
	/**
	 * 添加信息
	 * @param modul
	 * @return
	 * @throws SQLException
	 */
	public boolean addinfor(Adviceinfomodal modul) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		String Sql="insert into suggest(username,tablename,number,keyword,text,state)values('"+modul.getUsername()+"','"+modul.getTablename()+"','"+modul.getNumber()+"','"+modul.getKeyword()+"','"+modul.getText()+"','"+modul.getState()+"')";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					stmt.executeUpdate(Sql);
					stmt.close();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw e;
				} finally{
					CONN.release();
				} 
			 }
		}
		return false;
	}
	/**
	 * 对建议反馈表进行状态改变
	 * @param modul
	 * @return
	 * @throws SQLException
	 */
	public boolean alteroneinfor(Adviceinfomodal modul) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					stmt.executeUpdate("UPDATE suggest SET state = '是' WHERE number = '"+modul.getNumber()+"' and tablename='"+modul.getTablename()+"'");
					stmt.close();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw e;
				} finally{
					CONN.release();
				} 
			 }
		}
		return false;
	}
	/**
	 * 修改信息处理接口
	 * @return
	 * @throws SQLException
	 */
	public boolean alterinfor(Adviceinfomodal modul) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 删除信息处理接口
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteinfor(String tablename, int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	/*
	 * 查找表中全部数据
	 */
	public List<Adviceinfomodal> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 分页查询类:根据以下三个参数实现指定页数的指定记录条数的查询
	 * @param Pags:页数从1开始
	 * @param perPageRows：每页显示的记录从0开始
	 * @param flag：标记获取哪个数据，维修保养建议、故障知识建议
	 * @return
	 * @throws SQLException 
	 */
	public List<Adviceinfomodal> findPagedata(int Pags, int perPageRows,
			String flag) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		List<Adviceinfomodal> list=new ArrayList<Adviceinfomodal>();
		String Sql=null;
		if("boiler".equals(flag)){
			Sql="select top "+perPageRows+" * from suggest " +
			"where tablename like 'boiler%' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from suggest where tablename like 'boiler%' ORDER BY ID)";
		}else{
			Sql="select top "+perPageRows+" * from suggest " +
			"where tablename not like 'boiler%' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from suggest where tablename not like 'boiler%' ORDER BY ID)";
		}
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						Adviceinfomodal dd=new Adviceinfomodal();
						dd.setNumber(re.getString("number"));
						dd.setKeyword(re.getString("keyword"));
						dd.setState(re.getString("state"));
						dd.setTablename(re.getString("tablename"));
						dd.setText(re.getString("text"));
						dd.setUsername(re.getString("username"));
						list.add(dd);
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
		return list;
	}
	/**
	 * 查找表中某条数据
	 */
	public Adviceinfomodal findone(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
