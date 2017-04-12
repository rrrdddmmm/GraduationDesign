<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>功能目录</div>
    
    <dl class="leftmenu">
    
     <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>首页
    </div>
    	<ul class="menuson">
        <li ><cite></cite><a href="index.jsp" target="rightFrame">欢迎光临</a><i></i></li>
        </ul>    
    </dd>
    
     <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>安全预警及评价
    </div>
    	<ul class="menuson">
        <li ><cite></cite><a href="../WarmAndEvaluateController" target="rightFrame">安全预警及评价结果</a><i></i></li>
<!--         <li><cite></cite><a href="#" >更多历史记录</a><i></i></li>   -->
        </ul>    
    </dd>
     
    <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>锅炉数据显示
    </div>
    	<ul class="menuson">
    	
        <li ><cite></cite><a href="../NanliangshowController?dataname=ZQYL&guoluid=1" target="rightFrame">蒸汽压力实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=ZQWD&guoluid=1" target="rightFrame">蒸汽温度实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=ZQLL&guoluid=1" target="rightFrame">蒸汽流量实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=GSLL&guoluid=1" target="rightFrame">给水流量实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=GSWD&guoluid=1" target="rightFrame">给水温度实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=GSYL&guoluid=1" target="rightFrame">给水压力实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=SMQCKSW&guoluid=1" target="rightFrame">SMQCKSW实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=PYWD&guoluid=1" target="rightFrame">排烟温度实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=LTYL&guoluid=1" target="rightFrame">炉膛压力实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=QBYL&guoluid=1" target="rightFrame">汽包压力实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=QBSW&guoluid=1" target="rightFrame">汽包水位实时数据</a><i></i></li>
        <li ><cite></cite><a href="../NanliangshowController?dataname=SMQJKSW&guoluid=1" target="rightFrame">SMQJKSW实时数据</a><i></i></li>
        </ul>    
    </dd>
    
       
    
        
    
    <dd>
    <div class="title">
    <span><img src="../images/leftico02.png" /></span>锅炉故障知识管理
    </div>
    <ul class="menuson">
<!--        <li><cite></cite><a href="team.jsp" target="rightFrame">模糊查询知识</a><i></i></li> --> 
        <li><cite></cite><a href="../ShowFaulistController?name=subject" target="rightFrame">锅炉本体知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=belt_machine" target="rightFrame">皮带机知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=blow_machine" target="rightFrame">鼓风机知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=crush_machine" target="rightFrame">破碎机知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=squeegee_machine" target="rightFrame">刮板机知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=ventilate_machine" target="rightFrame">引风机知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=water_pump" target="rightFrame">水泵故障知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=deslaggin_machine" target="rightFrame">除渣机故障知识</a><i></i></li>
        <li><cite></cite><a href="../ShowFaulistController?name=fire_grate" target="rightFrame">炉排机故障知识</a><i></i></li>
        
        </ul>     
    </dd> 


    <dd>
    <div class="title">
    <span><img src="../images/leftico02.png" /></span>锅炉维修保养知识管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_belt_machine" target="rightFrame">皮带机保养知识</a><i></i></li>
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_blow_machine" target="rightFrame">鼓风机保养知识</a><i></i></li>
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_crush_machine" target="rightFrame">刮板机保养知识</a><i></i></li>
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_deslaggin_machine" target="rightFrame">除渣机保养知识</a><i></i></li>
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_squeegee_machine" target="rightFrame">刮板机保养知识</a><i></i></li>
        <li class="active"><cite></cite><a href="../ShowMainlistController?name=boiler_subject" target="rightFrame">锅炉本体保养知识</a><i></i></li>
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_ventilate_machine" target="rightFrame">引风机保养知识</a><i></i></li>
        <li><cite></cite><a href="../ShowMainlistController?name=boiler_water_pump" target="rightFrame">水泵保养知识</a><i></i></li>
    </ul>     
    </dd> 
	<c:if test="${user.user_competence=='管理员'}" var="aa" scope="session"> 
	    <dd>
	    <div class="title">
	    <span><img src="../images/leftico01.png" /></span>职工反馈审核
	    </div>
	    	<ul class="menuson">
	        <li ><cite></cite><a href="../CheckAdvicelistController?&page=1" target="rightFrame">审核故障知识数据</a><i></i></li>
	        <li><cite></cite><a href="../CheckAdvicelistController?flag=boiler&page=1" target="rightFrame">审核维修保养知识数据</a><i></i></li>
	        </ul>    
	    </dd>
	
<!-- 	
	    <dd>
	    <div class="title">
	    <span><img src="../images/leftico02.png" /></span>工作通知
	    </div>
	    <ul class="menuson">
	        <li><cite></cite><a href="newspublish.jsp" target="rightFrame">发布通知</a><i></i></li>
	        <li><cite></cite><a href="messagelist.jsp" target="rightFrame">已发通知</a><i></i></li>
	        </ul>     
	    </dd> 
 -->
	</c:if>

    <dd><div class="title"><span><img src="../images/leftico03.png" /></span>平台使用说明书</div>
    <ul class="menuson">
        <li><cite></cite><a href="manual.jsp" target="rightFrame">新手帮助</a><i></i></li>
        <li><cite></cite><a href="manual2.0.jsp" target="rightFrame">更新说明</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd>
    <div class="title">
    <span><img src="../images/leftico04.png" /></span>团队介绍
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="team.jsp" target="rightFrame">团队信息</a><i></i></li>
    </ul>
    </dd>   

<!-- 
    <dd>
    <div class="title">
    <span><img src="../images/leftico04.png" /></span>我的信息
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="error.jsp" target="rightFrame">完善信息</a><i></i></li>
        <li><cite></cite><a href="personage.jsp" target="rightFrame">工作情况</a><i></i></li>
    </ul>
    </dd>   
 -->   
    </dl>
</body>
</html>
