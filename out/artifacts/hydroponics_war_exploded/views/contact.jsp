<%--
  Created by IntelliJ IDEA.
  User: kirzner-pc
  Date: 10.02.2021
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Contact</title>
</head>
<body>
<div>
    <h1>Message form</h1>
</div>
<form action="ContactServlet" method="post">
    Name: <input name="name" />
    Email: <input name="email"type="email" />
    Message: <input name="message" />
    <input name="submit" type="submit" value="Отправить" />
</form>
</body>
</html>

