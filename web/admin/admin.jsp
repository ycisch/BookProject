<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/11
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理-华轩书海商城</title>
    <link rel="stylesheet" href="../static/css/admin.css">
    <script src="../static/js/jquery-1.11.3.min.js"></script>
    <script src="../static/js/admin.js"></script>
    <!-- <script>
        $(document).ready(function(){

            $("#admin").mouseover(function () {
                $("#books").css({"display":"block"});
            });
            $("#admin").mouseout(function () {
                $("#admin ul").css({"display":"none"});
            });

			$("#booklist").click(function () {
			    /* $("#books").css({"display":"none"}); */
				$("#userList").css({"display":"block"});
				$("#userList").siblings().css({"display":"none"});
			});


        });
    </script> -->
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
            <dd><span id="userList">用户列表</span></dd>
            <dd><span id="onlineList">在线用户</span></dd>

            <hr/>

            <dt>图书管理</dt>
            <dd><span id="bookList">查询图书</span></dd>
            <dd><span id="insertBook">添加图书</span></dd>
        </dl>
    </div>
    <div id="display">
        <h1>图书列表</h1>
        <div>
            <div id="origin">

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

            <div id="inserts">
                <form>
                    <table>
                        <tr>
                            <th>书名：</th>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <th>作者：</th>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <th>简介：</th>
                            <td><textarea></textarea></td>
                        </tr>
                        <tr>
                            <th>价格：</th>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <th>库存：</th>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <th>种类：</th>
                            <td>
                                <select>
                                    <option value="1">文学</option>
                                    <option value="2">社科</option>
                                    <option value="3">经管</option>
                                    <option value="4">少儿</option>
                                    <option value="5">生活</option>
                                    <option value="6">科技</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="添       加">
                            </td>

                        </tr>
                    </table>
                </form>
            </div>

            <div id="books">
                <ul>
                    <li>
                        <img src="../static/img/book/1.jpg">
                        <p><a href="#">当当全国独家 中华</a></p>
                        <span>中华经典诗词分级诵</span>
                        <p style="color: #cc3300">¥165.60</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/2.jpg">
                        <p><a href="#">北京女子图鉴（一直</a></p>
                        <span>王欣</span>
                        <p style="color: #cc3300">¥42.00</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/3.jpg">
                        <p><a href="#">穿过历史线，吃透小</a></p>
                        <span>王芳</span>
                        <p style="color: #cc3300">¥164.00</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/4.jpg">
                        <p><a href="#">当当全国独家 中华</a></p>
                        <span>中华经典诗词分级诵</span>
                        <p style="color: #cc3300">¥165.60</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/5.jpg">
                        <p><a href="#">自在成长：所有经</a></p>
                        <span>李子勋</span>
                        <p style="color: #cc3300">¥39.80</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/6.jpg">
                        <p><a href="#">女孩成长不烦恼（套</a></p>
                        <span>刷刷</span>
                        <p style="color: #cc3300">¥302.40</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/7.jpg">
                        <p><a href="#">名侦探柯南的科学之</a></p>
                        <span>(日)青山刚昌/著,(日)</span>
                        <p style="color: #cc3300">¥144.00</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                    <li>
                        <img src="../static/img/book/8.jpg">
                        <p><a href="#">高效人士的问题解决</a></p>
                        <span>（日）森秀明</span>
                        <p style="color: #cc3300">¥15.99</p>
                        <form>
                            <input type="hidden">
                            <input type="button" value="修改" class="btn1">
                            <input type="button" value="删除" class="btn2">
                        </form>
                    </li>
                </ul>
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
        </div>

        <!-- <div id="sikp">
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
        </div> -->


    </div>

    <div id="copyright">
        &copy;2019 Test 版权所有   203搞事大队
    </div>
</div>
</body>
</html>
