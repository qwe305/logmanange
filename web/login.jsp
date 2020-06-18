<%--
  Created by IntelliJ IDEA.
  User: 12467
  Date: 2020/6/17
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <style>
        .login{
            width: 250px;
            margin: 100px auto;
        }
        .msg{
            color: red;
            margin: 10px auto;
        }
        input[type=submit]{
            margin: 0 auto;
            width: 50px;
        }
    </style>
</head>
<body>
    <div class="login">
        <form method="post" action="login">
            <label>
                账号:<input type="text" name="username">
            </label>
            <br>
            <label>
                密码:<input type="password" name="password">
            </label>
            <div class="msg">${msg}</div>
            <div style="width: 100%;"><input type="submit" value="登录"></div>
        </form>
    </div>

</body>
</html>
