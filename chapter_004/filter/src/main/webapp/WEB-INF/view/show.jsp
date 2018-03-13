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
            <th>ID</th>
            <th>NAME</th>
            <th>LOGIN</th>
            <th>EMAIL</th>
            <th>TIME</th>
            <c:if test="${user.role == 'ADMIN'}">
                <th>ROLE</th>
            </c:if>
        </tr>
        <c:forEach items="${users}" var = "element">
            <tr>
                <td><c:out value="${element.id}"/></td>
                <td><c:out value="${element.name}"/></td>
                <td><c:out value="${element.login}"/></td>
                <td><c:out value="${element.email}"/></td>
                <td><c:out value="${element.createDate}"/></td>
                <c:if test="${user.role == 'ADMIN'}">
                    <td><c:out value="${element.role}"/></td>
                    <td><a href="${pageContext.servletContext.contextPath}/delete?id=${element.id}">Delete user</a></td>
                    <td><a href="${pageContext.servletContext.contextPath}/update?id=${element.id}">Update user</a></td>
                </c:if>
                <c:if test="${user.role == 'USER'}">
                    <c:if test="${element.role == user.role}">
                        <td><a href="${pageContext.servletContext.contextPath}/update?id=${element.id}">Update user</a></td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
    </table><br>
    <c:if test="${user.role == 'ADMIN'}">
        <a href="${pageContext.servletContext.contextPath}/create">Add new user</a>
    </c:if>
</form>
</body>
</html>