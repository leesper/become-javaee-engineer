<%--
  Created by IntelliJ IDEA.
  User: likejun
  Date: 2020/12/31
  Time: 4:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div style="color: red">
    <%= request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>
</div>
</body>
</html>
