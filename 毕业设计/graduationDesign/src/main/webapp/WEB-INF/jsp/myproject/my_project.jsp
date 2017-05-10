<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>日程安排-基于项目管理流程的校园软件项目协同平台</title>
		<link rel="stylesheet" type="text/css" href="../css/table.css">
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
			<span class="name">我的项目</span>
		</div>
		<div class="main_box">
			<table width="1000" border="2" cellpadding="0" cellspacing="0" class="main_table">
				<tbody>
				<tr>
					<td colspan="11" class="table_title">项目信息管理</td>
				</tr>
				
				<tr class="table_subtitle">
					<td width="%">项目名称</td>
					<td width="%">项目负责人</td>
					<td width="%">开发人数</td>
					<td width="%">立项时间</td>
					<td width="%">更新时间</td>
					<td width="%">任务优先级</td>
					<td width="%">项目状态</td>
					<td width="%">项目进度</td>
					<td width="%">任务下载</td>
					<td width="%">任务提交</td>
					<td width="%">操作</td>
				</tr>
				<c:forEach var="l" items="${list}">
				<tr>
					<td>${l.project_name}</td>
					<td>${l.leader}</td>
					<td>${l.all_number}</td>
					<td>${l.crt_time}</td>
					<td>${l.update_time}</td>
					<td>急</td>
					<c:if test="${l.status==0}">
							<td>待开发</td>
						</c:if>
					<c:if test="${l.status==1}">
							<td>开发中</td>
					</c:if>
					<td><progress value="50" max="100"></progress></td>
					<td><a href="../downLoadController/downLoad.do">任务下载</a></td>
					<td><a href="toUpTask.do">任务提交</a></td>
					<td><a href="../jion/toShow.do?id=${l.project_no}">查看</a></td>
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