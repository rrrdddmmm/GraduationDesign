<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>锅炉安全评价及预警系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//".":表示class，$(".click")：表示class中的click的标签
//实现添加数据的提示信息以及数据的提交
  $(".clickadd").click(function(){
	//调用填写信息页面、添加，页面数据填完成后调用确认添加对话框
	window.location.href="jsp/faultadd.jsp?tablename=${Fault.table_name}&backurl="+window.location.href;
});
//获得ajax对象
	function getXhr(){
		var xhr=null;
		if(window.XMLHttpRequest){
			//非ie浏览器
			xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject('Microsoft.XMLHttp');
		}
		return xhr;
	}
	
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
			 //实现页面数据的提交，但是页面不跳转
			 
  			var xhr=getXhr();
  			var tablename='${Fault.table_name}';
  			xhr.open('post','DeleteController',true);
  			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
  			xhr.onreadystatechange=function() {
  				if(xhr.readyState==4){
  					var txt=xhr.responseText;
					alert(txt);
  				}
  			};//pow='+arr[t-1].value+'&tablename='+Fault.table_name+'
  			xhr.send('pow='+arr[t-1].value+'&tablename='+tablename+'&flag=1');
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
    <li>锅炉故障知识管理</li>
    <li>锅炉设备${Fault.table_name}记录表</li>
    </ul>
    </div> 
    <div class="rightinfo">
    <c:if test="${user.user_competence=='管理员'}" var="aa" scope="session">
	    <div class="tools">
	    	<ul class="toolbar">
		        <li class="clickadd"><span><img src="images/t01.png" /></span>添加</li>
		        <li class="clickalter"><span><img src="images/t02.png" /></span>修改</li>
		        <li class="clickdelete"><span><img src="images/t03.png" /></span>删除</li>
	        </ul> 
	    </div>
    </c:if>
    <table class="tablelist">
    	<thead>
    	<tr>
    	<c:if test="${user.user_competence=='管理员'}" var="aa" scope="session">
        	<th><input name="" type="checkbox" value="" checked="checked"/></th>
        </c:if>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>故障类型</th>
        <th>故障原因</th>
        <th>处理对策</th>
        <c:if test="${user.user_competence=='职工'}" var="aa" scope="session">
        	<th>申请建议</th>
        </c:if>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
	        <c:forEach items="${Fault.list}"  var="li" >
		    <tr>
		    <c:if test="${user.user_competence=='管理员'}" var="aa" scope="session">
		        <td><input name="checkbox" type="checkbox" value="${li.falut_Number}" /></td>
		    </c:if>
		        <td>${li.falut_Number}</td>
		        <td>${li.falut_type}</td>
		        <td>${li.falut_cause}</td>
		        <td>${li.falut_handle}</td>
		        <c:if test="${user.user_competence=='职工'}" var="aa" scope="session">
		        	<td><a href="jsp/advicesubmit.jsp?falut_Number=${li.falut_Number}&tablename=${Fault.table_name}" target="rightFrame" class="tablelink">建议发表</a></td>
		        </c:if>
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
  	</div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
