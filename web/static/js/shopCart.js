var sum = 0;
function close_plan(){
    window.close()
}
function collection() {
    var flag = confirm("您将此商品移入收藏？");
    if (flag == true) {
        alert("移入成功！")
    }
}
function del1(id){
    var delNode=id.parentNode.parentNode;
    delNode.parentNode.removeChild(delNode);
}
function minus(num){
    //var num = $(".list input:nth-of-type(3)[class='less']").index(this);
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)-1;
    if(count<1){
        alert("商品购买的数量最低为1，不能再少了！");
    } else{
        document.getElementsByName("amount")[num].value=count;
        var totals=parseFloat(prices*count).toFixed(2);
        document.getElementById("price"+num).innerHTML="¥" +totals;
        /*$(".list :checkbox").each(function () {
            if($(this).prop("checked")==true){
                var allmoney = document.getElementById("allPrice");
                sum= allmoney-prices;
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
            }else {
                var allmoney = document.getElementById("allPrice");
                sum=allmoney-totals;
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
            }
        });*/
        if($(".bookid").is(":checked")){
             sum-=prices;
            if (sum<=0){
                var err = 0;
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + err.toFixed(2);
            } else {
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + sum.toFixed(2);
            }
        }
    }
}
function plus(num){
    //var num = $(".add").index(this);
    //alert(num);
    console.log(num+"####")
    var prices=document.getElementsByName("price")[num].value;
    parseFloat(prices);
    var count=parseInt(document.getElementsByName("amount")[num].value)+1;
    document.getElementsByName("amount")[num].value=count;
    var totals=parseFloat(prices*count).toFixed(2);

    console.log(prices+"@@@@@"+totals);

    var totals1 = "¥" +totals;

    console.log(document.getElementById("price"+num));

    document.getElementById("price"+num).innerHTML=totals1;

    /*$(".list :checkbox").each(function () {
        if($(this).prop("checked")==true){
            var allmoney = document.getElementById("allPrice");
            sum= allmoney+prices;
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
        }else {
             allmoney = document.getElementById("allPrice");
            sum=allmoney-totals;
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
        }
    });*/
    if($(".bookid").is(":checked")){
        sum= parseFloat(sum)+parseFloat(prices);

        document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
    }
}
$(function () {
    document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
    //全选或全不选
    $("#all").click(function(){
        if(this.checked){
            $(".list :checkbox").prop("checked", true);
            var prices=document.getElementsByName("price");
            var count=document.getElementsByName("amount");
            sum = 0;
            for(var i=0; i<prices.length;i++){
                sum+=prices[i].value*count[i].value;
            }
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
        }else{
            $(".list :checkbox").prop("checked", false);
            sum=0;
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
        }
    });
    //设置每个复选框的操作

    $(".list input[type='checkbox']").click(function() {
        if (this.checked) {
            var num1 = $(".list input[type='checkbox']").index(this);
            var prices=document.getElementsByName("price")[num1].value;
            var count=document.getElementsByName("amount")[num1].value;
            sum = sum + (prices*count);
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + sum.toFixed(2);
        } else {
            var num1 = $(".list input[type='checkbox']").index(this);
            var prices=document.getElementsByName("price")[num1].value;
            var count=document.getElementsByName("amount")[num1].value;
            sum = sum - (prices*count);
            if (sum<=0){
                var err = 0;
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + err.toFixed(2);
            } else {
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + sum.toFixed(2);
            }
        }
    });
    //设置全选复选框
    $(".list :checkbox").click(function(){
        allchk();
    });
});
function allchk(){
    var chknum = $(".list :checkbox").length;//选项总个数
    var chk = 0;
    $(".list :checkbox").each(function () {
        if($(this).prop("checked")==true){
            chk++;
        }
    });
    if(chknum==chk){//全选
        $("#all").prop("checked",true);
    }else{//不全选
        $("#all").prop("checked",false);
    }
}

function showsum() {
    console.log(sum);
    sum = 0;
    console.log(sum+"asdasdadsd");
}
