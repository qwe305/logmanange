<%--
  Created by IntelliJ IDEA.
  User: 12467
  Date: 2020/6/17
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加日志</title>
</head>
<body>
<form action="addlog" method="post" onsubmit="return check(this)">
    <input type="text" name="title" placeholder="请输入标题"><br>
    <br>
    <textarea cols="50" rows="20" name="content"></textarea>
    <input type="submit" value="提交">
</form>
</body>
<script>
    function check(f) {
        return f.title.value !== "" && f.context.value !== "";
    }
</script>
</html>
