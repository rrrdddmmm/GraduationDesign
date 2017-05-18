<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的信息</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript" src="../content/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../content/js/jquery-form.js"></script>
<script type="text/javascript" src="../content/js/user/opuser.js"></script>
<script src="../content/js/jquery.md5.js"></script>
<script type="text/javascript" src="../content/js/commonalert.js"></script>
<script type="text/javascript" src="../content/js/commonutil.js"></script>
<script src="laydate/laydate.js"></script>
</head>
<body>
	<h1 class="globle_title2">
		<img src="../content/images/tag.gif" id="myinfoimg"/> 修改用户信息 <em></em>
	</h1>
	<div class="sytxq_conment_wk">
		<div class="sytxq_conment_wk_bx">
			<div class="syt_lb_top">
				<h1 class="syt_lb_top_titleh2" id="userinfoh1">${user.name }的信息表</h1>
			</div>
			<div class="sytxq_conment">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="table_xq">
					<tr>
						<td class="table_xqa">姓名：</td>
						<td class="table_xqb">
						<input type="text" placeholder="姓名" id="name" value="${user.name }" class="syt_lb_top_conment_txt" />
						</td>
						<td  id="imgDiv" rowspan="5" colspan="1" style="width:10%;border-bottom:1px solid #94C2EF;padding-top:10px;" align="center">
							<img id="imgDiv" src="${user.image }" style="width:160px;height:180px;"><p style="color:red;text-align:left;">注：<br>1.照片的像素为160*180px。<br>2.照片格式为BMP/JPG/JPEG。<br>3.建议照片大小不超过40k。</p>
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">Email：</td>
						<td class="table_xqb">
						<input type="text" placeholder="Email" id="email" value="${user.email }" class="syt_lb_top_conment_txt" />
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">手机号：</td>
						<td class="table_xqb">
						<input type="text" placeholder="手机号" id="phone" value="${user.phone }" class="syt_lb_top_conment_txt" />
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
								<c:choose>
									<c:when test="${li.name==user.education }">
										<option selected="selected" value="${li.name }">${li.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${li.name }">${li.name }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
						</td>

					</tr>
					<tr>
						<td class="table_xqa">职称：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="title" style="float:left;">
							<c:forEach items="${titleconfiglist }" var="li" varStatus="idxStatus">
								<c:choose>
									<c:when test="${li.name==user.title }">
										<option selected="selected" value="${li.name }">${li.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${li.name }">${li.name }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
						</td>
						<td style="border-bottom:1px solid #94C2EF;" align="center">
							<form id="upload" enctype="multipart/form-data">
								<input type="file" name="file" id="uploadimage" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/>
							</form>
						</td>
					</tr>
					<tr>
						<td class="table_xqa">方向：</td>
						<td colspan="2" class="table_xqb">
						<select name="branch" class="input_b" id="direction" style="float:left;">
							<c:forEach items="${directionconfiglist }" var="li" varStatus="idxStatus">
								<c:choose>
									<c:when test="${li.name==user.direction }">
										<option selected="selected" value="${li.name }">${li.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${li.name }">${li.name }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> 
						</td>
	
					</tr>
					<tr>
				    	<td class="table_xqa">个人简介：</td>
				      	<td colspan="2" class="table_xqb">
				      		<textarea name="txtOpinion" class="textarea_wby" rows="4"  maxlength="155" style="width:468px;resize: none;" id="introduce" >${user.introduce}</textarea>
				      		<p style="color:red;text-align:left;"><br>注意：不能超过150个字符。</p>
				      	</td>
				    </tr>
					<tr>
						<td class="table_xqa">用户密码：</td>
						<td colspan="2" class="table_xqb"><input type="password" id="password" 
							placeholder="密码为空则不修改密码" value="" class="syt_lb_top_conment_txt"
							style="float:left;" />
							<div class="clear"></div>
						</td>
						
					</tr>
					<tr>
						<td class="table_xqa">用户状态：</td>
						<td class="table_xqb">
						<label> 
						 	<cite style="padding-top: 0px;"> 
						 	<input type="radio" value="1" name="state" />
						 	</cite>
							<span style="padding-top: 0px;">启用</span>
						 </label> 
						 <label> 
							<cite style="padding-top: 0px;">
							<input name="state" type="radio" value="2" />
							</cite>
							<span style="padding-top: 0px;">停用</span>
						</label>
						</td>
					</tr>
				</table>
			</div>
			<div class="sytxq_conment_bc">
				<button type="button" id="tsave" class="chaxun_but">保 存</button>
				<button type="button" onclick="location.href='userList.do'" class="chaxun_but">返
					回</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#role").val('${user.role }');
			$("input[name='state']:eq(${user.state-1})").attr("checked",
			'checked');
			$("#uploadimage").change(function(){
				_confirm("是否上传？",1,"uploadPhoto()");
			})
			
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
			     if($.trim($("#password").val())!=""){
					$("#password").val($.md5($.trim($("#password").val())));
				 }
			     $.ajax({
						type : "POST",
						url : "userAlterHandle.do",
						data : {
							id   :'${user.id}',
							name : $("#name").val(),
							email: $("#email").val(),
							phone: $("#phone").val(),
							role:  $("#role").val(),
							education: $("#education").val(),
							title: $("#title").val(),
							state: $("input[name='state']:checked").val(),
							direction: $("#direction").val(),
							introduce: $("#introduce").val(),
							password: $.trim($("#password").val())
						},
						dataType : "json",
						success : function(result) {
							if(result.status=='0'){
								_alert(result.msg);
								$("#password").val("");
								var newname=$("#name").val();
								$("#userinfoh1").html(""+newname+"的信息表");
								return;
							}else{
								_alert(result.msg,2);
							}
						},
						error : function() {  
				            _alert("信息修改失败，请检查网络后重试",2);  
				        }  
				});
	        })
		})
		function uploadPhoto() { 
			var id='${user.id}';
		    var imagePath = $("#uploadimage").val();  
		    if (imagePath == "") {  
		    	_alert("please upload image file",2);
		        return false;  
		    }  
		    var strExtension = imagePath.substr(imagePath.lastIndexOf('.') + 1);  
		    if (strExtension != 'jpg' && strExtension != 'jpeg'  
		            && strExtension != 'png' && strExtension != 'bmp') {  
		        _alert("please upload file that is a image",2);  
		        return false;  
		    }  
		    $("#upload").ajaxSubmit({  
		        type : 'POST',  
		        url : '../userMyInfomationController/uploadMyimage.do?id='+id+'',  
		        success : function(result) {  
		        	if(result.status=='0'){
						_alert(result.msg);
						$("#imgDiv").empty();
			            $("#imgDiv").html("<img id='imgDiv' src='"+result.newpath+"' style='width:160px;height:180px;'><p style='color:red;text-align:left;'>注：<br>1.照片的像素为160*180px。<br>2.照片格式为BMP/JPG/JPEG。<br>3.建议照片大小不超过40k。</p>");
			            $("#imgDiv").show();
			            $("#uploadimage").val("");
		        	}else{
		        		_alert(result.msg,2);
		        	}
		        },  
		        error : function() {  
		            _alert("上传失败，请检查网络后重试",2);  
		        }  
		    });  
		}  
	</script>
</body>