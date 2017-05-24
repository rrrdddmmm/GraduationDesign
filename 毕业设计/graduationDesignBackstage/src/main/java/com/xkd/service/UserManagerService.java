package com.xkd.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.dao.BaseDirectionMapper;
import com.xkd.dao.BaseUserMapper;
import com.xkd.entity.BaseDirection;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.util.DateDealwith;
import com.xkd.util.GetResousePath;

@Service("userManagerService")
@Scope("prototype")
public class UserManagerService {
	@Resource(name = "baseUserMapper")
	private BaseUserMapper		baseUserMapper;
	/**
	 * 方向常量表
	 */
	@Resource(name = "baseDirectionMapper")
	private BaseDirectionMapper	baseDirectionMapper;

	public StateResult userAddHandle(BaseUser user, StateResult stateResult) {
		user.setCreattime(DateDealwith.getCurrDate());
		user.setUpdatetime(DateDealwith.getCurrDate());
		user.setImage(null);
		if (verifyEmailAndPhone(user.getEmail(), null)) {
			if (verifyEmailAndPhone(null, user.getPhone())) {
				if (baseUserMapper.insertSelective(user) > 0) {
					stateResult.setStatus(0);
					stateResult.setMsg("服务器端:数据插入成功!");
				} else {
					stateResult.setStatus(1);
					stateResult.setMsg("服务器端:数据插入失败!");
				}
			} else {
				stateResult.setStatus(2);
				stateResult.setMsg("服务器端:该手机号已经注册!");
			}
		} else {
			stateResult.setStatus(3);
			stateResult.setMsg("服务器端:该邮箱已经注册!");
		}
		return stateResult;
	}

	public List<BaseUser> userList() {
		List<BaseUser> LIST = baseUserMapper.selectAll();
		return LIST;
	}

	public List<BaseUser> userAllStudentList() {
		List<BaseUser> LIST = baseUserMapper.selectAllRoleList("1");
		return LIST;
	}

	public BaseUser findByEmail(String email) {
		BaseUser obj = baseUserMapper.selectByEmailRolePwd(new BaseUser(email));
		return obj;
	}

	public StateResult userAlterHandle(BaseUser user, StateResult stateResult) {
		user.setUpdatetime(DateDealwith.getCurrDate());
		user.setCreattime(null);
		if (baseUserMapper.updateByPrimaryKeySelective(user) > 0) {
			stateResult.setStatus(0);
			stateResult.setMsg("服务器端:用户信息修改成功!");
		} else {
			stateResult.setStatus(1);
			stateResult.setMsg("服务器端:用户信息修改失败!");
		}
		return stateResult;
	}

	public List<BaseUser> userStateList(Model model, String state) {
		List<BaseUser> LIST = baseUserMapper.selectBystate(state);
		return LIST;
	}

	public StateResult userDelHandle(BaseUser user, StateResult stateResult) {
		if (baseUserMapper.deleteByPrimaryKey(user.getId()) > 0) {
			stateResult.setStatus(0);
			stateResult.setMsg("服务器端:数据删除成功!");
		} else {
			stateResult.setStatus(1);
			stateResult.setMsg("服务器端:数据删除失败!");
		}
		return stateResult;
	}

	public BaseUser userAlterHandle(Integer id) {
		BaseUser user = baseUserMapper.selectByPrimaryKey(id);
		return user;
	}

	public List<BaseDirection> getTeacherMenuForCreat() {
		List<BaseDirection> baseDirectionList = baseDirectionMapper.selectAll();
		for (BaseDirection baseDirection : baseDirectionList) {
			baseDirection.setUserList(baseUserMapper.selectByBaseDirection(baseDirection.getName()));
		}
		return baseDirectionList;
	}

	public StateResult uploadMyimage(BaseUser user, StateResult stateResult, Model model, MultipartFile file,
			HttpServletRequest request) throws IOException {
		try {
			if (file != null) {
				if (file.getName() != null || "".equals(file.getName())) {
					String[] name = file.getContentType().split("/");
					if ("BMP".equals(name[name.length - 1]) || "JPG".equals(name[name.length - 1])
							|| "JPEG".equals(name[name.length - 1]) || "bmp".equals(name[name.length - 1])
							|| "jpg".equals(name[name.length - 1]) || "jpeg".equals(name[name.length - 1])) {
						String images = DateDealwith.getSHC();
						// 物理地址
						File f = new File(GetResousePath.getUserTopImagesPath(user.getId().toString(), images));
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f);
						// 网络地址
						user.setImage(GetResousePath.getUserTopNetImagesPath(user.getId().toString(), images));
						if (baseUserMapper.updateByPrimaryKeySelective(user) > 0) {
							stateResult.setStatus(0);
							stateResult.setMsg("服务器端：上传成功!");
						} else {
							stateResult.setStatus(5);
							stateResult.setMsg("服务器端：数据库更改失败!");
						}
					} else {
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端：请上传规定格式!");
					}
				} else {
					stateResult.setStatus(2);
					stateResult.setMsg("服务器端：文件名不能为空!");
				}
			} else {
				stateResult.setStatus(3);
				stateResult.setMsg("服务器端：请选择文件!");
			}
		} catch (IllegalStateException e) {
			stateResult.setStatus(4);
			stateResult.setMsg("服务器端：上传失败，服务器异常，请稍后上传!");
		}
		stateResult.setNewpath(user.getImage());
		return stateResult;
	}

	/**
	 * email和手机号验证
	 *
	 * @param email
	 * @return
	 */
	private boolean verifyEmailAndPhone(String email, String phone) {
		BaseUser record = new BaseUser();
		record.setEmail(email);
		record.setPhone(phone);
		if (baseUserMapper.selectByEmailRolePwd(record) != null) {
			return false;
		}
		return true;
	}

}
