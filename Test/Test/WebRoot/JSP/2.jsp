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

		<title>万能播放器</title>

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
	<object width="420" height="360" classid="CLSID:22D6F312-B0F6-11D0-94AB-0080C74C7E95">
    <param name="filename" value="C:\Program Files\Genuitec\tomcat\apache-tomcat-6.0.26\webapps\resources\structs视频教程.flv" />
    <embed width="420" height="360" type="application/x-mplayer2" src="filename"></embed>
    </object>
	</body>
</html>
