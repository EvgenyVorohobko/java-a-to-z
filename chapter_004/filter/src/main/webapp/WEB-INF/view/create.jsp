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
    <title>CreateUsers</title>
</head>
<body>
<h2>CREATE USERS</h2>
<form action='${pageContext.servletContext.contextPath}/create' method='post' accept-charset = 'UTF-8'>
    Name User: <input type = 'text' name = 'name' placeholder="Name"><br>
    Login User: <input type = 'text' name = 'login' placeholder="Login"><br>
    Email User: <input type = 'text' name = 'email' placeholder="Email"><br>
    Password: <input type = 'password' name = 'password' placeholder="Password"><br>
    Role User: <input type="text" name = "id" placeholder="ID role">
    <input type = 'submit' value = 'Create User'><br>
</form>
<form action='${pageContext.servletContext.contextPath}/' method='get' accept-charset = 'UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>