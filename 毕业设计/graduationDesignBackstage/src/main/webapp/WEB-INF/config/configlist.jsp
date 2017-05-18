<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>配置信息列表</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script src="../content/js/commonalert.js" type="text/javascript"  charset="utf-8"></script>
</head>
<body>
	<h1 class="globle_title2">
        <img src="../content/images/tag.gif" />
        配置信息列表  <em></em></h1>
    <div class="syt_lb">
		</div>
		<div class="globle_bck">
        <h1 class="diandianb">:: 配置信息列表 ::<a href="configAdd.do?flage=${flage }&handle=1">
            <img src="../content//images/btn_add.jpg" width="52" height="22" class="f_r" style="margin: 2px 10px 0px 0px;" /></a></h1>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" id="tb"
			class="autotable2">
			<thead>
				<tr class="titletr">
					<td>名称</td>
					<td >创建时间</td>
					<td >修改时间</td>
					<td>状态</td>
					<td>操作</td>					
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${configlist }" var="li" varStatus="idxStatus">
				<tr class="whittr" data-itemid="${li.id }">
					<td align="center">${li.name }</td>
					<td><fmt:formatDate value="${li.creattime }" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${li.updatetime }" pattern="yyyy-MM-dd"/></td>
					<c:if test="${li.state==1 }"><td>启用</td></c:if>
					<c:if test="${li.state==2 }"><td>停用</td></c:if>
					<td><a href="configAdd.do?flage=${flage }&name=${li.name }&state=${li.state }&id=${li.id }&handle=2">修改</a>&nbsp;&nbsp;/&nbsp;&nbsp;
					<a class="font-red-sunglo">删除</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
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
				url : "configHandle.do",
				data : {
					id : id,
					handle:3,
					flage :'${flage }'
				},
				datatype : "json",
				error : function() {  
		            _alert("操作失败，请检查网络后重试",2);  
		        },  
				success : function(result) {
					if (result.status == '0') {
						_alert(result.msg);
						_parent.remove();
					}else{
						_alert(result.msg,2);
					} 
				}
			});
	}
</script>
</html>