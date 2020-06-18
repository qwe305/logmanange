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
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body >

<table class="table-b" border="0" cellspacing="0" cellpadding=>
    <tr>
        <td>日志标题</td>
        <td>日志内容</td>
        <td>发布时间</td>
        <td>操作</td>
    </tr>
        <tr>
            <td>111111</td>
            <td>5515</td>
            <td>2015_03_22</td>
            <td>
                <a href="<%=basePath%>/updatelog.jsp">修改日志</a>
                <a href="">删除日志</a>
            </td>
        </tr>
</table>

</body>
</html>
<style>
    table td{border:1px solid black}
    /* css注释：只对table td标签设置红色边框样式 */
</style>