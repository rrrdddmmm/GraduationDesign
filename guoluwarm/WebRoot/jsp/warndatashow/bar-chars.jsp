<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="jscharts.js"></script>
</head>
<body>
<div id="graph">Loading graph...</div>
<script type="text/javascript">
//利用json传送数据
	//var myData = new Array(['二月', 437], ['一月', 322]);
	var myData = new Array();
	var i=0;
	<c:forEach items="${barcharsdata}"  var="li" >
		var time='${li.time}';
		var value=${li.value}
		myData[i++]=[time, value+0.0];
	</c:forEach>
	var myChart = new JSChart('graph', 'bar');//pie  bar;
	//部件故障比//	
	<c:if test="${barcharselect.radio=='component'}" var="aa" scope="session">
	myChart=new JSChart('graph', 'pie');//pie  bar
	</c:if>
	<c:if test="${barcharselect.radio=='pivotal'}" var="aa" scope="session">
	myChart.setAxisNameX('Equipment');
	myChart.setAxisNameY('value');
	</c:if>
	<c:if test="${barcharselect.radio=='safety' || barcharselect.radio=='economy'}" var="aa" scope="session">
		myChart.setAxisNameX('month');
		myChart.setAxisNameY('value');
	</c:if>
	myChart.setDataArray(myData);
	myChart.setSize(616, 321);
	myChart.setTitle('Guolu Appraise Result');
	myChart.setBackgroundImage('bar_chart_bg.jpg');
	myChart.draw();
</script>
</body>
</html>
