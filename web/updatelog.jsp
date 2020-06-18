<%--
  Created by IntelliJ IDEA.
  User: 12467
  Date: 2020/6/17
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="myform" action="/login" method="post">
    日志标题：<input type="text" name="title" id="title">
    日志内容：<input type="text" name="content" id="content">
    <input type="submit" value="修改" id="update" name="update" >
    <p id="message"></p>
</form>
</body>
</html>
