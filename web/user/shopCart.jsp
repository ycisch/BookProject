<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12 0012
  Time: 上午 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>华轩书海购物车</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/shopcart.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>

    <%--  Ajax书写，用来对前台的加，减，删除，移入收藏，进行操作
            Q=Q.....
     --%>
    <script>
        $(function () {
            $(".less").click(function () {

                var num = $(".less").index(this);
                var bookid = $(".bookid:eq("+num+")").val();
                console.log(bookid+"@@@@");

                //传入id与删除类型，那么我们就可以删除了。
                $.ajax({
                    "url":"${pageContext.request.contextPath}/ShopServlet",
                    "type": "get",
                    "data": "opr=delete1&bookid="+bookid+"",
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    success:callback,
                });

                function callback() {
                    $(".price:eq("+num+")").attr('id',"price"+num);
                    minus(num);

                }
            })

            //点击添加之后要进行的Ajax操作
            $(".add").click(function () {
                var num = $(".add").index(this);
                var bookid = $(".bookid:eq("+num+")").val();



                console.log(bookid+"   "+num);


                //传入id与删除类型，那么我们就可以删除了。
                $.ajax({
                    "url":"${pageContext.request.contextPath}/ShopServlet",
                    "type": "get",
                    "data": "opr=add1&bookid="+bookid+"",
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    success:callback,
                });

                function callback() {
                    console.log("success");
                    $(".price:eq("+num+")").attr('id',"price"+num);
                    plus(num);

                }
            })

            //点击删除按钮对当前选中的id进行删除
            $(".del").click(function () {
                var num = $(".del").index(this);
                var bookid = $(".bookid:eq("+num+")").val();
                var shopid = $(".shopid:eq("+num+")").val();

                console.log(bookid+"@@@"+shopid+"@@@@"+num);

                //传入id与删除类型，那么我们就可以删除了。
                $.ajax({
                    "url":"${pageContext.request.contextPath}/ShopServlet",
                    "type": "get",
                    "data": "opr=delete&bookid="+bookid+"&shopid="+shopid,
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    success:callback(),
                });

                function callback() {
                    // var delNode=$(".del:eq("+num+")").parent().parent().parent();
                    // delNode.parentNode.removeChild(delNode);

                    $(".list:eq("+num+")").remove();
                    // delNode.parent().removeChild(delNode);
                    // console.log(delNode);

                }
            })

            //点击结算按钮之后要进行的Ajax操作
            $(".allcount").click(function () {
                //var num = $(".allcount").index(this);
                //var bookid = $(".bookid:eq("+num+")").val();

                var li = $(".bookid");
                var ids = new Array();
                var ids1 = new Array();
                var k  = 0,j = 0;
                console.log(li);

                for(var i = 0; i < li.length; i++){
                    var value = $(".bookid:eq("+i+"):checked").val();
                    if(value != null){
                        ids[k++] = value;
                        ids1[j++] = i;
                    }
                };

                var prek = 0;

                for(var i = 0; i < ids1.length; i++){
                    console.log(ids1[i]);

                    $(".list:eq("+(ids1[i]-prek)+")").remove();
                    prek++;
                }
                console.log(ids);

                //将所有的id保存起来就可以传送到后台了
                //传入id与删除类型，那么我们就可以删除了。
                $.ajax({
                    "url":"${pageContext.request.contextPath}/ShopServlet",
                    "type": "get",
                    "data": "opr=sum&ids="+ids,
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    success:callback,
                });

                function callback() {
                    $(".show_allprice").text("￥0.00");
                    showsum();
                }

            })


        })
    </script>
</head>
<body>
    <div class="shop">
    <div class="title"><h1>购物车</h1><span onclick="close_plan()">关闭</span></div>
    <div class="cartList">
        <ul >
            <li id="first">
                <input type="checkbox" id="all"  name="allbookid" class="allbookid">全选
            </li>
            <li>商品图片</li>
            <li>商品信息</li>
            <li>单价</li>
            <li>数量</li>
            <li>总价</li>
            <li>操作</li>
        </ul>
        <div class="box">

            <c:forEach items="${requestScope.list}" var="shoplist">
            <div class="list">
                <ul>
                    <li>
                        <input type="checkbox" name="bookid" class="bookid" value="${shoplist.book.bookid}">
                        <input type="hidden" name="shopid" class="shopid" value="${shoplist.shopId}">
                    </li>
                    <li><img src="${pageContext.request.contextPath}${shoplist.book.bookimg}"></li>
                    <li>${shoplist.book.bookName}</li>
                    <li>￥<input type="text" name="price" value="${shoplist.book.bookMoney}"></li>
                    <li><input type="button" name="minus" class="less" value="-" >
                        <input type="text" name="amount" value="${shoplist.num}">
                        <input type="button" name="plus" class="add" value="+">
                    </li>
                    <li id="price0" class="price">￥<c:out value="${shoplist.book.bookAuthor}"></c:out></li>
                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" >删除</p></li>
                </ul>
            </div>
            </c:forEach>

