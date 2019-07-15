<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12 0012
  Time: 下午 4:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>华轩个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/personalCenter.css">
</head>
<body>
<div class="father">
    <div id="header">
        <h3>华轩个人中心</h3>
        <em>四川省成都市</em>
        <span>-----华轩书海商城</span>
    </div>
    <div class="guangao">
        <p><img src="../static/img/guanggao.png"></p>
    </div>
    <div class="left">
        <i>个人信息</i>
        <hr/>
        <div class="left_list">
            <ul>
                <li><a href="${pageContext.request.contextPath}/UserServlet?opr=show" target="mainframe">查看个人信息</a> </li>

                <li><a href="${pageContext.request.contextPath}/ShopServlet?opr=list" target="mainframe">我的购物车</a></li>

                <li><a href="${pageContext.request.contextPath}/OrderServlet?opr=list" target="mainframe">我的订单</a></li>
            </ul>
        </div>
    </div>
    <div class="right">
        <iframe name="mainframe"></iframe>
    </div>
    <div class="footer">
        <p>猜你喜欢</p>
        <hr/>
        <ul class="books">
            <li><img src="../static/img/book/1.jpg"></li>
            <li><img src="../static/img/book/2.jpg"></li>
            <li><img src="../static/img/book/3.jpg"></li>
            <li><img src="../static/img/book/4.jpg"></li>
            <li><img src="../static/img/book/5.jpg"></li>
            <li><img src="../static/img/book/6.jpg"></li>
            <li><img src="../static/img/book/7.jpg"></li>

        </ul>
    </div>
</div>
</body>
</html>
