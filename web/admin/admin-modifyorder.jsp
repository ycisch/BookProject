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
    <title>Title</title>
</head>
<body>
<div class="modOrderInfo">
    <div class="newOrder">修改订单信息</div>
    <div class="newOrder_from" name="newOrder_from">
        <form action="${pageContext.request.contextPath}/UserServlet?opr=update" method="post">
            <p><strong>订单号：</strong><input type="text" value="${sessionScope["order"].orderid}" name="orderid" id="orderid" disabled="disabled"></p>
            <p><strong>图书编号：</strong><input type="text" value="${sessionScope["order"].bookid}" name="bookid" id="bookid"></p>
            <p><strong>图书数量：</strong><input type="text" value="${sessionScope["order"].booknum}" name="booknum" id="booknum"></p>
            <p><strong>消费金额：</strong><input type="text" value="${sessionScope["order"].money}" name="money" id="money"></p>
            <p><strong>买家ID：</strong><input type="text" value="${sessionScope["order"].userid}" name="userid" id="userid" disabled="disabled"></p>
            <p><strong>购买日期：</strong><input type="text" value="${sessionScope["order"].ctdate}" name="ctdate" id="ctdate"></p>
            <p><strong>地址：</strong><input type="text" value="${sessionScope["order"].address}" name="address" id="address"></p>
            <p>
                <a href="${pageContext.request.contextPath}/UserServlet?opr=update" ><input type="submit" name="modify" id="modify_button" value="确认修改"></a>
            </p>
        </form>
    </div>
</div>
</body>
</html>
