$(function close_plan(){
    window.close()
});
function collection() {
    var flag = confirm("移入收藏后，将不再购物车显示！是否继续操作？");
    if (flag == true) {
        alert("移入成功！")
    }
}
function del(id){
    var delNode=id.parentNode.parentNode;
    delNode.parentNode.removeChild(delNode);
}
function minus(num){
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)-1;
    if(count<1){
        alert("商品购买的数量最低为1，不能再少了！");
    }
    else{
        document.getElementsByName("amount")[num].value=count;
        var totals=parseFloat(prices*count).toFixed(2);
        document.getElementById("price"+num).innerHTML="¥" +totals;
    }
}
function plus(num){
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)+1;
    document.getElementsByName("amount")[num].value=count;
    var totals=parseFloat(prices*count).toFixed(2);
    document.getElementById("price"+num).innerHTML="¥" +totals;
}
$(function () {
    //全选或全不选
    document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +0.00.toFixed(2);
    $("#all").click(function(){
        var sum = 0;
        if(this.checked){
            $(".list :checkbox").prop("checked", true);
            var prices=document.getElementsByName("price");
            var count=document.getElementsByName("amount");
            for(var i=0; i<prices.length;i++){
                sum+=prices[i].value*count[i].value;
            }
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
        }else{
            $(".list :checkbox").prop("checked", false);
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
        }
    });

    var sum = 0;

    //设置每个复选框的value
    $(".list :checkbox").click(function() {
        // var sum = 0;
        if (this.checked) {
            // var num = $("input[type='checkbox']:checked").length;
            // for ( var i = 0; i<num;i++){
            var num1 = $(".list :checkbox").index(this);
            var prices=document.getElementsByName("price")[num1];
            var count=document.getElementsByName("amount")[num1];
            sum += prices*count;
            // }
            document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + sum.toFixed(2);
        } else {
            var num1 = $(".list :checkbox").index(this);
            var prices=document.getElementsByName("price")[num1];
            var count=document.getElementsByName("amount")[num1];
                sum -= prices*count;
                document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML = "¥" + sum.toFixed(2);
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
