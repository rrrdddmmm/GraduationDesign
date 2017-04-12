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
  $(".classcheck").click(function(){
	window.location.href="ShowMainlistController?name=${Main.table_name}&cycle=1&backurl="+window.location.href;
  
  });

  $(".daycheck").click(function(){
		window.location.href="ShowMainlistController?name=${Main.table_name}&cycle=2&backurl="+window.location.href;
	 
	  });

  $(".weekcheck").click(function(){
		window.location.href="ShowMainlistController?name=${Main.table_name}&cycle=3&backurl="+window.location.href;
	  
	  });

  $(".monthcheck").click(function(){
		window.location.href="ShowMainlistController?name=${Main.table_name}&cycle=4&backurl="+window.location.href;
	
	  });

  $(".halfyearcheck").click(function(){
		window.location.href="ShowMainlistController?name=${Main.table_name}&cycle=5&backurl="+window.location.href;
	  
	  });
  $(".yearcheck").click(function(){
		window.location.href="ShowMainlistController?name=${Main.table_name}&cycle=6&backurl="+window.location.href;
	  
	  });
//以下是维修保养知识的增加、修改、删除
	
//实现添加数据的提示信息以及数据的提交
  $(".clickadd").click(function(){
	//调用填写信息页面、添加，页面数据填完成后调用确认添加对话框
	window.location.href="jsp/maintainadd.jsp?tablename=${Main.table_name}&backurl="+window.location.href;
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
		window.location.href="jsp/maintainalter.jsp?Maintainnumber="+arr[t1].value+"&tablename=${Main.table_name}&backurl="+window.location.href;
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
			 //获取数据，转发或者直接在此函数中处理ajax
			 //实现页面数据的提交，但是页面不跳转
			 
  			var xhr=getXhr();
  			var tablename='${Main.table_name}';
  			xhr.open('post','DeleteController',true);
  			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
  			xhr.onreadystatechange=function() {
  				if(xhr.readyState==4){
  					var txt=xhr.responseText;
					alert(txt);
  				}
  			};//pow='+arr[t-1].value+'&tablename='+Fault.table_name+'
  			xhr.send('pow='+arr[t-1].value+'&tablename='+tablename+'&flag=2');
			alert(arr[t-1].value); 		 
		 }
});
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
</script>
</head>
<body>
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">维修保养知识库</a></li>
    <li><a href="#">锅炉设备${Main.table_name}维修保养知识</a></li>
    </ul>
    </div>
    <div class="rightinfo"> 
	    <div class="tools">
	    <c:if test="${user.user_competence=='管理员'}" var="aa" scope="session">
	    	<ul class="toolbar">
	        <li class="clickadd"><span><img src="images/t01.png" /></span>添加</li>
	        <li class="clickalter"><span><img src="images/t02.png" /></span>修改</li>
	        <li class="clickdelete"><span><img src="images/t03.png" /></span>删除</li>
	        </ul>
	       <ul class="toolbar1">
		   <li class="classcheck"><span><img src="images/t05.png" /></span>班检</li>
		   <li class="daycheck"><span><img src="images/t05.png" /></span>日检</li>
		   <li class="weekcheck"><span><img src="images/t05.png" /></span>周检</li>
		   <li class="monthcheck"><span><img src="images/t05.png" /></span>月检</li>
		   <li class="halfyearcheck"><span><img src="images/t05.png" /></span>半年检</li>
		   <li class="yearcheck"><span><img src="images/t05.png" /></span>年检</li>
		   </ul> 
	    </c:if>
	     <c:if test="${user.user_competence=='职工'}" var="aa" scope="session">
	       <ul class="toolbar">
		   <li class="classcheck"><span><img src="images/t05.png" /></span>班检</li>
		   <li class="daycheck"><span><img src="images/t05.png" /></span>日检</li>
		   <li class="weekcheck"><span><img src="images/t05.png" /></span>周检</li>
		   <li class="monthcheck"><span><img src="images/t05.png" /></span>月检</li>
		   <li class="halfyearcheck"><span><img src="images/t05.png" /></span>半年检</li>
		   <li class="yearcheck"><span><img src="images/t05.png" /></span>年检</li>
		   </ul> 
		 </c:if> 
	    </div>
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>维护周期</th>
        <th>维护内容</th>
        <c:if test="${user.user_competence=='职工'}" var="aa" scope="session">
        <th>申请修改</th>
        </c:if>
        <c:if test="${user.user_competence=='管理员'}" var="aa" scope="session">
        <th>操作</th>
        </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Main.list}"  var="li" >
	        <tr>
		        <td><input name="checkbox" type="checkbox" value="${li.inspect_number}" /></td>
		        <td>${li.inspect_number} </td>
		        <td>${li.inspect_cycle }</td>
		        <td>${li.inspect_content }</td>
		        <c:if test="${user.user_competence=='职工'}" var="aa" scope="session">
		        <td><a href="jsp/advicesubmit.jsp?falut_Number=${li.inspect_number}&tablename=${Main.table_name}" class="tablelink">修改建议</a></td>
	        	</c:if>
	        	<c:if test="${user.user_competence=='管理员'}" var="aa" scope="session">
		        <td><a href="#" class="tablelink">打卡</a></td>
	        	</c:if>
	        </tr> 
        </c:forEach>
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${Main.allpage}</i>页，当前显示第&nbsp;<i class="blue">${Main.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="ShowMainlistController?page=${Main.currentPage-1}&name=${Main.table_name}&cycle=${Main.cycle}" target="rightFrame">上页</a></li>
        <li class="paginItem"><a href="ShowMainlistController?name=${Main.table_name}&cycle=${Main.cycle}" target="rightFrame">1</a></li>
        <li class="paginItem"><a href="ShowMainlistController?name=${Main.table_name}&page=two&cycle=${Main.cycle}" target="rightFrame">2</a></li>
        <li class="paginItem"><a href="ShowMainlistController?name=${Main.table_name}&page=tree&cycle=${Main.cycle}" target="rightFrame">3</a></li>
        <li class="paginItem"><a href="ShowMainlistController?page=${Main.allpage}&name=${Main.table_name}&cycle=${Main.cycle}">尾页</a></li>
        <li class="paginItem"><a href="ShowMainlistController?page=${Main.currentPage+1}&name=${Main.table_name}&cycle=${Main.cycle}" target="rightFrame">下页</a></li>
        </ul>
    </div>
    
    </div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
