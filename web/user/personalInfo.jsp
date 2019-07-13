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
        <p><strong>账户：</strong><input type="text" name="username" id="username"></p>
        <p><strong>密码：</strong><input type="password" name="password" id="password"></p>
        <p><strong>邮箱：</strong><input type="text" name="email" id="email"></p>
        <p><strong>地址：</strong><input type="text" name="address" id="address"></p>
        <p><strong>电话：</strong><input type="text" name="phone" id="phone"></p>
        <p><strong>余额：</strong><input type="text" name="money" id="money"></p>
        <div class="button">
            <a href="../../admin/admin.jsp"><input type="submit" name="confirm" id="confirm_button" onclick="modify()" value="确认信息"></a>
            <a href="../modifyPersonalInfo.jsp"><input type="submit" name="modify" id="modify_button" onclick="modify()" value="修改信息"></a>
        </div>
    </div>
</div>
</body>
</html>
