<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	</script>
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	
	<!-- 头部开始 -->
	<jsp:include page="common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box_title">
			<span class="name">项目信息</span>
		</div>
		<div class="main_box">
				<table width="1000" border="2" cellpadding="0" cellspacing="0" class="main_table">
				
					
					<tr>
						<td>项目名称：</td>
						<td><input type="text" value="${pro.project_name}"></td>
						<td>参与人数：</td>
						<td><input type="text" value="${pro.all_number}"></td>
					</tr>
					<tr>
						<td>项目经理：</td>
						<td><input type="text" value="${pro.leader}"></td>
						<td>当前人数：</td>
						<td><input type="text" value="${pro.pronser_number}"></td>
					</tr>
					<tr>
						<td>开发语言：</td>
						<td><input type="text" value="${pro.project_language}"></td>
						<td>开发环境：</td>
						<td><input type="text" value="${pro.develop_platform}"></td>
					</tr>
					<tr>
						<td>项目批准人：</td>
						<td><input type="text" value="${pro.approver}" ></td>
						<td>项目预算：</td>
						<td><input type="text" value="${pro.projectbudget}" style="width:180px;margin-right:5px;"><span style="font-weight:bold">元</span></td>
					</tr>
					<tr>
						<td>项目简介：</td>
						<td colspan="3"><textarea name="" id="" size="20" >${pro.describeproject}</textarea></td>
						
						
					</tr>
					<tr>
						<td>立项时间：</td>
						<td><input type="text" value="${pro.crt_time}"></td>
						<td>更新时间：</td>
						<td><input type="text" value="${pro.update_time}"></td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
</html>