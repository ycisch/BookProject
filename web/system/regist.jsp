<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/11
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册-华轩书海商城</title>
    <link rel="stylesheet" href="../static/css/regist.css">
</head>
<body>
<div id="header">
    <p>
        <em>四川省成都市</em>
        <span>-----华轩书海商城</span>
    </p>
</div>
<div id="main">
    <div id="regist">
        <div id="regist_main">
            <div id="regist_header">注册</div>
            <div id="regist_form">
                <p>账号：<input type="text" name="username" id="username"></p>
                <p>密码：<input type="password" name="password" id="password"></p>
                <p>邮箱：<input type="text" name="email" id="email"></p>
                <p>地址：<input type="text" name="address" id="address"></p>
                <p>电话：<input type="text" name="phone" id="phone"></p>
                <p>
                    <input type="submit" name="regist" id="regist_button" value="注           册"/>
                </p>
            </div>
        </div>

        <div id="regist_footer">
            <a href="login.html" id="skip_login">已有账号？登录</a>
        </div>
    </div>
</div>
</body>
</html>
