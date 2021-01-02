<%--
  Created by IntelliJ IDEA.
  User: likejun
  Date: 2020/12/31
  Time: 3:31 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<form action="register" method="post">
    <label for="username">用户名：</label>
    <input type="text" id="username" name="username">
    <label for="password">密码：</label>
    <input type="text" id="password" name="password">
    <label for="email">邮箱：</label>
    <input type="text" id="email" name="email">
    <label for="name">姓名：</label>
    <input type="text" id="name" name="name">
    <fieldset>
        <legend>性别</legend>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">男</label>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">女</label>
    </fieldset>
    <label for="birthday">出生日期：</label>
    <input type="date" id="birthday" name="birthday">
    <input type="submit">注册</button>
</form>

<a href="download?fileName=hadoop.PNG">下载图片</a>
</body>
</html>
