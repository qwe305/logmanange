<%--
  Created by IntelliJ IDEA.
  User: 12467
  Date: 2020/6/17
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body >
<c:if test="${sessionScope.role == 2}">
    <a href="addlog.jsp">发布日志</a>
</c:if>
<form action="logselectbylike" method="post">
    <input type="hidden" name="uid" value="${uid}">
    <input type="text" name="title">
    <input type="submit" value="查询">
</form>
<a href="updatepassword.jsp">修改密码</a>
<table class="table-b" border="0" cellspacing="0" cellpadding=>
    <tr>
        <td>日志标题</td>
        <td>日志内容</td>
        <td>发布时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${logList}" var="log">
    <tr>
        <td>${log.title}</td>
        <td>${log.content}</td>
        <td>${log.create_date}</td>
        <td>
            <c:if test="${sessionScope.role == 2}">
                <a href="selectlog?id=${log.id}">修改日志</a>
            </c:if>
            <a href="logdelete?id=${log.id}&uid=${uid}">删除日志</a>
        </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
<style>
    table td{border:1px solid black}
    /* css注释：只对table td标签设置红色边框样式 */
</style>