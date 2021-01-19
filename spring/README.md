# Spring框架

## 练习题

1. Spring是什么，谈谈你的理解?

Spring是一套开源的Java框架，提供被称为“控制反转”和AOP的两大核心功能。开发人员在做开发的时候不可避免地要处理两种情况，一个是对象的创建，另一个是对象的依赖。当项目复杂到一定程度，或者按照分层架构设计时，就会产生复杂的对象依赖关系。Controller对象依赖Service对象，Service对象依赖Dao对象。开发人员如果自己组装，会非常复杂且容易出错。Spring框架通过控制反转，通过工厂设计模式替开发人员处理了对象的创建，并通过Spring容器管理；又通过依赖注入帮助开发人员建立对象之间复杂的依赖关系。而AOP则以一种非侵入的方式增强了对象的功能，其思想和装饰者模式相似。

2. Spring 的优点？

Spring框架最大的优点就是能与Java世界大量的第三方框架和类库进行整合，并且自身也基于Spring框架提供了大量的企业级框架，逐渐形成了Spring全家桶，一站式搞定所有开发任务，包括微服务。

3. Spring的IoC理解？

IoC是控制反转的意思。所谓控制反转，是指本来需要开发人员处理的对象创建和对象依赖关系组装的任务，现在由框架来负责。框架通过工厂模式管理对象创建，通过依赖注入为bean对象的属性注入值。

4. 什么是依赖注入？

依赖注入就是通过XML或者注解，为Spring容器管理的bean对象注入属性值，通过构造函数或者setter方法的方式。

5. Spring中的的注解有哪些，并描述其作用？

* @Component：bean标签对应注解，衍生@Repository、@Controller和@Service
* @Scope：对应bean标签scope属性
* @PostConstruct：对应bean标签init-method属性
* @PreDestroy：对应bean标签destroy-method属性
* @Autowired：用于进行对象的依赖注入
* @Qualifier：通过ID进行注解，常用于一个接口多个实现类的情况
* @Configuration：标识配置类
* @ComponentScan：对应XML配置文件中的context:component-scan，用来扫描Bean类型
* @Import引入其他的配置类，这些配置类不能用@Configuration修饰否则容易出错
* @PropertySource：指定要读取的properties文件
* @Value：对成员变量赋初始值
* @Bean：标记一个方法的返回值为bean对象，放到Spring容器中维护