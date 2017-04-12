<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>
<script src="../js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(../images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  

   <div class="logintop">    
     <span>欢迎登录预警及评价系统</span>    
      <ul>
       <li><a href="#">回首页</a></li>
       <li><a href="#">帮助</a></li>
       <li><a href="#">关于</a></li>
      </ul>    
   </div>
    
    <div class="loginbody">
    <span class="systemlogo"></span> 
    	<div class="loginbox">
    	<form action="../LoginController" method="post">
    		<ul>
    		<li><h4><input name="user_name" type="text" class="loginuser" value="用户名" onclick="JavaScript:this.value=''"/></h4></li> 
    		<li><h4><input name="user_password" type="password" class="loginpwd" value="密码" onclick="document.user_password.submit()"/></h4></li>
			<li>
			<h4>权限：
				<select name="user_competence"> 
				<option value="职工">职工</option>
		   		<option value="管理员">管理员</option>  
		    	</select>${login}
		    </h4>
			</li> 
    		<li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location=''"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="regist.jsp">去注册？</a></label></li>
    		</ul>
    	</form>
   	</div>
    </div>
    
    <div class="loginbm">版权所有  2016任勃</div>
</body>
</html>
