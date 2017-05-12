// JavaScript Document
$(document).ready(function(e) {
	//--------js代码开始---------------
   $('.selectbar').click(function(){
	   var arrtid = $(this).attr('data-id');
	   if($('.selectlist').length&&$('.selectlist').length>0) $('.selectlist').remove();
	   $('body').append('<ul class="selectlist"><li><input name="" type="checkbox" value="1" /> 差旅费</li><li><input name="" type="checkbox" value="2" /> 接待费</li></ul>');
	   var top = $(this).position().top + $(this).height()+4;
	   var left = $(this).position().left;
	   $('.selectlist').css({'top':top+'px','left':left+'px'});
	   $('.selectlist').mouseleave(function(){$('.selectlist').remove();});
	});
	//---------js代码结束--------------
});