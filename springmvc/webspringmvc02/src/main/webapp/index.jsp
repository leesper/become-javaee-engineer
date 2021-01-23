<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <fieldset>
        <h4>方法返回值String, 参数为 Model类型</h4>
        <a href="http://localhost:8080/default/gotoResultModel.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值String, 参数为 ModelMap类型</h4>
        <a href="http://localhost:8080/default/gotoResultModelMap.do">测试</a>
    </fieldset>

    <fieldset>
        <h4>方法返回值String, 使用SpringMVC的 重定向进行跳转页面</h4>
        <a href="http://localhost:8080/default/gotoResultRedirect.do">测试</a>
    </fieldset>
    <fieldset>
        <h4>方法返回值String, 使用SpringMVC的 转发进行跳转页面</h4>
        <a href="http://localhost:8080/default/gotoResultForward.do">测试</a>
    </fieldset>
</body>
</html>