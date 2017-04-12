package guolu.dao;

import guolu.entity.Usermodal;

import java.util.List;

public interface UserDAO {
	/**
	 * 获取所有用户信息处理接口
	 * @return
	 * @throws DAOException
	 */
	public List<Usermodal> findAll()throws DAOException;

}
