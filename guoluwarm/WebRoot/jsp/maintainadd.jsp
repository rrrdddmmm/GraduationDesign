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
			xhr.open('post','../MaintainAddController',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4){
					var txt=xhr.responseText;
					alert(txt);
					location.href = document.referrer;//重新载入上一页
					window.history.go(-1);
				}
			};
			xhr.send('Maintaincycle='+$F("Maintaincycle")+'&Maintaincontent='+$F("Maintaincontent")+'&Tablename='+tablename+'');
			//点击ajax对象和服务器端交互失败时可能是因为send发送数据失败，而send发送失败的原因:1、参数书写格式不正确  2、参数数据没有获取到，例如id值填写错误等
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
    <li><a href="#">维修保养知识管理</a></li>
    <li><a href="#">管理员${user.user_name}正在添加知识 </a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>表名：${param.tablename}</span></div>
	<ul class="forminfo">
	<li>
		<label>维护周期：</label>
			<select name="cycle" class="dfinput" id="Maintaincycle" style="width: 120px;size: 120px;"> 
			<option  value="班检">班检</option>
		   	<option  value="日检">日检</option>
		   	<option  value="周检">周检</option>
		   	<option  value="月检">月检</option>
		   	<option  value="半年检">半年检</option>
		   	<option  value="年检">年检</option>  
		    </select>
	</li>
	<li><label>维护内容</label><textarea name="Maintaincontent" cols="" rows="" class="textinput" id="Maintaincontent"></textarea><i>至少三个字符</i></li>
	<li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="save();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
	<input name="" type="button" class="btn" value="返回" onclick="back();"/></li>
	</ul>
    </div>
</body>
</html>
