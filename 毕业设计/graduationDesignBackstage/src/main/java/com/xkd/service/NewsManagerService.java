package com.xkd.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xkd.dao.BaseNewsMapper;
import com.xkd.entity.BaseNews;
import com.xkd.entity.StateResult;
import com.xkd.util.DateDealwith;
import com.xkd.util.GetResousePath;

/**
 * 新闻服务
 * 
 * @author RBB
 *
 */
@Service("newsManagerService")
@Scope("prototype")
public class NewsManagerService {
	/**
	 * 新闻常量表
	 */
	@Resource(name = "baseNewsMapper")
	private BaseNewsMapper	baseNewsMapper;

	public List<BaseNews> newsList() {
		List<BaseNews> list = baseNewsMapper.selectAll();
		return list;
	}

	public BaseNews getModelById(Integer id) {
		BaseNews baseNews = baseNewsMapper.selectByPrimaryKey(id);
		return baseNews;
	}

	public StateResult userDelHandle(BaseNews baseNews, StateResult stateResult) {
		if (baseNewsMapper.deleteByPrimaryKey(baseNews.getId()) > 0) {
			stateResult.setStatus(0);
			stateResult.setMsg("服务器端:数据删除成功!");
		} else {
			stateResult.setStatus(1);
			stateResult.setMsg("服务器端:数据删除失败!");
		}
		return stateResult;
	}

	public StateResult newsAddHandle(BaseNews baseNews, MultipartFile file) {
		StateResult stateResult = new StateResult();
		try {
			if (file != null) {
				if (file.getName() != null || "".equals(file.getName())) {
					String[] name = file.getContentType().split("/");
					if ("BMP".equals(name[name.length - 1]) || "JPG".equals(name[name.length - 1])
							|| "JPEG".equals(name[name.length - 1]) || "bmp".equals(name[name.length - 1])
							|| "jpg".equals(name[name.length - 1]) || "jpeg".equals(name[name.length - 1])) {
						// 物理地址
						File f = new File(GetResousePath.getNewsImagesAbsPath(baseNews.getLogo()));
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f);
					} else {
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端：请上传规定格式!");
						return stateResult;
					}
				} else {
					stateResult.setStatus(2);
					stateResult.setMsg("服务器端：文件名不能为空!");
					return stateResult;
				}
			} else {
				stateResult.setStatus(3);
				stateResult.setMsg("服务器端：请选择文件!");
				return stateResult;
			}
			// 设置网络地址
			baseNews.setLogo(GetResousePath.getNewsImagesNetPath(baseNews.getLogo()));
			baseNews.setCreattime(DateDealwith.getCurrDate());
			baseNews.setUpdatetime(DateDealwith.getCurrDate());
			if (baseNewsMapper.insertSelective(baseNews) > 0) {
				stateResult.setMsg("服务器端：新闻创建成功!");
				stateResult.setStatus(0);
				return stateResult;
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		stateResult.setMsg("服务器端：新闻创建失败!");
		stateResult.setStatus(4);
		return stateResult;
	}

	public StateResult newsAlterHandle(BaseNews baseNews) {
		StateResult stateResult = new StateResult();
		// 设置网络地址
		baseNews.setLogo(null);
		baseNews.setCreattime(null);
		baseNews.setUpdatetime(DateDealwith.getCurrDate());
		if (baseNewsMapper.updateByPrimaryKeySelective(baseNews) > 0) {
			stateResult.setMsg("服务器端：新闻修改成功!");
			stateResult.setStatus(0);
			return stateResult;
		}
		stateResult.setMsg("服务器端：新闻修改失败!");
		stateResult.setStatus(1);
		return stateResult;
	}

	public StateResult alterNewsImages(BaseNews baseNews, MultipartFile file) {
		StateResult stateResult = new StateResult();
		try {
			if (file != null) {
				if (file.getName() != null || "".equals(file.getName())) {
					String[] name = file.getContentType().split("/");
					if ("BMP".equals(name[name.length - 1]) || "JPG".equals(name[name.length - 1])
							|| "JPEG".equals(name[name.length - 1]) || "bmp".equals(name[name.length - 1])
							|| "jpg".equals(name[name.length - 1]) || "jpeg".equals(name[name.length - 1])) {
						// 物理地址
						File f = new File(GetResousePath.getNewsImagesAbsPath(baseNews.getLogo()));
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f);
					} else {
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端：请上传规定格式!");
						return stateResult;
					}
				} else {
					stateResult.setStatus(2);
					stateResult.setMsg("服务器端：文件名不能为空!");
					return stateResult;
				}
			} else {
				stateResult.setStatus(3);
				stateResult.setMsg("服务器端：请选择文件!");
				return stateResult;
			}
			// 设置网络地址
			baseNews.setLogo(GetResousePath.getNewsImagesNetPath(baseNews.getLogo()));
			stateResult.setNewpath(baseNews.getLogo());
			baseNews.setUpdatetime(DateDealwith.getCurrDate());
			if (baseNewsMapper.updateByPrimaryKeySelective(baseNews) > 0) {
				stateResult.setMsg("服务器端：新闻照片修改成功!");
				stateResult.setStatus(0);
				return stateResult;
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		stateResult.setMsg("服务器端：新闻照片修改失败!");
		stateResult.setStatus(4);
		return stateResult;
	}
}
