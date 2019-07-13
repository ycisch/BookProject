function close_plan() {
    window.close()
}
function collection() {
    var flag = confirm("移入收藏后，将不再购物车显示！是否继续操作？");
    if (flag == true) {
        alert("移入成功！")
    }
}
function del(id){
    var delNode=id.parentNode.parentNode;
    delNode.parentNode.removeChild(delNode);
    total();
}
function minus(num){
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)-1;
    if(count<1){
        alert("不能再减了，再减就没有啦！");
    }
    else{
        document.getElementsByName("amount")[num].value=count;
        var totals=parseFloat(prices*count).toFixed(2);
        document.getElementById("price"+num).innerHTML="¥" +totals;
    }
    total();
}
function plus(num){
    var prices=document.getElementsByName("price")[num].value;
    var count=parseInt(document.getElementsByName("amount")[num].value)+1;
    document.getElementsByName("amount")[num].value=count;
    var totals=parseFloat(prices*count).toFixed(2);
    document.getElementById("price"+num).innerHTML="¥" +totals;
    total();
}
function total(){
    var prices=document.getElementsByName("price");
    var count=document.getElementsByName("amount");
    var sum=0;
    for(var i=0; i<prices.length;i++){
        sum+=prices[i].value*count[i].value;
    }
    document.getElementById("allPrice").getElementsByTagName("span")[0].innerHTML="¥" +sum.toFixed(2);
}
total();