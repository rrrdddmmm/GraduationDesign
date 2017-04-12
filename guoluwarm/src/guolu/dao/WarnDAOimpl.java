package guolu.dao;

import guolu.entity.GuoluSearchmodul;
import guolu.entity.Nanlaingdatamodal;
import guolu.entity.EvaluateResult;
import guolu.entity.WarmResult;
import guolu.util.DBUtil_numchar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.poolsample.ConnManager;
import dbutil.poolsample.ConnectionPool;

public class WarnDAOimpl implements WarnDAO {
	/**
	 * 获取南梁锅炉主体设备时时数据存放在集合中
	 * 时间和数据对应
	 * @param modul：从界面获取的参数，以确定哪一个锅炉的哪个设备的数据
	 * @return
	 * @throws SQLException 
	 */
	public List<Nanlaingdatamodal> findnanliangdata(GuoluSearchmodul modul) throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		List<Nanlaingdatamodal> list=new ArrayList<Nanlaingdatamodal>();
		String Sql="select * from GL_MainBasicData where GUOLUNUM = "+modul.getGuoluid()+" ORDER BY CJSJ desc";
		
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					int i=0;
					while(re.next()){
						i++;
						Nanlaingdatamodal dd=new Nanlaingdatamodal();
						dd.setTime(re.getDate("CJSJ").toString());
						dd.setDate(""+i+"");//re.getDate("CJSJ").toString()+"-"+re.getTime("CJSJ").toString()
						dd.setValue(re.getFloat(modul.getRowname()));
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
	 * 查找预警数据一条数据
	 * @return
	 */
	public List<WarmResult> findwarnresultone(int ID){
		return null;
		
	}
	/**
	 * 查找预警数据的总页数
	 * @return
	 */
	public int findwarnallpage(){
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re = null;
		int i=0;
		String Sql="select * from GL_OutPut where Remark='预警'";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						i++;
					}
				re.close();
				stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
				} finally{
					CONN.release();
				} 
			 }
		}
		if(i%9==0){
			return i/9;
		}else{
			return i/9+1;
		}
	}
	/**
	 * 查找预警数据将其打包返回给界面
	 * @return
	 */
	public List<WarmResult> findwarnresult(int Pags, int perPageRows){
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		ConnManager CONN1=ConnectionPool.getPooledConn();
		Connection _conn,_conn1;
		Statement stmt,stmt1;
		ResultSet re,re1 = null;
		List<WarmResult> list=new ArrayList<WarmResult>();
		//String Sql="select top 9 * from GL_OutPut where Remark='预警'";
		String Sql="select top "+perPageRows+" * from GL_OutPut " +
		"where Remark='预警' and ID not in(select top "+perPageRows*(Pags-1)+" ID from GL_OutPut where Remark='预警' ORDER BY ID)";
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 _conn1=CONN1.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					stmt1 = _conn1.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						WarmResult dd=new WarmResult();
						dd.setId(re.getInt("ID"));
						dd.setGuolunum(re.getInt("GUOLUNUM"));
						dd.setTime(re.getDate("Time").toString());
						dd.setFaultname(re.getString("Name"));
						re1= stmt1.executeQuery("select * from subject where falut_type='"+re.getString("Name")+"'");
						while(re1.next()){
							dd.setFaultcause(re1.getString("falut_cause"));
							dd.setDealhandl(re1.getString("falut_handle"));
						}
						list.add(dd);
					}
				re.close();
				stmt.close();
				re1.close();
				stmt1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
				} finally{
					CONN.release();
					CONN1.release();
				} 
			 }
		}
		return list;
	}
	public List<Nanlaingdatamodal> findresultdata(EvaluateResult modul)
			throws SQLException {
		// TODO Auto-generated method stub
		//使用线程池连接数据库
		ConnManager CONN=ConnectionPool.getPooledConn();
		Connection _conn;
		Statement stmt;
		ResultSet re;
		String Sql = null;
		String fx;
		List<Nanlaingdatamodal> list=new ArrayList<Nanlaingdatamodal>();
		if("pivotal".equals(modul.getRadio())){// 关键重要度评价
			 Sql="select value, bh from GL_gjzyd_data where number = "+Integer.parseInt(modul.getMun())+" and month = "+Integer.parseInt(modul.getMonth())+" and YEAR="+Integer.parseInt(modul.getYear())+"ORDER BY bh";
			 fx="bh";
		}else if("economy".equals(modul.getRadio())){//经济性评价
			Sql="select * from GL_jingjixing_data where bh = "+Integer.parseInt(modul.getMun())+" and YEAR="+Integer.parseInt(modul.getYear())+"ORDER BY MONTH";
			fx="month";
		}else if("component".equals(modul.getRadio())){//部件故障比
			Sql="select value, bh from GL_bjgzb_data where month = "+Integer.parseInt(modul.getMonth())+" and YEAR="+Integer.parseInt(modul.getYear())+"ORDER BY bh";
			fx="bh";
		}else{//安全性
			Sql="select * from GL_kekaodu_data where bh = "+Integer.parseInt(modul.getMun())+" and YEAR="+Integer.parseInt(modul.getYear())+"ORDER BY MONTH";
			 fx="month";
		}
		if(CONN!=null){
			 _conn=CONN.getConnection();
			 if(_conn!=null){
				 System.out.println("success!!!");
				try {
					stmt = _conn.createStatement();
					re= stmt.executeQuery(Sql);
					while(re.next()){
						Nanlaingdatamodal dd=new Nanlaingdatamodal();
						if("pivotal".equals(modul.getRadio())){// 关键重要度评价
							dd.setTime(DBUtil_numchar.zhuanhuanK(re.getString(fx)));
						}else if("component".equals(modul.getRadio())){
							dd.setTime(DBUtil_numchar.zhuanhuanG(re.getString(fx)));
						}else{
							dd.setTime(re.getString(fx));
						}
						dd.setValue(re.getFloat("value"));
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
}
