<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript" src="../content/js/user/opuser.js"></script>
<script src="laydate/laydate.js"></script>
<script type="text/javascript" src="../content/js/commonalert.js"></script>
<script type="text/javascript" src="../content/js/commonutil.js"></script>
</head>
<body>
	<input type="hidden" id="id" value="" />
	<h1 class="globle_title2">
		<img src="../content/images/tag.gif" /> 添加用户 <em></em>
	</h1>
	<div class="sytxq_conment_wk">
		<div class="sytxq_conment_wk_bx">
			<div class="syt_lb_top">
				<h1 class="syt_lb_top_titleh2">用户信息表</h1>
			</div>
			<div class="sytxq_conment">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="table_xq">
					<tr>
						<td class="table_xqa">姓名：</td>
						<td class="table_xqb">
						<input type="text" placeholder="姓名" id="name" class="syt_lb_top_conment_txt" />
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">Email：</td>
						<td class="table_xqb">
						<input type="text" placeholder="Email" id="email" class="syt_lb_top_conment_txt" />
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">手机号：</td>
						<td class="table_xqb">
						<input type="text" placeholder="手机号" id="phone" class="syt_lb_top_conment_txt" />
						</td>

					</tr>
					<tr>
						<td class="table_xqa">角色：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="role" style="float:left;">
							<option value="1">学生</option>
						    <option value="2">教师</option>
						    <option value="3">管理员</option>
						</select> 
						</td>
					</tr>
					<tr>
						<td class="table_xqa">学历：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="education" style="float:left;">
							<c:forEach items="${educationconfiglist }" var="li" varStatus="idxStatus">
								<option value="${li.name }">${li.name }</option>
							</c:forEach>
						</select> 
						</td>
					</tr>
					<tr>
						<td class="table_xqa">职称：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="title" style="float:left;">
							<c:forEach items="${titleconfiglist }" var="li" varStatus="idxStatus">
								<option value="${li.name }">${li.name }</option>
							</c:forEach>
						</select> 
						</td>
					</tr>
				    <tr>
						<td class="table_xqa">方向：</td>
						<td colspan="2" class="table_xqb">
						<select name="branch" class="input_b" id="direction" style="float:left;">
							<c:forEach items="${directionconfiglist }" var="li" varStatus="idxStatus">
								<option value="${li.name }">${li.name }</option>
							</c:forEach>
						</select> 
						</td>
	
					</tr>
					<tr>
				    	<td class="table_xqa">个人简介：</td>
				      	<td colspan="2" class="table_xqb">
				      		<textarea name="txtOpinion" class="textarea_wby" rows="4"  maxlength="155" style="width:468px;resize: none;" id="introduce" ></textarea>
				      		<p style="color:red;text-align:left;"><br>注意：不能超过150个字符。</p>
				      	</td>
				    </tr>
					<tr>
						<td class="table_xqa">用户状态：</td>
						<td class="table_xqb">
						<label> 
						 	<cite style="padding-top: 0px;"> 
						 	<input type="radio" value="1" checked="checked" id="state" name="state" />
						 	</cite>
							<span style="padding-top: 0px;">启用</span>
						 </label> 
						 <label> 
							<cite style="padding-top: 0px;">
							<input name="state" id="state" type="radio" value="2" />
							</cite>
							<span style="padding-top: 0px;">停用</span>
						</label>
						</td>
					</tr>
				</table>
			</div>
			<div class="sytxq_conment_bc">
				<button type="button" id="tsave" class="chaxun_but">保 存</button>
				<button type="submit" onclick="callback()" class="chaxun_but">返
					回</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#tsave").click(function () {
				if(verifynull("name") && verifynull("email") &&
			       verifynull("phone") &&verifynull("introduce")) {
			    }else{
			    	return;
			    }
			    if(!verifymobile("phone")){
			   		return;
			     }
			     if(!varifyEmail("email")){
			        return;
			     }
			     $.ajax({
						type : "POST",
						url : "userAddHandle.do",
						data : {
							name : $("#name").val(),
							email: $("#email").val(),
							phone: $("#phone").val(),
							role:  $("#role").val(),
							education: $("#education").val(),
							title: $("#title").val(),
							direction: $("#direction").val(),
							introduce: $("#introduce").val(),
							state: $("#state").val()
						},
						dataType : "json",
						success : function(result) {
								if(result.status=='0'){
									_alert(result.msg);
									$("#name").val("");
									$("#email").val("");
									$("#phone").val("");
									$("#introduce").val("");
								}else{
									_alert(result.msg,2);
								}
								return;
						},
						error : function() {  
				            _alert("添加失败，请检查网络后重试",2);  
				        }  
				});
	        })
		})
	</script>
</body>