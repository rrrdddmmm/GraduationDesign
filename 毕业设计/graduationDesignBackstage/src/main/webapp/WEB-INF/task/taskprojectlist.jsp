<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>任务项目列表</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script src="../content/js/jquery.js" language="javascript"></script>
<script src="../content/js/globle_select.js"></script>
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
<h1 class="globle_title2"><img src="../content/images/tag.gif" /> 任务管理 → <a href="taskProject.do" ><em>任务列表</em></a></h1>
<div class="sytxq_conment_wk">

<div class="sytxq_conment_wk_bx">
  <div class="syt_lb">
    <div class="syt_lb_top">
      <h1 class="syt_lb_top_titleh1">查询条件</h1>
    </div>
    <div class="syt_lb_top_conment">
    <div class="fandr">
      <div class="form-groupl">
               担任角色：
      <select id="state" class="input_b">
          <option selected="selected" value="-1">---全部---</option>
          <option value="1">参与项目</option>
          <option value="2">创建项目</option>
      </select>
      </div>
      <button type="submit" class="chaxun_but" id="search">查询</button>
    </div>
    <div class="clearfix"></div>
  </div>
  </div>
  <div id="blockquote_content">
  <div class="globle_bck">
    <h1>  ∷ 项目-任务续表 ∷</h1>
  </div>
  </div>
  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="autotable2">
    <tr class="titletr">
      <td>项目名称</td>
      <td>申请人</td>
      <td>联系方式</td>
      <td>启动时间</td>
      <td>截止时间</td>
      <td>项目描述</td>
      <td>操作</td>
    </tr>
    <tr class="whittr">
      <td>计算机开发</td>
      <td>任勃</td>
      <td>18829348437</td>
      <td>2014-05-06</td>
      <td>2014-05-06</td>
      <td title="djhf速度快放假的第四部分金卡戴珊焚枯食淡">
      	<a href="#" >此任务目的在于。。。</a>
      </td>
      <td>
      	  <a href="taskProjectList.do" >创建任务</a>&nbsp;&nbsp;
      	  <a href="taskDistribution.do" >分配任务</a>&nbsp;&nbsp;
      	  <a href="taskChakan.do" >查看任务</a>
      </td>
    </tr>
  </table>
  <div class="sytxq_conment"></div>
</body>
</html>
