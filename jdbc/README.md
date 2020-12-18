# JDBC

## 知识点

* 各大数据库厂商提供的驱动实现了JDBC接口规范
* 四大核心对象：DriverManager、Connection、Statement和ResultSet
* 使用JDBC开发的步骤
  * 注册驱动
  * 获得连接
  * 获得SQL语句对象
  * 执行SQL语句获得结果
  * 处理结果
  * 释放资源
* 使用JDBC进行各种增删查改操作
* 如何使用PreparedStatement来避免SQL注入
* 数据库连接池的存在是为了避免频繁创建和销毁数据库连接的开销
* Java数据库连接池标准接口为`javax.sql.DataSource`，常见连接池：C3P0、Druid、HikariCP
* Druid连接池的简单使用、Apache Commons中DBUtils简单使用
* 使用QueryRunner核心类进行增删改
* 使用QueryRunner进行查询操作时如何配合ResultSetHandler使用（BeanHandler、ScalarHandler、BeanListHandler和ColumnListHandler）

## 练习题

1. 解答题

（1）什么是JDBC，在什么时候会用到它？（个人理解）

需要通过Java语言访问各种关系型数据库的时候会用到JDBC，但现在一般都用MyBatis或者Hibernate这类高级框架，裸写SQL的情况很少了，主要是不容易维护。当然理解JDBC对后面使用MyBatis会很有帮助。

（2）JDBC操作数据库的步骤 ？

注册驱动，获取连接，创建SQL语句，执行SQL语句得到结果，处理结果，释放资源

2. 编程题

（1）使用原生JDBC完成增删改查

参见JDBCDemo示例代码

3. 解答题

（1）为什么使用连接池和连接池工作原理（个人理解）。

使用连接池是为了避免频繁创建和销毁数据库连接造成的开销，有些库还会提供一些监控功能比如Druid。数据库连接池工作原理是将数据库连接预先创建好放在池中，每次使用时从池中选一个使用完毕再放回。

（2）有原生JDBC，为什么还要使用工具类（个人理解）

使用原生JDBC要写一大堆模板代码一步一步操作，工具类一步到位给你封装好了，可以少写几行代码。

4. 编程题

（1）使用DButils完成增删改查。（代码加截图）

参见JDBCDemo示例代码

5. 解答题

（1）什么是事务，事务的理解。（个人理解）

（2）如果没有用事务，可能出现哪些问题。（个人理解）

6. 编程题

（1）使⽤分层开发思想, 完成转账项目。（代码加截图）