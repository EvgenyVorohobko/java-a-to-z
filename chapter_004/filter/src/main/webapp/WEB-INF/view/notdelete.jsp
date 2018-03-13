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
    <title>NotDeleteUser</title>
</head>
<body>
<h2>NOT DELETE USERS</h2>
<h3>Try again!</h3><br>
<form action='${pageContext.servletContext.contextPath}/' method='get' accept-charset='UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>