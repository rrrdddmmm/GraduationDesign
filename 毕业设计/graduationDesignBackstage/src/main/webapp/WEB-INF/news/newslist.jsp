<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻信息列表</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script src="../content/js/commonalert.js" type="text/javascript"  charset="utf-8"></script>
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript" src="../content/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../content/js/jquery-form.js"></script>
<script type="text/javascript" src="../content/js/commonutil.js"></script>
<style>
.cp{width:500px; height:auto; background:#FFF; border:1px solid #ccc; padding:10px; position:absolute; box-shadow:5px 5px #ccc; margin-top:10px;}
.cp i{font-style:normal}
.cp h1{font-size:14px; border-bottom:1px solid #6CF; padding-bottom:10px; margin-bottom:10px;}
.cp h1 span{float:right; cursor:pointer; padding:0px 5px; background:#ff9900; color:#FFF; border-radius:10px;}
.cp .li-left{float:left; width:50px; font-size:12px; font-weight:bold; color:#F60; margin-right:15px; line-height:30px;}
.cp .li-right{float:left; width:420px;}
.cp .li-right dl{float:left; width:128px; line-height:30px; margin-right:5px; border:1px #fff solid}
.cp .li-right dl h2{font-size:12px; font-weight:100}
.cp .li-right dl h2.on{border-left:1px solid #ccc;border-top:1px solid #ccc; cursor:pointer; border-right:1px solid #ccc; background:#EEE}
.cp .cpchild{width:500px; height:auto; border:1px solid #ccc;background:#FFF; padding:10px; position:absolute; top:0px; left:0px; display:none}
.cp .cpchild dt{width:170px; float:left; display:block}
.schild{width:450px; padding:5px; position:absolute; top:0px; left:0px; background:#ff9900; border-radius:5px;}
.schild i{font-style:normal; color:#ff9900; font-size:30px; margin-left:-14px; position:absolute}
</style>
<script>
//滑动门JS
$(document).ready(function() {
    $("#blockquote_title a").each(function(index, element) {
        $(this).click(function(){
			$("#blockquote_title a").each(function(index, element) {
				$(this).attr('class','linkout');
			})
			$(this).attr('class','linkon');
			var k = index;
			$("#blockquote_content blockquote").each(function(indexs, element) {
			  $(this).css('display','none');
			  if(k==indexs) $(this).css('display','');
			});
		});
    });
	$("#blockquote_content blockquote").each(function(index, element) {
      if(index!=0) $(this).css('display','none');
    });
});

function closeDiv(obj){
	$(obj).parent().css('display','none');
	$(obj).parent().parent().find('i').text('+');
	$(obj).parent().parent().find('h2').removeClass('on');
}

  //弹出隐藏层
        function ShowDiv2(show_div, bg_div) {
            document.getElementById(show_div).style.display = 'block';
            document.getElementById(bg_div).style.display = 'block';
            var bgdiv = document.getElementById(bg_div);
            bgdiv.style.width = document.body.scrollWidth;
            $("#" + bg_div).height($(document).height());
        };

        //关闭弹出层
        function CloseDiv2(show_div, bg_div) {
            document.getElementById(show_div).style.display = 'none';
            document.getElementById(bg_div).style.display = 'none';
        };
		

</script>

     <style type="text/css">
        .black_overlay
        {
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: #000;
            z-index: 1001;
            -moz-opacity: 0.35;
            opacity: .35;
            filter: alpha(opacity=35);
        }
        
        .white_content
        {
            display: none;
            position: absolute;
            top: 14%;
            left: 24%;
            width: 50%;
            height: auto;
            z-index: 1002;
            overflow: hidden;
            padding-bottom: 20px;
        }
    </style>
</head>
<body>
	<h1 class="globle_title2">
        <img src="../content/images/tag.gif" />
        新闻信息列表  <em></em></h1>
    <div class="syt_lb">
		</div>
		<div class="globle_bck">
        <h1 class="diandianb">:: 新闻信息列表 ::<a style="color:red;text-align:left;">注：0.点击照片修改照片。1.照片的像素为160*180px。2.照片格式为BMP/JPG/JPEG。3.建议照片大小不超过40k。</a><a href="newsAdd.do">
            <img src="../content//images/btn_add.jpg" width="52" height="22" class="f_r" style="margin: 2px 10px 0px 0px;" /></a></h1>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" id="tb"
			class="autotable2">
			<thead>
				<tr class="titletr">
					<td  width="5%">logo</td>
					<td  width="20%">简介</td>
					<td   width="10%">创建按时间</td>
					<td   width="10%">修改时间</td>
					<td   width="5%">状态</td>
					<td   width="10%">操作</td>				
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${newslist }" var="li" varStatus="idxStatus">
				<tr class="whittr" data-itemid="${li.id }">
					<td id="imagesidP" title="${li.title }">
<!-- 						<video width="300" height="150" src="/resource/VID_20130916_115355.mp4" controls loop="loop" autoplay="autoplay">132465</video> -->
						<img id="imagesid" src="${li.logo }" width="168" height="80"/>
					</td>
					<td title="${li.explain }"><a href="${li.details }">${fn:substring(li.explain, 0, 15)}..</a></td>
					<td><fmt:formatDate value="${li.creattime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${li.updatetime }" pattern="yyyy-MM-dd"/></td>
	            	<c:if test="${li.state==1}"><td>启用</td></c:if>
	            	<c:if test="${li.state==2}"><td>停用</td></c:if>
					<td><a href="newsAlter.do?id=${li.id }">修改</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a
						class="font-red-sunglo">删除</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<!--弹出层---->
<div id="fade" class="black_overlay">
</div>
 <div id="MyDiv" class="white_content">
	<div class="sdcq_tck">
       <img src="../content/images/hong.gif" class="sdcq_tck_right_cha" width="1" height="16" onclick="CloseDiv2('MyDiv','fade')" />
       <div class="sdcq_tck_hong">
       <h1 class="globle_title3"><img src="../content/images/tcc_b.png" style=" vertical-align:middle" /> 修改新闻照片</h1>
    </div>
            <div class="sdcq_tck_conment">
     <form id="alterNewsImagesForm" enctype="multipart/form-data">
      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="autotable2" style="margin:1px auto">
        <tr>
			<td class="table_xqa">文件：</td>
			<td class="table_xqb">
			<input type="hidden" name="id" id="id"/>
			<input type="file" name="file" id="logo" class="syt_lb_top_conment_txt"/>
			</td>
			<td class="table_xqa">上传：</td>
			<td class="table_xqb">
			<button type="button" id="t_upload" class="syt_lb_top_conment_txt">上传</button>
			</td>
		</tr>
      </table>
      </form>
</div>
		
	</div>
	
</body>
<script type="text/javascript">
var _obj;
console.log(img);
$(document).ready(function() {
	var img = document.querySelectorAll('#imagesidP');//选择所有id为imagesidP的对象，返回值集合
	$(img).each(function(){
		$(this).click(function(){
			var _this=$(this);
			_parent = _this.parent();
			var id = _parent.attr("data-itemID");
			$("#id").val(id);
			ShowDiv2('MyDiv', 'fade');
			_obj=_this;
		});
	});
	
	$("#t_upload").click(function (id) {
		var dateObj=new Date();
		if(verifynull("logo")) {
	    }else{
	    	return;
	    }				
		$("#alterNewsImagesForm").ajaxSubmit({
	        type : 'POST',  
	        url : 'alterNewsImages.do?logo='+dateObj.getTime()+'', 
	        success : function(result) {  
	        	if(result.status=='0'){
	        		CloseDiv2('MyDiv','fade');
	        		$("#logo").val("");
	        		console.log(_obj);
	        		_obj.empty();
		            _obj.html('<img src="'+result.newpath+'" width="168" height="80"/>');
		            _obj.show();
					_alert(result.msg);
	        	}else{
	        		_alert(result.msg,2);
	        	}
	        },  
	        error : function() {  
	            _alert("上传失败，请检查网络后重试",2);  
	        }  
	    });  
    })
})

var _parent;
$(".font-red-sunglo").live("click", function() {
	var _this=$(this);
	_parent = _this.parent().parent();
	var id = _parent.attr("data-itemID");
	_confirm("是否删除此记录？",1,"del("+id+")");
});
	function del(id){
			$.ajax({
				type : "POST",
				url : "userDelHandle.do",
				data : {
					id : id,
				},
				datatype : "json",
				error : function() {  
		            _alert("操作失败，请检查网络后重试",2);  
		        },  
				success : function(result) {
					if (result.status == '0') {
						_parent.remove();
						_alert(result.msg);
					}else{
						_alert(result.msg,2); 
					} 
				}
			});
	}
</script>
</html>