<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/14 0014
  Time: 下午 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>充值界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/addMoney.css">

</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/PayServlet" method="post" target="view_window">
    <p> <strong>余额充值</strong></p>
    <p>商品订单号<input id="WIDout_trade_no" name="WIDout_trade_no"/></p>
    <p> 账户余额：<input type="text"  name="oldmoney"  id="oldmoney" value="${sessionScope["user"].money}" disabled="disabled">￥</p>
    <p> 充值金额：<input type="text" name="total_amount" id="addmoney">￥</p>
    <input type="submit" name="add" id="addmoney_button" value="充值">
</form>
</body>
<script language="javascript">

    function GetDateNow() {
        var vNow = new Date();
        var sNow = "";
        sNow += String(vNow.getFullYear());
        sNow += String(vNow.getMonth() + 1);
        sNow += String(vNow.getDate());
        sNow += String(vNow.getHours());
        sNow += String(vNow.getMinutes());
        sNow += String(vNow.getSeconds());
        sNow += String(vNow.getMilliseconds());
        console.log(sNow+"asd");
        document.getElementById("WIDout_trade_no").value=sNow;
    }
    GetDateNow();
</script>
</html>
