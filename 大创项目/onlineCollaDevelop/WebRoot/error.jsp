<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../content/css/stylepage.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.js"></script>

<script language="javascript" type="text/javascript">
$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 3;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    //parent.location.href = "../main/login.jsp";//上一层页面跳转
                      top.location.href = "../toPageController/toLogin.do";//最外层页面跳转
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    location.href = "#";
                }
            }
        </script> 


</head>


<body style="background:#edf6fa;" onload="startTimes();">

	<div class="place">
    <span>位置：error</span>
    <ul class="placeul">
    </ul>
    </div>
    
    <div class="error">
    
    <h2>非常遗憾，您访问的页面不存在！</h2>
    
    <h2>您可以尝试重新登录!</h2>
    <p ><a id="secondes">3</a>秒后将自动跳转至登录界面</p>
    <!-- ，立即跳转请点击,<a  href="javascript:history.back();">返回</a> -->
    <div class="reindex"><a href="../loginController/loginOut.do" target="_parent">重新登录</a></div>
    
    </div>
</body>
</html>
