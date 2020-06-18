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
<form id="myform" action="updatelog" method="post" onsubmit="return check(this)">
    <input name="id" value="${log.id}" type="hidden">
    <input type="text" name="title" placeholder="请输入标题" value="${log.title}"><br>
    <br>
    <textarea cols="50" rows="20" name="content">${log.content}</textarea>
    <input type="submit" value="提交">
</form>
</body>
<script>
    function check(f) {
        return f.title.value !== "" && f.context.value !== "";
    }
</script>
</html>
