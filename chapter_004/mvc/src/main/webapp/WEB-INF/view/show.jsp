<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  Created by vorokhobko2011@yandex.ru.
  User: Evgeny Vorokhobko
  Date: 20.02.2018.
  Time: 12:25.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowUsers</title>
</head>
<body>
<h2>ALL USERS</h2>
<form method='post'>
    <table border = "2">
        <tr>
            <th>CHOICE</th>
            <th>ID</th>
            <th>NAME</th>
            <th>LOGIN</th>
            <th>EMAIL</th>
            <th>TIME</th>
        </tr>
        <c:forEach items="${users}" var = "user">
            <tr>
                <td><input type='radio' name='id' value='${user.id}'></td>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.createDate}"/></td>
            </tr>
        </c:forEach>
    </table><br>
    <input type='submit' value='Add user' formaction='${pageContext.servletContext.contextPath}/create'>
    <input type='submit' value='Update user' formaction='${pageContext.servletContext.contextPath}/update'>
    <input type='submit' value='Delete user' formaction='${pageContext.servletContext.contextPath}/delete'>
</form>
</body>
</html>