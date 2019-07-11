$(document).ready(function(){
    $("#admin").mouseover(function () {
        $("#admin ul").css({"display":"block"});
    });
    $("#admin").mouseout(function () {
        $("#admin ul").css({"display":"none"});
    });
});
