<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="login" method="post">
    <label for="username">User name: </label>
    <input type="text" id="username" name="username">
    <label for="password">Password: </label>
    <input type="text" id="password" name="password">
    <input type="submit">
</form>

<a href="download?fileName=hadoop.PNG">下载图片</a>
</body>
</html>