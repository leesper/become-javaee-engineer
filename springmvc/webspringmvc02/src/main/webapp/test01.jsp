<%--
  Created by IntelliJ IDEA.
  User: likejun
  Date: 2021/1/22
  Time: 5:22 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <h4>演示Restful风格URL --- 新增（POST）</h4>
    <form action="${pageContext.request.contextPath}/user/100" method="post">
        <input type="submit" value="新增（POST）">
    </form>
</fieldset>

<fieldset>
    <h4>演示Restful风格URL --- 删除（DELETE）</h4>
    <form action="${pageContext.request.contextPath}/user/100" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="删除（DELETE）">
    </form>
</fieldset>

<fieldset>
    <h4>演示Restful风格URL --- 修改（PUT）</h4>
    <form action="${pageContext.request.contextPath}/user/100" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="修改（PUT）">
    </form>
</fieldset>

<fieldset>
    <h4>演示Restful风格URL --- 查找（GET）</h4>
    <a href="${pageContext.request.contextPath}/user/100">查询（GET）</a>
</fieldset>
</body>
</html>
