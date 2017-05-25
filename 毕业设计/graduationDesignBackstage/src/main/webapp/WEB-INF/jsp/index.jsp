<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
     <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" />
	<title>校园软件开发在线协同平台</title>
		<link rel="stylesheet" type="text/css" href="../bootstrap/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="../css/index.css">
	<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="../js/Validform_v5.3.2_min.js"></script>
	<style type="text/css">
         ul{
            list-style-type: none;
        }
        
        #wrap li{
            background: #006725;
        }
        #wrap a{
            color: #fff;
            text-decoration: none;
            display: block;
            width: 70px;
            text-align: center;
        }
        #wrap li:hover{
            background:#ff6709;
        }
        #wrap li ul{
            position: absolute;
            display: none;
        }
    </style>
</head>
<body style="background:url(../images/123.jpg) no-repeat ;background-size:1366px 877px">
	<!-- 头部开始 -->
	<jsp:include page="common/header.jsp"/>
	<!-- 头部结束 -->
		<!-- 主体开始 -->
		<div id="main" class="w">
			<!-- 焦点图开始 -->
			<div class="focus">
				<div class="photo">
					<ul>
						<li style="left:0;"><a><img src="../images/banner_01.jpg" alt="" width="900px" height="220px"></a></li>
						<li><a><img src="../images/banner_03.jpg" alt="" width="900px" height="220px"></a></li>
						<li><a><img src="../images/banner_04.jpg" alt="" width="900px" height="220px"></a></li>
					</ul>
				</div>
				<div class="focus_btn"></div>
			</div>
			<!-- 焦点图结束 -->
			<!--会议掠影开始-->
			<div class="mt15">
			    <div class="sketch fl w744 locating">
			        <div class="h locating">
			            <a href="javascript:;"  title="往期团队" style="left: 296px; width: 179px;"></a>
			        </div>
			        <div class="b">
			            <div id="scroll">
			                <ul class="img-z">
			                 	<li><a href="javascript:;"><img alt="" src="../images/ly01.jpg" width="240" height="140" /><span class="transparent"></span><em>人员合照</em></a></li> 
			                 	<li><a href="javascript:;"><img alt="" src="../images/ly02.jpg" width="240" height="140" /><span class="transparent"></span><em>开场致辞</em></a></li>                     
			                 	<li><a href="javascript:;"><img alt="" src="../images/ly03.jpg" width="240" height="140" /><span class="transparent"></span><em>参会领导</em></a></li>
			                 	<li><a href="javascript:;"><img alt="" src="../images/ly04.jpg" width="240" height="140" /><span class="transparent"></span><em>互动环节</em></a></li>
			                 	<li><a href="javascript:;"><img alt="" src="../images/ly05.jpg" width="240" height="140" /><span class="transparent"></span><em>交流探讨</em></a></li> 
			                 	<li><a href="javascript:;"><img alt="" src="../images/ly06.jpg" width="240" height="140" /><span class="transparent"></span><em>热烈讨论</em></a></li>           
			                </ul>
			            </div>
			        </div>
			        <div id="scroll_btn">
			        	<a href='javascript:;' id="iLeft_btn" title="左"></a>
			        	<a href='javascript:;' id="iRight_btn" title="右"></a>
			        </div>
			    </div>
			</div>
			<!--会议掠影结束-->
			
			<!--会议简介开始-->
			<div class="main_hy fr">
					<div class="ht">
						<div class="ht_l"><!-- target="_blank" -->
							<a href="#"><img src="../images/icon-hy.png" width="24" height="24" /><h2 style="margin-top:-5px;">平台简介</h2></a>
						</div>
						<div class="ht_r">
							<span class="gd"><a href="#">更多>></a></span>
						</div>
					</div>
					<div class="hc">
						<marquee scrollamount="2" direction="up" onMouseMove="stop()" onMouseOut="start()" style="margin-right:20px; margin-left:-10px; font-size:16px; color:#207D9F;">校园软件项目管理平台，是对于当今学校里、学生、老师之前项目申请与进度查看之间的不方便而建立的。利用智能推送，将项目进行发布。让学生们第一时间能够有机会选择自己想报的项目。该平台包括项目申报、项目查看、项目管理、项目推送。</marquee>
					</div>
				</div>
			</div>
			<!--通知公告开始-->
			<div class="main_tz mt15 w">
				<div class="main_tz_l fl">
					<ul class="hy">
						<li><a href="register.do"><img src="../images/zcsq.jpg"></a></li>
						<li><a href="../userLoginController/loginOut.do"><img src="../images/hcwz.jpg"></a></li>
					</ul>
					<ul class="yq">
						<li><img src="../images/yqlj.png" width="285" height="70"></li>
						<li><a href="http://www.cnki.net/" target="_blank"><img src="../images/yq01.jpg" width="285" height="70"></li></a>
						<li><a href="http://www.csdn.net/" target="_blank"><img src="../images/yq02.png" width="285" height="70"></li></a>
						<li><a href="http://www.w3school.com.cn/" target="_blank"><img src="../images/yq03.png" width="285" height="70"></li></a>
					</ul>
				</div>
				<div class="main_tz_r fl">
					<div class="main_tz_tittle">
						<img src="../images/tzgg.jpg" width="505" height="56">
					</div>
					<div class="new">
					<c:forEach items="${newslist }" var="li" varStatus="idxStatus">
						<ul class="arrow_box">
							<li title="${li.explain }">
								<div class="sy">
									<img src="${li.logo }"><a href="${li.details }" target="_blank"><p>${fn:substring(li.explain, 0, 15)}..</p></a>
								</div>
								<span class="dateview"><fmt:formatDate value="${li.updatetime }" pattern="yyyy-MM-dd"/></span>
							</li>
						</ul>
					</c:forEach>
					</div>
				</div>
			</div>
			<!--通知公告结束-->
            <!--内容-->
            <div id="tab">
            	<div class="tab2" style="padding-top: 15px; text-align: center; background-color: #E7E7E7;">
        			<div class="container">
        				<div class="col-md-6 col-sm-6" style="margin-top: 35px;">
        					<h3>校园软件管理系统</h3>
        					<p style="color: #337AB7;">为你提供更多的项目、让你不再因为有能力而没有锻炼的机会</p>
        				</div>
        				<div class="col-md-6 col-sm-6 ">
        					<img src="../images/list5.jpg" class="img-reponsive center-block" alt="科技" />
        				</div>
        			</div>
        		</div>
        		<div class="tab2" style="padding-top: 15px; text-align: center; background-color: #E7E7E7;">
        			<div class="container">
        				<div class="col-md-6 col-sm-6">
        					<img src="../images/list6.jpg" class="img-reponsive center-block" alt="科技" />
        				</div>
        				<div class="col-md-6 col-sm-6" style="margin-top: 35px;">
        					<h3>最快的线上验收功能</h3>
        					<p style="color: #337AB7;">在如今的校园中，项目的规划还不是多么健全。具备验收功能的管理平台，减轻了学生与老师之间的工作</p>
        				</div>
        		
        			</div>
        		</div>
        		<div class="tab2" style="padding-top: 15px; text-align: center; background-color: #E7E7E7;">
        			<div class="container">
        				<div class="col-md-6 col-sm-6" \ style="margin-top: 35px;">
        					<h3>智能推送功能</h3>
        					<p style="color: #337AB7;">当完成了一个项目的时候，该平台通过智能推送、筛选，向成员提供下一个项目任务</p>
        				</div>
        				<div class="col-md-6 col-sm-6">
        					<img src="../images/list7.jpg" class="img-reponsive center-block" alt="科技" />
        				</div>
        			</div>
        		</div>
            </div>
			<!--会议简介结束-->
			
		</div>
		<!-- 主体结束 -->
		<script type="text/javascript">
			jQuery(function(){
		        /*---焦点图---*/
		        var _hdbtn=jQuery('.focus_btn')
		        var _hdfocus=jQuery('.photo li')
		        var _hdpage=0
		        var _hdlen=_hdfocus.size()
		        var _hdhtml="";

		        for(i=0;i<_hdlen;i++){
		            i==0 ? _hdhtml+="<a class='cur' href='javascript:;'></a>" : _hdhtml+="<a href='javascript:;'></a>";
		        }
		        _hdbtn.html(_hdhtml)
		        _hdfocus.eq(0).find('span,em').stop().animate({bottom:0},500)
		        _hdbtn.find('a').mouseover(function(i){
		            clearInterval(ImgSlideInt)
		            if(!jQuery(this).hasClass('cur')){
		                _hdfocus.eq(_hdpage).stop(false,true).animate({left:"-=900"},500,function(){
		                    jQuery(this).css("left","900px")
		                    jQuery(this).find('span,em').css("bottom",'-='+50+'px')
		                })
		                _hdpage=_hdbtn.find('a').index(this)
		                _hdfocus.eq(_hdpage).stop(false,true).animate({left:"-=900"},500)
		                _hdfocus.eq(_hdpage).find('span,em').stop().animate({bottom:0},500)
		            }
		            jQuery(this).addClass('cur').siblings('a').removeClass('cur')
		        }).mouseout(function(){
		                    ImgSlideInt=setInterval(ImgSlide,5000)
		                })
		        ImgSlide=function(){
		            _hdfocus.eq(_hdpage).stop(false,true).animate({left:"-=900"},500,function(){
		                jQuery(this).css("left","900px")
		                jQuery(this).find('span,em').css("bottom",'-='+50+'px')
		            })
		            _hdpage >= _hdlen-1 ? _hdpage=0 : _hdpage++
		            _hdbtn.find('a').removeClass('cur').eq(_hdpage).addClass('cur')
		            _hdfocus.eq(_hdpage).stop(false,true).animate({left:"-=900"},500)
		            _hdfocus.eq(_hdpage).find('span,em').stop().animate({bottom:0},500)
		        }
		        ImgSlideInt=setInterval(ImgSlide,7000)
		        /*园区掠影*/
		        var _scro=jQuery('#scroll ul');
		        var _scroLen=parseInt(_scro.find('li').size());
		        var _scroPage=0;
		        var _scroMax=Math.ceil(_scroLen/2)-1;
		        jQuery('#iRight_btn').click(function(){
		            scro(true);
		        });
		        jQuery('#iLeft_btn').click(function(){
		            scro(false);
		        });
		        scro=function(des){
		            des ? _scroPage>=_scroMax ? _scroPage=0 : _scroPage++ :	 _scroPage<=0 ? _scroPage=_scroMax : _scroPage--
		            jQuery('#scroll ul').stop(false,true).animate({marginLeft:"-"+_scroPage*520+"px"},500)
		        };
		        jQuery('.s_in').animate({width:parseInt(jQuery('.in_article .h li:eq(0)').width())+20+'px'},500)
		        jQuery('.in_article .h li').mouseover(function(){
		            var obj=jQuery('.s_in')
		            n=jQuery('.in_article .h li').index(this)
		            obj.stop(true,false).animate({width:parseInt(jQuery(this).width())+20+'px',left:jQuery(this).position().left},200,function(){
		                jQuery('.in_article .h li').eq(n).addClass('cur').siblings('li').removeClass('cur')
		                jQuery('.in_article .b').hide().eq(n).show()
		            })
        		});
		     });
		</script>
		<!-- 页脚开始 -->
		<jsp:include page="common/foot.jsp"/>
		<!-- 页脚结束 -->
        <script src="../bootstrap/dist/js/jquery-1.10.2.min.js"></script>
		<script src="../bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>