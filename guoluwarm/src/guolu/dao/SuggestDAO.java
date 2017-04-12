package guolu.dao;

import guolu.entity.Adviceinfomodal;
import java.sql.SQLException;
import java.util.List;

/**
 * 实现对表suggest(职工反馈表)维护
 * @author RBB
 *
 */
public interface SuggestDAO {

	/*
	 * 查找表中全部数据
	 */
	public List<Adviceinfomodal>  findAll();
	/**
	 * 查找表中某条数据
	 */
	public Adviceinfomodal findone(int ID);
	/**
	 * 获得总页数
	 * @return
	 * @throws SQLException 
	 */
	public int Allpage(int perPageRows, String tablename) throws SQLException;
	/**
	 * 分页查询类:根据以下三个参数实现指定页数的指定记录条数的查询
	 * @param Pags:页数从1开始
	 * @param perPageRows：每页显示的记录从0开始
	 * @param tablename：表名
	 * @return
	 * @throws SQLException 
	 */
	public List<Adviceinfomodal> findPagedata(int Pags, int perPageRows,
			String tablename) throws SQLException;
	/**
	 * 添加信息
	 * @param modul
	 * @return
	 * @throws SQLException
	 */
	public boolean addinfor(Adviceinfomodal modul)throws SQLException;
	/**
	 * 删除信息处理接口
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteinfor(String tablename,int id)throws SQLException;
	/**
	 * 修改信息处理接口
	 * @return
	 * @throws SQLException
	 */
	public boolean alterinfor(Adviceinfomodal modul)throws SQLException;
}
