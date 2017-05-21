<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建项目</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script src="../content/js/jquery.js" language="javascript"></script>
<script src="../content/js/commonalert.js" type="text/javascript"></script>
<script type="text/javascript" src="../content/js/user/opuser.js"></script>
<script type="text/javascript" src="../content/js/commonutil.js"></script>
<script type="text/javascript" src="../content/js/commonalert.js"></script>
<script type="text/javascript" src="../content/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../content/js/jquery-form.js"></script>
<script src="../laydate/laydate.js"></script>
<style>
.cp{width:500px; height:auto; background:#FFF; border:1px solid #ccc; padding:1px; position:absolute;left:0; top:0; box-shadow:5px 5px #ccc; margin-top:10px;}
.cp i{font-style:normal}
.cp h1{font-size:14px; border-bottom:1px solid #6CF; padding-bottom:10px; margin-bottom:10px;}
.cp h1 span{float:right; cursor:pointer; padding:0px 5px; background:#ff9900; color:#FFF; border-radius:10px;}
.cp .li-left{float:left; width:100px; font-size:12px; font-weight:bold; color:#F60; margin-right:15px; line-height:30px; text-align: right}
.cp .li-right{float:left; width:380px;}
.cp .li-right dl{float:left; width:88px; line-height:30px;height:30px; margin-right:5px; border:1px #fff solid}
.cp .li-right dl h2{font-size:12px; font-weight:600;}
.cp .li-right dl h2.on{border-left:1px solid #ccc;border-top:1px solid #ccc; font-size:12px; cursor:pointer; border-right:1px solid #ccc; background:#EEE}
.cp .cpchild{max-width:420px; height:auto;background:#F90; position:absolute; top:0px; left:0px; display:none}
.cp .cpchild dt{width:90px;height:35px; display:block;float:left;margin-left: 5px;}
.schild{width:260px; padding:10px;position:absolute; top:80px; left:0px; background:#FFC46A; border-radius:5px; }
.schild i{font-style:normal;color:#FFC46A; font-size:30px; margin-left:-16px; position:absolute}
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
             _position:absolute;_top: expression(eval(document.compatMode && document.compatMode == 'CSS1Compat') ?documentElement.scrollTop + (document.documentElement.clientHeight - this.offsetHeight) / 2 : document.body.scrollTop + (document.body.clientHeight - this.clientHeight) / 2);
        }
        
        .white_content
        {
            display: none;
            position: absolute;
            top: 8%;
            left: 26%;
            width: 50%;
            height: auto;
            z-index: 1002;
            overflow: hidden;
            padding-bottom: 20px;
        }
</style>
<script type="text/javascript">
function aa(){
	//alert($(this).attr("data-id"));
	//alert($("input[name='c1']:checked").parent().text());
	$("#tutorname").val($("input[name='c1']:checked").parent().text());
	//alert($("input[name='c1']:checked").val());
	//$("#creatprojectName").val($("input[name='c1']:checked").parent().parent().prev().attr("data-id"));
	$("#tutoreid").val($("input[name='c1']:checked").val());
	//$("#creatprocurementDirectory").val($("input[name='c1']:checked").parent().parent().parent().parent().prev().attr("id"));
	//$("#creatprocurementDirectory").val(Directory);
	//$("#creatprojectUnivalent").val("123");
	$(".cp span").parent().parent().remove();
}
//滑动门JS
$(document).ready(function() {
	$("#aaa").hide();
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
      //${fn:substring(MenuFinally.name, 0, 3)}..
    });
	
	//点击弹出多个层
	$('.cc').click(function(){
		var arrtid = $(this).attr('data-id');
		if($('.cp').length&&$('.cp').length>0) $('.cp').remove();
		//$('body').remove();
		$('body').append('<div class="cp"><h1><span>×</span>指导教师</h1>'+
				'<div>'+
				'<div style="text-align:center"><button type="submit" class="chaxun_but2" onclick="aa()" >确定</button>'+
				'<button type="submit" class="chaxun_but2" onclick="$(\'.cp\').remove()">取消</button></div>'+
				'<ul style="background:#EEFFF7">'+
				'<ul>'+
				'<li class="li-left">方向</li>'+
				'<li class="li-right">'+
				'<c:forEach items="${baseDirectionList }" var="directionli" varStatus="idxStatus">'+
				'<dl>'+
				'<h2 data-id="${directionli.name}"><i>+</i>${directionli.name}</h2>'+
				'<div class="cpchild">'+
				'<c:forEach items="${directionli.userList }" var="userli" varStatus="idxStatus">'+
					'<dt title="${userli.introduce}"><input name="c1" type="radio" value="${userli.id}" />${userli.name}</dt>'+
				'</c:forEach>'+ 
				'<div class="clearfix"></div>'+
				'</div>'+
				'</dl>'+
				'</c:forEach>'+ 
				'</li><div class="clearfix"></div>'+
				'</ul>'+
				'</div>'+
				'<div class="clearfix"></div>'+
				'</div>');
		var top = $(this).position().top + 20;
		var left = $(this).position().left;
		$('.cp').css({'top':top+'px','left':left+'px'});
		$('.cp span').click(function(){
			$(this).parent().parent().remove();
		});
		
		//二级展开
		$('.cp h2').each(function(index, element) {
			$(this).click(function(){
				var dataid = $(this).attr('data-id');//ajax调用数据
				$('.cp h2').each(function(index, element) {  //全部设置加号
                    $(this).find('i').text('+');
					$(this).removeClass('on');
                });
				$('.cp .cpchild').each(function(index, element) {  //全部设置加号
                    $(this).css('display','none');
                });
				var topc = $(this).position().top+30;
				var leftc = $(this).position().left;
				$(this).find('i').text('-');
				$(this).addClass('on');
				$(this).parent().find('.cpchild').css({'top':topc+'px','display':'block',left:leftc+'px'});
			});
			
		});
		
		//三级展开
		$('.cpchild dt').each(function(index, element) {
            $(this).mouseover(function(){
            $.ajaxSettings.async=false;
            //$(element).text()
            //alert($(this).find("input[type='radio']")[0].value);
			if($('.schild').length&&$('.schild').length>0) $('.schild').remove();
			//$('body').append('<div class="schild"><i>◆</i><p id="pric"></p></div>');
			//$("#pric").text("该型号参数："+data.specParameters+"");
			var topc = $(this).offset().top;
			var leftc = ($(this).offset().left-90) + $(this).width();
			$('.schild').css({'top':topc+'px',left:leftc+'px'});
			});
			$(this).mouseleave(function(){
				$('.schild').remove();
			});
        });
		
	});
});
</script>
</head>
<body>
<h1 class="globle_title2"><img src="../content/images/tag.gif" /> 项目管理 → <em>创建项目</em></h1>
<div class="sytxq_conment_wk">

<div class="sytxq_conment_wk_bx">
  <div class="table_qh_bj">
    <div id="blockquote_title"> <a href="#" class="linkon">创建项目</a> <a style="color:red;text-align:left;">注：1.上传文件格式为txt/doc/docx/pdf。2.建议文件大小不超过40k。</a> 
      <div class="clearfix"></div>
    </div>
  </div>
  <div id="blockquote_content">
<blockquote>
  <div class="syt_lb_top">
    <h1 class="syt_lb_top_titleh2">申请表信息</h1>
  </div>
  <form id="addProjectForm" enctype="multipart/form-data">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xq">
	    <tr>
	      <td class="table_xqa">项目名称：</td>
	      <td class="table_xqb">
	      <input type="text"  id="name" name="projname" placeholder="项目名称" class="syt_lb_top_conment_txt"/></td>
	      <td class="table_xqa">预算：</td>
	      <td class="table_xqb">
	      <input type="text" id="budget" name="projbudget" placeholder="项目预算价格" class="syt_lb_top_conment_txt" /></td>
	    </tr>
	    <tr>
	      <td class="table_xqa">立项书：</td>
	      <td class="table_xqb">
	      <input type="file" id="progectfile" name="file" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/></td>
	      <td class="table_xqa">预算书：</td>
	      <td class="table_xqb">
	      <input type="file" id="budgetfile" name="file" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/></td>
	    </tr>
	    
	    <tr>
	      <td class="table_xqa">指导教师：</td>
	      <td class="table_xqb">
	      	<input type="text" id="tutoreid" name="projtutor" style="display:none"/>
	      	<input type="text" id="tutorname" name="projtutorname" class="syt_lb_top_conment_txt" />
	      	<input type="button" class="cc cjxm_but" value="指导教师" />
	      </td>
	      <td class="table_xqa">项目总人数：</td>
	      <td class="table_xqb">
	      	<input type="text" id="allnumber" name="projallnumber" placeholder="项目总人数" class="syt_lb_top_conment_txt"/>
	      </td>
	    </tr>
		<tr>
			<td class="table_xqa">开发语言：</td>
			<td class="table_xqb">
				<select id="language" name="projlanguage" class="input_b" style="float:left;">
					<c:forEach items="${languageconfiglist }" var="li" varStatus="idxStatus">
						<option value="${li.name }">${li.name }</option>
					</c:forEach>
				</select> 
			</td>
			<td class="table_xqa">开发平台：</td>
			<td class="table_xqb">
				<select id="platform" name="projplatform" class="input_b" style="float:left;">
					<c:forEach items="${platformconfiglist }" var="li" varStatus="idxStatus">
						<option value="${li.name }">${li.name }</option>
					</c:forEach>
				</select> 
			</td>
		</tr>
	    <tr>
	      <td class="table_xqa">结题时间：</td>
	      <td class="table_xqb">
	      <input name="projendtime" id="endtime" placeholder="请输入日期" class="syt_lb_top_conment_txt" onclick="laydate()" /></td>
	    </tr>
	    <tr>
	      <td class="table_xqa">项目简述：</td>
	      <td colspan="3" class="table_xqb">
	      <textarea name="projdescribe" id="describe" rows="4" maxlength="500" class="textarea_wby" ></textarea>
	      <p style="color:red;text-align:left;"><br>注意：不能超过500个字符。</p>
	      </td>
	    </tr>
  	</table>
   </form>
  <div class="sytxq_conment_bc">
    <button type="button" id="tsave" class="chaxun_but">保 存</button>
    <button type="button" onclick="callback()" class="chaxun_but">返 回</button>
  </div>
</div>
  <div class="sytxq_conment"></div>
</div>
</div> 
<script type="text/javascript">
$(document).ready(function() {
	$("#tsave").click(function(){
		var progectfilePath = $("#progectfile").val();  
		var progectfilePathExtension = progectfilePath.substr(progectfilePath.lastIndexOf('.') + 1);  
		var budgetfile = $("#budgetfile").val();  
		var budgetfileExtension = budgetfile.substr(budgetfile.lastIndexOf('.') + 1);  
		var dateObj=new Date();
		if(verifynull("name") && verifynull("budget") &&
			verifynull("progectfile") &&verifynull("budgetfile")&&
			verifynull("tutorname")&&verifynull("allnumber") && 
			verifynull("endtime")&&verifynull("describe")) {}else{
			    	return;
		}
		if(!verifyPric("budget")){return;}
		if (progectfilePathExtension != 'txt' && progectfilePathExtension != 'doc'  
		   && progectfilePathExtension != 'docx' && progectfilePathExtension != 'pdf') {  
		     _alert("please upload file that is a file",2);  
		   return false;  
		}  
		if (budgetfileExtension != 'txt' && budgetfileExtension != 'doc'  
		   && budgetfileExtension != 'docx' && budgetfileExtension != 'pdf') {  
		   _alert("please upload file that is a file",2);  
		   return false;  
		}  
		if($("#tutoreid").val()==""){
			_alert("请选择系统的指导教师!",2)
			return;
		}
		//判断结题时间大于当前时间
		var date2 = new Date($("#endtime").val());
		var today = new Date();
		var ww=date2.getTime()-today.getTime();
		if(ww<=0){
			_alert("结题时间有误!",2)
			$("#endtime").val("");
			return;
		}
		if(!regnum("allnumber")){return;}
		_confirm("是否添加此条记录？",1,"add()");
		
	})
})
function add(){
	$("#addProjectForm").ajaxSubmit({  
		type : 'POST',
		url : 'creatProjectHandle.do',  
		success : function(result) {  
			if(result.status=='0'){
				_alert(result.msg);
				$("#name").val("");
				$("#budget").val("");
				$("#budgetfile").val("");
				$("#progectfile").val("");
				$("#tutorname").val("");
				$("#tutoreid").val("");
				$("#allnumber").val("");
				$("#endtime").val("");
				$("#describe").val("");
			}else{
			    _alert(result.msg,2);
			}
		},  
		error : function() {  
		   _alert("创建项目失败，请检查网络后重试",2);  
		}  
	});  
}
</script>
</body>
</html>