# SpringBoot

## 练习题

1. 解答题

（1）SpringBoot解决那些问题？

解决过去使用Spring+SpringMVC框架时一上来先写一大堆配置的问题。SpringBoot约定大于配置，故很多的选项都有默认配置，可以开箱即用，又可以很方便的扩展。

（2）SpringBoot各种starter好处？

将一套相关的依赖关系打包成starter，直接引入pom文件，避免写一大堆依赖管理的配置项。

（3）YAML配置文件语法？

* 大小写敏感
* 键值对之间冒号分割，值前面空一格
* 用空格缩进表示层次关系
* 用井号表示注释

（4）SpringBoot可以与那些技术集成?（对各种技术作用描述）

* 集成内存键值对NoSQL数据库Redis
* 集成搜索引擎ElasticSearch
* 集成定时器Scheduled控制定时任务
* 集成SpringCloud提供微服务
* 集成RocketMQ实现消息队列
* 集成Freemarker或Thymeleaf提供模板引擎