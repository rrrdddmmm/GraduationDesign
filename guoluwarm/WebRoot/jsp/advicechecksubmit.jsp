<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职工建议审核</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/yanzheng.js"></script>
<script type="text/javascript">
function back1(){
	window.history.go(-1);
}
//获得ajax对象
function back(){
		if(confirm('是否保存！')!=false){
			//实现页面数据的提交，但是页面不跳转
			var xhr=getXhr();
			xhr.open('post','../AdviceInserController',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4){
					var txt=xhr.responseText;
					alert(txt);
					window.history.go(-1);
				}
			};//&tablename='+$F("tablename")+'&content='+$F("content")+'
			xhr.send('number='+$F("number")+'&tablename='+$F("tablename")+'&content='+$F("content")+'');
		}else{
			alert('保存已经取消！');
			window.history.go(-1);
		}
	}
	//获得ajax对象
	function getXhr(){
		var xhr=null;
		if(window.XMLHttpRequest){
			//非ie浏览器
			xhr=new XMLHttpRequest();
		}else{
			xhr=new ActiveXObject('Microsoft.XMLHttp');
		}
		return xhr;
	}
</script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理员${user.user_name }正在审核建议</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>表名：${param.tablename}</span></div>
	<ul class="forminfo">
	<!-- 使用是否审核的value值将表名传送过去 -->
	<li><label>用户名</label><input name="" type="text" class="dfinput" id="username" value="${param.username}"/></li>
	<li><label>编号</label><input name="" type="text" class="dfinput" id="number" value="${param.number}"/></li>
	<li><label>错误关键字</label><input name="keyword" type="text" class="dfinput" id="keyword" value="${param.keyword}"/></li>
	<!-- 是：将对数据库修改，状态值、内容。否：不做任何动作，删除任务有用户自行删除，或者有数据库自行经过一定时间删除（存储过程实现） -->
	<c:if test="${param.state=='否' }" var="aa" scope="session">
		<li><label>审核状态</label><cite><input name="yn" type="radio" value="${param.tablename}"   id="tablename"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name="yn" type="radio" value="${param.tablename}" checked="checked" id="tablename"/>否</cite></li>
	</c:if>
	<c:if test="${param.state!='否' }" var="aa" scope="session">
		<li><label>审核状态</label><cite><input name="yn" type="radio" value="${param.tablename}" checked="checked"  id="tablename"/>是</cite></li>
	</c:if>
		<li><label>反馈内容</label><textarea name="content"  cols="" rows="" class="textinput" id="content" >${param.text}</textarea></li>
		
	<c:if test="${param.state=='否' }" var="aa" scope="session">
		<li><label>&nbsp;</label>
		<input name="" type="button" class="btn" value="确认保存" onclick="back();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input name="" type="button" class="btn" value="返回" onclick="back1();"/>
		</li>
		
	</c:if>
	<c:if test="${param.state=='是' }" var="aa" scope="session">
		<li><label>&nbsp;</label><input name="" type="button" class="btn" value="返回" onclick="back1();"/></li>
	</c:if>
	</ul>
    </div>
</body>
</html>
