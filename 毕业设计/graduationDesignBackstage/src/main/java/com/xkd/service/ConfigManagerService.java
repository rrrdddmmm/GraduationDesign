package com.xkd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xkd.dao.BaseConfigMapper;
import com.xkd.dao.BaseDirectionMapper;
import com.xkd.dao.BaseLanguageMapper;
import com.xkd.dao.BasePlatformMapper;
import com.xkd.dao.BaseTitleMapper;
import com.xkd.dao.BaseeDucationMapper;
import com.xkd.entity.BaseConfig;
import com.xkd.entity.StateResult;
import com.xkd.util.DateDealwith;

/**
 * 系统配置
 * 
 * @author RBB
 *
 */
@Service("configManagerService")
@Scope("prototype")
public class ConfigManagerService {
	/**
	 * 学历常量表
	 */
	@Resource(name = "baseeDucationMapper")
	private BaseeDucationMapper	baseeDucationMapper;
	/**
	 * 方向常量表
	 */
	@Resource(name = "baseDirectionMapper")
	private BaseDirectionMapper	baseDirectionMapper;
	/**
	 * 职称常量表
	 */
	@Resource(name = "baseTitleMapper")
	private BaseTitleMapper		baseTitleMapper;
	/**
	 * 开发语言常量表
	 */
	@Resource(name = "baseLanguageMapper")
	private BaseLanguageMapper	baseLanguageMapper;
	/**
	 * 开发平台常量表
	 */
	@Resource(name = "basePlatformMapper")
	private BasePlatformMapper	basePlatformMapper;

	@Transactional
	public List<?> configList(Integer flage) {
		switch (flage) {
			case 1:
				return baseeDucationMapper.selectAll();
			case 2:
				return baseDirectionMapper.selectAll();
			case 3:
				return baseTitleMapper.selectAll();
			case 4:
				return baseLanguageMapper.selectAll();
			case 5:
				return basePlatformMapper.selectAll();
		}
		return null;
	}

	public StateResult configHandle(BaseConfig baseConfig, StateResult stateResult) {
		switch (baseConfig.getFlage()) {
			case 1:
				if (baseConfig.getHandle() == 1) {
					return configAdd(baseeDucationMapper, baseConfig, stateResult, "服务器端：学历");
				} else if (baseConfig.getHandle() == 2) {
					return configAlter(baseeDucationMapper, baseConfig, stateResult, "服务器端：学历");
				} else if (baseConfig.getHandle() == 3) {
					return configDelete(baseeDucationMapper, baseConfig, stateResult, "服务器端：学历");
				}
				break;
			case 2:
				if (baseConfig.getHandle() == 1) {
					return configAdd(baseDirectionMapper, baseConfig, stateResult, "服务器端：方向");
				} else if (baseConfig.getHandle() == 2) {
					return configAlter(baseDirectionMapper, baseConfig, stateResult, "服务器端：方向");
				} else if (baseConfig.getHandle() == 3) {
					return configDelete(baseDirectionMapper, baseConfig, stateResult, "服务器端：方向");
				}
				break;
			case 3:
				if (baseConfig.getHandle() == 1) {
					return configAdd(baseTitleMapper, baseConfig, stateResult, "服务器端：职称");
				} else if (baseConfig.getHandle() == 2) {
					return configAlter(baseTitleMapper, baseConfig, stateResult, "服务器端：职称");
				} else if (baseConfig.getHandle() == 3) {
					return configDelete(baseTitleMapper, baseConfig, stateResult, "服务器端：职称");
				}
				break;
			case 4:
				if (baseConfig.getHandle() == 1) {
					return configAdd(baseLanguageMapper, baseConfig, stateResult, "服务器端：开发语言");
				} else if (baseConfig.getHandle() == 2) {
					return configAlter(baseLanguageMapper, baseConfig, stateResult, "服务器端：开发语言");
				} else if (baseConfig.getHandle() == 3) {
					return configDelete(baseLanguageMapper, baseConfig, stateResult, "服务器端：开发语言");
				}
				break;
			case 5:
				if (baseConfig.getHandle() == 1) {
					return configAdd(basePlatformMapper, baseConfig, stateResult, "服务器端：开发平台");
				} else if (baseConfig.getHandle() == 2) {
					return configAlter(basePlatformMapper, baseConfig, stateResult, "服务器端：开发平台");
				} else if (baseConfig.getHandle() == 3) {
					return configDelete(basePlatformMapper, baseConfig, stateResult, "服务器端：开发平台");
				}
				break;
		}
		stateResult.setMsg("操作失败,请稍后重试!");
		stateResult.setStatus(-1);
		return stateResult;
	}

	private StateResult configAdd(BaseConfigMapper baseConfigMapper, BaseConfig baseConfig, StateResult stateResult,
			String strTable) {
		baseConfig.setCreattime(DateDealwith.getCurrDate());
		baseConfig.setUpdatetime(DateDealwith.getCurrDate());
		if (baseConfigMapper.selectByName(baseConfig.getName()) != null) {
			stateResult.setStatus(-1);
			stateResult.setMsg("" + strTable + "名称已经存在!");
		} else {
			if (baseConfigMapper.insertSelective(baseConfig) > 0) {
				stateResult.setMsg("" + strTable + "插入成功");
				stateResult.setStatus(0);
			} else {
				stateResult.setStatus(-1);
				stateResult.setMsg("" + strTable + "插入失败,请稍后重试!");
			}
		}
		return stateResult;
	}

	private StateResult configAlter(BaseConfigMapper baseConfigMapper, BaseConfig baseConfig, StateResult stateResult,
			String strTable) {
		baseConfig.setUpdatetime(DateDealwith.getCurrDate());
		if (baseConfigMapper.updateByPrimaryKeySelective(baseConfig) > 0) {
			stateResult.setStatus(0);
			stateResult.setMsg("" + strTable + "更新成功");
		} else {
			stateResult.setStatus(-1);
			stateResult.setMsg("" + strTable + "更新失败,请稍后重试!");
		}
		return stateResult;
	}

	private StateResult configDelete(BaseConfigMapper baseConfigMapper, BaseConfig baseConfig, StateResult stateResult,
			String strTable) {
		if (baseConfigMapper.deleteByPrimaryKey(baseConfig.getId()) > 0) {
			stateResult.setStatus(0);
			stateResult.setMsg("" + strTable + "删除成功");
		} else {
			stateResult.setStatus(-1);
			stateResult.setMsg("" + strTable + "删除失败,请稍后重试!");
		}
		return stateResult;
	}
}
