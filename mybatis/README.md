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

2. 编程题：使用MyBatis完成课上案例增删改查操作。（提交编码）

参见mybatisdemo代码。

3. 解答题

（1）传统开发模式的弊端有哪些？

需要重复编写从InputStream到SqlSessionFactory再到获取SqlSession对象的过程。另外，需要在代码中通过写死statement ID执行相应SQL语句，不方便维护。

（2）mybatis动态SQL语句有哪些，每个作用描述?

* if

用来拼接WHERE子句中的可选语句，当判断某个属性不为空时添加某个字段作为查询条件。

* choose（when otherwise）

类似Java的switch语句，在多个条件中选择一个。

* trim where set

where会在子元素有返回时提供WHERE子句，它会自动去除开头的AND和OR。可以通过自定义trim元素来定制元素功能。set元素用来动态包含需要更新的列。

* foreach

在SQL语句中对集合进行遍历，实现诸如IN...的功能。

（3）代理开发方式是什么？

只定义DAO接口，然后编写XML映射文件，提供响应SQL语句，为此必须满足4个条件：

* XML映射文件在resources目录下的结构必须与对应的接口包名相同
* XML映射文件中的namespace必须与接口包名相同
* XML映射文件中statement ID必须与对应接口名相同
* XML映射文件中的parameterType和resultType必须分别与函数参数类型和返回值类型相同

4. 编程题：mybatis使用分页插件实现分页功能。并获得分页数据。（需提交代码）

参见mybatisdao代码。

5. 解答题：mybatis常用注解有哪些

* 基础的CRUD注解：@Insert、@Delete、@Select和@Update
* 参数注解@Param
* 主键返回@SelectKey
* 等价于resultMap的结果映射注解@Results
* 等价于result的@Result注解
* 等价于association的一对一关系注解@One
* 等价于collection的一对多关系注解@Many

6. 编程题：使用mybatis注解或xml方式完成课上"一对一"查询案例、"一对多"查询案例和"多对多"查询案例。（需提交代码）

参见mybatisannotation代码。