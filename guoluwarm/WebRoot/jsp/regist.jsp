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
    $('.registbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.registbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(../images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  

   <div class="registtop">    
     <span>欢迎登录预警及评价系统</span>    
      <ul>
       <li><a href="#">回首页</a></li>
       <li><a href="#">帮助</a></li>
       <li><a href="#">关于</a></li>
      </ul>    
   </div>
    
    <div class="registbody">
    <span class="systemlogo"></span> 
    	<div class="registbox">
    	<form action="../RegisterController" method="post">
    		<ul>
    		<li><input name="user_name" type="text" class="registuser" value="用户名" onclick="JavaScript:this.value=''"/></li> 
    		<li><input name="user_password" type="password" class="registpwd" value="密码" onclick="JavaScript:this.value=''"/>${'密码'} </li>
			<li><input name="user_password_confirm" type="password" class="registpwd" value="再次输入密码" onclick="JavaScript:this.value=''"/>${'再次输密码'}</li>
    		<li><input name="" type="submit" class="registbtn" value="注册"  onclick="javascript:window.location=''"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="login.jsp">去登陆？</a></label></li>
    		</ul>
    	</form>
   	</div>
    </div>
    
    <div class="registbm">版权所有  2016任勃</div>
</body>
</html>
