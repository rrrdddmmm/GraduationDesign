<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">

function subgo(){
var oA = document.getElementById('b'); 
alert("klfjklx");   
oA.class = "selected";
}

//获得ajax对象
function save(){
		
			//实现页面数据的提交，但是页面不跳转
			var xhr=getXhr();
			xhr.open('post','AA',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4){
				}
			};
			xhr.send('aaAA=1');
		
	}

//获得ajax对象
function save1(){
		
			//实现页面数据的提交，但是页面不跳转
			var xhr=getXhr();
			xhr.open('post','AA',true);
			xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4){
				}
			};
			xhr.send('aaAA=2');
		
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

	
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li>安全预警及评价</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
  	<!--  <a href="javascript:void(0)" onclick="subgo()"-->
 
  	<c:if test="${aaAA=='1'}" var="aa" scope="session"> 
	  	<li><a href="#tab2" onclick="save()" class="selected">安全评价结果显示</a></li> 
	    <li><a href="#tab1" onclick="save1()">预警结果显示</a></li> 
  	</c:if>
  	<c:if test="${aaAA=='2'}" var="aa" scope="session"> 
	  	<li><a href="#tab2" onclick="save()">安全评价结果显示</a></li> 
	    <li><a href="#tab1" onclick="save1()" class="selected">预警结果显示</a></li> 
  	</c:if>
    
  	
  	</ul>
    </div> 
  	<div id="tab2" class="tabson">
   	<!-- 	安全评价结果显示 -->
   		<div id="contain" align="center">
		<iframe src="jsp/warndatashow/option.jsp" width="1000" height="420"   frameborder="0"></iframe>
		</div>
    </div> 
    <!-- 	安全预警结果显示 -->
  	<div id="tab1" class="tabson">
  		<div id="contain" align="center">
    	<iframe src="jsp/warndatashow/warmlist.jsp" width="1000" height="420"  frameborder="0"></iframe>
    </div>    
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

    </div>
</body>


</html>
