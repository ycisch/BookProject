<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12 0012
  Time: 上午 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改我的信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/modifyPersonalInfo.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/modifyPersonal.js"></script>
</head>
<body>
<div class="modPersonalInfo">
    <div class="newPersonal">修改个人信息</div>
    <div class="newPersonal_from" name="newPersonal_from">
        <form action="${pageContext.request.contextPath}/UserServlet?opr=update" method="post">
        <p><strong>账户：</strong><input type="text" value="${sessionScope["user"].username}" name="username" id="username" disabled="disabled"></p>
        <p><strong>密码：</strong><input type="text" value="${sessionScope["user"].password}" name="password" id="password"></p>
        <p><strong>邮箱：</strong><input type="text" value="${sessionScope["user"].email}" name="email" id="email"></p>
        <p><strong>地址：</strong><input type="text" value="${sessionScope["user"].address}" name="address" id="address"></p>
        <p><strong>电话：</strong><input type="text" value="${sessionScope["user"].phone}" name="phone" id="phone"></p>
        <p>
            <a href="${pageContext.request.contextPath}/UserServlet?opr=update" ><input type="submit" name="modify" id="modify_button" value="确认修改"></a>
        </p>
        </form>
    </div>
</div>
</body>
</html>
