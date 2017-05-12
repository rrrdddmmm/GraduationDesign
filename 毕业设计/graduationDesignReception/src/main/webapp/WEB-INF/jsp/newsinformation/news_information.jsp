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
	
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
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
					<jsp:include page="../common/right.jsp"/>
			</div>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="../common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
</html>