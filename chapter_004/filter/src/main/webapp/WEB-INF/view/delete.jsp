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
    <title>DeleteUser</title>
</head>
<body>
<h2>DELETE USERS</h2>
<form action='${pageContext.servletContext.contextPath}/delete' method='post' accept-charset='UTF-8'>
    <h3>Are you sure?<c:out value="${param.id}"/></h3><br>
    <input type='hidden' name='id' value='${param.id}'/><br>
    <input type='submit' value='Delete'>
</form>
<form action='${pageContext.servletContext.contextPath}/' method='get' accept-charset='UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>