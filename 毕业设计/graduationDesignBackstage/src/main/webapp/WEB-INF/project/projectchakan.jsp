<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目详情</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script src="../content/js/jquery.js" language="javascript"></script>
<script src="../content/js/commonalert.js" type="text/javascript"></script>
<script type="text/javascript" src="../content/js/user/opuser.js"></script>
<script type="text/javascript" src="../content/js/commonutil.js"></script>
<script type="text/javascript" src="../content/js/commonalert.js"></script>
<script type="text/javascript" src="../content/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../content/js/jquery-form.js"></script>
<script src="../laydate/laydate.js"></script>

</head>

<script>
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
            top: 16%;
            left: 26%;
            width: 50%;
            height: auto;
            z-index: 1002;
            overflow: hidden;
            padding-bottom: 20px;
        }

.checkbox.inline 
	{
	display: inline-block;
	padding-top: 5px;
	margin-bottom: 0;
	vertical-align: middle;
	}
    </style>



<body>
<div class="globle_bck">
  <div class="syt_lb_top">
    <h1 class="syt_lb_top_titleh1"> ∷项目详情∷ </h1>
  </div>
  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="autotable2">
    <tr class="titletr">
      <td>开发语言</td>
      <td>开发平台</td>
      <td>项目描述</td>
      <td>项目预算(元)</td>
      <td>立项书</td>
      <td>结题</td>
      <td>启动评价</td>
      <td>结题评价</td>
      <td>项目等级</td>
      <td width="8%" >操作</td>
    </tr>
    <tr class="whittr">
      <td>${project.projlanguage }</td>
      <td>${project.projplatform }</td>
      <td title="${project.projdescribe}">${fn:substring(project.projdescribe, 0, 5)}...</td>
      <td><a href="download.do?filePath=${project.projbudgetfile }">${project.projbudget }</a></td>
      <td><a href="download.do?filePath=${project.projprogectfile }">立项书查看</a></td>
      <td><a href="download.do?filePath=${allResultPath }">结题文档及成果</a></td>
      <c:if test="${project.projstatus==0 }"><td>待评价</td></c:if>
      <c:if test="${project.projstatus!=0 }">
      <td title="${project.projstartupevaluation }">${fn:substring(project.projstartupevaluation, 0, 5)}...</td>
      </c:if>
      
      
      <c:if test="${project.projstatus==0 or project.projstatus==1}"><td>评价未开始</td></c:if>
      <c:if test="${project.projstatus==2}"><td>待评价</td></c:if>
      <c:if test="${project.projstatus==3 }">
      <td title="${project.projresultevaluationvalue }">${fn:substring(project.projresultevaluationvalue, 0, 5)}...</td>
	  </c:if>
	  
	  
	  <c:if test="${project.projstatus==0 }"><td>等级待定</td></c:if>
	  <c:if test="${project.projstatus!=0 }"><td>${project.projgrade}</td></c:if>
      <c:if test="${userInfomation.email==project.projemail }">
      	<td><a href="javascript:void(0);" onclick="ShowDiv2('MyDiv', 'fade');">修改</a></td>
      </c:if>
      <c:if test="${userInfomation.email!=project.projemail }">
      	<td><a href="javascript:void(0);" onclick="ShowDiv2('MyDiv', 'fade');">查看详情</a></td>
      </c:if>
    </tr>
    <tr class="lantr">
<!--   autoplay="autoplay" -->
	<c:if test="${video.resultdescription!=null }">
	<td colspan="10">
    	<video width="600" height="250"  controls loop="loop"><source src="${video.resultfile }"/></video>
  	</td>
	</c:if>
	<c:if test="${video.resultdescription==null }">
	<td colspan="10">
    	<video width="600" height="250"  controls loop="loop" poster="${videodefaultimage }"><source src="${video.resultfile }"/></video>
  	</td>
  	</c:if>
  </tr>
  </table>
  <!--分页-->
  
</div>
<c:if test="${userInfomation.role==2 }">
  <div class="syt_lb_top">
    <h1 class="syt_lb_top_titleh2">审批意见</h1>
  </div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xq">
    <tr>
      <td class="table_xqa">审批意见：</td>
      <td class="table_xqb"><textarea name="advice" rows="4"  class="textarea_wby" id="advice"></textarea></td>
    </tr>
    <tr>
      <td class="table_xqa">项目审核等级：</td>
      <td class="table_xqb">
        <label><input type="radio" name="radio" id="excellent" value="4" checked="checked"/>优</label>
        <label><input type="radio" name="radio" id="good" value="3" />良</label>
        <label><input type="radio" name="radio" id="secondary" value="2" />中</label>
        <label><input type="radio" name="radio" id="poor" value="1" />差</label>
        <label><input type="radio" name="radio" id="notpass" value="0" />未通过</label>
      </td>
    </tr>
  </table>
  <div class="sytxq_conment_bc">
    <button type="button" id="t_auditing" class="chaxun_but">保 存</button>
    <button type="button" onclick="location.href='../projectManagerController/projectList.do'" class="chaxun_but">返 回</button>
     </div>
