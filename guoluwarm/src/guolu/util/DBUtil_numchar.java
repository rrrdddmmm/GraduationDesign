package guolu.util;

public class DBUtil_numchar {
	
	
	
	//a[0]////破碎机单元可靠度
	//q[1]//？？？？？单元可靠度
	//q[2]//皮带机单元可靠度
	//q[3]//刮板机单元可靠度
	//q[4]//1#锅炉单元可靠度
	//q[5]//1#炉排机单元可靠度
	//q[6]//1#炉鼓风机单元可靠度
	//q[7]//2#水泵单元可靠度
	//q[8]//1#水泵单元可靠度
	//q[9]////出渣机单元可靠度
	//q[10]//软化水箱液位低报警单元可靠度
	//q[11]////出渣机堵转单元可靠度
	//q[12]////输煤系统急停单元可靠度
	//q[13]//1#蒸汽压力高停炉单元可靠度//合并 a[13]  a[14]
	//q[14]//1#蒸汽压力高报警单元可靠度//合并 a[15]  a[16]  a[17]
	public static String zhuanhuanK(String str){
		if("0".equals(str)){
			return "PSJ";
		}else if("1".equals(str)){
			return "AAA";
		}else if("2".equals(str)){
			return "PDJ";
		}else if("3".equals(str)){
			return "GBJ";
		}else if("4".equals(str)){
			return "GU";
		}else if("5".equals(str)){
			return "LPJ";
		}else if("6".equals(str)){
			return "GFJ";
		}else if("7".equals(str)){
			return "2#SB";
		}else if("8".equals(str)){
			return "1#SB";
		}else if("9".equals(str)){
			return "CZJ";
		}else if("10".equals(str)){
			return "RHSX";
		}else if("11".equals(str)){
			return "RZJDZ";
		}else if("12".equals(str)){
			return "SMXTJT";
		}else if("13".equals(str)){
			return "ZQYLGTL";
		}else if("14".equals(str)){
			return "ZQYLGBJ";
		}else{
			return "";
		}
	}
	
	
	//c[0]////破碎机关键重要度
	//c[1]//关键重要度
	//c[2]//皮带机关键重要度
	//c[3]//刮板机关键重要度
	//c[4]//1#锅炉引风机关键重要度
	//c[5]//1#炉排机关键重要度
	//c[6]//1#炉鼓风机故障关键重要度
	//c[7]//2#水泵故障关键重要度
	//c[8]//1#水泵故障关键重要度
	//c[9]////出渣机故障关键重要度
	//c[10]//软化水箱液位低报警关键重要度
	//c[11]////出渣机堵转关键重要度
	//c[12]////输煤系统急停关键重要度
	public static String zhuanhuanG(String str){
		if("0".equals(str)){
			return "PSJ";
		}else if("1".equals(str)){
			return "AAA";
		}else if("2".equals(str)){
			return "PDJ";
		}else if("3".equals(str)){
			return "GBJ";
		}else if("4".equals(str)){
			return "YFJ";
		}else if("5".equals(str)){
			return "LPJ";
		}else if("6".equals(str)){
			return "GFJ";
		}else if("7".equals(str)){
			return "2#SB";
		}else if("8".equals(str)){
			return "1#SB";
		}else if("9".equals(str)){
			return "CZJ";
		}else if("10".equals(str)){
			return "RHSXD";
		}else if("11".equals(str)){
			return "CZJDZ";
		}else if("12".equals(str)){
			return "SMXTJT";
		}else{
			return "";
		}
	}
}