<%--            <div class="list">--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <input type="checkbox" name="bookid" class="bookid" value="1">--%>
<%--                    </li>--%>
<%--                    <li><img src="${pageContext.request.contextPath}/static/img/book/2.jpg"></li>--%>
<%--                    <li>北京女子</li>--%>
<%--                    <li>￥<input type="text" name="price" value="21.90"></li>--%>
<%--                    <li><input type="button" name="minus" class="less" value="-" onclick="minus(0);"><input type="text" name="amount" value="1"><input type="button" name="plus" class="add" value="+" onclick="plus(0);"></li>--%>
<%--                    <li id="price0">￥21.90</li>--%>
<%--                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" onclick="del(this);">删除</p></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="list">--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <input type="checkbox" name="bookid" class="bookid" value="2">--%>
<%--                    </li>--%>
<%--                    <li><img src="${pageContext.request.contextPath}/static/img/book/4.jpg"></li>--%>
<%--                    <li>自在成长</li>--%>
<%--                    <li>￥<input type="text" name="price" value="49.99"></li>--%>
<%--                    <li><input type="button" name="minus" class="less" value="-" onclick="minus(1);"><input type="text" name="amount" value="1"><input type="button" name="plus" class="add" value="+" onclick="plus(1);"></li>--%>
<%--                    <li id="price1">￥49.99</li>--%>
<%--                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" onclick="del(this);">删除</p></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="list">--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <input type="checkbox" name="bookid" class="bookid" value="3">--%>
<%--                    </li>--%>
<%--                    <li><img src="${pageContext.request.contextPath}/static/img/book/2.jpg"></li>--%>
<%--                    <li>北京女子</li>--%>
<%--                    <li>￥<input type="text" name="price" value="21.90"></li>--%>
<%--                    <li><input type="button" name="minus" class="less" value="-" onclick="minus(2);"><input type="text" name="amount" value="1"><input type="button" name="plus" class="add" value="+" onclick="plus(2);"></li>--%>
<%--                    <li id="price2">￥21.90</li>--%>
<%--                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" onclick="del(this);">删除</p></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="list">--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <input type="checkbox" name="bookid" class="bookid" value="4">--%>
<%--                    </li>--%>
<%--                    <li><img src="${pageContext.request.contextPath}/static/img/book/4.jpg"></li>--%>
<%--                    <li>自在成长</li>--%>
<%--                    <li>￥<input type="text" name="price" value="49.99"></li>--%>
<%--                    <li><input type="button" name="minus" class="less" value="-" onclick="minus(3);"><input type="text" name="amount" value="1"><input type="button" name="plus" class="add" value="+" onclick="plus(3);"></li>--%>
<%--                    <li id="price3">￥49.99</li>--%>
<%--                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" onclick="del(this);">删除</p></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="list">--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <input type="checkbox" name="bookid" class="bookid" value="5">--%>
<%--                    </li>--%>
<%--                    <li><img src="${pageContext.request.contextPath}/static/img/book/2.jpg"></li>--%>
<%--                    <li>北京女子</li>--%>
<%--                    <li>￥<input type="text" name="price" value="21.90"></li>--%>
<%--                    <li><input type="button" name="minus" class="less" value="-" onclick="minus(4);"><input type="text" name="amount" value="1"><input type="button" name="plus" class="add" value="+" onclick="plus(4);"></li>--%>
<%--                    <li id="price4">￥21.90</li>--%>
<%--                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" onclick="del(this);">删除</p></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
<%--            <div class="list">--%>
<%--                <ul>--%>
<%--                    <li>--%>
<%--                        <input type="checkbox" name="bookid" class="bookid">--%>
<%--                    </li>--%>
<%--                    <li><img src="${pageContext.request.contextPath}/static/img/book/4.jpg"></li>--%>
<%--                    <li>自在成长</li>--%>
<%--                    <li>￥<input type="text" name="price" value="49.99"></li>--%>
<%--                    <li><input type="button" class="less" name="minus"  value="-" onclick="minus(5);"><input type="text" name="amount" value="1"><input type="button" class="add" name="plus" value="+" onclick="plus(5);"></li>--%>
<%--                    <li id="price5">￥49.99</li>--%>
<%--                    <li><p class="collection" onclick="collection();">移入收藏</p><p class="del" onclick="del(this);">删除</p></li>--%>
<%--                </ul>--%>
<%--            </div>--%>
            <ol>
                <li id="allPrice">商品总计:<span class="show_allprice"></span></li>
                <li><span class="allcount" >结算</span></li>
            </ol>
        </div>
    </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/shopCart.js"></script>
</body>
</html>
