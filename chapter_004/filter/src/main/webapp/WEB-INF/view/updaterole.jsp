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
    <title>ShowAllRoles</title>
</head>
<body>
<h2>SHOW ALL ROLES</h2>
<form method='post'>
    <table border = "2">
        <tr>
            <th>ID</th>
            <th>NAME</th>
        <tr>
        <c:forEach items="${roles}" var = "role">
        <tr>
            <td><c:out value="${role.id}"/></td>
            <td><c:out value="${role.name}"/></td>
            <c:if test="${role.name != 'ADMIN'}">
                <td><a href="${pageContext.servletContext.contextPath}/deleterole?id=${role.id}">Delete</a></td>
            </c:if>
        </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.servletContext.contextPath}/addrole">Add new role</a>
</form>
</body>
</html>
