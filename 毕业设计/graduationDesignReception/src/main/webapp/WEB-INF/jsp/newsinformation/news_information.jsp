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
		/*main*/
		#main{width:900px;overflow:hidden;height:auto;background-color: #E7F1FA;}
		#main .l_box {width: 100%;}
		#main .l_box_title{border-bottom:2px solid #bebebe; height:46px; line-height:46px;}
		/*通知公告*/
		.main_tz{width:1366px;height:auto;overflow:hidden;background-color: #e8e7e7;padding-left: 170px;}
		.main_tz_r{ width:100%;height:auto;margin: 5px 0px 5px 20px;background:#e8e7e7;padding:10px;}
		.main_tz_r .new .arrow_box { background: #f8f8f8; box-shadow: 0px 1px 0px rgba(255,255,255,.1), inset 0px 1px 1px rgba(214, 214, 214, 0.7); width: 800px; height:100px;border-radius: 6px; position: relative; padding: 10px 0; margin: 30px 50px; }
		.main_tz_r .new .arrow_box img { width: 120px; height:100px;float: left; margin: -10px 20px 0 20px; }
		.main_tz_r .new .arrow_box p { float: left;line-height: 100px;height:100px;}
		.main_tz_r .new .arrow_box a:hover { color:#ff6709;}
		.main_tz_r .new .arrow_box::after { content: ""; width: 10px; height: 10px; border-radius: 50%; position: absolute; left: 526px; top: 36px; background: #CCCCCE; border: 2px solid #fff; transition: all 0.5s; }/* 圆形 */
		.main_tz_r .new .arrow_box:hover::after { border: #fff 2px solid; background: #5EA51B }/* 圆形 */
		.main_tz_r .new .arrow_box:hover { background: #f4f2f2; color: #ff6709; text-shadow: #f7f7f7 1px 1px 1px }
		.main_tz_r .new .arrow_box .dateview { background:#e8e7e7;position: absolute; left: 555px; top: 40px; width: 125px; line-height: 30px; background: #5EA51B; border-radius: 0px 40px; text-align: center; color: #fff }
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
<body style="background:url(../images/123.jpg) no-repeat center 0px;background-size:1366px 877px;">
	
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		<div class="l_box fl">
			<div class="l_box_title" style="width: 900px;">
				<span class="name">新闻动态</span>
			</div>
		
            <div class="main_tz_r fl" style="margin-left:-10px;">
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
						</ul>
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
	<!-- 主体结束 -->
	<!-- 页脚开始 -->
	<jsp:include page="../common/foot.jsp"/>
	<!-- 页脚结束 -->
</body>
</html>