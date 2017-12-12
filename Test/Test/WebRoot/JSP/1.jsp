<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<HTML>
	<body>
	<!-- 显示播放页面 -->
		<object width="320" height="250"
			classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
			<param name="CONTROLS" value="ImageWindow">
			<param name="CONTROLS" value="StatusBar">
			<param name="CONSOLE" value="Video">
			<param name="CENTER" value="TRUE">
			<param name="MAINTAINSPECT" value="TRUE">
		</object>
		<!-- 显示控制页面 -->
		<object width="320" height="30"
			classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
			<param name="CONTROLS" value="StatusBar">
			<param name="CONSOLE" value="Video">
		</object>
		<!-- 定义控制面板 -->
		<object width="320" height="30"
			classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
			<param name="CONTROLS" value="ControlPanel">
			<param name="CONSOLE" value="Video">
			<param name="SRC" value="C:\Program Files\Genuitec\tomcat\apache-tomcat-6.0.26\webapps\resources\网络安全基本方案介绍.avi">
			<param name="AUTOSTART" value="TRUE">
			<param name="PREFETCH" value="0">
			<param name="LOOP" value="0">
			<param name="NUMLOOP" value="0">
		</object>
	</body>
</HTML>



