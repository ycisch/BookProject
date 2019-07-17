<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/13
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/static/css/menu.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/center.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style1.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/menu.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/menu1.js"></script>

    <script>
        $(function () {
            $(".btn_brand_prev").click(function () {
                console.log("asdasd");
                var num = ${page.currPageNo};
                var style = ${style};
                var style1 =${style1};
                console.log(style+"   "+style1)
                num = num - 1;
                if(num <= 0) num = 1;
                console.log(num);

                location.href="BookServlet?opr=keyList&style1="+'${style1 }'+"&style="+'${style }'+"&page="+num;
            });

            $(".btn_brand_next").click(function () {
                var num = ${page.currPageNo};
                if(num <= 0) num = 1;
                // var style = ;
                // var style1 =;
                num += 1;
                // console.log(num);
                if(num >= ${page.totalPageCout}) {

                    num = num = ${page.totalPageCout};;
                }
                location.href="BookServlet?opr=keyList&style1="+'${style1 }'+"&style="+'${style }'+"&page="+num;
            })
        })
    </script>
</head>
<body>
<div class="top">
    <div class="top-text">
        <span>华轩书海商城</span>
        ${style}<br>
        ${style1};
    </div>
    <div class="top-serach">
        <form class="top-serach-form">
            <div class="input1">
                <input type="text" placeholder="我喜欢你，像风走了八万里" />
                <input class="btn" type="button" value="搜索">
            </div>
        </form>
    </div>
    <div class="top-info">

        <a href="${pageContext.request.contextPath}/user/personalCenter.jsp" class="top-info-1">我的文轩</a>
        <a href="${pageContext.request.contextPath}/system/login.jsp">登录</a>
        <a href="${pageContext.request.contextPath}/system/regist.jsp">注册</a>
        <div class="top-info-2">
            <a href="#">购物车</a>
            <div class="top-info-21"></div>
        </div>
    </div>

</div>
<div class="top-footer">
    <div class="top-footer-text">
        全部商品分类
    </div>
    <div class="top-footer-ul">
        <a href="#">首页</a>
        <c:choose>
            <c:when test="${requestScope.style=='2'}">
                <a href="#" class="type_a">文学频道</a>
            </c:when>
            <c:otherwise>
                <a href="#">文学频道</a>
            </c:otherwise>
        </c:choose>


        <a href="#">社科频道</a>
        <a href="#">经管频道</a>
        <a href="#">少儿频道</a>
        <a href="#">生活频道</a>
        <a href="#">科技频道</a>
        <a href="#">音像</a>
        <a href="#">百货</a>
        <a href="#">电子书</a>
    </div>
</div>
<div class="center1">
    <h2>文学频道</h2>
    <ul>
        <c:forEach items="${requestScope.bookList}" var="bookList">
            <li>
                <img src="${pageContext.request.contextPath}${bookList.bookimg}">
                <p><a href="#">${bookList.bookName}</a></p>
                <span>${bookList.bookAuthor}</span>
                <p style="color: #cc3300">¥<span>${bookList.bookMoney}</span></p>
                <form action="ShopServlet" method="post">
                    <input type="hidden" name="opr" value="add">
                    <input type="hidden" name="bookid" value="${bookList.bookid}">
                    <input type="submit" value="添加到购物车" class="btn1">
                </form>
            </li>
        </c:forEach>



<%--        设置左右按钮--%>
        <div class="btn_brand_prev" type="rollpre"></div>
        <div class="btn_brand_next" type="rollnext"></div>

<%--        <li>--%>
<%--            <img src="../static/img/book/1.jpg">--%>
<%--            <p><a href="#">当当全国独家 中华</a></p>--%>
<%--            <span>中华经典诗词分级诵</span>--%>
<%--            <p style="color: #cc3300">¥165.60</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/2.jpg">--%>
<%--            <p><a href="#">北京女子图鉴（一直</a></p>--%>
<%--            <span>王欣</span>--%>
<%--            <p style="color: #cc3300">¥42.00</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/3.jpg">--%>
<%--            <p><a href="#">穿过历史线，吃透小</a></p>--%>
<%--            <span>王芳</span>--%>
<%--            <p style="color: #cc3300">¥164.00</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/4.jpg">--%>
<%--            <p><a href="#">当当全国独家 中华</a></p>--%>
<%--            <span>中华经典诗词分级诵</span>--%>
<%--            <p style="color: #cc3300">¥165.60</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/5.jpg">--%>
<%--            <p><a href="#">自在成长：所有经</a></p>--%>
<%--            <span>李子勋</span>--%>
<%--            <p style="color: #cc3300">¥39.80</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/6.jpg">--%>
<%--            <p><a href="#">女孩成长不烦恼（套</a></p>--%>
<%--            <span>刷刷</span>--%>
<%--            <p style="color: #cc3300">¥302.40</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/7.jpg">--%>
<%--            <p><a href="#">名侦探柯南的科学之</a></p>--%>
<%--            <span>(日)青山刚昌/著,(日)</span>--%>
<%--            <p style="color: #cc3300">¥144.00/p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            <img src="../static/img/book/8.jpg">--%>
<%--            <p><a href="#">高效人士的问题解决</a></p>--%>
<%--            <span>（日）森秀明</span>--%>
<%--            <p style="color: #cc3300">¥15.99</p>--%>
<%--            <form>--%>
<%--                <input type="hidden">--%>
<%--                <input type="button" value="添加到购物车" class="btn1">--%>
<%--            </form>--%>
<%--        </li>--%>
    </ul>
</div>
<div class="footer">
    ©2019 Test 版权所有   203搞事大队
</div>
<div class="footer-right">
    <div class="footer-ewm">
        联系<br>我们
        <div class="footer1">

        </div>
    </div>

    <div class="footer-zd">
        置顶
    </div>
</div>
</body>
</html>

