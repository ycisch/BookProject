<%--
  Created by IntelliJ IDEA.
  User: W
  Date: 2019/7/15
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-华轩书海商城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/admin.js"></script>
    <script>
        $(function () {
            var prepwdOk = false;
            var newpwdOk = false;
            var repwdOk = false;
            $("#prepwd").focus(function () {
                $("#prepwdError").html("");
            });
            $("#prepwd").blur(function () {
                var adminname = $("#adminname").val();
                var prepwd =  $("#prepwd").val();

                console.log(adminname+"  "+prepwd);

                $.ajax({
                    url:"${pageContext.request.contextPath}/AdminServlet",
                    data:"opr=test&adminname="+adminname+"&adminpwd="+prepwd,
                    type:"get",
                    dataType:"text",
                    success:callBack,
                });
                function callBack(data) {
                    console.log(data);
                    if (data == "true"){
                        prepwdOk = true;
                        $("#prepwdError").html("");
                        $("#prepwdSuccess").html("密码正确");
                    }
                    else {

                        $("#prepwdError").html("原密码错误");
                        $("#prepwdSuccess").html("");
                    }
                }
                $("#newpwd").focus(function () {
                    $("#newpwdError").html("");
                });
                $("#newpwd").blur(function () {
                    var newpwd = $("#newpwd").val();
                    if (newpwd.length < 3) {
                        $("#newpwdSuccess").html("");
                        $("#newpwdError").html("密码长度小于3");
                    }else {
                        newpwdOk = true;
                        $("#newpwdSuccess").html("密码可用");
                        $("#newpwdError").html("");
                    }
                });
                $("#repwd").focus(function () {
                    $("#repwdError").html("");
                });
                $("#repwd").blur(function () {
                    var newpwd = $("#newpwd").val();
                    var repwd = $("#repwd").val();
                    console.log(newpwd+"  "+repwd)
                    if (newpwd == repwd){
                        repwdOk = true;
                        $("#repwdSuccess").html("输入正确");
                        $("#repwdError").html("");
                    } else {
                        $("#repwdSuccess").html("");
                        $("#repwdError").html("两次输入不一致");
                    }
                });
                $("#login_button").click(function () {
                    if (prepwdOk && newpwdOk && repwdOk){
                        $("#login_button").submit();
                    } else {
                        return false;
                    }
                })
            })
        })
    </script>
    <style>
        #prepwdError{
            font-size: 14px;
            color: red;
        }
        #prepwdSuccess{
            font-size: 14px;
            color: green;
        }
        #newpwdError{
            font-size: 14px;
            color: red;
        }
        #newpwdSuccess{
            font-size: 14px;
            color: green;
        }
        #repwdError{
            font-size: 14px;
            color: red;
        }
        #repwdSuccess{
            font-size: 14px;
            color: green;
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
        <h1>管理员信息</h1>
        <div id="admin_info">
            <table>
                <form action="${pageContext.request.contextPath}/AdminServlet?opr=update" id="update_form"  method="post">
                    <tr>
                        <th>用户名：</th>
                        <td colspan="3"><input id="adminname" type="text" name="adminname" value="${admin.adminName}" readonly="readonly"></td>
                    </tr>
                    <tr>
                        <th>原密码：</th>
                        <td colspan="3"><input type="password" name="adminpwd" value="" id="prepwd"></td>
                        <td><span id="prepwdError"></span> <span id="prepwdSuccess"></span></td>
                    </tr>
                    <tr>
                        <th>新密码：</th>
                        <td colspan="3"><input type="password" name="newpwd" value="" id="newpwd"></td>
                        <td><span id="newpwdError"></span> <span id="newpwdSuccess"></span></td>
                    </tr>
                    <tr>
                        <th>确认密码：</th>
                        <td colspan="3"><input type="password" name="repwd" value="" id="repwd"></td>
                        <td><span id="repwdError"></span> <span id="repwdSuccess"></span></td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <input type="submit" name="login" id="login_button" value="确  认  修  改"/>
                        </td>
                    </tr>
                </form>
            </table>
        </div>
    </div>
    <div id="copyright">
        &copy;2019 Test 版权所有   203搞事大队
    </div>
</div>
</body>
</html>
