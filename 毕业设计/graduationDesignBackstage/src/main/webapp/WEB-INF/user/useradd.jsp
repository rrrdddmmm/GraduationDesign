<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript" src="../content/js/user/opuser.js"></script>
<script src="laydate/laydate.js"></script>
</head>
<body>
	<input type="hidden" id="id" value="" />
	<h1 class="globle_title2">
		<img src="../content/images/tag.gif" /> 添加用户 <em></em>
	</h1>
	<div class="sytxq_conment_wk">
		<div class="sytxq_conment_wk_bx">
			<div class="syt_lb_top">
				<h1 class="syt_lb_top_titleh2">用户信息表</h1>
			</div>
			<div class="sytxq_conment">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="table_xq">
					<tr>
						<td class="table_xqa">姓名：</td>
						<td class="table_xqb">
						<input type="text" placeholder="姓名" id="uname" class="syt_lb_top_conment_txt" />
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">Email：</td>
						<td class="table_xqb">
						<input type="text" placeholder="Email" id="uname" class="syt_lb_top_conment_txt" />
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">手机号：</td>
						<td class="table_xqb">
						<input type="text" placeholder="手机号" id="uname" class="syt_lb_top_conment_txt" />
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">角色：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="branch" style="float:left;">
								<option selected="selected" value="-1">---请选择---</option>
								<option value="1">任勃</option>
								<option value="2">丁美丽</option>
						</select> 
						</td>
					</tr>
					
					<tr>
						<td class="table_xqa">职称：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="branch" style="float:left;">
								<option selected="selected" value="-1">---请选择---</option>
								<option value="1">任勃</option>
								<option value="2">丁美丽</option>
						</select> 
						</td>
					</tr>
					<tr>
						<td class="table_xqa">学历：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="branch" style="float:left;">
								<option selected="selected" value="-1">---请选择---</option>
								<option value="1">任勃</option>
								<option value="2">丁美丽</option>
						</select> 
						</td>
					</tr>
					<tr>
						<td class="table_xqa">方向：</td>
						<td class="table_xqb">
						<select name="branch" class="input_b" id="branch" style="float:left;">
								<option selected="selected" value="-1">---请选择---</option>
								<option value="1">任勃</option>
								<option value="2">丁美丽</option>
						</select> 
						</td>
					</tr>
					<tr>
				    	<td class="table_xqa">个人简介：</td>
				      	<td colspan="3" class="table_xqb"><textarea name="txtOpinion" rows="3" class="textarea_wby" id="txtOpinion" ></textarea></td>
				    </tr>
				    
				    <tr>
				      <td class="table_xqa">头像上传：</td>
				      <td class="table_xqb"><input type="file" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/></td>
				    </tr>
					<tr>
						<td class="table_xqa">用户密码：</td>
						<td class="table_xqb"><input type="password" id="upwd"
							placeholder="密码为空则不修改密码" class="syt_lb_top_conment_txt"
							style="float:left;" />
							<div class="clear"></div></td>
					</tr>

					<tr>
						<td class="table_xqa">用户状态：</td>
						<td class="table_xqb">
						<label> 
						 	<cite style="padding-top: 0px;"> 
						 	<input type="radio" value="1" checked="checked" name="state" />
						 	</cite>
							<span style="padding-top: 0px;">启用</span>
						 </label> 
						 <label> 
							<cite style="padding-top: 0px;">
							<input name="state" type="radio" value="2" />
							</cite>
							<span style="padding-top: 0px;">停用</span>
						</label>
						</td>
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