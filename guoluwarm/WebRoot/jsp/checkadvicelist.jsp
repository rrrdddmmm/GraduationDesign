<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
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

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">知识反馈表</a></li>
    </ul>
    </div>
 
    <div class="rightinfo">  
     
    <table class="imgtable">
    <thead>
    <tr>
    	<th>用户名</th>
    	<th>表名</th>
	    <th>故障编号</th>
	    <th>关键字</th>
	    <th>反馈内容</th>
	    <th>是否审核</th>
	    <th>审核</th>
    </tr>
    </thead>
    
    <tbody> 
    <c:forEach items="${Adicelist.modul}"  var="li" >
	    <tr>
		    <td>${li.username }</td>
		    <td>${li.tablename }</td>
		    <td>${li.number }</td>
		    <td>${li.keyword }</td>
		    <td>${li.text }</td>
		    <td>${li.state }</td>
		    <td><a href="jsp/advicechecksubmit.jsp?username=${li.username }&tablename=${li.tablename }&number=${li.number }&keyword=${li.keyword }&text=${li.text }&state=${li.state }">点击审核</a></td>
	    </tr>
    </c:forEach>
    
    </tbody>
    </table>

    <div class="pagin">
    	<div class="message">共<i class="blue">${Adicelist.allpage}</i>页，当前显示第&nbsp;<i class="blue">${Adicelist.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="CheckAdvicelistController?page=${Adicelist.currentPage-1}&flag=${Adicelist.flag}" target="rightFrame">上页</a></li>
        <li class="paginItem"><a href="CheckAdvicelistController?flag=${Adicelist.flag}&page=1" target="rightFrame">1</a></li>
        <li class="paginItem"><a href="CheckAdvicelistController?flag=${Adicelist.flag}&page=2" target="rightFrame">2</a></li>
        <li class="paginItem"><a href="CheckAdvicelistController?flag=${Adicelist.flag}&page=3" target="rightFrame">3</a></li>
        <li class="paginItem"><a href="CheckAdvicelistController?page=${Adicelist.allpage}&flag=${Adicelist.flag}">尾页</a></li>
        <li class="paginItem"><a href="CheckAdvicelistController?page=${Adicelist.currentPage+1}&flag=${Adicelist.flag}" target="rightFrame">下页</a></li>
        </ul>
    	</div>
  	</div>
  
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
