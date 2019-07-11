<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/11
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理-华轩书海商城</title>
    <link rel="stylesheet" href="../static/css/admin.css">
    <script src="../static/js/jquery-1.11.3.min.js"></script>
    <script src="../static/js/admin.js"></script>
    <!--<script>
        $(document).ready(function(){
            $("#admin").mouseover(function () {
                $("#admin ul").css({"display":"block"});
            });
            $("#admin").mouseout(function () {
                $("#admin ul").css({"display":"none"});
            });
        });
    </script>-->
</head>
<body>

<div id="header">
    <em>四川省成都市</em>
    <span>-----华轩书海商城</span>
    <div id="admin">
        <span>欢迎您：admin</span>
        <i id="down"></i>
        <!-- <i id="mark"></i> -->
        <ul>
            <li>
                <a href="#">
                    <i id="home"></i>
                    个人信息
                </a>
            </li>
            <li>
                <a href="#">
                    <i id="exit"></i>
                    注销
                </a>
            </li>
        </ul>
    </div>
</div>
<div id="main">
    <div id="navigation">
        <dl>
            <dt>返回首页</dt>
            <dd><a href="">返回首页</a></dd>

            <hr/>

            <dt>我的购物车</dt>
            <dd><a href="">购物车</a></dd>
            <dd><a href="">我的订单</a></dd>

            <hr/>

            <dt>用户管理</dt>
            <dd><a href="">用户列表</a></dd>
            <dd><a href="">在线用户</a></dd>

            <hr/>

            <dt>图书管理</dt>
            <dd><a href="">查询图书</a></dd>
            <dd><a href="">添加图书</a></dd>
        </dl>
    </div>
    <div id="display">
        <h1>图书列表</h1>
        <div id="books">展示图书</div>
        <div id="sikp">
            <p>
                <a href="#"><span>首页</span></a>
                &nbsp;|&nbsp;
                <a href="#"><span>下一页</span></a>
                &nbsp;|&nbsp;
                <a href="#"><span>尾页</span></a>
                &nbsp;|&nbsp;
                <a></a><span>当前第页</span>
                &nbsp;|&nbsp;
                <a></a><span>总共页</span>
            </p>
        </div>
    </div>
    <div id="copyright">
        &copy;
    </div>
</div>
</body>
</html>
