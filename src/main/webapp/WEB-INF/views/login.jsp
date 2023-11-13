<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 13.11.2023
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorMessage}</font>
</p>
<form action="LoginServlet" method="POST">
    <p>Name : <input name="name" type="text"/>
    </p>
    <p> Password : <input name="password" type="password"/>
    </p>
    <input type="submit"/></form>

</body>
</html>
