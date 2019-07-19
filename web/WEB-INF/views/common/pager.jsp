<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.nuc.util.PageTest.SystemContext"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>


<pg:pager items="${param.items }" maxPageItems="${param.pageSize }"
          export="curPage=pageNumber" url="${param.url}">
    <!-- pg:param 是为了下一次点击url 中和服务器传参数 -->
    <pg:param name="requestMethod" />
    <pg:param name="nameKeyword" />
    <pg:param name="id" />



    <pg:first >
        <a href="<%=pageUrl%>">首页</a>
    </pg:first>
    <pg:prev>
        <a href="<%=pageUrl%>">上一页</a>
    </pg:prev>
    <pg:pages>
        <%
            if (curPage == pageNumber) {
        %>
        <a style="border:1px solid red"><%=pageNumber%></a>

        <%
        } else {
        %>
        <a href="<%=pageUrl%>"><%=pageNumber%></a>
        <%
            }
        %>
    </pg:pages>
    <pg:next>
        <a href="<%=pageUrl%>">下一页</a>
    </pg:next>
    <pg:last>
        <a href="<%=pageUrl%>">尾页</a>
    </pg:last>
</pg:pager>