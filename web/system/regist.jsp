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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/regist.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            var usernameOk = false;
            var passwordOk = false;
            var emailOk = false;
            var addressOk = false;
            var phoneOk = false;

            $("#username").focus(function () {
               $("#usernameError").html("");
            });
            $("#username").blur(function () {
                var username = $("#username").val();

                if (username == null || username == ""){
                    $("#usernameError").html("用户名为空");
                    return false;
                }
                $.ajax({
                    url:"../UserServlet",
                    data:"opr=exist&username="+username,
                    type:"get",
                    dataType:"text",
                    success:callBack,
                });
                function callBack(data) {
                    if (data == "true")
                    $("#usernameError").html("用户名不可用");
                    else {
                        usernameOk = true;
                        $("#usernameSuccess").html("用户名可以使用");
                    }
                }
            });
            $("#password").blur(function () {
                var password = $("#password").val();
                if (password == null || password == ""){
                    $("#passwordError").html("密码为空");
                } else if (password.length < 3){
                    $("#passwordError").html("密码长度小于3");
                }else{
                    passwordOk = true;
                    $("#passwordSuccess").html("密码可用");
                }
            });
            $("#email").blur(function () {
                var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                var email = $("#email").val();
                if (email == null || email == ""){
                    $("#emailError").html("邮箱为空");
                } else if (!reg.test(email)){
                    $("#emailError").html("邮箱格式不对");
                }else {
                    emailOk = true;
                    $("#emailSuccess").html("邮箱可用");
                }
            });
            $("#address").blur(function () {
                var address = $("#address").val();
                if (address == null || address == ""){
                    $("#addressError").html("地址为空");
                }else {
                    addressOk = true;
                    $("#addressSuccess").html("地址可用");
                }
            });
            $("#phone").blur(function () {
                var phone = $("#phone").val();
                var reg =  /^1[34578]\d{9}$/;
                if (phone == null || phone == ""){
                    $("#phoneError").html("手机号为空");
                } else if (!reg.test(phone)){
                    $("#phoneError").html("手机号格式不对");
                }else {
                    phoneOk = true;
                    $("#phoneSuccess").html("手机号可用");
                }
            });
            $("#regist_button").click(function () {
                if (usernameOk && passwordOk && emailOk && addressOk && phoneOk) {
                    $("#regist_button").submit();
                }else {
                    return false;
                }
            })
        });
    </script>
    <style>
        #usernameError{
            font-size: 14px;
            color: red;
        }
        #passwordError{
            font-size: 14px;
            color: red;
        }
        #emailError{
             font-size: 14px;
             color: red;
         }
        #addressError{
            font-size: 14px;
            color: red;
        }
        #phoneError{
            font-size: 14px;
            color: red;
        }
        #usernameSuccess{
            font-size: 14px;
            color: green;
        }
        #passwordSuccess{
            font-size: 14px;
            color: green;
        }
        #emailSuccess{
            font-size: 14px;
            color: green;
        }
        #addressSuccess{
            font-size: 14px;
            color: green;
        }
        #phoneSuccess{
            font-size: 14px;
            color: green;
        }
    </style>
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
    <div id="regist">
        <div id="regist_main">
            <div id="regist_header">注册</div>
            <div id="regist_form">
                <form action="${pageContext.request.contextPath}/UserServlet?opr=regist" method="post">
                    <p>账号：<input type="text" name="username" id="username">
                        <span id="usernameError"></span><span id="usernameSuccess"></span></p>
                    <p>密码：<input type="password" name="password" id="password">
                        <span id="passwordError"></span><span id="passwordSuccess"></span></p>
                    <p>邮箱：<input type="text" name="email" id="email">
                        <span id="emailError"></span><span id="emailSuccess"></span></p>
                    <p>地址：<input type="text" name="address" id="address">
                        <span id="addressError"></span><span id="addressSuccess"></span></p>
                    <p>电话：<input type="text" name="phone" id="phone">
                        <span id="phoneError"></span><span id="phoneSuccess"></span></p>
                    <p>
                        <input type="submit" name="regist" id="regist_button" value="注           册"/>
                    </p>
                </form>
            </div>
        </div>

        <div id="regist_footer">
            <a href="login.jsp" id="skip_login">已有账号？登录</a>
        </div>
    </div>
</div>
</body>
</html>
