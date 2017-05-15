<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户列表</title>
    <link href="../content/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../content/js/jquery.1.7.2.min.js"></script>
    <script type="text/javascript" src="../content/js/user/opuser.js"></script>
</head>
<body>
    <h1 class="globle_title2">
        <img src="../content/images/tag.gif" />
        用户列表  <em></em></h1>
    <div class="syt_lb">
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="globle_bck">
        <h1 class="diandianb">:: 用户列表 ::</h1>
        <table width="100%" border="0" cellspacing="1" cellpadding="0" id="tb" class="autotable2">
            <thead>
                <tr class="titletr">
                    <td>姓名</td>
                    <td>邮件</td>
                    <td>手机号</td>
                    <td>角色</td>
                    
                    <td>职称</td>
                    <td>学历</td>
                    <td>方向</td>
                    <td>个人简介</td>
                    <td>创建时间</td>
                    <td>更新时间</td>
                    <td>账号状态</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
            <tr class="whittr" data-itemid="121">
            	<td align="center">任勃</td>
            	<td>314187985@qq.com</td>
            	<td>18829348437</td>
            	<td>老师</td>
            	<td>教授</td>
            	<td>博士</td>
            	<td>大数据</td>
            	<td title="sajdhsajkn撒娇的赛季的起哦按属地加上">本人曾参与...</td>
            	<td>2016/10/22</td>
            	<td>2016/10/22</td>
            	<td>启用</td>
            	<td><a href="userAlter.do">修改</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a class="font-red-sunglo">删除</a>
            	</td>
            </tr>
            </tbody>
        </table>
    </div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        //firstStep();
        $("#search").click(function () {
            currentPage = 1;
            firstStep();
        });
    });
</script>
</html>
