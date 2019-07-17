<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/11
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>后台管理-华轩书海商城</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
        <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
        <script>
            $(function () {
                $(".btn1").click(function () {
                    var id = $(this).prev().val();
                    alert(id);
                    location.href="BookServlet?opr=keyList&style=id&page=1&id="+id;
                })

                $(".btn2").click(function () {
                    var id = $(this).prev().prev().val();
                    var name = $(this).parent().prev().prev().prev().text();
                    alert(name);
                    if (confirm("确认删除"+name+"吗？\n")==true){
                        location.href="BookServlet?opr=del&id="+id;
                    }

                })

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
                        <a href="${pageContext.request.contextPath}/AdminServlet?opr=show">
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
                    <dd><a href="${pageContext.request.contextPath}/OrderServlet?opr=showAllusersorder"><span id="onlineList">用户订单</span></a></dd>

                    <hr/>

                    <dt>图书管理</dt>
                    <dd><a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=1"><span id="bookList">查询图书</span></a></dd>
                    <dd><a href="${pageContext.request.contextPath}/admin/admin_insert.jsp"><span id="insertBook">添加图书</span></a></dd>
                    <dd><a href="${pageContext.request.contextPath}/admin/admin_insertstyle.jsp"><span id="insertStyle">添加分类</span></a></dd>
                </dl>
            </div>
            <div id="display">
                <h1>图书列表</h1>
                <div>
                    <div id="books">
                        <ul>
                            <c:forEach items="${requestScope.bookList}" var="bookList">
                                <li>
                                    <img src="${pageContext.request.contextPath}${bookList.bookimg}">
                                    <p><a href="#">${bookList.bookName}</a></p>
                                    <span>${bookList.bookAuthor}</span>
                                    <p style="color: #cc3300">¥<span>${bookList.bookMoney}</span></p>
                                    <form>
                                        <input type="hidden" value="${bookList.bookid}">
                                        <input type="button" value="修改" class="btn1">
                                        <input type="button" value="删除" class="btn2">
                                    </form>
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="sikp">
                            <p>
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=1"><span>首页</span></a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=${page.currPageNo}"><span class="previous">上一页</span></a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=${page.currPageNo+2}"><span class="next">下一页</span></a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=${page.totalPageCout}"><span>尾页</span></a>
                                &nbsp;|&nbsp;
                                <a><span class="">当前${page.currPageNo+1}第页</span></a>
                                &nbsp;|&nbsp;
                                <a><span>总共${page.totalPageCout}页</span></a>
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
