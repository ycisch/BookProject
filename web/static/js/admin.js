$(document).ready(function(){
    $("#admin").mouseover(function () {
        $("#admin ul").css({"display":"block"});
    });
    $("#admin").mouseout(function () {
        $("#admin ul").css({"display":"none"});
    });


    $("#userList").click(function () {
        /* $("#books").css({"display":"none"}); */
        $("#users").css({"display":"block"});
        $("#users").siblings().css({"display":"none"});
        $("#display h1").html("用户列表");
    });

    $("#onlineList").click(function () {
        $("#onlines").css({"display":"block"});
        $("#onlines").siblings().css({"display":"none"});
        $("#display h1").html("在线用户");
    });

    $("#bookList").click(function () {
        $("#books").css({"display":"block"});
        $("#books").siblings().css({"display":"none"});
        $("#display h1").html("图书列表");
    });

    $("#insertBook").click(function () {
        $("#inserts").css({"display":"block"});
        $("#inserts").siblings().css({"display":"none"});
        $("#display h1").html("添加图书");
    });



});
