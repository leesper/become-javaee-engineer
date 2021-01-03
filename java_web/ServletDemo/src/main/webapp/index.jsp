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
<a href="register.jsp">新用户注册</a>

<body>
<form action="${pageContext.request.contextPath}/safe" method="get">
    <h2>去海边游泳,请选择要携带的物品</h2>
    <input type="checkbox" id="pant" name="product" value="泳裤">
    <label for="pant">泳裤</label>
    <input type="checkbox" id="bikini" name="product" value="⽐基尼">
    <label for="pant">⽐基尼</label>
    <input type="checkbox" id="video" name="product" value="摄像机">
    <label for="pant">摄像机</label>
    <input type="checkbox" id="camera" name="product" value="单反相机">
    <label for="pant">单反相机</label>
    <input type="checkbox" id="oil" name="product" value="防晒油">
    <label for="pant">防晒油</label>
    <input type="checkbox" id="grenade" name="product" value="⼿榴弹">
    <label for="pant">⼿榴弹</label>
    <input type="checkbox" id="machine_gun" name="product" value="冲锋枪">
    <label for="pant">冲锋枪</label>
    <br />
    <input type="submit" value="提交" />
</form>
</body>

</body>
</html>