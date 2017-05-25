<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册申请-校园软件开发在线协同平台</title>
	<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="../css/validform.css">
	<link rel="stylesheet" type="text/css" href="../css/base.css">
	<style type="text/css">
		body{ margin:0; padding:0; font:normal 14px/24px "\5FAE\8F6F\96C5\9ED1";}
	</style>
	<script src="../content/js/commonalert.js" type="text/javascript" ></script>
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	<script src="../content/js/jquery.md5.js" type="text/javascript" ></script>
	
</head>
<body style="background:url(../images/123.jpg) no-repeat ;background-size:1366px 877px">
	
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box fl">
			<div class="l_box_title">
				<span class="name">注册申请</span>
			</div>
			<div class="l_box_content">
				<div style="margin:20px auto; text-align:center; width:500px;">
					<form class="registerform" method="post" action="">
			            <table width="100%" style="table-layout:fixed;">
			            	<tr>
			                    <td class="need">*</td>
			                    <td class="txt">姓   名：</td>
			                    <td><input type="text" id="name"  name="name" class="inputxt"/></td>
			                    <td><div class="Validform_checktip" id="warning_01"></div></td>
			                </tr>
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">电子邮箱：</td>
			                    <td><input type="text" id="email"  name="email" class="inputxt" datatype="e" errormsg="请输入正确的格式！"  /></td>
			                    <td><div class="Validform_checktip" id="warning_02"></div></td>
			                </tr>             
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">手机号码：</td>
			                    <td><input type="text" value="" id="phone" name="tel" class="inputxt" datatype="m" errormsg="手机号码输入有误！"  /></td>
			                    <td><div class="Validform_checktip" id="warning_03"></div></td>
			                </tr>
			                
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">角色：</td>
			                    <td>
			                    	<select name="province" id="role"  datatype="*" nullmsg="请选择！" errormsg="请选择所在国家！">
				                    	<option value="-1">--请选择--</option>      
								        <option value="1">学生</option>  
					        			<option value="2">教师</option> 
				                    </select>
			                    </td>
			                    <td><div class="Validform_checktip" id="warning_04"></div></td>
			                </tr>
			                <tr>
			                    <td class="need"></td>
			                    <td></td>
			                    <td colspan="2">
			                        <input type="button" id="regist_button" class="confirm" value="注册" /> 
			                        <input type="reset" class="clear" value="重置" />
			                    </td>
			                </tr>
			            </table>
			        </form>
				</div>
			</div>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="../common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
<script type="text/javascript">   
	$(function(){
		//隐藏所有提示信息
	  	$("#warning_1").hide();$("#warning_2").hide();$("#warning_3").hide();$("#warning_4").hide();
	  	//注册按钮单击处理
	  $("#regist_button").click(function(){
	  	//获取要提交的数据
	  	var email = $("#email").val().trim();
	  	var phone = $("#phone").val().trim();
	  	var role = $("#role").val().trim();
	  //检测数据格式
	  	if($("#name").val() == ""){
	  		$("#warning_01").html("2-16个字符");
	  		$("#warning_01").show();
	  		return;
	  	}
	  	if(email == ""){
	  		$("#warning_02").html("请输入常用的电子邮箱");
	  		$("#warning_02").show();
	  		return;
	  	}
	  	if(!varifyEmail("email")){
	  		$("#warning_02").html("电子邮箱格式有误！");
	  		$("#warning_02").show();
	  		$("#email").val("");
	  		return;
	  	}
	  	if(phone == ""){
	  	  	$("#warning_03").html("请输入中国大陆手机号码");
	  		$("#warning_03").show();
	  		return;
	  	}
	  	if(!verifymobile("phone")){
	  	  	$("#warning_03").html("手机号码格式有误!");
	  		$("#warning_03").show();
	  		$("#phone").val("");
	  		return;
	  	}
	  	if(role == "-1"){
	  	  	$("#warning_04").html("请选择角色");
	  		$("#warning_04").show();
	  		return;
	  	}
	  	//发送ajax请求
		  $.ajax({
		  		url:"registerHandle.do",
		  		type:"post",
		  		dataType:"json",
		  		data:{"name":$.trim($("#name").val()),
		  			  "email":$.trim(email),
		  			  "phone":$.trim(phone),
		  			  "role":$.trim(role)
		  			},
		  		success:function(result){
		  			if(result.status==0){//成功
		  				_alert(result.msg);
		  			}else if(result.status!=0){//用户名被占用
		  				_alert(result.msg,2);
		  			}
		  		},
		  		error : function() {  
		 		   _alert("注册失败，请检查网络后重试",2);  
		 		}  
		  	});
	  });
	});
	function verifymobile(id){
		var reg=/^1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{4,7}(-\d{1,8})?$/;
	    var result= reg.test($("#"+id+"").val());
	    if(!result){
	        $("#"+id+"").val("");
			return false;
	    }
		return true;
	}
	//对电子邮件的验证
	function varifyEmail(){
		  //对电子邮件的验证
		  var myreg =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/
		  if(!myreg.test($.trim($("#email").val()))){
		    return false;
		  }
		  return true;
		}
	</script>
</html>
