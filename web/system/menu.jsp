<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/11
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/static/css/menu.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/footer.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/center.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/style1.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/menu.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/menu1.js"></script>
</head>
<body>
<div class="top">
    <div class="top-text">
        <span>华轩书海商城</span>
    </div>
    <div class="top-serach">
        <form action="BookServlet?opr=keyList&style1=name&page=1" class="top-serach-form" method="post">
            <div class="input1">
                <input type="text" name="style" placeholder="我喜欢你，像风走了八万里" />
                <input class="btn" type="button" value="搜索">
            </div>
        </form>
    </div>
    <div class="top-info">

        <a href="${pageContext.request.contextPath}/user/personalCenter.jsp" class="top-info-1">我的文轩</a>
        <div class="top-info-2">
            <a href="#">购物车</a>
            <div class="top-info-21"></div>
        </div>
    </div>

</div>
<div class="top-footer">
    <div class="top-footer-text">
        全部商品分类
        <div class="top-footer-style">
            <p class="top-h1">图书分类</p>
            <br>
            <div class="top-left">
                <ul>
                    <p class="top-footer-p">少儿</p>
                    <li><a href="#">0-2岁</a></li>
                    <li><a href="#">3-6岁</a></li>
                    <li><a href="#">7-12岁</a></li>
                    <li><a href="#">13-15岁</a></li>
                </ul>
                <div class="top-footer-style-dp">

                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                </div>
            </div>
            <hr style="margin: 8px 0px;color: #aaaaaa;border:1px none #000">
            <div class="top-left">
                <ul>
                    <p class="top-footer-p">学习考试</p>
                    <li><a href="#">教材与教辅</a></li>
                    <li><a href="#">注册会计师</a></li>
                    <li><a href="#">建筑类</a></li>
                    <li><a href="#">辞典与工具书</a></li>
                </ul>
                <div class="top-footer-style-dp">

                    <ul>
                        <span>育儿/早教123123</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                </div>
            </div>
            <hr style="margin: 8px 0px;color: #aaaaaa;border:1px none #000">
            <div class="top-left">
                <ul>
                    <p class="top-footer-p">童书</p>
                    <li><a href="#">儿童文学</a></li>
                    <li><a href="#">童话故事</a></li>
                    <li><a href="#">必读名著</a></li>
                </ul>
                <div class="top-footer-style-dp">

                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                </div>
            </div>
            <hr style="margin: 8px 0px;color: #aaaaaa;border:1px none #000">
            <div class="top-left">
                <ul>
                    <p class="top-footer-p">童书</p>
                    <li><a href="#">儿童文学</a></li>
                    <li><a href="#">童话故事</a></li>
                    <li><a href="#">必读名著</a></li>
                </ul>
                <div class="top-footer-style-dp">

                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                </div>
            </div>
            <hr style="margin: 8px 0px;color: #aaaaaa;border:1px none #000">
            <div class="top-left">
                <ul>
                    <p class="top-footer-p">童书</p>
                    <li><a href="#">儿童文学</a></li>
                    <li><a href="#">童话故事</a></li>
                    <li><a href="#">必读名著</a></li>
                </ul>
                <div class="top-footer-style-dp">

                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                </div>
            </div>
            <hr style="margin: 8px 0px;color: #aaaaaa;border:1px none #000">
            <div class="top-left">
                <ul>
                    <p class="top-footer-p">童书</p>
                    <li><a href="#">儿童文学</a></li>
                    <li><a href="#">童话故事</a></li>
                    <li><a href="#">必读名著</a></li>
                </ul>
                <div class="top-footer-style-dp">

                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                    <ul>
                        <span>育儿/早教</span>
                        <li>育儿百科</li>
                        <li>早教</li>
                        <li>亲子互动</li>
                        <li>婴幼儿饮食营养</li>
                        <li>婴幼儿护理健康</li>
                    </ul>
                </div>
            </div>
            <hr style="margin: 8px 0px;color: #aaaaaa;border:1px none #000">
        </div>
    </div>
    <div class="top-footer-ul">
        <a href="#">首页</a>
        <a href="${pageContext.request.contextPath}/BookServlet?opr=keyList&style1=style&style=2&page=1">文学频道</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=3&page=1">社科频道</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=4&page=1">经管频道</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=5&page=1">少儿频道</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=6&page=1">生活频道</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=7&page=1">科技频道</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=8&page=1">音像</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=9&page=1">百货</a>
        <a href="../BookServlet?opr=keyList&style1=style&style=10&page=1">电子书</a>
    </div>
</div>
<div class="center">
    <div class="menu">
        <div class="bg-img">
            <div class="left-jt"></div>
            <div class="right-jt"></div>
            <div class="select-tb">
                <ul>
                    <a class="bg" href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                </ul>
            </div>
        </div>
    </div>
    <div class="center-new1">
        <h2>新书预售</h2>
        <img src="../static/img/book/10.jpg">
        <p><a href="#">师道</a></p>
        <span>姚卫伟</span>
        <p style="color: #cc3300">¥27.60</p>
        <img src="../static/img/1.png" width="150px" height="100px">
    </div>
    <div class="center-new">
        <h2>新书</h2>
        <ul>
            <li>
                <img src="../static/img/book/1.jpg">
                <p><a href="#">当当全国独家 中华</a></p>
                <span>中华经典诗词分级诵</span>
                <p style="color: #cc3300">¥165.60</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/2.jpg">
                <p><a href="#">北京女子图鉴（一直</a></p>
                <span>王欣</span>
                <p style="color: #cc3300">¥42.00</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/3.jpg">
                <p><a href="#">穿过历史线，吃透小</a></p>
                <span>王芳</span>
                <p style="color: #cc3300">¥164.00</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/4.jpg">
                <p><a href="#">当当全国独家 中华</a></p>
                <span>中华经典诗词分级诵</span>
                <p style="color: #cc3300">¥165.60</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/5.jpg">
                <p><a href="#">自在成长：所有经</a></p>
                <span>李子勋</span>
                <p style="color: #cc3300">¥39.80</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/6.jpg">
                <p><a href="#">女孩成长不烦恼（套</a></p>
                <span>刷刷</span>
                <p style="color: #cc3300">¥302.40</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/7.jpg">
                <p><a href="#">名侦探柯南的科学之</a></p>
                <span>(日)青山刚昌/著,(日)</span>
                <p style="color: #cc3300">¥144.00/p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
            <li>
                <img src="../static/img/book/8.jpg">
                <p><a href="#">高效人士的问题解决</a></p>
                <span>（日）森秀明</span>
                <p style="color: #cc3300">¥15.99</p>
                <form>
                    <input type="hidden">
                    <input type="button" value="添加到购物车" class="btn1">
                </form>
            </li>
        </ul>
    </div>
    <div class="center-focus">
        新书热销版
        <ul>
            <li>总榜</li>
            <li>童书</li>
            <li>管理</li>
            <li>传记</li>
            <li>教辅</li>
        </ul>
        <div class="center-focus-dp">
            <ul >
                <li style="width: 190px">1&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
                <li style="width: 190px">2&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
                <li style="width: 190px">3&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
                <li style="width: 190px">4&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
                <li style="width: 190px">5&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
                <li style="width: 190px">6&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
                <li style="width: 190px">7&nbsp;&nbsp;
                    <span style="display: block;float:right;">半小时漫画唐诗</span>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="footer">
    ©2019 Test 版权所有   203搞事大队
</div>
</body>
</html>

