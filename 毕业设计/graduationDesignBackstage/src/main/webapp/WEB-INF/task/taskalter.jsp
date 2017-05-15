<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改任务</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript" src="../content/js/user/opuser.js"></script>
<script src="../laydate/laydate.js"></script>
</head>
<body>
	<input type="hidden" id="id" value="" />
	<h1 class="globle_title2">
		<img src="../content/images/tag.gif" /> 修改任务 <em></em>
	</h1>
	<div class="sytxq_conment_wk">
		<div class="sytxq_conment_wk_bx">
			<div class="syt_lb_top">
				<h1 class="syt_lb_top_titleh2">任务信息表</h1>
			</div>
			<div class="sytxq_conment">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="table_xq">
					<tr>

						<td class="table_xqa">项目名称：</td>
						<td class="table_xqb"><select name="unit" class="input_b">
								<option value="1" selected="selected" disabled="disabled">软件协同开发平台</option>
						</select></td>
					</tr>
					
					
					<tr>
						<td class="table_xqa">参与人员：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="branch" style="float:left;">
								<option selected="selected" value="-1">---总体任务---</option>
								<option value="1">任勃</option>
								<option value="2">丁美丽</option>
						</select> 
						</td>
					</tr>
					
					
					<tr>
						<td class="table_xqa">开始时间 ：</td>
						<td class="table_xqb"><input name="newreturnTime" placeholder="请输入日期" class="syt_lb_top_conment_txt" onclick="laydate()" id="newreturnTime"/></td>

					</tr>

					<tr>
						<td class="table_xqa">截止时间 ：</td>
						<td class="table_xqb"><input name="newreturnTime" placeholder="请输入日期" class="syt_lb_top_conment_txt" onclick="laydate()" id="newreturnTime"/></td>

					</tr>
					
					<tr>
				    	<td class="table_xqa">任务简述：</td>
				      	<td colspan="3" class="table_xqb"><textarea name="txtOpinion" rows="4" class="textarea_wby" id="txtOpinion" ></textarea></td>
				    </tr>
				    
				    <tr>
				      <td class="table_xqa">任务书：</td>
				      <td class="table_xqb"><input type="file" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/></td>
				    </tr>
					
				</table>
			</div>
			<div class="sytxq_conment_bc">
				<button type="button" id="tsave" onclick="save()" class="chaxun_but">保 存</button>
				<button type="submit" onclick="callback()" class="chaxun_but">返
					回</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var cTG = $(".yzcg");
        var cSB = $(".yzsb");
		$(document).ready(function() {
		//GetData();
		$("#branch").blur(function () {
                branch();
            })
        $("#roleid").blur(function () {
                roleid();
		})
		})
		function branch() {
                if ($("#branch").val()> 0) {
                    cTG.eq(0).show();
                    cSB.eq(0).hide();
                    return true;
                } else {
                    cTG.eq(0).hide();
                    cSB.eq(0).show();
                    return false;
                }
            }
        function roleid() {
                if ($("#roleid").val()> 0) {
                    cTG.eq(1).show();
                    cSB.eq(1).hide();
                    return true;
                } else {
                    cTG.eq(1).hide();
                    cSB.eq(1).show();
                    return false;
                }
            }
	</script>
</body>