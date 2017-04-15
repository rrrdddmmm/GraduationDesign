package com.xkd.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * 获取集合数据类型
 * 集合数据的工厂
 * @author RBB
 *为什么 不能注入呢？？
 *此类如果：不写非单例则多个用户使用时访问的对象就一样
 *如果写成成员函数则类加载一次，则同一对象的数据是一样的
 *如果new写在方法中调用一次方法创建一个实例
 */
@Repository("getCollectType")
@Scope("prototype")//非单例模式

public class GetCollectType {
	public Map<String, Object> getSoMap() {
		return new HashMap<String,Object>();
	}
	public Map<String, Integer> getSiMap() {
		return new HashMap<String,Integer>();
	}
	public Map<Integer,String> getIsMap() {
		return new LinkedHashMap<Integer,String>();
	}
	public Map<String,String> getSsMap() {
		return new LinkedHashMap<String,String>();
	}
	public List<Integer> getIntList() {
		return new ArrayList<Integer>();
	}
	public List<String> getStrList() {
		return new ArrayList<String>();
	}
	
}
