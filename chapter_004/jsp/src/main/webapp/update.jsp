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
<form action='<%=request.getContextPath()%>/update' method='post' accept-charset='UTF-8'>
    <input type='hidden' name='id' value='<%=request.getParameter("id")%>'></br>
    Name User: <input type = 'text' name = 'name'></br>
    Login User: <input type = 'text' name = 'login'></br>
    Email User: <input type = 'text' name = 'email'></br>
    <input type='submit' value='Update user'></br>
</form>
<form action='<%=request.getContextPath()%>/show' method='get' accept-charset='UTF-8'>
    <input type='submit' value='Back'>
</form>
</body>
</html>