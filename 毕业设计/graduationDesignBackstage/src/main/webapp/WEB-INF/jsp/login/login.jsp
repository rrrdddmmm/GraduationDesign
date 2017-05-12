<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册申请-基于项目管理流程的校园软件项目协同平台</title>
	<link rel="stylesheet" type="text/css" href="../css/validform.css">
	<link rel="stylesheet" type="text/css" href="../css/base.css">
	<style type="text/css">
		body{ margin:0; padding:0; font:normal 14px/24px "\5FAE\8F6F\96C5\9ED1";}
	</style>
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box fl">
			<div class="l_box_title">
				<span class="name">登陆</span>
			</div>
			<div class="l_box_content">
				<div style="margin:20px auto; text-align:center; width:500px;">
					<form class="registerform" method="post" action="">
			            <table width="100%" style="table-layout:fixed;">
			                
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">电子邮箱：</td>
			                    <td><input type="text" value="" id="email" name="email" class="inputxt" datatype="e" errormsg="请输入正确的格式！"  /></td>
			                    <td><div class="Validform_checktip" id="warning_2"></div></td>
			                </tr>
			                <tr>
			                    <td class="need" style="width:10px;">*</td>
			                    <td class="txt">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
			                    <td ><input type="password" name="password" id="password" class="inputxt" datatype="s2-16" errormsg="用户名至少2个字符,最多16个字符！" /></td>
			                    <td><div class="Validform_checktip" id="warning_1"></div></td>
			                </tr>
			               <tr>
			                    <td class="need">*</td>
			                    <td class="txt">角色：</td>
			                    <td>
			                    	<select name="role" id="role" datatype="*" nullmsg="请选择！" errormsg="请选择所在国家！">
				                    	<option value="1">--请选择--</option>      
								        <option value="1">学生</option>  
				                    </select>
			                    </td>
			                    <td><div class="Validform_checktip"></div></td>
			                </tr>
			                <tr>
			                    <td class="need"></td>
			                    <td></td>
			                    <td colspan="2">
			                        <input type="button" id="login" class="confirm" value="登录" /> <input type="reset" class="clear" value="重置" />
			                    </td>
			                </tr>
			            </table>
			        </form>
				</div>
			</div>
		</div>
		<div class="r_box fr">
			<div class="r_box_hy">
					<jsp:include page="../common/right.jsp"/>
			</div>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<div id="footer" class="w">
		<br>
		<p>地址：西安市临潼区陕鼓大道西安科技大学 邮编 710600 </p>
		<p>版权所有：© 陕西省西安市临潼区西安科技大学</p>
	</div>
	<!-- 页脚结束 -->
</body>
<script type="text/javascript">
	$(function(){
	  $("#login").click(function(){
		  $("#warning_1").html("");
		  $("#warning_2").html("");
		  $("#role").html();
	   var password = $("#password").val().trim();
      	var email = $("#email").val().trim();
      	var role=$("#role").val().trim();
      	var flag = true;//通过检测
      	if(password==""){
      		$("#warning_1").html("2-16个字符");
      		flag = false;//未通过检测
      	}
      	if(email==""){
      		$("#warning_2").html("请输入注册时的电子邮箱");
      		flag = false;//未通过检测
      	}if(role==""){
      		$("#role").html("请选择角色");
      	}
      		//通过检测，发送Ajax请求
      	if(flag){
      		$.ajax({     		
      		  url:"loginIn.do",
      		  type:"post",
      		  data :{"password":password,"email":email,"role":role},
      		  dataType:"json",
      		  success:function(result){
      		  	if(result.status==0){//成功 		  		
      		  		window.location.href="../index/toIndex.do";
      		  	}else if(result.status==1){
      		  	   $("#warning_1").html("用户名错误");
      		  	}else if(result.status==2){
      		  	  $("#warning_2").html("邮箱错误 ");
      		  	}
      		  }
		      
      		});
      	}
	 });
	});
	</script>
</html>
