var num = 0;
var f = 0;


$(function () {

    var time1 = function(){
        if(num >= 4){
            num = -1;
            f = 4;
        }
        num++;
        var text = "../static/img/11("+(num+1)+").jpg";
        $(".menu").css({"background-image":"url('"+text+"')"});
        $(".select-tb ul a:eq("+f+")").css({"background":"#aaaaaa"});
        $(".select-tb ul a:eq("+num+")").css({"background":"orange"});

        f = num;
    };

    var timer=null;
    //定时器  尝试
    function autoplay(){
        timer = setInterval(time1,1500);
    }

    autoplay();

    //当鼠标移动到图像上是显示左右标签
    $(".menu").mousemove(function () {

        $(".left-jt").show();
        $(".right-jt").show();
    });

    $(".menu").hover(function () {
        clearInterval(timer);
    },function(){
        timer = setInterval(time1,1000);
    });

    //当鼠标移出去的时候，就不显示左右标签
    $(".menu").mouseleave(function () {
        $(".left-jt").hide();
        $(".right-jt").hide();
    })
    $(".menu").mouseleave = autoplay;

    //当鼠标点击左标的时候
    $(".left-jt").click(function () {
        //console.log(num);
        if(num <= 0){
            alert("当前已经是第一页");
        }
        else{
            num--;
            var x = num+1;
            var text = "../static/img/11("+x+").jpg";
            //console.log(num+" @@####  "+f);
            $(".menu").css({"background-image":"url('"+text+"')"});
            $(".select-tb ul a:eq("+f+")").css({"background":"#aaaaaa"});
            $(".select-tb ul a:eq("+num+")").css({"background":"orange"});
            f = num;
        }
    })

    //当鼠标点击右标的时候
    $(".right-jt").click(function () {
        if(num >= 4){
            alert("当前已经是最后一页");
        }
        else{
            num++;
            var x = num+1;
            var text = "../static/img/11("+x+").jpg";
            //console.log(num+" @@  "+f);
            $(".menu").css({"background-image":"url('"+text+"')"});
            $(".select-tb ul a:eq("+f+")").css({"background":"#aaaaaa"});
            $(".select-tb ul a:eq("+num+")").css({"background":"orange"});
            f = num;
        }
    })

    //当下边的选项框点击的时候
    $(".select-tb ul a").click(function () {
        var num1 = $(this).attr("text");
        var num2 = parseInt(num1) - 1;
        num = num2;
        //console.log(f+"    "+num);
        $(".select-tb ul a:eq("+f+")").css({"background":"#aaaaaa"});
        $(".select-tb ul a:eq("+num+")").css({"background":"orange"});
        var text = "../static/img/11("+(num+1)+").jpg";
        //console.log(num+" @@####  "+f);
        $(".menu").css({"background-image":"url('"+text+"')"});
        f = num;
    })


})