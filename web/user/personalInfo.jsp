<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11 0011
  Time: 下午 5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的华轩信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/personaInfo.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<div class="perinfo">
    <div class="personal">个人信息</div>
    <div class="personal_from" name="personal_form">
        <p><strong>账户：</strong><input type="text" value="${requestScope["user"].username}" name="username" id="username" disabled="disabled" ></p>
        <p><strong>密码：</strong><input type="text" value="${requestScope["user"].password}" name="password" id="password" disabled="disabled" ></p>
        <p><strong>邮箱：</strong><input type="text" value="${requestScope["user"].email}" name="email" id="email" disabled="disabled" ></p>
        <p><strong>地址：</strong><input type="text" value="${requestScope["user"].address}" name="address" id="address" disabled="disabled" ></p>
        <p><strong>电话：</strong><input type="text" value="${requestScope["user"].phone}" name="phone" id="phone" disabled="disabled" ></p>
        <p><strong>余额：</strong><input type="text" value="${requestScope["user"].money}" name="money" id="money" disabled="disabled" ></p>
        <div class="button">
            <a href="${pageContext.request.contextPath}/user/addMoney.jsp"><input type="button" name="addmoney" id="addmoney_button"  value="余额充值"></a>
            <a href="${pageContext.request.contextPath}/user/modifyPersonalInfo.jsp"><input type="submit" name="modify" id="modify_button"  value="修改信息"></a>
        </div>
    </div>
</div>
</body>
</html>