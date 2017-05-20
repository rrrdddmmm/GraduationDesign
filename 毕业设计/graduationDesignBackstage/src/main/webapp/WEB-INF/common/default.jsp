<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>校园软件开发在线协同平台</title>
<link href="../content/css/style.css" rel="stylesheet" type="text/css" />
<script src="../content/js/commonalert.js" type="text/javascript"  charset="utf-8"></script>
<script src="../content/js/jquery.js" type="text/javascript"></script>
</head>

<body>
<div class="sys-top-banner">
  <div class="sys-help">
    <div class="biao_time">
       <a href="javascript:" id="localtime" class="font_whie"></a></br>
       <a href="javascript:" id="localtime1" class="font_whie"></a>
    </div>
    <div class="top_tw">
      <div class="admin_user"><a href="#" class="yellow">欢迎您，${userInfomation.name }</a></div> 
        <div class="t_ctuichu"><a class="font_whie" href="javascript:_back101('是否退出？', 2,'tc');">退出</a></div>
      <div class="clear"></div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<!--内容区-->
<div class="sys-content h"> 
  <!--left-->
  <div class="sys-content-left"> <img src="../content/images/title.fw.png" />
    <ul class="ulnav">
      <li> <i class="i1"></i><em><a href="getIndex.do" class="lan" target="rightT">系统首页</a></em> </li>
      <li> <i class="i2"></i><em>项目管理</em>
      <dd class="snav dis">  
      		<dl><a href="../projectCreatController/toCreatProject.do" target="rightT">创建项目</a></dl>        
            <dl><a href="../projectManagerController/projectList.do" target="rightT">项目列表</a></dl>
        </dd>
      </li>
      <li> <i class="i3"></i><em>任务管理</em>
      	<dd class="snav dis">
          	<dl><a href="../taskManagerController/taskProject.do" target="rightT">任务列表</a></dl>
        </dd>
      </li>
      <li> <i class="i3"></i><em>团队管理</em>
      <dd class="snav dis">
          <dl><a href="../teamManagerController/teamList.do" target="rightT">团队列表</a></dl>
        </dd>
      </li>
      <li> <i class="i4"></i><em>用户管理</em>
      <dd class="snav dis">
          <dl><a href="../userManagerController/userAdd.do" target="rightT">添加用户</a></dl>
        </dd>
      	<dd class="snav dis">
          <dl><a href="../userManagerController/userList.do" target="rightT">用户列表</a></dl>
        </dd>
        <dd class="snav dis">
          <dl><a href="../userManagerController/userStateList.do?state=2" target="rightT">停用用户</a></dl>
        </dd>
      </li>
      <li> <i class="i5"></i><em>系统维护</em>
        <dd class="snav dis">
          <dl><a href="../configManagerController/configList.do?flage=1" target="rightT">学历管理</a></dl>          
        </dd>
		<dd class="snav dis">
	          <dl><a href="../configManagerController/configList.do?flage=2" target="rightT">方向管理</a></dl>          
	    </dd>
		<dd class="snav dis">
	          <dl><a href="../configManagerController/configList.do?flage=3" target="rightT">职称管理</a></dl>          
	    </dd>
	    <dd class="snav dis">
	          <dl><a href="../configManagerController/configList.do?flage=4" target="rightT">开发语言管理</a></dl>          
	    </dd>
	    <dd class="snav dis">
	          <dl><a href="../configManagerController/configList.do?flage=5" target="rightT">开发平台管理</a></dl>          
	    </dd>
	    <dd class="snav dis">
	          <dl><a href="../newsManagerController/newsList.do" target="rightT">新闻管理</a></dl>          
	    </dd>
	    <dd class="snav dis">
	          <dl><a href="../dbRecBackupController/list.do" target="rightT">数据库备份恢复</a></dl>          
	    </dd>
      </li>
      <li> <i class="i5"></i><em>个人信息管理</em>
        <dd class="snav dis">
          <dl><a href="../userMyInfomationController/myInfomation.do" target="rightT">わたしの信息</a></dl>          
        </dd>
      </li>
      
    </ul>
  </div>
  
  <!--right-->
  <div class="sys-content-right">
    <div class="sys-content-right-content">

      <div class="sys-content-right-iframe">
      
        <iframe frameborder="0" class="main" id="rightT" name="rightT" scrolling="auto" src="getIndex.do"></iframe>
        <script type="text/javascript">
				var oFrm = document.getElementById('rightT');
				oFrm.onload = oFrm.onreadystatechange = function () {
					if (this.readyState && this.readyState != 'complete') {
						return;
					}
					else {
						$(".loading").hide();
					}
				}
            </script> 
      </div>
    </div>
  </div>
  <div class="clearfix"></div>
