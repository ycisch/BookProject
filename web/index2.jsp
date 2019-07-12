<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/12
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="static/js/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $(".btn2").click(function () {
                console.log("@@@@");
                var formData = new FormData(document.getElementById("tf"));
                // var file = $(".file1")[0].files[0];
                // formData.append("nfile",file);
                // console.log(formData);
                $.ajax({
                   "url":"BookServlet",
                    "type": "post",
                    "data": formData,
                    "dataType": "text",
                    processData:false,
                    contentType:false,
                    "success":callback,
                    "error":function () {
                        alert("用户名验证出现错误，请稍后再试或者联系管理员！");
                    }
                });

                function callback(data) {
                    console.log(data+"@@@@");
                    $(".img1").show();
                    $(".img1").css({"background":"url("+data+")"})
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

<form id ="tf1">
    <form action="" enctype="multipart/form-data" method="post" id="tf">
        <p>选择图片：<input class="file1" type="file" name="nfile"> </p>
        <div class="img1"></div>
        <p><input class="btn2" type="button" value="提交"></p>
    </form>
</form>
</body>
</html>
