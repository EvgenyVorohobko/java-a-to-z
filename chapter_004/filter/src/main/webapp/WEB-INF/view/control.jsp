<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgeny
  Date: 26.02.2018
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ControlEnterUser</title>
</head>
<body>
<h2>Control Entered User</h2>
<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action='${pageContext.servletContext.contextPath}/control' method='post' accept-charset = 'UTF-8'>
    Login User: <input type = 'text' name = 'login'><br>
    Password: <input type = 'password' name = 'password'><br>
    <input type = 'submit' value = 'Enter in Program'>
</form>
</body>
</html>