<%--
  Created by IntelliJ IDEA.
  User: W
  Date: 2019/7/15
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-华轩书海商城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
    <script>
        $(function () {


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
                <a href="${pageContext.request.contextPath}/AdminServlet?opr=show&id=${admin.adminId}">
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
            <dd><a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=1"><span id="bookList">查询图书</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_insert.jsp"><span id="insertBook">添加图书</span></a></dd>
            <dd><a href="${pageContext.request.contextPath}/admin/admin_insertstyle.jsp"><span id="insertStyle">添加分类</span></a></dd>
        </dl>
    </div>
    <div id="display">
        <h1>修改订单</h1>${book.bookimg}
        <div>
            <div id="updateorder">
                <table>
                    <form action="${pageContext.request.contextPath}/BookServlet?opr=update" id="update_form" method="post">
                        <tr>
                            <th>书号：</th>
                            <td colspan="3"><input type="text" name="bookId" value="${book.bookid}"></td>
                        </tr>
                        <tr>
                            <th>书名：</th>
                            <td colspan="3"><input type="text" name="bookName" value="${book.bookName}"></td>
                        </tr>
                        <tr>
                            <th>作者：</th>
                            <td colspan="3"><input type="text" name="bookAuthor" value="${book.bookAuthor}"></td>
                        </tr>
                        <tr>
                            <th>简介：</th>
                            <td colspan="3"><textarea name="bookInfo">${book.bookInfo}</textarea></td>
                        </tr>
                        <tr>
                            <th>价格：</th>
                            <td colspan="3"><input type="text" name="bookMoney" value="${book.bookMoney}"></td>
                        </tr>
                        <tr>
                            <th>库存：</th>
                            <td colspan="3"><input type="text" name="bookNum" value="${book.bookNum}"></td>
                        </tr>
                        <tr>
                            <th>种类：</th>
                            <td colspan="3">
                                类型:
                                <select class="form-control" id="field" name="bookStyle">
                                    <option value="${book.bookStyle}">${book.bookStyle_value}</option>
                                </select>
                                <br>
                                标签:
                                <select class="form-control" id="profession" name="bookCategory">
                                    <option value="${book.bookCategory}">${book.bookCategory_value}</option>
                                </select>
                            </td>
                        </tr>
                        <input type="hidden" name="bookImg" class="img_data" value="..${book.bookimg}">
                    </form>
                    <tr>
                        <form action="" enctype="multipart/form-data" method="post" id="tf_update">
                            <th>图书展示预览：</th>
                            <td colspan="2">
                                <div class="img1" style="background: url(${pageContext.request.contextPath}${book.bookimg})"></div>
                            </td>
                            <td>
                                <p>选择图片：<input class="file1" type="file" name="nfile"> </p>
                                <p><input class="btn_update" type="button" value="上  传  图  片"></p>
                            </td>
                        </form>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="button" value="修        改" onclick="document.getElementById('update_form').submit();">

                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div id="copyright">
        &copy;2019 Test 版权所有   203搞事大队
    </div>
</div>
</body>
</html>
