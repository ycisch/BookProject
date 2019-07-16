<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/11
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员登录</title>
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet" >
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <script>

    </script>
</head>
<body>
<div id="header">
    <p>
        <a href="menu.jsp">
            <em>四川省成都市</em>
            <span>-----华轩书海商城</span>
        </a>
    </p>
</div>
<div id="main">
    <div id="login">
        <div id="login_main">
            <c:if test="${!empty message}">
            <script>
                alert("用户名或密码错误！");
            </script>
            </c:if>
            <div id="login_header">登录</div>
            <div id="login_form">
                <form action="${pageContext.request.contextPath}/AdminServlet?opr=login" method="post">
                    <p>账号：<span id="nameerror"></span></p>
                    <p><input type="text" name="adminname" id="username"></p>
                    <p>密码：<span id="pwderror"></span></p>
                    <p><input type="password" name="adminpwd" id="password"></p>
                    <p>
                        <input type="checkbox" name="save" class="login_save"/><span class="login_save">记住我！！！</span>
                        <input type="submit" name="login" id="login_button" value="登录"/>
                    </p>
                </form>
            </div>
        </div>

        <div id="login_footer">
            <a href="" id="forget">忘记密码？</a>
            <a href="regist.jsp" id="skip_regist">注册</a>
        </div>
    </div>
</div>
</body>
</html>

