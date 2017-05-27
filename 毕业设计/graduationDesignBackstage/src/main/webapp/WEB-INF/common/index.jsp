<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("cache-control", "no-cache");
response.setHeader("cache-control", "no-nostore");
response.setHeader("expire", "0");
response.setHeader("progma", "no-cache");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<meta HTTP-EQUIV="expires" CONTENT="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统主页</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--内容区-->
<div class="xtsy_wk">
 <div class="xtsy_wk_kjtop">
 <div class="syt_a">项目介绍</div>
 </div>
 <div class="syt_0a">
     <video width="1100" height="410"  controls loop="loop">
		<source src="/resource/indexdefault.mp4"/>
	</video>
	
 </div>
 <div class="xtsy_wk_kjtop">
   <div class="syt_a">系统说明</div>
 </div>
 <table border="0" cellpadding="0" cellspacing="0" class="w_tablen" >
   <tr align="left" >
     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     1.0、前言</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		随着信息技术的飞速发展，软件已成为人们生活必不可少的一部分，软件产品的规模也越来越庞大，
		对软件项目实施有效的管理显得尤为重要。现今，项目开发一直受到同学们的热捧，但是在校园软件
		开发过程中存在着种种的问题，通过建立基于项目管理流程的校园软件项目协同平台来为学生老师服务
		，可以提高校园软件项目开发的效率。</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     1.1 选题背景</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;随着信息技术的飞速发展，软件已成为人们生活必不可少的一部分，软件产品的规模也越来越庞大，
		对软件项目实施有效的管理显得尤为重要。现今，项目开发一直受到同学们的热捧，但是在校园软件
		开发过程中存在着种种的问题，通过建立基于项目管理流程的校园软件项目协同平台来为学生老师服
		务，可以提高校园软件项目开发的效率。</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 1.2发展及研究现状</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近年来工作流和项目协同工作平台得到了快速发展。文献[1]应用J2EE体系架构和EJB技术实现科研
		管理系统。文献[2]应用开源工作流引擎和J2EE技术来实现科研项目管理，规范科研管理的业务流程
		和行为。前者的研究主要集中在协同设计、会议和化学等方面，而后者更注重固定流程和制度的控制，
		忽略了企业科研过程，具有业务流程易变、资源共享性差和系统安全性低的问题。在目前一些主流项目
		管理软件中，svn是一个开放源代码的版本控制系统，相较于RCS、CVS，它采用了分支管理系统，它
		的设计目标就是取代CVS，并且代码一致性非常高，管理方便，逻辑明确，符合一般人思维习惯。
		而Concurrent Version System也一度成为主流，不必担心数据流失，对中文路径名支持的较好，
		本地文件与库的对应可以多对多。但它却不支持文件改名且只允许存储文件。
		除此之外，GitHub提供Git存储库服务，基于web，允许你使用Git的源代码管理功能，或者其特性。
		但它可能不是捕捉创意过程和记录创意点子的最佳工具。</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 1.3 选题意义</br>
    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在校园中，由于教师课业繁重，有了好的项目苦于找不到学生协作或找到的学生资源太少，
    	以至于好的项目被搁浅甚至荒废，而学生恰恰又难以找到合适的项目或得到的项目信息太零散
    	以至于无从下手的这种千里马遇不到伯乐，伯乐难寻千里马的障碍，基于本项目巧妙地解决了
    	这一问题，该平台提供了教师发布项目的机会，并将各个教师所申请发布的项目归类，对于
    	每个项目教师可将项目目的与任务、组织机构、参加项目要求、项目安排、项目评审规则、
    	项目奖励、项目组织者联系方式等信息发布在该平台上，学生可通过自己的技术所长或爱好
    	选择适合自己的项目，达到一箭双雕的效果。针对那些没有项目经验的不了解项目流程的学生
    	来说，该平台提供了一系列项目管理开发流程模型，如科研项目流程模型、竞赛项目流程模型等，
    	项目负责教师选择相应流程模型[3-8]，定期要求项目团队提交相关资料，严格控制项目进度，
    	督促学生完成分配的任务，从而可以规范一个软件开发团队的日常工作，提高工作效率，
    	从而达到协同开发[9-12]的目的。</br></td>
    </tr>
  </table>
 <div class="xtsy_wk_kjtop">
   <div class="syt_a">系统开发协同流程图</div>
 </div>
 <table border="0" cellpadding="0" cellspacing="0" class="w_tablen" >
   <tr align="left" class="">
     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../content/images/banner_03.jpg" width="803" height="479" /></td>
   </tr>
 </table>
</div>
<div class="xtsy_wk" style="margin-top:10px;">
  <div class="clearfix"></div>
</div>
</body>
</html>
