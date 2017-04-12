<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>recursion</title> 
<style type="text/css">
body {
	background-image: url(../images/18.jpg);
}
</style> 
<script type="text/javascript"> 
    var index = 30;  
    text = new Array (30); 
    var link = 'NewFile.jsp';  
    text[0] = "数控锅炉简介"; 
    text[1] = "新技术应用"; 
    text[2] = "数控锅炉较传统锅炉相比，更节能环保";
	text[3] = "燃油锅炉如何保养"; 
    text[4] = "燃油锅炉和燃气锅炉的区别"; 
    text[5] = "世界领先的热工设备制造商"; 
	text[6] = "自来水二次污染危害大 专家建议使用净水器"; 
    text[7] = "【pH值】水质 pH值的测定 玻璃电极法GB/T6920-1986"; 
    text[8] = "【溶解氧】电化学探头法 《水和废水监测分析方法》"; 
	text[9] = "【臭和味】文字描述法《水和废水监测分析方法》"; 
    text[10] = "【侵蚀性二氧化碳】甲基橙指示剂滴定法《水和废水监测分析方法》"; 
    text[11] = "数控锅炉简介"; 
	text[12] = "新技术应用"; 
    text[13] = "数控锅炉较传统锅炉相比，更节能环保1";
    text[14] = "【浊度】水质 浊度的测定GB/T13200-1991";
	text[15] = "自来水二次污染危害大 专家建议使用净水器"; 
    text[16] = "【pH值】水质 pH值的测定 玻璃电极法GB/T6920-1986"; 
    text[17] = "【臭和味】文字描述法《水和废水监测分析方法》"; 
	text[18] = "【侵蚀性二氧化碳】甲基橙指示剂滴定法《水和废水监测分析方法》"; 
    text[19] = "数控锅炉较传统锅炉相比，更节能环保";
    text[20] = "【溶解氧】 GB/T11913-1989《水和废水监测分析方法》"; 
	text[21] = "燃油锅炉和燃气锅炉的区别"; 
    text[22] = "数控锅炉较传统锅炉相比，更节能环保";
    text[23] = "【臭和味】文字描述法《水和废水监测分析方法》"; 
	text[24] = "【悬浮物(SS)】水质 悬浮物的测定 重量法GB/T11901-1989"; 
    text[25] = "【浊度】水质 浊度的测定GB/T13200-1991"; 
    text[26] = "【pH值】水质 pH值的测定 玻璃电极法GB/T6920-1986";  
	text[27] ="【臭和味】文字描述法《水和废水监测分析方法1》"; 
    text[28] = "【高锰酸盐指数】水质 高锰酸盐指数的测定 GB";  
    text[29] = "【侵蚀性二氧化碳】甲基橙滴定法《水和废水监测分析方法》"; 
    document.write ("<marquee scrollamount='1' scrolldelay='100' direction='down' width='850' height='680'>"); 
    for (i = 0; i < index; i++) 
    { 
        document.write ("<a href="+link+" targrt='_blank'>"); 
        document.write (text[i] + "</a><br />"); 
    } 
    document.write ("</marquee>") 
</script> 
</head> 
<body> 
</body> 
</html>