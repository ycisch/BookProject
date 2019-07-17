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
            $(".btn_insert").click(function () {
                console.log("@@@@");
                var formData = new FormData(document.getElementById("tf_insert"));
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
                    $(".img_data").val(data);
                }
            })
        })
    </script>

    <script type="text/javascript">
        $(function() {
            //ajax实现二级联动
            $.post("${pageContext.request.contextPath}/OrderServlet?opr=style",function(data){
                var field = "";
                console.log(data)
                for(var i=0;i<data.length;i++){
                    field += "<option value='" + data[i].id + "'>" + data[i].booksName + "</option>";
                }
                $("#field").append(field);
                //选中一级学科触发函数,异步获取二级学科
                $("#field").change(function() {
                    var field = $("#field option:selected").val();//获取下拉列表中的选中项
                    var textfield = $("#field option:selected").text();//获取下拉列表中的内容
                    $("#profession > option:gt(0)").each(function(){//避免option累加
                        $("#profession").empty();
                    });
                    $.post("${pageContext.request.contextPath}/OrderServlet?opr=category",{field:field},function(data){

                        console.log(data);

                        var profession = "";
                        for(var i=0;i<data.length;i++){
                            profession += "<option value='" + data[i].id+ "'>" + data[i].booksName + "</option>";
                        }
                        $("#profession").append(profession);
                    },"json");
                });
            },"json");
        });
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
        <h1>添加图书</h1>
        <div>
            <div id="inserts">
                <table>
                    <form action="${pageContext.request.contextPath}/BookServlet?opr=add" id="insert_form" method="post">
                        <tr>
                            <th>书号：</th>
                            <td colspan="3"><input type="text" name="bookId"></td>
                        </tr>
                        <tr>
                            <th>书名：</th>
                            <td colspan="3"><input type="text" name="bookName"></td>
                        </tr>
                        <tr>
                            <th>作者：</th>
                            <td colspan="3"><input type="text" name="bookAuthor"></td>
                        </tr>
                        <tr>
                            <th>简介：</th>
                            <td colspan="3"><textarea name="bookInfo"></textarea></td>
                        </tr>
                        <tr>
                            <th>价格：</th>
                            <td colspan="3"><input type="text" name="bookMoney"></td>
                        </tr>
                        <tr>
                            <th>库存：</th>
                            <td colspan="3"><input type="text" name="bookNum"></td>
                        </tr>
                        <tr>
<%--                            <th>种类：</th>--%>
<%--                            <td colspan="3">--%>
<%--                                <select name="bookStyle">--%>
<%--                                    <option value="1">文学</option>--%>
<%--                                    <option value="2">社科</option>--%>
<%--                                    <option value="3">经管</option>--%>
<%--                                    <option value="4">少儿</option>--%>
<%--                                    <option value="5">生活</option>--%>
<%--                                    <option value="6">科技</option>--%>
<%--                                </select>--%>
<%--                            </td>--%>
                            <th>种类：</th>
                            <td colspan="3">
                                类型:
                                <select class="form-control" id="field" name="bookStyle">
                                    <option>----请选择类型----</option>
                                </select>
                                <br>
                                标签:
                                <select class="form-control" id="profession" name="bookCategory">
                                    <option>----请选择标签----</option>
                                </select>
                            </td>
                        </tr>
                        <input type="hidden" name="bookImg" class="img_data" value="">
                    </form>
                    <tr>
                        <form action="" enctype="multipart/form-data" method="post" id="tf_insert">
                            <th>图书展示预览：</th>
                            <td colspan="2">
                                <div class="img1"></div>
                            </td>
                            <td>
                                <p>选择图片：<input class="file1" type="file" name="nfile"> </p>
                                <p><input class="btn_insert" type="button" value="上  传  图  片"></p>
                            </td>
                        </form>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <input type="button" value="添        加" onclick="document.getElementById('insert_form').submit();">
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
