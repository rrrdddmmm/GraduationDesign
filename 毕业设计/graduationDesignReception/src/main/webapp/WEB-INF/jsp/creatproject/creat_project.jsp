<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>创建项目-基于项目管理流程的校园软件项目协同平台</title>
	<link rel="stylesheet" type="text/css" href="../css/base.css">
		<link rel="stylesheet" type="text/css" href="../css/table.css">
	<style type="text/css">
		body{ margin:0; padding:0; font:normal 14px/24px "\5FAE\8F6F\96C5\9ED1";}
	</style>
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	    $(function(){
	        $('#off-body').click(function(){
	            $('body').css({'background':'#e8e7e7 '})
	            $(this).hide();
	        });
	    });
		 $(document).ready(function(){
            $("#wrap li").hover(function(){
                $(this).children("ul").slideToggle();
            });
        });
		 function verify(){
			 if(verifynull("project_name")&&verifynull("email")&&verifynull("file")&&verifyselect("project_language")&&
					 verifynull("develop_platform")&&verifynull("all_number")
					 &&verifynull("crt_time_str")&&verifynull("update_time_str")&&verifynull("leader")&&
					 verifynull("approver")&&verifynull("projectbudget")&&verifynull("describeproject")&&
					 verifyPric("projectbudget")&&regnum("all_number")){
				 return true;
			 }else{
				 return false;
			 }
		 }
		//金额验证
		 function verifyPric(id){
		     var reg=/^[0-9]*.{0,1}[0-9]*[0-9]$/;
		     var result= reg.test($("#"+id+"").val());
		     if(!result){
		         alert("请填写正确金额格式！",2);
		         $("#"+id+"").val("");
		 		return false;
		     }
		 	return true;
		 }
		 //数字验证
		 function regnum(id){
		     var reg=/^[0-9]*[0-9]*[0-9]$/;
		     var result= reg.test($("#"+id+"").val());
		     if(!result){
		         alert("请填写正确数量格式！",2);
		         $("#"+id+"").val("");
		 		return false;
		     }
		 	return true;
		 }
		//判空验证
		 function verifynull(id){
		 	if($("#"+id+"").is(":visible") && $("#"+id+"").val()==""){
		 		alert("请填写"+id);
		 		return false;
		 	}else{
		 		return true;
		 	}
		 }
		//判空验证
		 function verifyselect(id){
		 	if($("#"+id+"").val()==-1){
		 		alert("请填写"+id);
		 		return false;
		 	}else{
		 		return true;
		 	}
		 }
	</script>
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box_title">
			<span class="name">创建项目</span>
		</div>
		<div class="main_box">
			<fs:form action="toSave.do" method="post" id="" modelAttribute="project">
				<table width="1000" border="2" cellpadding="0" cellspacing="0" class="main_table">
					<tbody>
					<tr>
						<td>项目名称：</td>
						<td>
							<input type="text" name="project_name" id="project_name"　>
							<input type="text" name="status" value="0" style="display:none;">
							<input type="text" name="pronser_number" value="1" style="display:none;">
							<input type="text" name="email" id="email" value="${user.email }" style="display:none;">
						</td>
						<td>开发语言：</td>
						<td>
							<select name="project_language" id="project_language">
								<option value ="java">java</option>
								<option value ="c语言">c语言</option>
								<option value="c++">c++</option>
								<option value="php">php</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>参与人数：</td>
						<td><input type="text" name="all_number" id="all_number"></td>
						<td>上传立项书：</td>
						<td><input type="file" id="file"></td>
					</tr>
					<tr>
						<td>项目批准人：</td>
						<td><input type="text" name="approver" id="approver"></td>
						<td>开发环境：</td>
						<td><input type="text" name="develop_platform" id="develop_platform"></td>
					</tr>
					<tr>
						<td>项目经理：</td>
						<td><input type="text" name="leader" id="leader"></td>
						<td>项目预算：</td>
						<td><input type="text" name="projectbudget" id="projectbudget"　style="width:180px;margin-right:5px;"><span style="font-weight:bold">元</span></td>
					</tr>
					<tr>
						<td>项目简介：</td>
						<td colspan="3"><textarea name="describeproject" id="describeproject" size="20"></textarea></td>
					</tr>
					<tr>
						<td>立项时间：</td>
						<td><input type="date" name="crt_time_str" id="crt_time_str"></td>
						<td>启动时间：</td>
						<td><input type="date" name="update_time_str" id="update_time_str"></td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="submit" value="提交项目" onclick="return verify();" class="btn">
							<input type="reset" value="取消创建" class="btn">
						</td>
					</tr>
					</tbody>
				</table>
			</fs:form>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="../common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
</html>