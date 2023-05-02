<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World 2023!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form method="get" action="hello-servlet">
    <input type="text" name="login">
    <br><br>
    <input type="password" name="password">
    <br><br>
    <input type="submit" name="button" value="send">
</form>

</body>
</html>