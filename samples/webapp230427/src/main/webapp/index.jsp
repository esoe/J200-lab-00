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
<a href="hello-servlet">Перейти на страницу hello-servlet</a>
<form method="post" action="hello-servlet">
    <input type="text" name="login" value="login" />
    <br>
    <input type="password" name="password" />
    <br>
    <input type="submit" name="submit" value="send" />
</form>


</body>
</html>