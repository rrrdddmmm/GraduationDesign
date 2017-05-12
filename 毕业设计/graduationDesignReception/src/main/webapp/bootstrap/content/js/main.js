
var winopen = true;
$(document).ready(function () {
    setWin();
    $(".sys-content-right").hide();
    $(".sys-content-right").first().show();
});
function setWin() {
    var $width = $(window).width();
    var $height = $(window).height();
    $(".sys-content-left").css("height", ($height - 50) + "px");
    $(".sys-content-right").css("height", ($height - 50) + "px");
}
$(window).resize(function() {
    setWin();
});
