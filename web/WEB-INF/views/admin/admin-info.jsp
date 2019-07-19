<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/18
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>管理员个人信息界面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        .img1{
            width: 150px;
            height: 150px;
        }

    </style>
</head>

<body>

<div class="x-body">


    <form id="ft_sub" class="layui-form" lay-filter="test1" action="${pageContext.request.contextPath}/AdminServlet" method="post">
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="adminname" required="" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${sessionScope.admin.adminName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_email" name="password" required="required" lay-verify="required"
                       autocomplete="off" class="layui-input" value="${sessionScope.admin.adminPwd}">
            </div>
        </div>
    </form>


</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        form.render();

        //自定义验证规则
        form.verify({
            // nikename: function(value){
            //     if(value.length < 5){
            //         return '昵称至少得5个字符啊';
            //     }
            // }
            // ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            // ,repass: function(value){
            //     if($('#L_pass').val()!=$('#L_repass').val()){
            //         return '两次密码不一致';
            //     }
            // }
        });

        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);//关闭当前页
        });


    });
</script>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();

</script>




</body>

</html>