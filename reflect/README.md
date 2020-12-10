# 反射

## 知识点

* 类加载器的概念
* 反射、通过反射获取构造方法和成员方法
* JUnit单元测试的使用
* 注解的定义和使用、元注解@Target和@Retention
* Lombok的使用

## 练习题

1. 选择题

（1）注解和注释区别？（D）

A：注释：给程序员看的， 注解：给虚拟机看的

B：注释和注解都是需要被编译的

C：注释和注解都是实现业务逻辑必须要使用的

D：注解主要是对程序代码解释，说明的作用，而注释主要是参与代码编译，给程序看的

（2）JDK中提供的注解含义描述正确的是？（A）

A：@Override描述子类重写父类的方法

B：@SuppressWarnings提示错误

C：@Deprecated表示方法推荐使用，其他的过时

D：@Override JDK1.5版本的时候 该注解可以应用在 类的实现上

（3）下面获取String类的字节码对象正确的是？多选（A）

A：Class c = String.class; 

B：Class c = new String().getClass();

C：Class c = Class.forName(java.lang.String);

D：Class c = Class.forName(String);

（4）关于 Method的 Object invoke(Object obj, Object... args)方法说法正确的是？多选（AC）

A：此方法不可以执行private修饰的方法

B：此方法可以执行私有方法,但是要先调用void setAccessible(true)

C：参数一是被执行方法的对象,参数二是方法参数值

D：参数一是方法名,参数二是方法参数值

（5）以下关于Class对象的获取方式错误的是？（C）

A：通过类名.class获得

B：通过对象名.getClass()方法获得

C：通过Class类的静态方法获得：staticClassforName(类全名), 每一个类的Class对象都只有一个

D：以上都不对

（6）下列哪个选项不属于Java程序加载类的步骤（D）

A：加载：读取class文件

B：连接：验证内部结构，为静态资源分配空间，处理非静态引用

C：初始化：将代码放到代码区，初始化静态成员，将静态和非静态分离

D：创建对象：为该类创建一个普通的对象