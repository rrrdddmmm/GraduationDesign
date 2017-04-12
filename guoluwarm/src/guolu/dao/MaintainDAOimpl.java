package guolu.dao;

import guolu.entity.Machinemtmodal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dbutil.poolsample.ConnManager;
import dbutil.poolsample.ConnObject;
import dbutil.poolsample.ConnectionPool;

public class MaintainDAOimpl implements MaintainDAO {
	/**
	 * 仅在本包内创建对象，数据库对象改变了，写在构造函数中，当创建对象的时候就会改变数据库对象
	 */
	protected MaintainDAOimpl(){
		ConnObject.URLName="jdbc:sqlserver://localhost:1433;databaseName=equipment_maintenance_service";
	}
//	public static void main(String args[]) throws SQLException{
//		MaintainDAOimpl ss=new MaintainDAOimpl();
//		System.out.println("boiler_belt_machine:"+ss.Allpage(3, "boiler_belt_machine"));
//	}
	/**
	 * 获得总页数
	 * @return
	 * @throws SQLException 
	 * @throws SQLException 
	 * 点击班检是返回cycle=1、点击日检是返回cycle=2、
	 * 点击周检是返回cycle=3、点击月检是返回cycle=4、
	 * 点半年班检是返回cycle=5、点击年检是返回cycle=6
	 */
	public int Allpage(int perPageRows, String tablename,String cycle) throws SQLException {
		// TODO Auto-generated method stub
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		int t=0;
		String Sql="select * from "+tablename+"";
		if("1".equals(cycle)){
			Sql=Sql+" where inspect_cycle like '班检'";
		}else if("2".equals(cycle)){
			Sql=Sql+" where inspect_cycle like '日检'";
		}else if("3".equals(cycle)){
			Sql=Sql+" where inspect_cycle like '周检'";
		}else if("4".equals(cycle)){
			Sql=Sql+" where inspect_cycle like '月检'";
		}else if("5".equals(cycle)){
			Sql=Sql+" where inspect_cycle like '半年检'";
		}else if("6".equals(cycle)){
			Sql=Sql+" where inspect_cycle like '年检'";
		}else{
			System.out.println("按顺序输出");
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

	public boolean addinfor(Machinemtmodal modul) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		String Sql="insert into "+modul.getTablename()+"" +
				"(inspect_number,inspect_cycle,inspect_content)values('"
		+modul.getInspect_number()+"','"+modul.getInspect_cycle()+"','"+modul.getInspect_content()+"')";
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

	public boolean alterinfor(Machinemtmodal modul) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		String Sql="UPDATE "+modul.getTablename()+" SET inspect_cycle='"+modul.getInspect_cycle()+"' , inspect_content='"+modul.getInspect_content()+"' " +
						"WHERE inspect_number = '"+modul.getInspect_number()+"'";
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

	public boolean deleteinfor(String tablename, String faultNumber)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Machinemtmodal> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 分页查询类:根据以下三个参数实现指定页数的指定记录条数的查询
	 * @param Pags:页数从1开始
	 * @param perPageRows：每页显示的记录从0开始
	 * @param tablename：表名
	 * 击班检是返回cycle=1、点击日检是返回cycle=2、
	 * 点击周检是返回cycle=3、点击月检是返回cycle=4、
	 * 点半年班检是返回cycle=5、点击年检是返回cycle=6
	 * @return
	 * @throws SQLException 
	 */
	public List<Machinemtmodal> findPagedata(int Pags, int perPageRows,
			String tablename,String cycle) throws SQLException {
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		List<Machinemtmodal> list=new ArrayList<Machinemtmodal>();
		String Sql="select top "+perPageRows+" * from "+tablename+" " +
				"where ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" ORDER BY ID)";
		if("1".equals(cycle)){
			Sql=Sql+"and inspect_cycle='班检'";
		}else if("2".equals(cycle)){
			Sql="select top "+perPageRows+" * from "+tablename+" " +
			"where inspect_cycle='日检' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" where inspect_cycle='日检' ORDER BY ID)";
		}else if("3".equals(cycle)){
			Sql="select top "+perPageRows+" * from "+tablename+" " +
			"where inspect_cycle='周检' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" where inspect_cycle='周检' ORDER BY ID)";
		}else if("4".equals(cycle)){
			Sql="select top "+perPageRows+" * from "+tablename+" " +
			"where inspect_cycle='月检' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" where inspect_cycle='月检' ORDER BY ID)";
		}else if("5".equals(cycle)){
			Sql="select top "+perPageRows+" * from "+tablename+" " +
			"where inspect_cycle='半年检' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" where inspect_cycle='半年检' ORDER BY ID)";
		}else if("6".equals(cycle)){
			Sql="select top "+perPageRows+" * from "+tablename+" " +
			"where inspect_cycle='年检' and  ID not in(select top "+perPageRows*(Pags-1)+" ID from "+tablename+" where inspect_cycle='年检' ORDER BY ID)";
		}else{
			System.out.println("按顺序输出");
		}
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						Machinemtmodal modul=new Machinemtmodal();
						modul.setInspect_number(re.getString("inspect_number"));
						
						modul.setInspect_cycle(re.getString("inspect_cycle"));
						modul.setInspect_content(re.getString("inspect_content"));
						modul.setTablename(tablename);
						System.out.println(modul);
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
	public Machinemtmodal findonedata(String tablename, String falutNumber)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
