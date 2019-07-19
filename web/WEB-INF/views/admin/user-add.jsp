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
    <title>欢迎页面-X-admin2.0</title>
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

    <form action="" class="layui-form" action="" enctype="multipart/form-data" method="post" id="tf_insert">
        <div class="layui-form-item">
            <label class="layui-form-label">图片展示</label>
            <div class="layui-input-block">
                <div class="img1"></div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择图片</label>
            <div class="layui-input-block">
                <input id="file1" type="file" name="nfile">
                <%--                <input class="layui-btn layui-btn-normal" id="btn_insert" type="button" value="">--%>

                <button type="button" class="layui-btn layui-btn-normal" id="btn_insert">上传图片</button>
            </div>
        </div>
    </form>

    <form id="ft_sub" class="layui-form" lay-filter="test1" action="${pageContext.request.contextPath}/AdminServlet" method="post">
        <input type="hidden" value="add" name="opr">
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>用户名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="username" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>将会成该用户的唯一识别码
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="L_email" name="password" required="required" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>邮箱
            </label>
            <div class="layui-input-inline">
                <input type="email" id="L_pass" name="email" required="email" lay-verify="email"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>地址
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="address" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>电话
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="phone" required="phone" lay-verify="phone"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <input type="hidden" name="userImg" class="img_data" value="">
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                添加
            </button>
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

<script>
    $(function () {
        $("#btn_insert").click(function () {
            console.log("@@@@");
            var formData = new FormData(document.getElementById("tf_insert"));
            // var file = $(".file1")[0].files[0];
            // formData.append("nfile",file);
            console.log(formData);

            $.ajax({
                "url":"${pageContext.request.contextPath}/BookServlet?opr=img",
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
                $(".img_data").val("."+data);
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
            console.log(field)
            console.log($("#field"))
            $("#field").append(field);

            console.log($("#field").toArray())
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

</body>

</html>