<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供热系统</title>
<script type="text/javascript" src="jsp/warndatashow/jscharts.js"></script>
<style type="text/css">
html{
	border:#CCC }
body{
	padding:2px;
	margin:0px auto;
	width:1000px;
	background-image: url(jsp/warndatashow/3Z4RWJY57120_1000x500.jpg);
}
#body_left{
width:220px;
height:300px;
padding:10px;
margin:0px 0px 10px 80px;
float:left;
background:#3CB371;
}
#graph{
	
margin:0px 20px 15px 0px;
float:right;
}
#body_left_head{
width:220px;
height:40px;
border:4px;
}
h1 {
	color: #C09;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
    
 <div id="header" align="center">
   <h1><strong>${GuoluSearchmodul.guoluid }#锅炉实时监控系统</strong></h1>
   <p>&nbsp;</p>
 </div>
<div id="body">
<div id="body_left">
<div id="body_left_head" align="center">${GuoluSearchmodul.guoluid }#锅炉</div>
<div id="body_left_contain"><img src="jsp/warndatashow/FK)Z9POSFOW}TPAKTSE}FV1.png" alt="" width="220" height="114" />
  <blockquote>
  <p>${GuoluSearchmodul.guoluid }#锅炉${GuoluSearchmodul.rowname }主体设备运行时时数据</p>
     <h2><a href="NanliangshowController?dataname=${GuoluSearchmodul.rowname }&guoluid=1" target="rightFrame">1#</a> 
     	 <a href="NanliangshowController?dataname=${GuoluSearchmodul.rowname }&guoluid=2" target="rightFrame">2#</a> 
     	 <a href="NanliangshowController?dataname=${GuoluSearchmodul.rowname }&guoluid=3" target="rightFrame">3#</a>
     </h2>
  </blockquote>
</div>
</div>
<div id="graph">Loading...</div></div>
<script type="text/javascript">
//如何动态的生成此数组，根据数据库中的数据生成数据项数。[1997, 7.80], [1998, 4.80], [1999, 6.50]
	var myData = new Array();
	var i=0;
	<c:forEach items="${data}"  var="li" >
		var time=${li.time}
		var value=${li.value}
		myData[i++]=[time, value+0];
	</c:forEach>
	var myChart = new JSChart('graph', 'line');
	myChart.setDataArray(myData);
	myChart.setTitle("Boiler data constantly");
	myChart.setTitleColor('#8E8E8E');
	//可以将颜色编码改掉
	myChart.setTitleFontSize(15);
	myChart.setAxisNameX('Time');
	//不同的设备y值单位不一样
	<c:choose>
  		<c:when test="${GuoluSearchmodul.rowname=='ZQYL'}">myChart.setAxisNameY("unit:pa");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='ZQWD'}">myChart.setAxisNameY("unit:。C");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='ZQLL'}">myChart.setAxisNameY("unit:M3");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='GSLL'}">myChart.setAxisNameY("unit:M3");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='GSWD'}">myChart.setAxisNameY("unit:。C");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='GSYL'}">myChart.setAxisNameY("unit:pa");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='SMQCKSW'}">myChart.setAxisNameY("unit:M");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='PYWD'}">myChart.setAxisNameY("unit:。C");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='LTYL'}">myChart.setAxisNameY("unit:pa");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='QBYL'}">myChart.setAxisNameY("unit:pa");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='QBSW'}">myChart.setAxisNameY("unit:M");</c:when>
 		<c:when test="${GuoluSearchmodul.rowname=='SMQJKSW'}">myChart.setAxisNameY("unit:M");</c:when>
  		<c:otherwise>myChart.setAxisNameY("123123");</c:otherwise>
  	</c:choose>

  	  
	
	
	myChart.setAxisColor('#8420CA');
	myChart.setAxisValuesColor('#949494');
	myChart.setAxisPaddingLeft(100);
	myChart.setAxisPaddingRight(120);
	myChart.setAxisPaddingTop(50);
	myChart.setAxisPaddingBottom(40);
	myChart.setAxisValuesDecimals(3);
	myChart.setShowXValues(false);
	myChart.setGridColor('#C5A2DE');
	myChart.setLineColor('#BBBBBB');
	myChart.setLineWidth(2);
	myChart.setFlagColor('#9D12FD');
	myChart.setFlagRadius(4);
//为每一个点定义含义
	<c:forEach items="${data}"  var="li" >
	var time=${li.time}
	var value=${li.value}
		myChart.setTooltip([time, value]);
	</c:forEach>
//定义横坐标
	<c:forEach items="${data}"  var="li" >
		var time=${li.time}
		var str="${li.date}";
		myChart.setLabelX([time, str]);
	</c:forEach>
	myChart.setSize(660, 321);
	myChart.setBackgroundImage('jsp/warndatashow/0552.jpg');
	myChart.draw();
</script>
</body>
</html>
