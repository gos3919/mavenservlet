<%--
  Created by IntelliJ IDEA.
  User: 高升
  Date: 2020/11/9
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--使用el表达式 是否当作字符串来进行处理-->
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>password</td>
            <td>gender</td>
            <td>email</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td>
                    <button type="button">update</button>
                    <button type="button">delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
