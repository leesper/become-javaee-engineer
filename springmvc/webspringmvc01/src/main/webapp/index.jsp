<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <fieldset>
        <h4>用法1:RequestMapping注解作用在类上，实现对请求路径的分类管理，限定类中方法访问的前缀</h4>
        <a href="http://localhost:8080/default/gotoResult.do">测试Default路径</a>
        <a href="http://localhost:8080/user/gotoResult.do">测试User路径</a>
    </fieldset>
    <fieldset>
        <h4>用法2 method属性限定请求方法: 请求的handler相同，请求方式不同进入不同方法处理</h4>
        <a href="http://localhost:8080/default/gotoResultMethod.do">Get方式测试</a>
        <form action="http://localhost:8080/default/gotoResultMethod.do" method="post">
            <input type="submit" value="Post方式测试">
        </form>
    </fieldset>

    <fieldset>
        <h4>功能1: 默认支持ServletAPI</h4>
        <a href="http://localhost:8080/params/gotoParams.do?id=123&name=guan">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能2: 绑定简单的数据类型</h4>
        <a href="http://localhost:8080/params/gotoParamsBase.do?isVIP=0">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能3: @RequsestParam注解的使用</h4>
        <a href="http://localhost:8080/params/gotoParamsRequestParam.do?id=1001">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能4: 绑定pojo对象</h4>
        <a href="http://localhost:8080/params/gotoParamsPojo.do?id=2&name=guanayi">测试</a>
    </fieldset>

    <fieldset>
        <h4>功能5: 绑定pojo对象的包装对象</h4>
        <a href="http://localhost:8080/params/gotoParamsQueryVo.do?user.id=2&user.name=zhang3">测试</a>
    </fieldset>
</body>
</html>
