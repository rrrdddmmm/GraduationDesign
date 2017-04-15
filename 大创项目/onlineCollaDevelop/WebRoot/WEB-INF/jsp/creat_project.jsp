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
	</script>
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	
	<!-- 头部开始 --><!-- 头部开始 --><div align="right"><ol><li><h1><em><font face="Adobe 黑体 Std R"><strong></strong></font><font face="隶书" size="4" color="#0000ff">
	<u><strong><a href="../myInformation/toMyInformation.do">${user.email }:欢迎您!!!</a></strong></u></font></em></h1></li>
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
						<li><a href="../jion/toJion.do">加入项目</a></li>
						<li><a href="toCreatProject.do">创建项目</a></li>
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
			<span class="name">创建项目</span>
		</div>
		<div class="main_box">
			<form action="toSave.do" method="post">
				<table width="1000" border="2" cellpadding="0" cellspacing="0" class="main_table">
					<tbody>
					<tr>
						<td>项目名称：</td>
						<td><input type="text" name="project_name"></td>
						<td>开发语言：</td>
						<td>
							<select name="project_language">
								<option value ="1">java</option>
								<option value ="2">c语言</option>
								<option value="3">c++</option>
								<option value="4">php</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>参与人数：</td>
						<td><input type="text" name="all_number"></td>
						<td>上传立项书：</td>
						<td><input type="file" name="" id=""></td>
					</tr>
					<tr>
						<td>项目批准人：</td>
						<td><input type="text" name="approver"></td>
						<td>开发环境：</td>
						<td><input type="text" name="develop_platform"></td>
					</tr>
					<tr>
						<td>项目经理：</td>
						<td><input type="text" name="leader"></td>
						<td>项目预算：</td>
						<td><input type="text" name="budget" style="width:180px;margin-right:5px;"><span style="font-weight:bold">元</span></td>
					</tr>
					<tr>
						<td>项目简介：</td>
						<td colspan="3"><textarea name="describe" id="" size="20"></textarea></td>
					</tr>
					<tr>
						<td>立项时间：</td>
						<td><input type="date" name="crt_time"></td>
						<td>启动时间：</td>
						<td><input type="date" name="update_time"></td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="submit" value="提交项目" class="btn">
							<input type="reset" value="取消创建" class="btn">
						</td>
					</tr>
					</tbody>
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