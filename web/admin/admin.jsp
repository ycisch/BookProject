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
                    <dd><span id="select">返回首页</span></dd>

                    <hr/>

                    <!--            <dt>我的购物车</dt>
                                <dd><a href="">购物车</a></dd>
                                <dd><a href="">我的订单</a></dd>

                                <hr/> -->

                    <dt>用户管理</dt>
                    <dd><a href="${pageContext.request.contextPath}/admin/admin_userlist.jsp"><span id="userList">用户列表</span></a></dd>
                    <dd><a href="${pageContext.request.contextPath}/admin/admin_online.jsp"><span id="onlineList">在线用户</span></a></dd>

                    <hr/>

                    <dt>图书管理</dt>
                    <dd><a href="${pageContext.request.contextPath}/BookServlet?opr=welcome&page=1"><span id="bookList">查询图书</span></a></dd>
                    <dd><a href="${pageContext.request.contextPath}/admin/admin_insert.jsp"><span id="insertBook">添加图书</span></a></dd>
                </dl>
            </div>
            <div id="display">
                <h1>图书列表</h1>
                <div>
<%--                    <div id="update">
                        <table>
                            <form action="${pageContext.request.contextPath}/BookServlet?opr=update" id="update_form" method="post">
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
                                    <th>种类：</th>
                                    <td colspan="3">
                                        <select name="bookStyle">
                                            <option value="1">文学</option>
                                            <option value="2">社科</option>
                                            <option value="3">经管</option>
                                            <option value="4">少儿</option>
                                            <option value="5">生活</option>
                                            <option value="6">科技</option>
                                        </select>
                                    </td>
                                </tr>
                                <input type="hidden" name="bookImg" class="img_data" value="">
                            </form>
                            <tr>
                                <form action="" enctype="multipart/form-data" method="post" id="tf_update">
                                    <th>图书展示预览：</th>
                                    <td colspan="2">
                                        <div class="img1"></div>
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
                    <div id="users">
                        <table>
                            <tr>
                                <th class="username">用户名</th>
                                <th class="email">邮箱</th>
                                <th class="adress">地址</th>
                                <th class="phone">电话</th>
                                <th class="operation" colspan=2>操作</th>
                            </tr>
                            <tr>
                                <td class="username">张三</td>
                                <td class="email">1111111111.@qq.com</td>
                                <td class="adress">山西省</td>
                                <td class="phone">12365474121</td>
                                <td class="update"><span>修改</span></td>
                                <td class="delete"><span>删除</span></td>
                            </tr>
                            <tr>
                                <td class="username">李四</td>
                                <td class="email">1112.@qq.com</td>
                                <td class="adress">山西省</td>
                                <td class="phone">12365474258</td>
                                <td class="update"><span>修改</span></td>
                                <td class="delete"><span>删除</span></td>
                            </tr>
                            <tr>
                                <td class="username">王五</td>
                                <td class="email">1113.@qq.com</td>
                                <td class="adress">山西省</td>
                                <td class="phone">12365414635</td>
                                <td class="update"><span>修改</span></td>
                                <td class="delete"><span>删除</span></td>
                            </tr>
                        </table>
                        <div class="sikp">
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

                    <div id="onlines">
                        <table>
                            <tr>
                                <th class="username">用户名</th>
                                <th class="email">邮箱</th>
                                <th class="adress">地址</th>
                                <th class="phone">电话</th>
                            </tr>
                            <tr>
                                <td class="username">张三</td>
                                <td class="email">22222222.@qq.com</td>
                                <td class="adress">山西省</td>
                                <td class="phone">12365474121</td>
                            </tr>
                            <tr>
                                <td class="username">李四</td>
                                <td class="email">1112.@qq.com</td>
                                <td class="adress">山西省</td>
                                <td class="phone">12365474258</td>
                            </tr>
                            <tr>
                                <td class="username">王五</td>
                                <td class="email">1113.@qq.com</td>
                                <td class="adress">山西省</td>
                                <td class="phone">12365414635</td>
                            </tr>
                        </table>
                        <div class="sikp">
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
                                    <th>种类：</th>
                                    <td colspan="3">
                                        <select name="bookStyle">
                                            <option value="1">文学</option>
                                            <option value="2">社科</option>
                                            <option value="3">经管</option>
                                            <option value="4">少儿</option>
                                            <option value="5">生活</option>
                                            <option value="6">科技</option>
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
                    </div>--%>
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
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=list&&page=1"><span>首页</span></a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=list&&page=${page.currPageNo}"><span class="previous">上一页</span></a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=list&&page=${page.currPageNo+2}"><span class="next">下一页</span></a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/BookServlet?opr=list&&page=${page.totalPageCout}"><span>尾页</span></a>
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
