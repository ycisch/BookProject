<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12 0012
  Time: 下午 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/order.css">
</head>
<body>
<form class="order" >
    <table id="order" >
        <tr id="title">
            <th>订单号</th>
            <th>图书编号</th>
            <th>图书数量</th>
            <th>消费金额</th>
            <th>买家ID</th>
            <th>购买日期</th>
            <th>地址</th>
        </tr>
        <c:forEach var="list" items="orderList">
            <tr>
                <td>${list.orderid}</td>
                <td>${list.bookid}</td>
                <td>1${list.booknum}</td>
                <td>${list.money}</td>
                <td>${list.userid}</td>
                <td>${list.ctdate}</td>
                <td>${list.user.address}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
