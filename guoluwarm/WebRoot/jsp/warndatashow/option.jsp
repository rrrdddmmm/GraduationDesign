<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="../../js/yanzheng.js"></script>
<style type=text/css>
.tagContent {
	DISPLAY: none;
	BACKGROUND: url(bg.gif) repeat-x;
	WIDTH: 865px;
	COLOR: #474747;
	HEIGHT: 350px;
	padding: 10px;
}
#tagContent DIV.selectTag { DISPLAY: block }
#select{
	padding:30px 10px;
	width:150px;
	float:left;}
.chart{
	margin:10px 0px;
	width:400px;
	height:200px;
	float:left;
}
body,td,th {
	color: #933;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
 <div id=tagContent>
    <div class="tagContent selectTag" id=tagContent1>
      <div id="select">
<form action="../../WarmAndEvaluateController" target="rightFrame" method="post">
        <table width="200">
          <tr>
            <td height="39"><label>
              <c:if test="${barcharselect.radio=='safety'}" var="aa" scope="session">
              	<input type="radio" name="radio" value="safety" id="est" checked="checked" onclick="kk();"/>
              </c:if>
              <c:if test="${barcharselect.radio!='safety'}" var="aa" scope="session">
              	<input type="radio" name="radio" value="safety" id="est" onclick="kk();"/>
              </c:if>  
              安全性评价</label></td>
          </tr>
          
          <tr>
            <td height="39"><label>
              <c:if test="${barcharselect.radio=='component'}" var="aa" scope="session">
              <input  type="radio" name="radio" value="component"  id="est"  checked="checked" onclick="kk1();"/>
              </c:if>
              <c:if test="${barcharselect.radio!='component'}" var="aa" scope="session">
              <input  type="radio" name="radio" value="component"  id="est" onclick="kk1();"/>
              </c:if>
              部件故障比评价</label></td>
          </tr>
          
          <tr>
            <td height="41"><label>
              <c:if test="${barcharselect.radio=='pivotal'}" var="aa" scope="session">
              <input type="radio" name="radio" value="pivotal" id="est" checked="checked" onclick="kk1();"/>
              </c:if>
              <c:if test="${barcharselect.radio!='pivotal'}" var="aa" scope="session">
              <input type="radio" name="radio" value="pivotal" id="est"  onclick="kk1();"/>
              </c:if>
              关键重要度评价</label>
            </td>
          </tr>
          
          <tr>
            <td height="37"><label>
     		  <c:if test="${barcharselect.radio=='economy'}" var="aa" scope="session">
              <input type="radio" name="radio" value="economy" id="est" checked="checked" onclick="kk();"/>
              </c:if>
              <c:if test="${barcharselect.radio!='economy'}" var="aa" scope="session">
              <input type="radio" name="radio" value="economy" id="est" onclick="kk();"/>
              </c:if>         
              经济性评价</label>
            </td>
           </tr>
		<tr>
			<td height="37">
			<label>年份：<select style="width:50px" name="year" id="year" size="1">
				  <c:if test="${barcharselect.year=='2015'}" var="aa" scope="session"> 
				  <option value="2015" selected="selected">2015</option>
				  <option value="2014">2014</option>
				  <option value="2013">2013</option>
				  </c:if>
				  <c:if test="${barcharselect.year=='2014'}" var="aa" scope="session"> 
				  <option value="2015">2015</option>
				  <option value="2014" selected="selected">2014</option>
				  <option value="2013">2013</option>
				  </c:if>
				  <c:if test="${barcharselect.year=='2013'}" var="aa" scope="session"> 
				  <option value="2015">2015</option>
				  <option value="2014">2014</option>
				  <option value="2013" selected="selected">2013</option>
				  </c:if> 
			  </select></label>
			</td>
		</tr> 
	  <!-- 默认隐藏style="display:none;" -->
	  <tr style=${barcharselect.style } id="tt">
		<td height="37">
		<label>月份：<select style="width:50px;" name="month" id="month" size="1"> 
		    <c:if test="${barcharselect.month=='1'}" var="aa" scope="session"> 
		    <option value="1" selected="selected">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='2'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2" selected="selected">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='3'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3" selected="selected">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='4'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4" selected="selected">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='5'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5" selected="selected">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='6'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6" selected="selected">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='7'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7" selected="selected">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='8'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8" selected="selected">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='9'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9" selected="selected">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='10'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10" selected="selected">10</option>
		    <option value="11">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='11'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11"  selected="selected">11</option><option value="12">12</option>
		    </c:if>
		    <c:if test="${barcharselect.month=='12'}" var="aa" scope="session"> 
		    <option value="1">1</option><option value="2">2</option>
		    <option value="3">3</option><option value="4">4</option>
		    <option value="5">5</option><option value="6">6</option>
		    <option value="7">7</option><option value="8">8</option>
		    <option value="9">9</option><option value="10">10</option>
		    <option value="11">11</option><option value="12"  selected="selected">12</option>
		    </c:if>
	    </select></label>
	    </td>
	  </tr>

		<tr>
		   <td height="37"> 
		   <label>编号：<select style="width:50px;" name="num" id="num" size="1">
		  <c:if test="${barcharselect.mun=='1'}" var="aa" scope="session"> 
		  	<option value="1" selected="selected">1</option>
		  	<option value="2">2</option>
		   	<option value="3">3</option>
		  </c:if>
		  <c:if test="${barcharselect.mun=='2'}" var="aa" scope="session">   	
		   	<option value="1">1</option>
		  	<option value="2" selected="selected">2</option>
		   	<option value="3">3</option>
		  </c:if>
		  <c:if test="${barcharselect.mun=='3'}" var="aa" scope="session"> 
		   	<option value="1">1</option>
		  	<option value="2">2</option>
		   	<option value="3" selected="selected">3</option>
		  </c:if>
		   </select></label>
		   </td>
	   </tr>

		<tr>
			<td>
		       <input type="submit" name="" value="查询" style="width:100px" /><!--onclick="save();"  -->
			</td>
		</tr>
		
     </table>
</form>
    </div>
    <div class="chart"><iframe src="bar-chars.jsp" width="700" height="350"   frameborder="0"></iframe></div>
    </div>
</div>
</body>
</html>
