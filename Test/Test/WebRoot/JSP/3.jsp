<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP '3.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<object id="MediaPlayer" width="478" height="300"
			codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf. 
            cab#Version=6,1,5,217"
			type="application/x-oleobject"
			standby="Loading Microsoft Windows Media Player components..."
			classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" VIEWASTEXT>
			<param name="DisplayBackColor" value="0">
			<param name="DisplayForeColor" value="16777215">
			<param name="DisplayMode" value="0">
			<param name="DisplaySize" value="-1">
			<param name="Filename" value="C:\Program Files\Genuitec\tomcat\apache-tomcat-6.0.26\webapps\resources\structs视频教程.flv">
			<!-- 此处设置播放的视频连接 -->
			<param name="ShowControls" value="0">
		</object>



	</body>
</html>
