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
		 function uptask(){
			 if(verifynull("submitter")&&verifynull("file")){
				 alert("提交成功!");
			 }else{
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
	<jsp:include page="common/header.jsp"/>
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
						<td>提交人：</td>
						<td><input type="text" name="all_number" id="submitter"></td>
						<td>上传立项书：</td>
						<td><input type="file" id="file"></td>
					</tr>
					
					<tr>
						<td colspan="4">
							<input type="button" value="提交项目" onclick="return uptask();" class="btn">
							<input type="button" value="取消提交" class="btn" onclick="history.back()">
						</td>
					</tr>
					</tbody>
				</table>
			</fs:form>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
</html>