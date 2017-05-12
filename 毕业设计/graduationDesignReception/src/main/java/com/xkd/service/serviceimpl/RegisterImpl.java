package com.xkd.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkd.dao.UserDaoMapper;
import com.xkd.entity.StateResult;
import com.xkd.entity.User;
import com.xkd.service.RegisterService;

/**
 * 注册服务
 * @author RBB
 *
 */
@Service(value="RegisterService")
public class RegisterImpl implements RegisterService{
	@Autowired
	private UserDaoMapper userDao;
	/**
	 * 
	 */
		public StateResult registUser(User user){
			StateResult result = new StateResult();
			User usr = userDao.findByEmail(user.getEmail());
			if(usr != null){
				result.setStatus(1);
				result.setMsg("emil已占用");
				return result;
			}
			userDao.save(user);
			System.out.println("注册成功");
			result.setStatus(0);
			result.setMsg("注册成功");
			return result;
		}

}
