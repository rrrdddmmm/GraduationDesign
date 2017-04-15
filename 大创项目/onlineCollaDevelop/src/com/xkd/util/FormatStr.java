package com.xkd.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Scope;

/**
 * 字符串转换工具类
 * @author RBB
 *
 */
@Scope("prototype")
public class FormatStr {
	/**
	 * 此类提供获取集合数据类型，有此类就是不想随便就能看到new
	 * 只能使用一次
	 */
	private static GetCollectType getCollectType=new GetCollectType();
	/**
	 * 提供一个字符串数组和一个符号，将其组装成字符符号间隔的字符串
	 * 如果传送过来的数据是null时，返回null
	 */
	public static String ToString(String str[],String symbol){
		String Perstr=null;
		if(str!=null){
			Perstr=str[0];
			for(int i=1;i<str.length;i++){
				if(symbol!=null){
					Perstr=Perstr+symbol+str[i];
				}else{
					return null;
				}
			}
		}
		return Perstr;
	}
	/**
	 * 提供一个符号隔开的数字字符串，将其分解后数据转化为整型作为集合的
	 */
	public static List<String> ToListStr(String str,String symbol){
		List<String> list=null;
		list=getCollectType.getStrList();
		if(str!=null){
			String[] StrPer=str.split(symbol);
			//将String类型的权限id值转换为Integer
			for(String sstr:StrPer){
				list.add(sstr);
			}
		}
		return list;
	}
	/*
	 * 
	 */
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		} 
}
