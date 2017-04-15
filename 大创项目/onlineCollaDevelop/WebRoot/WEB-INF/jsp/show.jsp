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
	
	<!-- 头部开始 --><!-- 头部开始 --><div align="right"><ol><li><h1><em><font face="Adobe 黑体 Std R"><strong></strong></font><font face="隶书" size="4" color="#0000ff">
	<u><strong><a href="../myInformation/toMyInformation.do">admin:欢迎您!!!</a></strong></u></font></em></h1></li>
	<li><font face="隶书" size="4" color="#0000ff"><u><a href="../exit/toExit.do">退出</a><br><br></u></font></li></ol></div>
	<div id="header" class="w">
		<div class="topbar">
			<div class="logo fl">
				<a href="../index/toIndex.do"><img src="../images/logo1.png" width="268" height="70" alt="西安科技大学"></a>
			</div>
			<div class="nav fr" id="wrap">
				<ul class="clearfix">
						<li><a href="../index/toIndex.do">首页</a></li>
						<li><a href="../news/toNews.do">新闻动态</a></li>
						<li><a href="toJion.do">加入项目</a></li>
						<li><a href="../creatProject/toCreatProject.do">创建项目</a></li>
						<li><a href="../myProject/toMyProject.do">我的项目</a></li>
						<li><a href="../register/toRegister.do">注册</a></li>
						<li><a href="../login/toLogin.do">登陆</a></li>
						<li><a href="../teacherStrength/toTeachersStrength.do">师资力量</a></li>
				</ul>
			</div>
		</div>
		<div class="topphoto" >
			<img src="../images/lt.png" alt="" width="1039" height="90">
		</div>
	</div>
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
						<td><input type="text" value="${pro.budget}" style="width:180px;margin-right:5px;"><span style="font-weight:bold">元</span></td>
					</tr>
					<tr>
						<td>项目简介：</td>
						<td colspan="3"><textarea name="" id="" size="20" >${pro.describe}</textarea></td>
						
						
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
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<div id="footer" class="w">
		<br>
		<p>地址：西安市临潼区陕鼓大道西安科技大学 邮编 710600 </p>
		<p>版权所有：© 陕西省西安市临潼区西安科技大学</p>
	</div>
	<!-- 页脚结束 -->
</body>
</html>