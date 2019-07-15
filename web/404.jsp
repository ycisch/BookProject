<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/15
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Free Bootstrap Error Template</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
    <!-- FONT AWESOME CSS -->
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css'>
    <!-- custom CSS here -->
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" />
</head>
<body>


<div class="container">

    <div class="row pad-top text-center">
        <div class="col-md-6 col-md-offset-3 text-center">
            <h1>  What have you done? </h1>
            <h5> Now Go Back Using Below LInk</h5>
            <span id="error-link"></span>
            <h2>! ERROR DECETED !</h2>
        </div>
    </div>

    <div class="row text-center">
        <div class="col-md-8 col-md-offset-2">

            <h3> <i  class="fa fa-lightbulb-o fa-5x"></i> </h3>
            <a href="${pageContext.request.contextPath}/system/menu.jsp" class="btn btn-primary">GO TO HOME PAGE</a>
            <br/><br/>More Templates <a href="http://www.baidu.com/" target="_blank" title="303搞事大队">303搞事大队</a>
        </div>
    </div>

</div>
<!-- /.container -->


<!--Core JavaScript file  -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.js"></script>
<!--bootstrap JavaScript file  -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
<!--Count Number JavaScript file  -->
<script src="${pageContext.request.contextPath}/static/js/countUp.js"></script>
<!--Custom JavaScript file  -->
<script src="${pageContext.request.contextPath}/static/js/custom.js"></script>
</body>
</html>

