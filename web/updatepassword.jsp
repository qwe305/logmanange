<%--
  Created by IntelliJ IDEA.
  User: 12467
  Date: 2020/6/18
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form action="updatepassword" method="post" onsubmit="return check(this)">
    输入密码：<input type="password" name="password"><br>
    再次输入密码：<input type="password" name="repassword">
    <input type="submit" value="修改">
</form>
</body>
<script>
    function check(f) {
        return f.password.value!==""&&f.repassword.value===f.password.value
    }
</script>
</html>