</div>

<!--底部区-->
<div class="clearfix"></div>
<div class="sys-bottom">版权所有：西安科技大学  &nbsp;&nbsp;&nbsp; 联系电话：4006-722-712&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>

<!--JS 菜单联动-->
<script language="javascript">
		
$(document).ready(function(e) {
	tick();
    $('.ulnav li').each(function(index, element) {
		$(this).click(function(){
			$('.ulnav li').each(function(index, element) {
            	$(this).find('dd').css('display','none');
        	});
			$(this).find('dd').css('display','block');
		});
		$(this).find('dd dl').click(function () {
                $(this).parent().parent().parent().find('li dd dl').css({ "background": "" });
                $(this).css({ "background": "url(../content/images/nav_bgon.fw.png)" });
                $(this).siblings('dl').css({ "background": "" });
            });
    });
});
    function showLocale(objD) {
        var str, colorhead, colorfoot;
        var yy = objD.getYear();
        if (yy < 1900) yy = yy + 1900;
        var MM = objD.getMonth() + 1;
        if (MM < 10) MM = '0' + MM;
        var dd = objD.getDate();
        if (dd < 10) dd = '0' + dd;
        var hh = objD.getHours();
        if (hh < 10) hh = '0' + hh;
        var mm = objD.getMinutes();
        if (mm < 10) mm = '0' + mm;
        var ss = objD.getSeconds();
        if (ss < 10) ss = '0' + ss;
        var ww = objD.getDay();
        if (ww == 0) colorhead = "";
        if (ww > 0 && ww < 6) colorhead = "";
        if (ww == 6) colorhead = "";
        if (ww == 0) ww = "星期日";
        if (ww == 1) ww = "星期一";
        if (ww == 2) ww = "星期二";
        if (ww == 3) ww = "星期三";
        if (ww == 4) ww = "星期四";
        if (ww == 5) ww = "星期五";
        if (ww == 6) ww = "星期六";
        colorfoot = ""
        	str = colorhead + yy + "年" + MM + "月" + dd + "日 " + hh + ":" + mm + ":" + ss + "  " + ww + colorfoot;
            return (str);
    }
        function tick() {
        var today;//'${timecha}'
        today = new Date();//2017/01/02 04:05:00
        var date2 = new Date('${timecha}');
        document.getElementById("localtime").innerHTML = showLocale(today);
        //document.getElementById("localtime1").innerHTML = showLocale1(date2,today);
        //window.setTimeout("tick()", 1000);
    }
        function showLocale1(objD,objD2) {
            var str, colorhead;
            //获取时差
            var ww=objD.getTime()-objD2.getTime();
            var ww1=parseInt(ww/1000/60/60);
            if (ww1 < 10) ww1 = '0' + ww1;
            
            var day = parseInt(parseInt(ww/1000/60/60)/24);
            
            ww1=(parseInt(ww/1000/60/60)-day*24);
            if (ww1 < 10) ww1 = '0' + ww1;
            
            //获取分差
            var mm =ww/1000/60/60-parseInt(ww/1000/60/60);;
            var mm1=parseInt(mm*60);
            if (mm1 < 10) {mm1 = '0' + mm1;}
			//获取秒差
            var ss=mm*60-parseInt(mm*60);
            ss=parseInt(ss*60);
            if (ss < 10) ss = '0' + ss;
            
            
            if((ww<0 || mm<0) && userInfomation!=guozichuID) {
              //将部分账号关闭
              top.location.href="../userManageController/toplUpdateUser.do?state=1";
             return ("");
            }else{
            	if((ww<0 || mm<0) && userInfomation==guozichuID) {
            		str = colorhead +"00时00分00秒";
            	}else{
            		str = colorhead +day+"天"+ww1+"时"+ mm1 + "分" + ss + "秒";
           	}
                return (str);
            }
        }
</script>

</body>
</html>
