<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>新闻动态-基于项目管理流程的校园软件项目协同平台</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css">
	<link rel="stylesheet" type="text/css" href="../css/base.css">
	<style type="text/css">
		body{ margin:0; padding:0; font:normal 14px/24px "\5FAE\8F6F\96C5\9ED1";}
		#fr1{
			    margin-top: -708px;
                margin-right: 450px;
			}
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
	</script>
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	
	<!-- 头部开始 --><!-- 头部开始 --><div align="right"><ol><li><h1><em><font face="Adobe 黑体 Std R"><strong></strong></font><font face="隶书" size="4" color="#0000ff"><u><strong><a href="../myInformation/toMyInformation.do">${user.email }:欢迎您!!!</a></strong></u></font></em></h1></li><li><font face="隶书" size="4" color="#0000ff"><u><a href="../exit/toExit.do">退出</a><br><br></u></font></li></ol></div>
	<div id="header" class="w">
		<div class="topbar">
			<div class="logo fl">
				<a href="toIndex.do"><img src="../images/logo1.png" width="268" height="70" alt="西安科技大学"></a>
			</div>
			<div class="nav fr" id="wrap">
				<ul class="clearfix">
						<li><a href="../index/toIndex.do">首页</a></li>
						<li><a href="toNews.do">新闻动态</a></li>
						<li><a href="../jion/toJion.do">加入项目</a></li>
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
			<div class="l_box_title" style="width: 725px;">
				<span class="name">新闻动态</span>
			</div>
		
                <div class="main_tz_r fl" style="margin-left:-10px;">
					<div class="main_tz_tittle" style="margin-left: 15px;">
						<img src="../images/tzgg.jpg" width="505" height="56">
					</div>
					<div class="new">
						<ul class="arrow_box">
							<li>
								<div class="sy">
									<img src="../images/tz01.jpg"><a href="http://www.xazwy.com/News/18/778.html"><p>陕西省西安科技大学校园协同开发平台启动仪式</p></a>
								</div>
								<span class="dateview">2017-06-30</span>
							</li>
						</ul>
						<ul class="arrow_box">
							<li>
								<div class="sy">
									<img src="../images/tz02.jpg"><a href="http://www.xazwy.com/News/18/777.html"><p>2017年陕西省西安科技大学校园协同开发平台试运行</p></a>
								</div>
								<span class="dateview">2017-05-01</span>
							</li>
						</ul>
						<ul class="arrow_box">
							<li>
								<div class="sy">
									<img src="../images/tz03.jpg"><a href="http://www.xazwy.com/news/18/779.html"><p>西安科技大学举办平台授权活动</p></a>
								</div>
								<span class="dateview">2017-04-17</span>
							</li>
						</ul><ul><li><br></li></ul>
						<ul class="arrow_box">
							<li>
								<div class="sy">
									<img src="../images/tz04.jpg"><a href="http://www.xazwy.com/News/18/784.html"><p>日本花甲协会农学专家佐藤千秋一行访问西安科技大学</p></a>
								</div>
								<span class="dateview">2017-03-27</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--通知公告结束-->
		     </div>
		  </div>
		</div>
		<div class="r_box fr" id="fr1">
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
</html>