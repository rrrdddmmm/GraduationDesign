<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>锅炉安全预警</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//".":表示class，$(".click")：表示class中的click的标签
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});
});
</script>
</head>
<body>
    <div class="rightinfo">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>锅炉编号</th>
        <th>报警时间</th>
        <th>故障名称</th>
        <th>故障原因</th>
        <th>处理对策</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
	        <c:forEach items="${Warmdata.modul}"  var="li" >
		    <tr>
		        <td>${li.guolunum}</td>
		        <td>${li.time}</td>
		        <td>${li.faultname}</td>
		        <td>${li.faultcause}</td>
		        <td>${li.dealhandl}</td>
		        <td><a href="../../WarmController?ID=${li.id}" target="rightFrame" class="tablelink">查看</a></td>
		    </tr> 
	        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
    	<div class="message">共<i class="blue">${Warmdata.allpage}</i>页，当前显示第&nbsp;<i class="blue">${Warmdata.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="../../WarmAndEvaluateController?page=${Warmdata.currentPage-1}" target="rightFrame">上页</a></li>
        <li class="paginItem"><a href="../../WarmAndEvaluateController?page=1" target="rightFrame">1</a></li>
        <li class="paginItem"><a href="../../WarmAndEvaluateController?page=2" target="rightFrame">2</a></li>
        <li class="paginItem"><a href="../../WarmAndEvaluateController?page=3" target="rightFrame">3</a></li>
        <li class="paginItem"><a href="../../WarmAndEvaluateController?page=${Warmdata.allpage}" target="rightFrame">尾页</a></li>
        <li class="paginItem"><a href="../../WarmAndEvaluateController?page=${Warmdata.currentPage+1}" target="rightFrame">下页</a></li>
        </ul>
    </div>
</div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
