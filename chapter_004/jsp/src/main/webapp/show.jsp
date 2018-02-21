<%@ page import="by.vorokhobko.servletwithuser.User" %>
<%@ page import="by.vorokhobko.servletwithuser.UserStore" %><%--
  Created by vorokhobko2011@yandex.ru.
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
        <% UserStore users = UserStore.INSTANCE;
        for (User user : users.findAll()) {%>
            <tr>
                <th>CHOICE</th>
                <th>ID</th>
                <th>NAME</th>
                <th>LOGIN</th>
                <th>EMAIL</th>
                <th>TIME</th>
            </tr>
            <tr>
                <td><input type='radio' name='id' value= <%=user.getId()%>></td>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=user.getEmail()%></td>
                <td><%=user.getCreateDate()%></td>
            </tr>
        <%}%>
    </table><br>
    <input type='submit' value='Add user' formaction='<%=request.getContextPath()%>/create'>
    <input type='submit' value='Update user' formaction='<%=request.getContextPath()%>/update'>
    <input type='submit' value='Delete user' formaction='<%=request.getContextPath()%>/delete'>
</form>
</body>
</html>