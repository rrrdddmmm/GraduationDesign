package guolu.dao;

import java.sql.SQLException;


import guolu.entity.Usermodal;
/**
 * 利用用户名和密码查找用户信息接口
 * @author RBB
 *
 */
public interface LoginDAO {
	/**
	 * 用户登陆处理接口
	 * @param username
	 * @param passwd
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 */
	public Usermodal finduserinfo(String username,String passwd ,String user_competence)throws SQLException;
	
	
	/**
	 * 找回密码处理接口
	 * @param ID：工号(username)
	 * @return
	 * @throws DAOException
	 */
	public Usermodal SearchPasswd(int ID)throws DAOException;
}
