package com.xkd.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.controller.SessionController;
import com.xkd.dao.BaseUserMapper;
import com.xkd.entity.BaseUser;
import com.xkd.entity.StateResult;
import com.xkd.util.ConfigStr;
import com.xkd.util.DateDealwith;
import com.xkd.util.GetResousePath;

@Service("userMyInfomationService")
@Scope("prototype")
public class UserMyInfomationService {
	@Resource(name = "baseUserMapper")
	private BaseUserMapper	baseUserMapper;

	public BaseUser myInfomationAlter(BaseUser user, StateResult stateResult, HttpServletRequest request) {
		user.setUpdatetime(DateDealwith.getCurrDate());
		if (verifyEmailAndPhone(user.getEmail(), null, user.getId())) {
			if (verifyEmailAndPhone(null, user.getPhone(), user.getId())) {
				user.setUpdatetime(DateDealwith.getCurrDate());
				BaseUser sessionUser = SessionController.getLoginInfomation(request);
				if (sessionUser.getPassword() == null || sessionUser.getPassword().equals(user.getPassword())
						|| "".equals(user.getPassword())) {
					user.setPassword(null);
				}
				if (baseUserMapper.updateByPrimaryKeySelective(user) > 0) {
					stateResult.setStatus(0);
					stateResult.setMsg("修改成功!");
				} else {
					stateResult.setStatus(1);
					stateResult.setMsg("修改失败!");
				}
			} else {
				stateResult.setStatus(2);
				stateResult.setMsg("服务器端:该手机号已经注册!");
			}
		} else {
			stateResult.setStatus(3);
			stateResult.setMsg("服务器端:该邮箱已经注册!");
		}
		return user;
	}

	public StateResult uploadMyimage(Integer id, StateResult stateResult, Model model, MultipartFile file,
			HttpServletRequest request) throws IOException {
		BaseUser sessionUser = SessionController.getLoginInfomation(request);
		String idStr = sessionUser.getId().toString();
		if (id != null) {
			idStr = id.toString();
		}
		try {
			if (file != null) {
				if (file.getName() != null || "".equals(file.getName())) {
					String[] name = file.getContentType().split("/");
					if ("BMP".equals(name[name.length - 1]) || "JPG".equals(name[name.length - 1])
							|| "JPEG".equals(name[name.length - 1]) || "bmp".equals(name[name.length - 1])
							|| "jpg".equals(name[name.length - 1]) || "jpeg".equals(name[name.length - 1])) {
						String images = DateDealwith.getSHC();
						// 物理地址
						File f = new File(GetResousePath.getUserTopImagesPath(idStr, images));
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f);
						// 网络地址
						sessionUser.setImage(GetResousePath.getUserTopNetImagesPath(idStr, images));
						if (id == null) {
							model.addAttribute(ConfigStr.userInfomation, sessionUser);
						}
						myInfomationAlter(sessionUser, new StateResult(), request);
						stateResult.setStatus(0);
						stateResult.setMsg("服务器端：上传成功!");
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
		if (sessionUser != null) {
			stateResult.setNewpath(sessionUser.getImage());
		}
		return stateResult;
	}

	/**
	 * email和手机号验证
	 *
	 * @param email
	 * @return
	 */
	private boolean verifyEmailAndPhone(String email, String phone, Integer id) {
		BaseUser record = new BaseUser();
		record.setEmail(email);
		record.setPhone(phone);
		record = baseUserMapper.selectByEmailRolePwd(record);
		if (record != null) {
			if (record.getId() != id) {
				return false;
			}
		}
		return true;
	}
}
