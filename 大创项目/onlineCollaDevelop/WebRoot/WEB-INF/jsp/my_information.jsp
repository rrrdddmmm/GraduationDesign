<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
	<!-- 头部开始 --><!-- 头部开始 --><div align="right"><ol><li><h1><em><font face="Adobe 黑体 Std R"><strong></strong></font><font face="隶书" size="4" color="#0000ff">
	<u><strong><a href="toMyInformation.do">admin:欢迎您!!!</a></strong></u></font></em></h1></li>
	<li><font face="隶书" size="4" color="#0000ff"><u><a href="../exit/toExit.do">退出</a><br><br></u></font></li></ol></div>
	<div id="header" class="w">
		<div class="topbar">
			<div class="logo fl">
				<a href="../index/toIndex.do"><img src="../images/logo1.png" width="268" height="70" alt="西安植物园"></a>
			</div>
			<div class="nav fr">
				<ul class="clearfix">
						<li><a href="../index/toIndex.do">首页</a></li>
						<li><a href="../news/toNews.do">新闻动态</a></li>
						<li><a href="rcap.html">加入项目</a></li>
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
			                    <td><input type="text" value="" name="email" class="inputxt" datatype="e" errormsg="请输入正确的格式！"  /></td>
			                    <td><div class="Validform_checktip">请输入常用的电子邮箱</div></td>
			                </tr>
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">手机号码：</td>
			                    <td><input type="text" value="" name="tel" class="inputxt" datatype="m" errormsg="手机号码输入有误！"  /></td>
			                    <td><div class="Validform_checktip">请输入中国大陆手机号码</div></td>
			                </tr>
			                
			                <tr>
			                    <td class="need">*</td>
			                    <td class="txt">角色：</td>
			                    <td>
			                    	<select name="province" datatype="*" nullmsg="请选择！" errormsg="请选择所在国家！">
				                    	<option value="XZ">--请选择--</option>      
								        <option value="UK">学生</option>  
					        			<option value="CN">教师</option> 
				                    </select>
			                    </td>
			                    <td><div class="Validform_checktip">请选择角色</div></td>
			                </tr>
			                <tr>
			                    <td class="need"></td>
			                    <td></td>
			                    <td colspan="2">
			                        <input type="submit" class="confirm" value="保存" /> <input type="button" onclick="history.back();" class="clear" value="返回" />
			                    </td>
			                </tr>
			            </table>
			        </form>
				</div>
			</div>
		</div>
		<div class="r_box fr">
			<div class="r_box_hy">
					<ul class="hy">
						<div class="l_box_title">
							<span class="name">注册入口</span>
						</div>
						<li class="b"><a href="../register/toRegister.do"><img src="../images/zcsq.jpg"></a></li>
						<div class="l_box_title">
							<span class="name">登录入口</span>
						</div>
						<li class="b"><a href="../login/toLogin.do"><img src="../images/hcwz.jpg"></a></li>
					</ul>
					<ul class="yq">
						<li><img src="../images/yqlj.png" width="205" height="60"></li>
						<li><a href="http://www.xazwy.com/" target="_blank"><img src="../images/yq01.jpg" width="205" height="60"></li></a>
						<li><a href="http://www.xab.cas.cn/" target="_blank"><img src="../images/yq02.png" width="205" height="60"></li></a>
						<li><a href="http://www.ibcas.ac.cn/" target="_blank"><img src="../images/yq03.png" width="205" height="60"></li></a>
					</ul>
			</div>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<div id="footer" class="w">
		<br>
		<p>地址：西安市临潼区陕鼓大道西安科技大学 邮编 710600 </p>
		<p>版权所有：© 陕西省西安市临潼区西安科技大学</p>
	</div>
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