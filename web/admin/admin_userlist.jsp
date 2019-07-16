<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: W
  Date: 2019/7/15
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-华轩书海商城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
    <script>
        $(function () {
            var num = ${page.currPageNo};
            if (num == 1){
                $("#hasPrev").hide();
                $("#hasNext").show();
            }else if(num == ${page.totalPageCout} ){
                $("#hasPrev").show();
                $("#hasNext").hide();
            }
            $(".btn").click(function () {
                console.log("@@@@");
                var formData = new FormData(document.getElementById("tf"));
                // var file = $(".file1")[0].files[0];
                // formData.append("nfile",file);
                // console.log(formData);

                $.ajax({
                    "url":"../BookServlet",
                    "type": "post",
                    "data": formData,
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    "success":callback
                });

                function callback(data) {
                    console.log(data+"@@@@");
                    $(".img1").show();
                    $(".img1").css({"background":"url("+data+")"});
                    alert(data);
                    $("#img_data").val(data);
                }
            })
        })
    </script>

    <style>
        .img1{
            display: none;
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>
<div id="header">
    <em>四川省成都市</em>
    <span>-----华轩书海商城</span>
    <div id="admin">
        <span>欢迎您：${admin.adminName}</span>
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
            <dd><span id="select">返回首页</span></dd>

            <hr/>

            <!--            <dt>我的购物车</dt>
                        <dd><a href="">购物车</a></dd>
                        <dd><a href="">我的订单</a></dd>

                        <hr/> -->

            <dt>用户管理</dt>
            <dd><a href="${pageContext.request.contextPath}/AdminServlet?opr=list&currPageNo=1"><span id="userList">用户列表</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_order.jsp"><span id="onlineList">用户订单</span></a></dd>

            <hr/>

            <dt>图书管理</dt>
            <dd><a href="${pageContext.request.contextPath}/BookServlet?opr=list&page=1"><span id="bookList">查询图书</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_insert.jsp"><span id="insertBook">添加图书</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_insertstyle.jsp"><span id="insertStyle">添加分类</span></a></dd>
        </dl>
    </div>
    <div id="display">
        <h1>图书列表</h1>
        <div>
            <div id="users">
                <table>
                    <tr>
                        <th class="username">用户名</th>
                        <th class="email">邮箱</th>
                        <th class="adress">地址</th>
                        <th class="phone">电话</th>
                        <th class="operation" colspan=2>操作</th>
                    </tr>
                    <c:forEach var="list" items="${userList}">
                        <tr>
                            <td class="username">${list.username}</td>
                            <td class="email">${list.email}</td>
                            <td class="adress">${list.address}</td>
                            <td class="phone">${list.phone}</td>
<%--                            <td class="update"><span><a href="${pageContext.request.contextPath}/UserServlet?opr=update">修改</a></span></td>--%>
                            <td class="delete"><span><a href="${pageContext.request.contextPath}/AdminServlet?opr=delete&id=${list.id}">删除</a></span></td>
                        </tr>
                    </c:forEach>

                </table>
                <div class="sikp">
                    <p>
                        <a href="${pageContext.request.contextPath}/AdminServlet?opr=list&currPageNo=1"><span>首页</span></a>
                        &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/AdminServlet?opr=list&currPageNo=${requestScope["page"].currPageNo-1}"><span>上一页</span></a>
                        |
                        <a href="${pageContext.request.contextPath}/AdminServlet?opr=list&currPageNo=${requestScope["page"].currPageNo+1}"><span>下一页</span></a>
                        &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/AdminServlet?opr=list&currPageNo=${requestScope["page"].totalPageCout}"><span>尾页</span></a>
                        &nbsp;|&nbsp;
                        <a></a><span>当前第${requestScope["page"].currPageNo}页</span>
                        &nbsp;|&nbsp;
                        <a></a><span>总共${requestScope["page"].totalPageCout}页</span>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div id="copyright">
        &copy;2019 Test 版权所有   203搞事大队
    </div>
</div>
</body>
</html>
