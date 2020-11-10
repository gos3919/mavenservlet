<%--
  Created by IntelliJ IDEA.
  User: 高升
  Date: 2020/11/9
  Time: 20:35
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
<div>
    <form action="updateById" method="post">
        <table>
            <tr>
                <td>
                    <input type="hidden" name="id" value="${user.id}">
                    name:<input name="name" type="text" value=${user.name}>
                </td>
            </tr>
            <tr>
                <td>password:<input name="password" type="text" value=${user.password}></td>
            </tr>
            <tr>
                <td>gender:<input name="gender" type="text" value=${user.gender}></td>
            </tr>
            <tr>
                <td>email:<input name="email" type="text" value=${user.email}></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
