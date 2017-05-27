<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("cache-control", "no-cache");
response.setHeader("cache-control", "no-nostore");
response.setHeader("expire", "0");
response.setHeader("progma", "no-cache");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<meta HTTP-EQUIV="expires" CONTENT="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>校园软件开发在线协同平台</title>
<link href="content/css/style.css" rel="stylesheet" type="text/css" />
<script src="content/js/commonalert.js" type="text/javascript"  charset="utf-8"></script>
<script src="content/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="content/js/jquery.1.7.2.min.js" type="text/javascript"></script>
<script src="content/js/jquery.md5.js"></script>
<script src="content/js/user/userlogin.js" type="text/javascript"></script>

<style>
</style>
</head>

<body>
    <div class="deluku" style="top: 253px;">
    <h1 class="logo">
         <img src="content/images/logo.fw.png" /> 

    </h1>
    <div class="login_form f_14">

        <table width="80%" border="0" cellpadding="0" cellspacing="10" style="margin: 38px auto">
            <tr>
                <td height="40" align="right">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
                <td >
                    <input name="email" type="text" class="input_txt"  id="email" placeholder="请输入您的邮箱"/>

                </td>
            </tr>
            <tr>
                <td height="40" align="right">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                 <td>
                   <input name="password" type="password" placeholder="初始化密码：123456" class="input_txt"  id="password" onkeydown="if (event.keyCode == 13) { login(); };"  placeholder="请输入您的密码" />

                 </td>
            </tr>
            <tr>
                <td height="40" align="right">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</td>
                 <td height="40">
                   <select id="role" class="input_b" style="width:148px;height:34px">
			          <option selected="selected" value="-1">---请选择---</option>
			          <option value="1">学生</option>
			          <option value="2">教师</option>
			          <option value="3">管理员</option>
      				</select>
                 </td>
            </tr>
            <tr>
                <td height="40" colspan="2" >
                    <button type="button" class="btn_submit" style="margin-left:90px;">登 录</button>
                    <button type="reset" class="btn_reset">重 置</button>
                </td>
            </tr>
        </table>
    </div>
<div class="site_info">
主办单位：西安科技大学<br />
技术支持：任勃&nbsp;&nbsp;18829348437
</div>
</div>
    <script type="text/javascript">
        var winHeight;
        var winWidth;
        var win = null;
        winWidth = window.self.screen.width;
        winHeight = window.self.screen.height;
        function toFull() {
            if (window.name == "fullscreen") return;
            var a = window.open("", "fullscreen", "top=0,left=0,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,copyhistory=no,width=" + winWidth + ",height=" + (winHeight - 50))
            a.location = window.location.href
            window.opener = null
            window.close()
        }
        //toFull();
    </script>
    <script type="text/javascript">
        $(function () {
            $("body").append("<div id='main_bg'/>");
            $("#main_bg").append("<img src='content/images/login_bg.jpg' id='bigpic'>");
            cover();
            $(window).resize(function () { //浏览器窗口变化 
                cover();
            });
            var msg= '${controllerExceptionInfo}';
            if(msg!=""){
            	_alert('${controllerExceptionInfo}',2);	
            }
        });
        function cover() {
            var win_width = $(window).width();
            var win_height = $(window).height();
            $("#bigpic").attr({ width: win_width, height: win_height });
        }

</script>
<script type="text/javascript">
$(function() {
	$(".btn_submit").click(function() {
		login();
	});
	$(".btn_reset").click(function() {
		$("#email").val("");
		$("#password").val("");
		$("#role").val("");
	});
});
function login() {
	if ($("#email").attr("value") == "" || 
		$("#password").attr("value") == "" || 
		$("#role").attr("value") == "-1") {
		_alertlogin("用户名和密码和角色不为空",2);
		return;
	} else if(!varifyEmail($.trim($("#email").val()))){
		_alertlogin("请输入正确邮箱!",2);
	}else{
		$.ajax({
			type : "POST",
			url : "userLoginController/loginHandle.do",
			data : "email=" + $.trim($("#email").val())+
				   "&password=" + $.md5($.trim($("#password").val()))+
			       "&role=" + $.trim($("#role").val()),
			dataType : "json",
			error : function() {
				_alertlogin("错误输出",2);
			},
			success : function(result) {
				//解析返回的JSON结果
      		  	if(result.status==0){//成功 		  		
      		  	window.location.href = "commonController/toDefault.do";
				$("#email").val("");
				$("#password").val("");
				$("input[name='role']:checked").val("-1");
      		  	}else {
      		  	_alertlogin(result.msg,2);
					return;
				}
			}
		})
	}
}
function varifyEmail(email){
  //对电子邮件的验证
  var myreg =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
  if(!myreg.test(email)){
    return false;
  }
  return true;
}
</script>
</body>
</html>
