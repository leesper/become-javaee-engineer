# MyBatis

## 练习题

1. 解答题

（1）什么是Mybatis，Mybatis的优点？

MyBatis是基于Java的数据持久层框架。使用Mybatis可以避免编写大量重复的JDBC模板代码，并可以使用连接池来避免频繁建立和销毁数据库连接。使用MyBatis访问数据库可以自动在数据和POJO之间建立映射，避免自己建立数据与对象之间的实体关系映射。MyBatis的SQL语句是配置在XML文件中的，对于相同的SQL语句可以进行优化并缓存，可以很方便的修改SQL语句而避免改动Java代码，其支持的动态SQL能挺高开发效率。

（2）MyBatis的基本工作流程

MyBatis通过核心配置文件和mapper映射文件来进行参数配置和动态SQL配置，其中核心配置文件会关联mapper映射文件。然后在编写代码时通过加载核心配置文件创建SqlSessionFactory，通过SqlSessionFactory的openSession()方法获取SqlSession对象，在SqlSession对象上调用CRUD方法，通过由“命名空间+ID”格式构成的Statement ID来执行编写在mapper配置文件中的动态SQL语句MappedStatement。MappedStatement由Executor负责执行。输入参数和输出参数都可以配置成基本类型、基本类型的包装类型、Map或者POJO类，由框架自动建立映射。

（3）#{}和${}的区别是什么？

${}只是简单的字符串替换，#{}则相当于JDBC的`?`通配符。前者不能防止SQL注入，而后者可以。能用#{}则尽量用。

（4）Mybatis 核心配置文件内容

包含如下内容：

* configuration：根元素
* properties（属性）：引入外部properties文件，然后用类似${jdbc.driver}的方法引用配置属性
* settings（全局配置参数）：MyBatis运行时行为配置，极为重要
* typeAliases（类型别名）：为Java类型设置一个较短的名字，这样可以少打几个字
* typeHandlers（类型处理器）：自定义类型处理器来支持数据库类型到Java类型之间的映射
* objectFactory（对象⼯⼚）：修改创建结果对象的对象工厂的默认行为
* plugins（插件）：定义在映射语句执行的过程中拦截调用的类
* environments（环境集合属性对象）：多数据库环境配置
* environment（环境⼦属性对象）：配置单一数据库环境
* transactionManager（事务管理）：数据库事务配置
* dataSource（数据源）：数据库驱动相关配置
* mappers（映射器）：告诉MyBatis去哪寻找SQL映射语句

2. 编程题

（1）使用MyBatis完成课上案例增删改查操作。（提交编码）

参见mybatisdemo代码。