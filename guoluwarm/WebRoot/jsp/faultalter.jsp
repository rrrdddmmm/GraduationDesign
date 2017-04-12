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
function back(){
	window.history.go(-1);
}
//获得ajax对象
function save(){
		if(confirm('是否保存！')!=false){
			//实现页面数据的提交，但是页面不跳转
			var tablename="${param.tablename}";
			var xhr=getXhr();
			xhr.open('post','../FaultknowAlterController',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4){
					var txt=xhr.responseText;
					alert(txt);
					location.href = document.referrer;//重新载入上一页
					window.history.go(-1);
					//location.reload();
				}
			};
			xhr.send('Faulttype='+$F("Faulttype")+'&Faultnumber='+$F("Faultnumber")+'&Faultcause='+$F("Faultcause")+'&Dealhand='+$F("Dealhand")+'&Tablename='+tablename+'');
		}else{
			alert('保存已经取消！');
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
    <li><a href="#">锅炉故障知识管理</a></li>
    <li><a href="#">管理员${user.user_name}正在修改知识 </a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>表名：${param.tablename}</span></div>
	<ul class="forminfo">
	<!-- 使用是否审核的value值将表名传送过去 -->
	<li><label>故障编号</label><input name="" type="text" class="dfinput" id="Faultnumber" value="${param.falut_Number}"/></li>
	<li><label>故障类型</label><input name="Faulttype" type="text" class="dfinput" id="Faulttype"/></li>
	<li><label>故障原因</label><textarea name="Faultcause" cols="" rows="" class="textinput" id="Faultcause"></textarea><i>至少三个字符</i></li>
	<li><label>处理对策</label><textarea name="Dealhand" cols="" rows="" class="textinput" id="Dealhand"></textarea><i>至少三个字符</i></li>
	<li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="save();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<input name="" type="button" class="btn" value="返回" onclick="back();"/></li>
	</ul>
    </div>
</body>
</html>
