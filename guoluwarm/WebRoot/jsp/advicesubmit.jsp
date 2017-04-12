<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>职工建议</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/yanzheng.js"></script>
<script type="text/javascript">
//获得ajax对象
function back(){
		if(confirm('是否保存！')!=false){
			//实现页面数据的提交，但是页面不跳转
			var xhr=getXhr();
			xhr.open('post','../AdviceController',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4){
					var txt=xhr.responseText;
					alert(txt);
					window.history.go(-1);
				}
			};
			xhr.send('keyword='+$F("keyword")+'&Faultnumber='+$F("Faultnumber")+'&tablename='+$F("tablename")+'&content='+$F("content")+'');
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
    <li><a href="#">建议反馈</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>表名：${param.tablename}</span></div>
	<ul class="forminfo">
	<!-- 使用是否审核的value值将表名传送过去 -->
	<li><label>编号</label><input name="" type="text" class="dfinput" id="Faultnumber" value="${param.falut_Number}"/></li>
	<li><label>错误关键字</label><input name="keyword" type="text" class="dfinput" id="keyword"/><i>多个关键字用,隔开</i></li>
	<li><label>是否审核</label><cite><input name="state" type="radio" value="${param.tablename}" checked="checked" id="tablename"/>否</cite></li>
	<li><label>反馈内容</label><textarea name="content" cols="" rows="" class="textinput" id="content"></textarea></li>
	<li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="back();"/></li>
	</ul>
    </div>
</body>
</html>
