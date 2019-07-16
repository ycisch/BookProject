<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/7/16
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>省市联动</title>
    <script type="text/javascript" src="jquery-1.11.1.js"></script>
    <script type="text/javascript">
        var pro=["河南","山东","黑龙江"];
        var city=[["郑州","开封","新政","濮阳","平顶山","洛阳","三门峡"],["济南","日照","烟台","德州","聊城"],["哈尔滨","齐齐哈尔","佳木斯","牡丹江"]];
        $(function(){
            //初始化省份下拉列表
            for(var i=0;i<pro.length;i++){
                $("#province").append($("<option></option>").val(i+1).html(pro[i]));
            }
            //为省份下拉列表绑定change事件
            $("#province").change(function(){
                var index=$(this).val()-1;//获取当前省的下标
                $("#city").prop("length",1);//清空原有的数据
                for(var i=0;i<city[index].length;i++){//重新为市赋值
                    $("#city").append($("<option>").val(i+1).html(city[index][i]));
                }
            });
        })
    </script>
</head>
<body>
<div style="height: 200px;width: 300px;background-color: aquamarine;text-align: center" id="div1">
    <select id="province">
        <option value="0" selected>-请选择-</option>
    </select>省
    <select id="city">
        <option value="0" selected>-请选择-</option>
    </select>市
</div>
</body>
</html>
