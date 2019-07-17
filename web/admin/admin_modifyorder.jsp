<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/16 0016
  Time: 下午 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-华轩书海商城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
    <script>
        $(function () {
            var num = ${page.currPageNo};
            if (num == 1){
                $("#hasPrev").hide();
                $("#hasNext").show();
            }else if(num == ${page.totalPageCout}){
                $("#hasPrev").show();
                $("#hasNext").hide();
            }
            $(".btn").click(function () {
                console.log("@@@@");
                var formData = new FormData(document.getElementById("tf"));
                // var file = $(".file1")[0].files[0];
                // formData.append("nfile",file);
                // console.log(formData);

                $.ajax({
                    "url":"../BookServlet",
                    "type": "post",
                    "data": formData,
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    "success":callback
                });

                function callback(data) {
                    console.log(data+"@@@@");
                    $(".img1").show();
                    $(".img1").css({"background":"url("+data+")"});
                    alert(data);
                    $("#img_data").val(data);
                }
            })
        })
    </script>

    <style>
        .img1{
            display: none;
            width: 150px;
            height: 150px;
        }

    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/modifyOrderInfo.css">
</head>
<body>
<div id="header">
    <em>四川省成都市</em>
    <span>-----华轩书海商城</span>
    <div id="admin">
        <span>欢迎您：${admin.adminName}</span>
        <i id="down"></i>
        <!-- <i id="mark"></i> -->
        <ul>
            <li>
                <a href="#">
                    <i id="home"></i>
                    个人信息
                </a>
            </li>
            <li>
                <a href="#">
                    <i id="exit"></i>
                    注销
                </a>
            </li>
        </ul>
    </div>
</div>
<div id="main">
    <div id="navigation">
        <dl>
            <dt>返回首页</dt>
            <dd><span id="select">返回首页</span></dd>

            <hr/>

            <!--            <dt>我的购物车</dt>
                        <dd><a href="">购物车</a></dd>
                        <dd><a href="">我的订单</a></dd>

                        <hr/> -->

            <dt>用户管理</dt>
            <dd><a href="${pageContext.request.contextPath}/AdminServlet?opr=list&currPageNo=1"><span id="userList">用户列表</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/OrderServlet?opr=showAllusersorder"><span id="onlineList">用户订单</span></a></dd>

            <hr/>

            <dt>图书管理</dt>
            <dd><a href="${pageContext.request.contextPath}/BookServlet?opr=list&page=1"><span id="bookList">查询图书</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_insert.jsp"><span id="insertBook">添加图书</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_insertstyle.jsp"><span id="insertStyle">添加分类</span></a></dd>
        </dl>
    </div>
    <div class="modOrderInfo">
        <div class="newOrder">修改订单信息</div>
        <div class="newOrder_from" name="newOrder_from">
            <form action="${pageContext.request.contextPath}/OrderServlet?opr=updateorder" method="post">
                <p><strong>订单号：</strong><input type="text" value="${requestScope.orderup.orderId}" name="orderid" id="orderid"></p>
                <p><strong>图书编号：</strong><input type="text" value="${requestScope.orderup.bookId}" name="bookid" id="bookid"></p>
                <p><strong>图书数量：</strong><input type="text" value="${requestScope.orderup.booknum}" name="booknum" id="booknum"></p>
                <p><strong>消费金额：</strong><input type="text" value="${requestScope.orderup.money}" name="money" id="money"></p>
                <p><strong>买家ID：</strong><input type="text" value="${requestScope.orderup.userId}" name="userid" id="userid"></p>
                <p><strong>购买日期：</strong><input type="text" value="${requestScope.orderup.ctdate}" name="ctdate" id="ctdate"></p>
                <p><strong>地址：</strong><input type="text" value="${requestScope.orderup.user.address}" name="address" id="address"></p>
                <p>
                    <input type="submit" name="modify" id="modify_button" value="确认修改">
                </p>
            </form>
        </div>
    </div>
    <div id="copyright">
        &copy;2019 Test 版权所有   203搞事大队
    </div>
</div>
</body>
</html>


<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="modOrderInfo">--%>
<%--    <div class="newOrder">修改订单信息</div>--%>
<%--    <div class="newOrder_from" name="newOrder_from">--%>
<%--        <form action="${pageContext.request.contextPath}/UserServlet?opr=update" method="post">--%>
<%--            <p><strong>订单号：</strong><input type="text" value="${requestScope.orderup.orderId}" name="orderid" id="orderid" disabled="disabled"></p>--%>
<%--            <p><strong>图书编号：</strong><input type="text" value="${requestScope.orderup.bookId}" name="bookid" id="bookid"></p>--%>
<%--            <p><strong>图书数量：</strong><input type="text" value="${requestScope.orderup.booknum}" name="booknum" id="booknum"></p>--%>
<%--            <p><strong>消费金额：</strong><input type="text" value="${requestScope.orderup.money}" name="money" id="money"></p>--%>
<%--            <p><strong>买家ID：</strong><input type="text" value="${requestScope.orderup.userId}" name="userid" id="userid" disabled="disabled"></p>--%>
<%--            <p><strong>购买日期：</strong><input type="text" value="${requestScope.orderup.ctdate}" name="ctdate" id="ctdate"></p>--%>
<%--            <p><strong>地址：</strong><input type="text" value="${requestScope.orderup.user.address}" name="address" id="address"></p>--%>
<%--            <p>--%>
<%--                <input type="submit" name="modify" id="modify_button" value="确认修改">--%>
<%--            </p>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
