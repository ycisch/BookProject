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

    <form class="layui-form" lay-filter="test1" action="${pageContext.request.contextPath}/BookServlet" method="post">
        <input type="hidden" value="add" name="opr">
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>图书编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="bookId" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>将会成该图书的唯一识别码
            </div>
        </div>
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>书名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="bookName" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="x-red">*</span>作者
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_email" name="bookAuthor" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="bookMoney" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>数量
            </label>
            <div class="layui-input-inline">
                <input type="text"  name="bookNum" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
                <span class="x-red">*</span>简介
            </label>
            <div class="layui-input-inline">
                <textarea id="text_area" name="bookInfo" required lay-verify="required" placeholder="请输入"
                          class="layui-textarea" >${book.bookInfo}</textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label  class="layui-form-label">
            <span class="x-red">*</span>分类
        </label>
            <div class="layui-input-inline">
                <select class="form-control" id="field" name="bookStyle" lay-filter="select">
                    <option>----请选择类型----</option>
                </select>
            </div>
            <label  class="layui-form-label">
                <span class="x-red">*</span>标签
            </label>
            <div class="layui-input-inline">
                <select class="form-control" id="profession" name="bookCategory" lay-filter="select1">
                    <option>----请选择标签----</option>
                </select>
            </div>
        </div>
        <input type="hidden" name="bookImg" class="img_data" value="">
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="add" lay-submit="">
                增加
            </button>
        </div>
    </form>


</div>

<script>
    layui.use(['form'], function () {
        form = layui.form
            , layer = layui.layer;
        $.post("${pageContext.request.contextPath}/OrderServlet?opr=style",function(data){
            var field = "";
            console.log(data)
            for(var i=0;i<data.length;i++){
                field += "<option value='" + data[i].bookStyle + "'>" + data[i].booksName + "</option>";
            }
            console.log(field)
            console.log($("#field"))
            $("#field").append(field);
            form.render('select');

            console.log($("#field").toArray())
            //选中一级学科触发函数,异步获取二级学科

            form.on('select(select)', function(data){
                var areaId=(data.value);
                console.log(areaId+"@@@")
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath}/OrderServlet?opr=category',
                    data: {field:areaId},
                    dataType:  'json',
                    success: function(data){
                        $("#profession").html("");
                        $.each(data, function(key, val) {
                            var option1 = $("<option>").val(val.bookStyle).text(val.booksName);
                            $("#profession").append(option1);
                            form.render('select');
                        });
                        $("#profession").get(0).selectedIndex=0;
                    }
                });
            });


            <%--$("#field").change(function() {--%>
            <%--    var field = $("#field option:selected").val();//获取下拉列表中的选中项--%>
            <%--    var textfield = $("#field option:selected").text();//获取下拉列表中的内容--%>
            <%--    console.log(field+"   "+textfield);--%>
            <%--    $("#profession > option:gt(0)").each(function(){//避免option累加--%>
            <%--        $("#profession").empty();--%>
            <%--    });--%>
            <%--    $.post("${pageContext.request.contextPath}/OrderServlet?opr=category",{field:field},function(data){--%>

            <%--        console.log(data);--%>

            <%--        var profession = "";--%>
            <%--        for(var i=0;i<data.length;i++){--%>
            <%--            profession += "<option value='" + data[i].id+ "'>" + data[i].booksName + "</option>";--%>
            <%--        }--%>
            <%--        $("#profession").append(profession);--%>
            <%--        form.render('select');--%>
            <%--    },"json");--%>
            <%--});--%>
        },"json");
    });
</script>

<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        form.render();


        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            // 获得frame索引
            var index = parent.layer.getFrameIndex(window.name);
            //关闭当前frame
            parent.layer.close(index);
            // layer.alert("增加成功", {icon: 6},function () {
            // });
            // return false;
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


</body>

</html>