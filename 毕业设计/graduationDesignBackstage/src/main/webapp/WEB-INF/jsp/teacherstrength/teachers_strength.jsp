<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" />
	<title>师资力量-基于项目管理流程的校园软件项目协同平台</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/dist/../css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/base.css">
	<style type="text/css">
		body{ margin:0; padding:0; font:normal 14px/24px "\5FAE\8F6F\96C5\9ED1";}
		.media{
    
          width: 400px;
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
</head>
<body style="background:url(../images/123.jpg) no-repeat center 0px;">
	
	<!-- 头部开始 -->
	<jsp:include page="../common/header.jsp"/>
	<!-- 头部结束 -->
	<!-- 主体开始 -->
	<div id="main" class="w">
		
		<div class="l_box fl">
			<div class="l_box_title">
				<span class="name">师资力量</span>
			</div>
			<div class="l_box_content">
				<div class="l_box_content">
				<p>申请人具有博士学位，年龄40周岁以下，具有2年以上科研或工作经历。</p>
				<p>申请人在所从事领域已取得突出的学术业绩，为同龄人中的拔尖人才，已获得学术界同行的高度认可。</p> 
				<p>申请人具有广阔的学术视野和创新思维，具备成为所从事领域领军人才的潜质。</p> 
				<p>申请人学风严谨，遵守法纪及职业道德规范。</p>
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
     <script src="bootstrap/dist/../js/jquery-1.10.2.min.js"></script>
	 <script src="bootstrap/dist/../js/bootstrap.min.js"></script>
</body>
<script type="text/javascript" src="http://baike.bdimg.com/static/wiki-common/pkg/wiki-common_sync_js_0_29c88fe.js"></script>
<script type="text/javascript" src="http://baike.bdimg.com/static/wiki-lemma/pkg/wiki-lemma_31d9713.js"></script>
<script type="text/javascript">
		!function(){		
			require.async("wiki-lemma:widget/lemma_content/commonModule/map/map.js",function(init){
				!!window.ScriptLazyLoad && window.ScriptLazyLoad.regist({
					dom:$('#map2911582'),
					loadFunc:function(){
						init("containerPrefix=container&query=%E9%99%95%E8%A5%BF%E7%9C%81%E8%A5%BF%E5%AE%89%E6%A4%8D%E7%89%A9%E5%9B%AD&city=%E8%A5%BF%E5%AE%89%E5%B8%82&zoom=14&markerPosX=108.966752&markerPosY=34.214782&centerX=108.966752&centerY=34.214782&markerUid=ce5fd91795be8a4e2db17e0b&nomark=false&markerTitle=%E8%A5%BF%E5%AE%89%E6%A4%8D%E7%89%A9%E5%9B%AD&markerAddress=%E9%9B%81%E5%A1%94%E5%8C%BA%E7%BF%A0%E5%8D%8E%E5%8D%97%E8%B7%AF17%E5%8F%B7&float=hangright&desc=%E9%99%95%E8%A5%BF%E7%9C%81%E8%A5%BF%E5%AE%89%E6%A4%8D%E7%89%A9%E5%9B%AD","2911582");
						},
						distance:500
				});
			});
		}();
	</script>

</html>