</c:if>
<!--弹出层---->
<div id="fade" class="black_overlay">
</div>
 <div id="MyDiv" class="white_content">
<div class="sdcq_tck">
  <img src="../content/images/hong.gif" class="sdcq_tck_right_cha" width="1" height="16" onclick="CloseDiv2('MyDiv','fade')" />
  <div class="sdcq_tck_hong">
  <h1 class="globle_title3"><img src="../content/images/tcc_b.png" style=" vertical-align:middle" /> 项目详情  
	 <c:if test="${userInfomation.email==project.projemail }">
		 <a style="color:red;text-align:left;">注意：* 标示的栏目可修改哦!</a>
	 </c:if> 
  </h1>
  </div>
  <div class="sdcq_tck_conment">
  <form id="alterProjectForm" enctype="multipart/form-data">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xq">
     <tr>
	      <td class="table_xqa">项目名称：</td>
	      <td class="table_xqb">
	      <input type="text"  id="name" name="projname" value="${project.projname }" placeholder="项目名称" class="syt_lb_top_conment_txt"/>
	      <a style="color:red;text-align:left;">*</a>
	      </td>
	      <td class="table_xqa">预算：</td>
	      <td class="table_xqb">
	      <input type="text" id="budget" name="projbudget" value="${project.projbudget }" placeholder="项目预算价格" class="syt_lb_top_conment_txt" />
	      <a style="color:red;text-align:left;">*</a>
	      </td>
	    </tr>
    <tr>
	      <td class="table_xqa">立项书：</td>
	      <td class="table_xqb">
	      <input type="file" id="progectfile" name="progectfile" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/>
	      <a style="color:red;text-align:left;">*</a>
	      </td>
	      <td class="table_xqa">预算书：</td>
	      <td class="table_xqb">
	      <input type="file" id="budgetfile" name="budgetfile" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/>
	      <a style="color:red;text-align:left;">*</a>
	      </td>
	    </tr>
	    
    <tr>
      <td class="table_xqa">项目负责人：</td>
      <td class="table_xqb">
      <input type="text" value="${project.creatpersionname }" class="syt_lb_top_conment_txt" disabled="true"/>
      <input type="text" name="projid" value="${project.projid }" style="display:none"/>
      </td>
      <td class="table_xqa">联系方式：</td>
      <td class="table_xqb"><input type="text" value="${project.projphone }" class="syt_lb_top_conment_txt" disabled="true"/></td>
    </tr>
    
    <tr>
      <td class="table_xqa">创建时间：</td>
      <td class="table_xqb"><input name="newreturnTime" value="<fmt:formatDate value="${project.projcreattime }"
							pattern="yyyy-MM-dd" />" placeholder="请输入日期" class="syt_lb_top_conment_txt" id="newreturnTime" disabled="true"/></td>
      <td class="table_xqa">结题时间：</td>
      <td class="table_xqb">
      <input name="projendtime" id="endtime" value="<fmt:formatDate value="${project.projendtime }"
							pattern="yyyy-MM-dd" />" placeholder="请输入日期" class="syt_lb_top_conment_txt" onclick="laydate()"/>
		<a style="color:red;text-align:left;">*</a>					
	  </td>
    </tr>
    
    <tr>
      <td class="table_xqa">指导教师：</td>
      <td class="table_xqb"><input type="text" value="${project.projtutorname }"class="syt_lb_top_conment_txt" disabled="true"/></td>
      
      <td class="table_xqa">项目状态：</td>
      <td class="table_xqb">
      <c:if test="${project.projstatus==0 }">
      <input type="text" value="待启动审核" class="syt_lb_top_conment_txt" disabled="true"/>
      </c:if>
      <c:if test="${project.projstatus==1 }">
      <input type="text" value="开发中" class="syt_lb_top_conment_txt" disabled="true"/>
      </c:if>
      <c:if test="${project.projstatus==2 }">
      <input type="text" value="待结题审核" class="syt_lb_top_conment_txt" disabled="true"/>
      </c:if>
      <c:if test="${project.projstatus==3 }">
      <input type="text" value="已完成" class="syt_lb_top_conment_txt" disabled="true"/>
      </c:if>
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
	<a style="color:red;text-align:left;">*</a>
	</td>
      
    <td class="table_xqa">开发平台：</td>
		<td class="table_xqb">
		<select id="platform" name="projplatform" class="input_b" style="float:left;">
			<c:forEach items="${platformconfiglist }" var="li" varStatus="idxStatus">
			<option value="${li.name }">${li.name }</option>
			</c:forEach>
		</select> 
	<a style="color:red;text-align:left;">*</a>
	</td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目总人数：</td>
      <td class="table_xqb"><input type="text"  id="allnumber" name="projallnumber" value="${project.projallnumber }" placeholder="项目总人数" class="syt_lb_top_conment_txt"/>
      <a style="color:red;text-align:left;">*</a>
      </td>
      <td class="table_xqa">当前人数：</td>
      <td class="table_xqb"><input type="text" value="${project.projcurrentnumber }" placeholder="项目当前人数" class="syt_lb_top_conment_txt" disabled="true"/></td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目简述：</td>
      <td colspan="3" class="table_xqb"><textarea name="projdescribe" id="describe" rows="4" class="textarea_wby" >${project.projdescribe }</textarea>
      <p style="color:red;text-align:left;"><br>*</p>
      </td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目启动审核评价：</td>
      <td colspan="3" class="table_xqb"><textarea  rows="4" class="textarea_wby"  disabled="true">${project.projstartupevaluation }</textarea></td>
    </tr>
    <tr>
      <td class="table_xqa">项目结题审核评价：</td>
      <td colspan="3" class="table_xqb"><textarea  rows="4" class="textarea_wby"  disabled="true">${project.projresultevaluationvalue }</textarea></td>
    </tr>
  </table>
  </form>
  <c:if test="${userInfomation.email==project.projemail }">
     <div class="win_btn">
     <button type="button" id="tsave" class="chaxun_but2">确认</button>
     <button type="button" onclick="CloseDiv2('MyDiv','fade')" class="chaxun_but2">取消</button>
     </div>
 </c:if>
  </div>
  <div class="sdcq_tck_baidi"></div>
