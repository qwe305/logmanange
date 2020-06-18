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
    <title>用户列表</title>
    <style>
        table td{border:1px solid black}
        /* css注释：只对table td标签设置红色边框样式 */
    </style>
</head>
<body>
    ${msg}
    <c:if test="${msg == null or msg == ''}">
        <a href="updatepassword.jsp">修改密码</a>
    <form action="selectuserlike" method="get">
        <input type="text" name="name">
        <input type="submit" value="查询">
    </form>
    <table class="table-b" border="0" cellspacing="0" cellpadding=>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>注册时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td><a href="userloglist?id=${user.id}">${user.username}</a></td>
                <td>${user.password}</td>
                <td>${user.register_date}</td>
                <td>
                    <a href="userloglist?id=${user.id}">查看日志</a>
                    <a href="">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</body>
</html>
