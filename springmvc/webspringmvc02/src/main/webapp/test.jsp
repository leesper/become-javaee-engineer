<%--
  Created by IntelliJ IDEA.
  User: likejun
  Date: 2021/1/22
  Time: 2:30 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="js/vue.js"></script>
    <script src="js/axios-0.18.0.js"></script>
</head>
<body>
SpringMVC框架进行Ajax交互
<fieldset>
    <h4>Ajax 的Json数据</h4>
    <div id="app">
        <input type="button" @click="clickMe()" value="发送Ajax数据">
        {{ userList }}
    </div>
</fieldset>
</body>
</html>
<script>
    new Vue({
        el: '#app',
        data:{
            userList: []
        },
        methods:{
            clickMe:function(){
                const params = {id:1, username:'你好', sex:'男'};
                axios.post("/ajax/testAjax.do", params)
                    .then(response => {
                        // console.log(response.data);
                        this.userList = response.data;
                    }).catch(error =>{
                        console.dir(error);
                    });
            }
        }
    })
</script>
