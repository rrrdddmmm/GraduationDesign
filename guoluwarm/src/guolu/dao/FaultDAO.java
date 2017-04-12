package guolu.dao;

import guolu.entity.Machinefaultmodal;

import java.sql.SQLException;
import java.util.List;

public interface FaultDAO {
	/**
	 * 获取所有主体设备数据处理接口
	 * @return
	 * @throws DAOException
	 */
	public List<Machinefaultmodal> findAll()throws SQLException;
	/**
	 * 获得总页数
	 * @return
	 * @throws SQLException 
	 */
	public int Allpage(int perPageRows,String tablename) throws SQLException;
	/**
	 * 修改信息处理接口
	 * @return
	 * @throws SQLException
	 */
	public boolean alterinfor(Machinefaultmodal modul)throws SQLException;
	/**
	 * 分页查询类:根据以下三个参数实现指定页数的指定记录条数的查询
	 * @param Pags:页数从1开始
	 * @param perPageRows：每页显示的记录从0开始
	 * @param tablename：表名
	 * @return
	 * @throws SQLException 
	 */
	public List<Machinefaultmodal> findPagedata(int Pags,int perPageRows,String tablename) throws SQLException;
	/**
	 * 查找某张表的某条数据，将结果打包返回。
	 * @param tablename
	 * @param falut_Number
	 * @return
	 * @throws SQLException
	 */
	public Machinefaultmodal findonedata(String tablename,String falut_Number) throws SQLException;
	/**
	 * 删除信息处理接口
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteinfor(String tablename,String fault_Number)throws SQLException;
	/**
	 * 添加信息
	 * @param modul
	 * @return
	 * @throws SQLException
	 */
	public boolean addinfor(Machinefaultmodal modul)throws SQLException;
}
