<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12 0012
  Time: 下午 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
            <th>图片</th>
            <th>图书编号</th>
            <th>图书数量</th>
            <th>消费金额</th>
            <th>买家姓名</th>
            <th>购买日期</th>
            <th>地址</th>
        </tr>
        <c:forEach items="${orderlist}" var="orderlist">
            <tr>
                <td>${orderlist.orderId}</td>
                <td><img src="${pageContext.request.contextPath}${orderlist.book.bookimg}"></td>
                <td>${orderlist.bookId}</td>
                <td>${orderlist.booknum}</td>
                <td>${orderlist.money}</td>
                <td>${orderlist.user.username}</td>
                <td>${orderlist.ctdate}</td>
                <td>${orderlist.user.address}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
