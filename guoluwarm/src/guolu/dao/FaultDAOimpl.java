package guolu.dao;

import guolu.entity.Machinefaultmodal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.poolsample.ConnManager;
import dbutil.poolsample.ConnectionPool;
/**
 * 实现从subject表将数据提取、处理、打包最终返回给控制层
 * 查询所有记录。
 * @author RBB
 *
 */
public class FaultDAOimpl implements FaultDAO {
	/**
	 * 查询所有记录
	 */
	public List<Machinefaultmodal> findAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}
	/**
	 * 更通用不受表以及列的约束
	 * 获得tablename表的fault_Number所有数据，为生成唯一编号服务
	 */
	public List<String> findAllnum(String tablename,String fault_Number)throws SQLException{
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		List<String> list=new ArrayList<String>();
		String Sql="select "+fault_Number+" from "+tablename+"";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						list.add(re.getString(""+fault_Number+""));
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
	 * 
	 * @param modul
	 * @return
	 * @throws SQLException
	 */
	public boolean alterone(String Sql)throws SQLException {
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
	 * 修改信息：根据接收的数据修改信息：根据判空来确定选择是修改故障原因还是故障处理对策
	 */
	public boolean alterinfor(Machinefaultmodal modul)throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		String Sql="UPDATE "+modul.getTablename()+" SET falut_cause = '"+modul.getFalut_cause()+"' ," +
				" falut_type='"+modul.getFalut_type()+"' , falut_handle='"+modul.getFalut_handle()+"' " +
						"WHERE falut_Number = '"+modul.getFalut_Number()+"'";
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
	 * 根据接收的信息确定到表的记录行后删除该行信息然后
	 * 将数据库该行记录以后的所有fault_Number记录均重新生成
	 */
	public boolean deleteinfor(String tablename, String faultNumber)throws SQLException {
		// TODO Auto-generated method stub
		return false ;
	}
	/**
	 * 将传入的数据添加到数据库fault_Number自动生成
	 */
	public boolean addinfor(Machinefaultmodal modul) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		String Sql="insert into "+modul.getTablename()+"" +
				"(falut_type,falut_cause,falut_handle,falut_Number)values('"
		+modul.getFalut_type()+"','"+modul.getFalut_cause()+"','"+modul.getFalut_handle()+"','"+modul.getFalut_Number()+"')";
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
	 * 获得总页数
	 * @return
	 * @throws SQLException 
	 */
	public int Allpage(int perPageRows, String tablename) throws SQLException {
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		int t=0;
		String Sql="select * from "+tablename+"";
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
	 * 分页查询类:根据以下三个参数实现指定页数的指定记录条数的查询
	 * @param Pags:页数从1开始,当前页
	 * @param perPageRows：每页显示的记录从0开始，每页显示的数据量
	 * @param tablename：表名
	 * @return
	 * @throws SQLException 
	 */
	public List<Machinefaultmodal> findPagedata(int Pags, int perPageRows,
			String tablename) throws SQLException {
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		List<Machinefaultmodal> list=new ArrayList<Machinefaultmodal>();
		String Sql="select top "+perPageRows+" * from "+tablename+" " +
				"where ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" ORDER BY ID)";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						Machinefaultmodal modul=new Machinefaultmodal();
						modul.setFalut_type(re.getString("falut_type"));
						modul.setFalut_cause(re.getString("falut_cause").substring(0, 3)+"......");
						modul.setFalut_handle(re.getString("falut_handle").substring(0, 3)+"......");
						modul.setID(re.getInt("ID"));
						modul.setFalut_Number(re.getString("falut_Number"));
						list.add(modul);
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
	 * 根据表名、故障编号定位到一个数据库的某条记录
	 */
	public Machinefaultmodal findonedata(String tablename, String falutNumber)
			throws SQLException {
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		Machinefaultmodal modul=null;
		String Sql="select  * from "+tablename+" where falut_Number='"+falutNumber+"'";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						modul=new Machinefaultmodal();
						modul.setFalut_type(re.getString("falut_type"));
						modul.setFalut_cause(re.getString("falut_cause"));
						modul.setFalut_handle(re.getString("falut_handle"));
						modul.setID(re.getInt("ID"));
						modul.setFalut_Number(re.getString("falut_Number"));
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
		return modul;
	}
}
