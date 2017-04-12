<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作通知</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//".":表示class，$(".click")：表示class中的click的标签
//实现添加数据的提示信息以及数据的提交
  $(".clickadd").click(function(){
	//调用填写信息页面、添加，页面数据填完成后调用确认添加对话框
	window.location.href="jsp/faultadd.jsp?tablename=${Fault.table_name}&backurl="+window.location.href;
});
  //实现数据修改的提示信息以及数据的提交
  $(".clickalter").click(function(){
	 	//调用填写信息页面、页面数据填完成后调用确认修改对话框
	//获取checkbox的对象数组
	var arr=document.getElementsByName("checkbox");
	t=0;//用来记录用户选中的个数
	t1=0;//若是选择一个就记录这一个下标
	//判断是否是选中多个，添加不能一次多个，所以只能选中一个一次
	for(i=0;i<arr.length;i++){
		if(arr[i].checked){
		 t1=i;
		 t++;
	 	}
		if(t>1){
		 break;
		}
	}
	if(t>1){
		alert("一次只能修改一项数据！");
	}else if(t==0){
		alert("请选择一项数据！");
	}else{
		//页面跳转，添加获取、转发
		window.location.href="jsp/faultalter.jsp?falut_Number="+arr[t1].value+"&tablename=${Fault.table_name}&backurl="+window.location.href;
	}
});
  //实现数据删除的确认以及数据的提交
  $(".clickdelete").click(function(){
		//删除直接调用确认对话框。
	//获取checkbox的对象数组
		 var arr=document.getElementsByName("checkbox");
		 t=0;//用来记录用户选中的个数
		 //判断是否没有选中
		 for(i=0;i<arr.length;i++){
			 if(arr[i].checked){
				 t++;
			 }
			 if(t==1){
				 break;
			 }
		 }
		 if(t==0){
			 alert("至少选中一项数据！");
		 }else{
			 //获取数据，转发或者直接在此函数中处理ajax
			 alert(arr[t-1].value);
			 
		 }
});
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
//写对数据库的操作ajax
	
  alert("成功！");
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
  //写对数据库的操作ajax
  alert("失败！");
});

});
</script>
</head>

<body>
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>工作通知</li>
    <li>管理员${user.user_name}正在操作已发通知</li>
    </ul>
    </div> 
    <div class="rightinfo">
    
	    <div class="tools">
	    	<ul class="toolbar">
		        <li class="clickadd"><span><img src="../images/t01.png" /></span>添加</li>
		        <li class="clickalter"><span><img src="../images/t02.png" /></span>修改</li>
		        <li class="clickdelete"><span><img src="../images/t03.png" /></span>删除</li>
	        </ul> 
	    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
    	
        	<th><input name="" type="checkbox" value="" checked="checked"/></th>
       
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>故障类型</th>
        <th>故障原因</th>
        <th>处理对策</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
	        <c:forEach items="${Fault.list}"  var="li" >
		    <tr>
		    
		        <td><input name="checkbox" type="checkbox" value="${li.falut_Number}" /></td>
		   
		        <td>${li.falut_Number}</td>
		        <td>${li.falut_type}</td>
		        <td>${li.falut_cause}</td>
		        <td>${li.falut_handle}</td>
		        <td><a href="ShowFaultOKController?tablename=${Fault.table_name}&faultnumber=${li.falut_Number}" target="rightFrame" class="tablelink">查看</a></td>
		    </tr> 
	        </c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${Fault.allpage}</i>页，当前显示第&nbsp;<i class="blue">${Fault.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="ShowFaulistController?page=${Fault.currentPage-1}&name=${Fault.table_name}" target="rightFrame">上页</a></li>
        <li class="paginItem"><a href="ShowFaulistController?name=${Fault.table_name}" target="rightFrame">1</a></li>
        <li class="paginItem"><a href="ShowFaulistController?name=${Fault.table_name}&page=two" target="rightFrame">2</a></li>
        <li class="paginItem"><a href="ShowFaulistController?name=${Fault.table_name}&page=tree" target="rightFrame">3</a></li>
        <li class="paginItem"><a href="ShowFaulistController?page=${Fault.allpage}&name=${Fault.table_name}">尾页</a></li>
        <li class="paginItem"><a href="ShowFaulistController?page=${Fault.currentPage+1}&name=${Fault.table_name}" target="rightFrame">下页</a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的保存 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
