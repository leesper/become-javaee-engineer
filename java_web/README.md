# Java Web

## 知识点

* Java Web中的静态资源和动态资源
* URL请求路径
* Tomcat服务器安装和IDEA集成
* Web项目目录结构
* HTTP协议相关知识
* Servlet和HttpServlet
* ServletContext对象及其使用（获取初始化参数、资源绝对路径以及作为域对象）
* 4大域对象（page、request、session和application）
* Servlet注解开发
* Request和Response对象
* 服务器转发和客户端重定向

## 练习题

1. 解答题

（1）URL 请求路径由哪些构成

协议://域名或IP:端口/资源位置?参数=值

（2）Tomcat在我们开发过程中起到那些作用

Tomcat作为Web服务器，用来运行使用Java开发的满足Servlet规范的Web应用

（3）Servlet核心作用

提供一个协议无关的接口，用来处理请求并返回响应，构建BS模式应用

（4）Servlet在什么情况下使用doGet()，在什么情况使用doPost()?（个人描述）

处理GET请求用doGet()，处理POST请求用doPost()

2. 编程题

（1）完成用户登录案例。（代码加截图）

参见ServletDemo代码，主要步骤：

* 建表
* 开发前端页面
* 开发后端Servlet逻辑
* 注册Servlet到web.xml

3. 解答题

 （1）JavaWeb 四⼤域对象分别是哪几个？它们的作用范围是？

* page：作用于jsp页面
* request：在一次请求中有效
* session：在一次会话中有效
* application：在整个web项目（当前web应用）运行期间有效，即ServletContext

 （2）注解和web.xml两者之间的优缺点

注解更直观，简单，直接一行代码写好就可以了，但是每次修改要重新编译；web.xml要多写几行才能达到同样目的，但修改后不需要重新编译。

3. 编程题（代码加截图）

（1）完成⽂件下载案例

参见DownloadDemo代码。

4. 解答题

（1）request 和response各自的作用

request代表的是客户端浏览器向服务器发送的“请求”，包括各种提交的请求参数；response表示服务器向客户端发送的各种“响应”，包括处理结果。

（2）转发重定向的区别

服务端转发，客户端重定向。所以转发不会改变URL，但重定向会；转发是服务器行为，客户端无需再请求一次，而重定向是客户端行为，客户端会再次发送一次请求；转发只能发生在内部，重定向可以到别的外部网站。

 5. 编程题（代码加截图）

（1）完成课上学习的⽤户登录功能

参见RegisterLoginDemo。

6. 解答题

（1）Cookie是什么

（2）Cookie的主要内容包括

（3）Cookie的应⽤场景？

7. 编程题

（1）完成服务器向浏览器发送Cookie （代码和截图）

8. 解答题

（1）Cookie 和 Session 的各自特点？

（2）Cookie和 Session的不同点？

（3）如果客户端禁止 cookie 那么 session 还能用吗？

9. 编程题

（1）完成验证码案例（截图和代码）