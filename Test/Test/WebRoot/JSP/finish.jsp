<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'finish.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script language=javascript defer>
<!--
var volv=phx.settings.volume;
setInterval("if(phx.playState==3){time.innerText=phx.controls.currentPositionString+'|'+
phx.currentMedia.durationString}",1000);
setInterval("if(phx.playState==3){itcn.style.width=parseInt(245*(phx.controls.currentPosition/phx.currentMedia.duration))}",1000);
function volup(){
if (volv<100){
volv+=5;
phx.settings.volume=volv;
time.innerText=volv;}
else{time.innerText='最大';}
}
function voldown(){
if (volv>0){
volv-=5;
phx.settings.volume=volv;
time.innerText=volv;}
else{time.innerText='最小';}
}
-->

<!--
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
-->

</script>
	</head>

	<body>
		<div>
 <p align="center">
  <object classid="clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6" id="phx" width="600" height="450">
    <param name="URL" value="C:\Program Files\Genuitec\tomcat\apache-tomcat-6.0.26\webapps\resources\structs视频教程.flv">
    <param name="rate" value="1">
    <param name="balance" value="0">
    <param name="currentPosition" value="0">
    <param name="defaultFrame" value>
    <param name="playCount" value="1">
    <param name="autoStart" value="-1">
    <param name="currentMarker" value="0">
    <param name="invokeURLs" value="-1">
    <param name="baseURL" value="">
    <param name="volume" value="100">
    <param name="mute" value="0">
    <param name="uiMode" value="full">
    <param name="stretchToFit" value="-1">
    <param name="windowlessVideo" value="0">
    <param name="enabled" value="-1">
    <param name="enableContextMenu" value="-1">
    <param name="fullScreen" value="0">
    <param name="SAMIStyle" value="">
    <param name="SAMILang" value="">
    <param name="SAMIFilename" value>
    <param name="ShowCationing" value="1">
    <param name="captioningID" value="">
    <param name="enableErrorDialogs" value="0">
    <param name="_cx" value="12859">
    <param name="_cy" value="8361">
  </object>
</p>

<p align="center">
  <input type="image" src="images/jingyin.jpg"  onclick="phx.settings.mute=phx.settings.mute==true?false:true;time.innerText=phx.settings.mute==true?'静音':'关闭静音';"">
  <input  type="image" src="images/bofang.jpg" onclick="phx.controls.play();time.innerText='播放';"">
  <input  type="image" src="images/zanting.jpg" onclick="phx.controls.pause();time.innerText='暂停';"">
  <input  type="image" src="images/tingzhi.jpg"  onclick="phx.controls.stop();time.innerText='停止';"" value="停止">
  <input type="image" src="images/quanping.jpg" onclick="if(phx.playState==3)phx.fullscreen=1;">
  <a href="C:\Program Files\Genuitec\tomcat\apache-tomcat-6.0.26\webapps\resources\structs视频教程.flv"><img border="0" src="images/download1.jpg"/></a>
  </p></div>
	</body>
</html>
