<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by vorokhobko2011@yandex.ru.
  User: Evgeny Vorokhobko
  Date: 20.02.2018.
  Time: 12:25.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateUser</title>
</head>
<body>
<h2>UPDATE USERS</h2>
<form action='${pageContext.servletContext.contextPath}/update' method='post' accept-charset='UTF-8'>
    <input type='hidden' name='id' value='${param.id}'><br>
    Name User: <input type = 'text' name = 'name'><br>
    Login User: <input type = 'text' name = 'login'><br>
    Email User: <input type = 'text' name = 'email'><br>
    Password: <input type = 'password' name = 'password'><br>
    Role User:
    <c:if test="${user.role == 'ADMIN'}">
        <input type='radio' name='role' value='ADMIN'>ADMIN
        <input type='radio' name='role' value='USER'>USER<br>
    </c:if>
    <c:if test="${user.role == 'USER'}">
        <input type='hidden' name='role' value='USER'>USER<br>
    </c:if>
    <input type='submit' value='Update user'><br>
</form>
<form action='${pageContext.servletContext.contextPath}/' method='get' accept-charset='UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>