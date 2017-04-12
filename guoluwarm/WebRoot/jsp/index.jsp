<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
	<style type="text/css">
		.text{text-align:center}
		.back{background-color:blue}
		p{font-size:15pt;font-color:popular}
	</style>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 

</head>
<body background="../images/background.jpg" style="background-color:skyblue;">

 <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">欢迎光临</a></li>
    </ul>
    </div>
	 <div class="text"><p>蒸汽锅炉安全预警系统开发团队服务</p></div>
	  <div class="back">
		<p>
		    ${user.user_name} 用户欢迎您来到蒸汽锅炉安全预警系统，我们将为您提供优质的服务！
		</p>
	  </div>
</body>
</html>