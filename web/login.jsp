<%--
  Created by IntelliJ IDEA.
  User: 12467
  Date: 2020/6/17
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<h1>登录界面</h1>
<form id="myform" action="LoginServlet" method="post">
    用户名：<input type="text" name="username" id="username">
    密码：<input type="password" name="password" id="password">
    <input type="submit" value="登录" id="login" name="login" >
    <a href="<%=basePath%>/register.jsp">注册</a>
    <p id="message"></p>
</form>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#login").click(function() {
            if ($("#username").val() === "") {
                $("#username").focus();
                $("#message").text("账号不能为空");
                return false;
            } else if ($("#password").val() === "") {
                $("#password").focus();
                $("#message").text("密码不能为空");
                return false;
            }
            return true;
        })
    })
</script>
