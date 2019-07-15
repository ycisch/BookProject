<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/14 0014
  Time: 下午 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/addMoney.css">
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/UserServlet?opr=add" method="post">
    <p> <strong>余额充值</strong></p>
    <p> 账户余额：<input type="text"  name="oldmoney"  id="oldmoney" value="${sessionScope["user"].money}" disabled="disabled">￥</p>
    <p> 充值金额：<input type="text" name="addmoney" id="addmoney">￥</p>
    <input type="submit" name="add" id="addmoney_button" value="充值">
</form>
</body>
</html>
