<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>我的信息-基于项目管理流程的校园软件项目协同平台</title>
	<link rel="stylesheet" type="text/css" href="../css/validform.css">
	<link rel="stylesheet" type="text/css" href="../css/base.css">
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
	</script>
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box fl">
			<div class="l_box_title">
				<span class="name">个人信息</span>
			</div>
			<div class="l_box_content">
				<div style="margin:20px auto; text-align:center; width:500px;">
					<form class="registerform" method="post" action="">
			            <table width="100%" style="table-layout:fixed;">
			               
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">电子邮箱：</td>
			                    <td><input type="text" value="${user.email }" name="email" class="inputxt" /></td>
			                </tr>
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">手机号码：</td>
			                    <td><input type="text" value="${user.phone }" name="tel" class="inputxt"  /></td>
			                </tr>
			                
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">角色：</td>
			                    <td><input type="text" value="学生"  class="inputxt" /></td>
			                </tr>
			                <tr>
			                    <td class="need"></td>
			                    <td></td>
			                    <td colspan="2">
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
	<jsp:include page="../common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
<script type="text/javascript" src="../js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".registerform").Validform({
			tiptype:2
		});
	});
</script>
</html>