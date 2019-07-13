$(function(){

    //显示全部商品分类
    // $(".top-footer-text").mousemove(function () {
    //     $(".top-footer-style").show();
    // })
    //
    //
    // $(".top-footer-text").mouseleave(function () {
    //     $(".top-footer-style").hide();
    // })

    //显示购物车信息
    var text;
    $(".top-info-2").mousemove(function () {
        text = $(".top-info-21").text();
        // console.log(text);
        var html1 = "购物车里没有东西哦！ Q=Q";
        if(text == "" || text == null){
            $(".top-info-21").html(html1);
        }
        // var div = $("<div class='class'>");
        $(".top-info-21").show();
    })

    $(".top-info-2").mouseleave(function () {
        if(text == "" || text == null) $(".top-info-21").html("");
        $(".top-info-21").hide();
    })


    //侧边栏信息
    $(".top-left").mousemove(function () {
        var index = $(".top-left").index(this);
        console.log(index);
        $(".top-footer-p").css({"background":""});
        $(".top-footer-p:eq("+index+")").css({"background":"#cccccc"});
        // $(".top-footer-style-dp:eq("+index+")").css({"background":"#cccccc"});
        $(".top-footer-style-dp:eq("+index+")").show();
        // $(".top-footer-style-dp").show();
    });


    $(".top-left").mouseleave(function () {
        $(".top-footer-p").css({"background":""});
        $(".top-footer-style-dp").hide();
    })

    //出现二维码
    $(".footer-ewm").mousemove(function(){
        $(".footer1").show();
    })
    $(".footer-ewm").mouseleave(function(){
        $(".footer1").hide();
    })


})