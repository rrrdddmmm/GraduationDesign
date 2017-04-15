package com.xkd.util;




public interface ConfigStr {
/**
 * 这些什么字符串页面将取的时候就用什么字符串，但是用同时用这组件的所有了应该字符串都相同
 * 分页解耦：前台和分页组件的耦
 */
	public static final String listdate="list";
	public static final String pagedate="page";
	public static final Integer keyanfundsTypeID=1;//科研经费ID
	public static final Integer guozichuID=1;//国资处ID
	public static final Integer zjshnehestate=0;//自审核状态
	public static final String filePath="config\\陕西省教育厅政府年采购预算表.xls";
	public static final String filePathnew="陕西省教育厅政府年采购预算表.xls";
	public static final Integer filetitlerow=4;//文件头的行数
	
	public static final String timelimit="2027-01-01";//

	
}
