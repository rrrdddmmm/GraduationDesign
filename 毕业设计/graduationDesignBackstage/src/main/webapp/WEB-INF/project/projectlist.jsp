<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>项目列表</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/commonalert.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../content/js/jquery.js"></script>
<script type="text/javascript" src="../content/js/commonalert.js"></script>
<script type="text/javascript" src="../content/js/globle_select.js"></script>

<style type="text/css">
.black_overlay {
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
	filter: alpha(opacity = 35);
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 35%;
	width: 50%;
	height: auto;
	z-index: 1002;
	overflow: hidden;
	padding-bottom: 20px;
}
</style>
</head>

<body>
	<div class="syt_lb">
		<div class="syt_lb_top">
			<h1 class="syt_lb_top_titleh1">查询条件</h1>
		</div>
		<div class="syt_lb_top_conment">
			<div class="fandr">
				<div class="form-groupl">
				<c:if test="${userInfomation.role==2 }">
					申请人： <select id="application" class="input_b">
							<option selected="selected" value="-1">---全部---</option>
							<c:forEach items="${applicationlist }" var="li" varStatus="idxStatus">
								<option value="${li.projemail }">${li.creatpersionname }</option>
							</c:forEach>
						  </select> 
					审核类型： <select id="auditstate" class="input_b">
						<option selected="selected" value="-1">---全部---</option>
						<option value="0">启动审核</option>
						<option value="2">结题审核</option>
						<option value="3">已完成</option>
					</select> 
				</c:if>
			  	<c:if test="${userInfomation.role==1 }">	
					担任角色： <select id="jointype" class="input_b">
						<option selected="selected" value="-1">---全部---</option>
						<option value="1">参与项目</option>
						<option value="2">创建项目</option>
					</select>
			 	</c:if>
				</div>
				<c:if test="${userInfomation.role!=3 }">	
				<button type="button" id="CriteriaQuery" class="chaxun_but">查询</button>
				</c:if>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="globle_bck">
		<div class="syt_lb_top">
			<h1 class="syt_lb_top_titleh1">∷项目列表∷</h1>
		</div>
		<table width="100%" border="0" cellspacing="1" cellpadding="0"
			class="autotable2">
			<tr class="titletr">
				<td>项目名称</td>
				<td>申请人</td>
				<td>指导人</td>
				<td>总开发人数</td>
				<td>当前人数</td>
				<td>创建时间</td>
				<td>截止时间</td>
				<td>项目状态</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${projectlist }" var="li" varStatus="idxStatus">
				<tr class="whittr" data-itemid="${li.projid }">
					<td>${li.projname }</td>
					<td title="${li.projphone }">${li.creatpersionname }</td>
					<td>${li.projtutorname }</td>
					<td>${li.projallnumber }</td>
					<td>${li.projcurrentnumber }</td>
					<td><fmt:formatDate value="${li.projcreattime }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${li.projendtime }"
							pattern="yyyy-MM-dd" /></td>
					<td>
						<c:if test="${li.projstatus==0 }">待启动审核</c:if>
						<c:if test="${li.projstatus==1 }">开发中</c:if>
						<c:if test="${li.projstatus==2 }">待结题审核</c:if>
						<c:if test="${li.projstatus==3 }">已完成</c:if>
					</td>
					<td>
					<c:if test="${userInfomation.role==1 }">
						<a href="../projectAuditController/projectChakan.do?projid=${li.projid }">查看</a>&nbsp;&nbsp;
						<c:if test="${userInfomation.email==li.projemail }">
							<a class="font-red-sunglo">删除</a>
						</c:if>
					</c:if>
					<c:if test="${userInfomation.role==2 }">
						<a href="../projectAuditController/projectChakan.do?projid=${li.projid }">审核</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${userInfomation.role==3 }">
						<a href="../projectAuditController/projectChakan.do?projid=${li.projid }">查看</a>&nbsp;&nbsp;
						<a class="font-red-sunglo">删除</a>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

<script>
	$(document).ready(function() {
		$("#application").val("${project.projemail}");//回显
		$("#auditstate").val("${project.projstatus}");//回显
		$("#jointype").val("${project.jointype}");//回显
		$("#CriteriaQuery").click(function() {
			if('${userInfomation.role }'=='1'){
				window.location.href ="projectList.do?jointype="+$("#jointype").val()+"";
			}else if('${userInfomation.role }'=='2'){
				window.location.href ="projectList.do?projemail="+$("#application").val()+"&projstatus="+$("#auditstate").val()+"";
			}else  if('${userInfomation.role }'=='3'){
			
			}
		});
	})
	var _parent;
	$(".font-red-sunglo").live("click", function() {
		var _this = $(this);
		_parent = _this.parent().parent();
		var id = _parent.attr("data-itemID");
		_confirm("是否删除此记录？", 1, "del(" + id + ")");
	});
	function del(id) {
		$.ajax({
			type : "POST",
			url : "delHandle.do",
			data : {
				projid : id,
			},
			datatype : "json",
			error : function() {
				_alert("操作失败，请检查网络后重试", 2);
			},
			success : function(result) {
				if (result.status == '0') {
					_alert(result.msg);
					_parent.remove();
				} else {
					_alert(result.msg, 2);
				}
			}
		});
	}
</script>


</html>
