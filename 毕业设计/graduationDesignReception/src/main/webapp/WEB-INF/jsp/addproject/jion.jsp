<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>加入项目-基于项目管理流程的校园软件项目协同平台</title>
	<link rel="stylesheet" type="text/css" href="../css/base.css">
		<link rel="stylesheet" type="text/css" href="../css/table.css">
	<style type="text/css">
		body{ margin:0; padding:0; font:normal 14px/24px "\5FAE\8F6F\96C5\9ED1";}
	</style>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
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
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box_title">
			<span class="name">加入项目</span>
		</div>
		<div class="main_box">
			<table width="1000" border="2" cellpadding="0" cellspacing="0" class="main_table">
				<tbody>
				<tr>
					<td colspan="9" class="table_title">项目信息管理</td>
				</tr>
				<tr class="table_subtitle">
					<td width="%">项目名称</td>
					<td width="%">项目经理</td>
					<td width="%">开发人数</td>
					<td width="%">当前人数</td>
					<td width="%">立项时间</td>
					<td width="%">更新时间</td>
					<td width="%">项目状态</td>
					<td width="%">操作</td>
				</tr>
				
				<c:forEach var="l" items="${list}">
					
					<tr>
						<td>${l.project_name}</td>
						<td>${l.leader}</td>
						<td>${l.all_number}</td>
						<td>${l.pronser_number}</td>
						<td>${l.crt_time}</td>
						<td>${l.update_time}</td>
						<c:if test="${l.status==0}">
							<td>待开发</td>
						</c:if>
						<c:if test="${l.status==1}">
							<td>开发中</td>
						</c:if>
						<td><a href="toShow.do?id=${l.project_no}">查看</a>丨<a href="toAdd.do?id=${l.project_no}">加入</a></td>
					</tr>
					</c:forEach>
				<table border="0" width="1000" class="main_page">
					<tbody>
						<tr>
							<td width="50%">共  <span class="page_text">5</span>  页  |  第  <span class="page_text">1</span>  页</td>
							<td width="40%" align="right">【 <a href="#">首页</a> | <a href="#">上一页</a> | <a href="#">下一页</a> | <a href="">末页</a> 】</td>
							<td width="10%">转至  <input type="text" size="1">  页</td>
						</tr>
					</tbody>
				</table>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="../common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
</html>