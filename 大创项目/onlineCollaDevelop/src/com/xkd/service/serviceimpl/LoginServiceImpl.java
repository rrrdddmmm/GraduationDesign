package com.xkd.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkd.dao.UserDaoMapper;
import com.xkd.entity.StateResult;
import com.xkd.entity.User;
import com.xkd.service.LoginService;
/**
 * 登陆服务
 * @author RBB
 *
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{
/**
 * 
 */
	@Autowired
	private UserDaoMapper userDao;
/**
 * 
 */
	public StateResult checkLogin(User user) {	
		StateResult result=new StateResult();
		User userd = userDao.findByName(user.getUsername());

		if(userd==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}

		if(!user.getEmail().equals(userd.getEmail())){
			result.setStatus(2);
			result.setMsg("邮箱不正确");
			return result;
		}
		
		if(!user.getRole().equals(userd.getRole())){
			result.setStatus(3);
			result.setMsg("角色不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和邮箱正确");	
		System.out.println("验证通过");
		return result;
	}
	
/**
 * 
 */
	public StateResult registUser(User user){

		StateResult result = new StateResult();
		User usr = userDao.findByName(user.getUsername());
		User users=new User();
		if(usr != null){
			result.setStatus(1);
			result.setMsg("用户名已占用");
			return result;
		}
		
		
		users.setUsername(user.getUsername());
		users.setEmail(user.getEmail());
		users.setPhone(user.getPhone());
		users.setRole(user.getRole());
		userDao.save(users);
		System.out.println("注册成功");
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}

}