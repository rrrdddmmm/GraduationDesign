package guolu.dao;

import java.sql.SQLException;

import guolu.entity.Registermodal;

public interface RegisterDAO {
	/**
	 * 用户注册保存处理接口
	 * @param account
	 * @throws DAOException
	 */
	public void saveAccount(Registermodal modul)throws SQLException;
	
	/**
	 * 注册时检查用户输入的用户名和密码是否有重复处理接口
	 * @param account
	 * @return
	 * @throws DAOException
	 */
	public boolean checkAccount(String username)throws SQLException;

}
