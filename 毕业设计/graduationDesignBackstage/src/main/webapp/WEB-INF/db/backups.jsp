<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>备份数据列表</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script src="../content/js/commonalert.js" type="text/javascript"  charset="utf-8"></script>
</head>
<body>
	<h1 class="globle_title2">
        <img src="../content/images/tag.gif" />
        备份数据信息列表  <em></em></h1>
    <div class="syt_lb">
		</div>
		<div class="globle_bck">
        <h1 class="diandianb">:: 备份数据库信息列表 ::<a href="javascript:void(0);" onclick="backupsave();">
            <img src="../content//images/backup.jpg" width="52" height="22" class="f_r" style="margin: 2px 10px 0px 0px;" /></a></h1>
		<table width="100%" border="0" cellspacing="1" cellpadding="0" id="tb"
			class="autotable2">
			<thead>
				<tr class="titletr">
					<td >备份时间</td>
					<td>操作</td>					
				</tr>
			</thead>
			<tbody id="tbody">
			<c:forEach items="${list }" var="li" varStatus="idxStatus">
				<tr class="whittr" data-itemid="${li.id }">
					<td>${li.creattimestr }</td>
					<td>
					<a href="javascript:void(0);" onclick="recoversave('${li.backuppath }');">恢复</a>&nbsp;&nbsp;/&nbsp;&nbsp;
					<a href="download.do?filePath=${li.backuppath }">下载</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	var _path;
	function backupsave(){
		_confirm("是否备份数据库？",1,"backup()");
	}
	function recoversave(path){
		_path=path;
		_confirm("是否恢复数据库？",1,"recover()");
	}
	function recover(){
		$.ajax({
			type : "POST",
			url : "recover.do",
			data : {
 				backuppath: ''+_path+''
			},
			datatype : "json",
			error : function() {  
	            _alert("操作失败，请检查网络后重试",2);  
	        },  
			success : function(result) {
				if (result.state == '0') {
					_alert(result.msg);
				}else{
					_alert(result.msg,2);
				} 
			}
		});
	}
	
	function backup(){
			$.ajax({
				type : "POST",
				url : "backup.do",
				data : {},
				datatype : "json",
				error : function() {  
		            _alert("操作失败，请检查网络后重试",2);  
		        },  
				success : function(result) {
					if (result.state == '0') {
						_alert(result.msg);
						$("#tbody").append(
								'<tr class="whittr" data-itemid="'+result.id+'">'+
								'<td>'+result.creattimestr+'</td>'+
								'<td>'+
								'<a href="javascript:void(0);" onclick="recoversave(\''+result.backuppath+'\');">恢复</a>&nbsp;&nbsp;/&nbsp;&nbsp;'+
								'<a href="download.do?filePath='+result.backuppath+'">下载</a>'+
								'</td>'+
							'</tr>');
					}else{
						_alert(result.msg,2);
					} 
				}
		});
	}
</script>
</html>