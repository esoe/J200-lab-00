<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body align="center">
<h1><%= "Hello World!" %>
</h1>
<br/>
<a  href="hello-servlet">Hello Servlet</a>
    <form action="hello-servlet" method="post">
        <input type="text" name="login" />
        <br><br>
        <input type="password" name="password" />
        <br><br>
        <input type="submit" value="Sing in">
    </form>
</body>
</html>