</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#language").val("${project.projlanguage}");
	$("#platform").val("${project.projplatform}");
	var msg='${msg}';if(msg!="" && msg!=null){_alert(msg)}
	$("#t_auditing").click(function(){
		_confirm("是否确认审核？",1,"audit()");
		
	})
	$("#tsave").click(function(){
		var progectfilePath = $("#progectfile").val();  
		var progectfilePathExtension = progectfilePath.substr(progectfilePath.lastIndexOf('.') + 1);  
		var budgetfile = $("#budgetfile").val();  
		var budgetfileExtension = budgetfile.substr(budgetfile.lastIndexOf('.') + 1);  
		var dateObj=new Date();
		if(verifynull("name") && verifynull("budget") &&
			verifynull("tutorname")&&verifynull("allnumber") && 
			verifynull("endtime")&&verifynull("describe")) {}else{
			    	return;
		}
		if(!verifyPric("budget")){return;}
		if($("#progectfile").val()!=''){
			if (progectfilePathExtension != 'txt' && progectfilePathExtension != 'doc'  
			&& progectfilePathExtension != 'docx' && progectfilePathExtension != 'pdf') {  
				_alert("please upload file that is a file",2);  
				return false;  
			}  
		}
		if($("#budgetfile").val()!=''){
			if (budgetfileExtension != 'txt' && budgetfileExtension != 'doc'  
			   && budgetfileExtension != 'docx' && budgetfileExtension != 'pdf') {  
			   _alert("please upload file that is a file",2);  
			   return false;  
			}  
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
		_confirm("是否添加此条记录？",1,"alter()");
		
	})

})
function alter(){
	$("#alterProjectForm").ajaxSubmit({  
		type : 'POST',
		url : 'alterProjectHandle.do', 
		success : function(result) {  
			if(result.status=='0'){
				CloseDiv2('MyDiv','fade');
				window.location.href ="projectChakan.do?projid=${project.projid }&msg="+result.msg+"";
				$("#budgetfile").val("");
				$("#progectfile").val("");
			}else{
			    _alert(result.msg,2);
			}
		},  
		error : function() {  
		   _alert("创建项目失败，请检查网络后重试",2);  
		}  
	}); 
}
function audit(){
	$.ajax({
		type : "POST",
		url : "auditHandle.do",
		data : {
			projid   :'${project.projid }',
			advice : $("#advice").val(),
			projstartupevaluationvalue:'${project.projstartupevaluationvalue }',
			values: $("input[name='radio']:checked").val()
		},
		dataType : "json",
		success : function(result) {
			if(result.status=='0'){
				_alert(result.msg);
			}else{
				_alert(result.msg,2);
			}
		},
		error : function() {  
            _alert("信息修改失败，请检查网络后重试",2);  
        }  
	});
}
</script>
</body>
</html>
