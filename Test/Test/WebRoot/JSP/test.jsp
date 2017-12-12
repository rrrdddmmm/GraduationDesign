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

		<title>My JSP 'test.jsp' starting page</title>

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
		<table align="center" border="0">
			<tr>
				<!--  定义播放界面 -->
				<td>
					<object width="550" height="350"
						classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
						<param name="CONTROLS" value="ImageWindow">
						<param name="CONSOLE" value="Video">
						<param name="CENTER" value="TRUE">
						<param name="MAINTAINSPECT" value="TRUE">
					</object>
				</td>
			</tr>
			<!--  定义状态栏 -->
			<tr>
				<td>
					<object width="550" height="30"
						classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
						<param name="CONTROLS" value="StatusBar">
						<param name="CONSOLE" value="Video">
					</object>
				</td>
			</tr>
			<tr>
				<!--定义控制面板  -->
				<td>
					<object width="550" height="30"
						classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
						<param name="CONTROLS" value="ControlPanel">
						<param name="CONSOLE" value="Video">
						<param name="SRC"
							value="C:\Program Files\Genuitec\tomcat\apache-tomcat-6.0.26\webapps\resources\structs视频教程.flv">
						<param name="AUTOSTART" value="TRUE">
						<param name="PREFETCH" value="0">
						<param name="LOOP" value="0">
						<param name="NUMLOOP" value="0">
					</object>
				</td>
			</tr>
		</table>
	</body>
</html>
