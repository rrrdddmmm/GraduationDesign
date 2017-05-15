<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>项目列表</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script src="../content/js/commonalert.js" type="text/javascript"  charset="utf-8"></script>
<script src="../content/js/jquery.js" language="javascript"></script>
<script src="../content/js/globle_select.js"></script>
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
    <h1 class="syt_lb_top_titleh1"> ∷项目审核∷ </h1>
  </div>
  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="autotable2">
    <tr class="titletr">
      <td>开发语言</td>
      <td>开发平台</td>
      <td>项目描述</td>
      <td>项目预算</td>
      <td>立项书</td>
      <td>结题</td>
      <td>启动评价</td>
      <td>结题评价</td>
      <td>项目完成等级</td>
      <td width="8%" >操作</td>
    </tr>
    <tr class="lantr">
      <td>java</td>
      <td>windows</td>
      <td title="czjkhjdk形成健康vcxvxjkcvkx科技宣传部vjkx开心好吃vkjxhv涉及到合肥括号局就开始电话覅USD部分">此项目目的在于...</td>
      <td><a href="chakan.html">2000</a></td>
      <td><a href="chakan.html">立项书查看</a></td>
      <td><a href="chakan.html">结题文档及成果</a></td>
      <td title="sadsad撒大声地撒打算">待评价</td>
      <td title="撒发生的鬼地方个公分好几个看见好看好看">评价未开始</td>
      <td>评价未开始</td>
      <td><a href="javascript:void(0);" onclick="ShowDiv2('MyDiv', 'fade');">修改</a></td>
    </tr>
  </table>
  <!--分页-->
</div>
  <div class="syt_lb_top">
    <h1 class="syt_lb_top_titleh2">审批意见</h1>
  </div>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xq">
    <tr>
      <td class="table_xqa">审批意见：</td>
      <td class="table_xqb"><textarea name="txtOpinion" rows="4"  class="textarea_wby" id="txtOpinion2"></textarea></td>
    </tr>
    <tr>
      <td class="table_xqa">项目审核意见：</td>
      <td class="table_xqb">
		<label><input type="radio" name="radio" id="radio" value="1" checked="checked"/>启动项目</label>
        <label><input name="radio" type="radio" id="radio2" value="2" />审核未通过</label>
        <label><input type="radio" name="radio" id="radio" value="2" />优</label>
        <label><input name="radio" type="radio" id="radio2" value="1" />良</label>
        <label><input type="radio" name="radio" id="radio" value="0" />中</label>
        <label><input name="radio" type="radio" id="radio2" value="-2" />差</label>
        <label><input type="radio" name="radio" id="radio" value="-10" />未通过</label>
      </td>
    </tr>
  </table>
  <div class="sytxq_conment_bc">
    <button type="submit" class="chaxun_but">保 存</button>
    <button type="button" onclick="history.back();" class="chaxun_but">返 回</button>
     </div>

<!--弹出层---->
<div id="fade" class="black_overlay">
</div>
 <div id="MyDiv" class="white_content">

<div class="sdcq_tck">
  <img src="../content/images/hong.gif" class="sdcq_tck_right_cha" width="1" height="16" onclick="CloseDiv2('MyDiv','fade')" />
  <div class="sdcq_tck_hong">
  <h1 class="globle_title3"><img src="../content/images/tcc_b.png" style=" vertical-align:middle" /> 修改信息</h1>
  </div>
  <div class="sdcq_tck_conment">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_xq">
    <tr>
      <td class="table_xqa">项目负责人：</td>
      <td class="table_xqb"><input type="text" class="syt_lb_top_conment_txt" /></td>
      <td class="table_xqa">联系方式：</td>
      <td class="table_xqb"><input type="text" class="syt_lb_top_conment_txt" /></td>
    </tr>
    
    <tr>
      <td class="table_xqa">立项书：</td>
      <td class="table_xqb"><input type="file" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/></td>
      <td class="table_xqa">预算书：</td>
      <td class="table_xqb"><input type="file" style="width:137px; height:27px" class="syt_lb_top_conment_txt"/></td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目负责人：</td>
      <td class="table_xqb"><input type="text"  placeholder="项目名称" class="syt_lb_top_conment_txt"/></td>
      <td class="table_xqa">联系方式：</td>
      <td class="table_xqb"><input type="text" placeholder="负责人联系方式" class="syt_lb_top_conment_txt" /></td>
    </tr>
    <tr>
      <td class="table_xqa">创建时间：</td>
      <td class="table_xqb"><input name="newreturnTime" placeholder="请输入日期" class="syt_lb_top_conment_txt" onclick="laydate()" id="newreturnTime"/></td>
      <td class="table_xqa">结题时间：</td>
      <td class="table_xqb"><input name="newreturnTime" placeholder="请输入日期" class="syt_lb_top_conment_txt" onclick="laydate()" id="newreturnTime"/></td>
    </tr>
    
    <tr>
      <td class="table_xqa">指导教师：</td>
      <td class="table_xqb"><input type="text" class="syt_lb_top_conment_txt" /></td>
      <td class="table_xqa">项目状态：</td>
      <td class="table_xqb"><select name="select4"  class="input_b" >
        <option selected="selected" value="-1">请选择</option>
        <option value="1">待审核</option>
        <option value="2">进行中</option>
        <option value="2">已完成</option>
      </select></td>
    </tr>

    <tr>
      <td class="table_xqa">开发语言：</td>
      <td class="table_xqb"><select name="select3"  class="input_b" >
        <option selected="selected" value="-1">请选择</option>
        <option value="1">java</option>
        <option value="2">c++</option>
        <option value="3">c#</option>
      </select></td>
      
      <td class="table_xqa">开发平台：</td>
      <td class="table_xqb"><select name="select4"  class="input_b" >
        <option selected="selected" value="-1">请选择</option>
        <option value="1">Windows</option>
        <option value="2">Linux</option>
      </select></td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目总人数：</td>
      <td class="table_xqb"><input type="text"  placeholder="项目总人数" class="syt_lb_top_conment_txt"/></td>
      <td class="table_xqa">当前人数：</td>
      <td class="table_xqb"><input type="text" placeholder="项目当前人数" class="syt_lb_top_conment_txt" /></td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目简述：</td>
      <td colspan="3" class="table_xqb"><textarea name="txtOpinion" rows="4" class="textarea_wby" id="txtOpinion" ></textarea></td>
    </tr>
    
    <tr>
      <td class="table_xqa">项目启动审核评价：</td>
      <td colspan="3" class="table_xqb"><textarea name="txtOpinion" rows="4" class="textarea_wby" id="txtOpinion" ></textarea></td>
    </tr>
    <tr>
      <td class="table_xqa">项目结题审核评价：</td>
      <td colspan="3" class="table_xqb"><textarea name="txtOpinion" rows="4" class="textarea_wby" id="txtOpinion" ></textarea></td>
    </tr>
  </table>
     <div class="win_btn">
     <button type="submit" class="chaxun_but2">确认</button>
     <button type="submit" class="chaxun_but2">取消</button>
     </div>
  </div>
  <div class="sdcq_tck_baidi"></div>
</div>
</div>
</body>
</html>
