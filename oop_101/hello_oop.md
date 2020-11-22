# 面向对象

请先研究文末的“带着问题去学习”，包括它的出题范围和思路，去分析学习时应该怎样回忆知识点、怎样运用知识点并将它们串起来，做到即学即用、即用即学。

## 知识点

在Java的世界中万物皆对象。每个对象都有自己的属性和行为，封装、继承和多态是面向对象的三大特征。类是一类事物的抽象描述，是模板；对象是一类事物的具体实例，是实体。成员变量具有默认值，成员变量与局部变量在以下方面有区别有联系：

* 在类中位置
* 在内存的位置
* 生命周期
* 初始化值
* 作用范围

封装是对信息的隐藏，防止类的数据被随意访问，只能通过指定的方式访问类。要注意掌握this关键字和构造方法的概念。JavaBean是Java编程中的一种标准规范，满足如下要求：

* 公共的，具体的（不是抽象类）
* 定义了无参构造方法（建议包含带参构造方法）
* 有getter、setter方法

### 继承

一个类通过继承有条件地自动获得另一个类的属性和方法，它们就构成了子类和父类的关系。这样做提高了代码的复用性，“多态”的概念就是在“继承”的基础上实现的。子类对象在构建时会先创建父类对象，引入继承关系后存在一些新情况：

* 子类重名的成员变量覆盖父类变量，可通过super关键字访问
* 子类重名的成员方法啊是对父类方法的重写
* 子类的构造方法默认会调用父类的构造方法，也可以手动调用

可以在Java中定义只有方法型构而没有方法体的抽象方法，包含抽象方法的类称为抽象类。抽象类不能创建对象，只能被其他类继承和实现。

### 接口

Java语言中的接口是一种引用类型，描述“行为”，即方法的集合，实现接口的类实现接口所有的抽象方法。一个接口包含3种方法：抽象方法、默认方法和静态方法。抽象方法的abstract关键字可以省略，特指一类只有签名没有实现的方法；默认方法用default修饰，必须定义，且可以被子类调用或者重写；而静态方法用static关键字修饰，且只能通过接口名调用，无法通过子类名或子类对象调用。接口还可以定义默认为public static final的常量。

一个类可以实现多个接口，每个接口的抽象方法都必须实现一遍；每个接口的默认方法都可以继承使用，有重名的必须重写；多个接口中同名的静态方法只能通过接口名访问，故不冲突。一个接口可以继承多个接口，如果父接口有重名的默认方法，则需要在子接口中重写一次。

### 多态

多态指同一种行为在不同对象上出现的不同的表现形式。使用多态必须满足3个条件：

* 继承或者实现
* 父类引用指向子类对象
* 子类重写父类的方法

使用多态可以实践依赖倒置原则并面向接口编程。但注意引用类型转换问题，向上转换是子类向父类转，是默认的；向下转换是父类向子类转以调用子类有而父类没有的方法，是强制的，为了避免ClassCastException错误，可以使用instanceof运算符判断某个对象是否为某个抽象数据类型的实例。

### 一些Java API的使用

掌握Random、Scanner、BigInteger和BigDecimal类的使用。

## 练习题

1. 选择题

（1）如果有一个Student类的定义如下，并且已经创建了stu对象：

```java
public class Student {
  String name;
	public void method() {
    System.out.println(name);
  }
}

public class Demo {
  public static void main(String[] args){
    Student stu = new Student();
  }
}
```

那么希望给其成员变量name赋值,并执行成员方法method的正确写法是：（C）

A：stu.name=张三 和 stu.method;

B：stu.name()=张三 和 stu.method();

C：stu.name=张三 和 stu.method();

D：stu.name()=张三 和 stu.method;

2. 编程题

需求：请定义一个交通工具(Vehicle)的类，其中有：

  属性：车的品牌(brand)，车的类型(type) ;

  方法：启动方法(start()) 行驶的方法(run()) ; 

  在测试类中通过对象完成成员变量和成员方法的使用

结果如下:

Porche is starting

Porsche is running on the highway

```java
package com.javaee.vehicle;

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Vehicle("Porsche", "Car");
        car.start();
        car.run();
    }
}

```

```java
package com.javaee.vehicle;

public class Vehicle {
    private String brand;
    private String type;

    public Vehicle() {}

    public Vehicle(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void start() {
        System.out.printf("%s %s is starting\n", brand, type);
    }

    public void run() {
        System.out.printf("%s %s is running on the highway\n", brand, type);
    }
}

```

3. 选择题

（1）以下程序运行结果是：（B ）

 ```java
public class Fu {
  public Fu() {
    System.out.print("Fu");
  }
}

public class Zi extends Fu {
  public Zi() {
    System.out.print("Zi");
  }
}

public class Test {
  public static void main(String[] args) {
    Zi zi = new Zi();
  }
}
 ```

A: ZiFu 

B: FuZi 

C: Zi 

D: 编译报错

（2）请问,什么是方法的重写? （C ）

A: 方法名相同即为重写

B: 在一个类中，方法名相同和参数列表无关

C: 在子父类中，方法名相同，参数列表相同和返回值类型相同

D: 在子父类中，方法名相同，参数列表可以不一致

（3）在Java中，下面关于抽象类的描述正确的是 （B ）

A:  抽象类可以被直接实例化(直接创建对象)

B: 如果一个类中有一个方法被声明为抽象的，那么这个类必须是抽象类

C:  抽象类中的方法必须都是抽象的

D: 抽象类中必须要有抽象方法或者普通方法

（4）给定java代码，如下：

```java
public abstract class Shape { 
  public abstract void draw();   
} 
```

要创建Shape类的子类Circle，以下代码正确的是（ D）。

A: 

```java
public class Circle extends Shape{ 
   public int draw(){
		//...
   }   
} 
```

B:

```java
public class Circle { 
  public void draw(){
    //...
  }   
} 
```

C:

```java
public class Circle extends Shape{  
  public void draw(); 
}
```

D:

```java
public class Circle extends Shape{  
  public void draw(){ 
    //...  
  } 
} 
```

（5）阅读以下代码, 请选择出正确的运行结果（ B）。

```java
public class Fu {
  int num = 10;
  public void show() {
    System.out.println("fu...");
  }
}

public class Zi extends Fu {
	int num = 20;
}

public class Test {
	public static void main(String[] args) {
    Zi z = new Zi();
    System.out.println(z.num);
    z.show();
  }
}
```

A: 10 fu...

B: 20 fu...

C: 20

D: 10

4. 编程题

 题目一：每一款手机都有自己的品牌和价格，原来的手机只能打电话，发短信，来电显示只能显示手机号；现在的新手机针对于来电显示做了功能的升级,还能显示头像，还能显示归属地，请设计程序，完成手机的升级！

训练提示

新手机在老手机的基本功能基础上,针对老手机的某个功能进行重新实现

参考方案

* 定义一个老手机类（OldPhone），包含品牌和价格两个属性，对应的构造，get/set方法，还有打电话，和发短信的方法，来电显示的方法

* 定义一个新手机（NewPhone），继承老手机类，重写来电显示方法进行升级

* 最后在测试类中，创建新手机对象，为属性赋值，调用继承过来的方法以及来电显示方法

你的代码（请提交编译通过的代码）

```java
public class Phone {
    private String brand;
    private double price;

    public Phone() {}

    public Phone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void makeCall() {
        System.out.println(brand + " make a phone call");
    }

    public void sendMessage() {
        System.out.println(brand + " send a message");
    }

    public void displayCaller() {
        System.out.println(brand + " display caller's phone number");
    }
}
```

```java
public class SmartPhone extends Phone {
    public SmartPhone() {}

    public SmartPhone(String brand, double price) {
        super(brand, price);
    }

    @Override
    public void displayCaller() {
        System.out.println(getBrand() + " display caller's phone number, head and location");
    }
}
```

```java
public class PhoneDemo {
    public static void main(String[] args) {
        Phone nokia = new Phone("Nokia", 3000.00);
        SmartPhone apple = new SmartPhone("Apple", 8000.00);

        nokia.makeCall();
        nokia.sendMessage();
        nokia.displayCaller();

        apple.makeCall();
        apple.sendMessage();
        apple.displayCaller();
    }
}
```

5. 选择题

 （1）下列关于接口的成员特点，说法正确的是（C）：

A: 接口中的变量，都是被public static final修饰的

B: 接口中有构造方法

C: 接口中的方法, 默认自带public abstract

D: 接口跟类的关系是继承

（2）请阅读代码:

 ```java
public class Animal {}
public class Dog extends Animal{}
public class Cat extends Animal{}
public class Test {
	public static void main(String[] args) {
    // 请在此处填写代码
  }
} 
 ```

请问以下哪个代码是在运行阶段也不会出现错误的向下转型 （多选）（BC）

A：Animal a = new Dog(); Cat c = (Cat) a;

B： Animal a = new Dog(); Dog d = (Dog) a; 

C：Object o = new Animal(); Animal a = (Animal) o; 

D：Dog d = new Dog(); Cat c = (Cat) d;

6. 编程题

题目一

（1）请定义员工(Employee类)：

属性：姓名、性别、年龄(全部私有)

行为：工作(抽象)

无参、全参构造方法

get/set方法

（2）请定义绘画(Draw接口)

抽象方法：绘画

（3）请定义“JavaTeacher讲师类”继承自“员工类”

（4）请定义”UITeacher讲师类”，继承自“员工类”，并实现“绘画”接口。

要求：请按上述要求设计出类和接口，并实现相关的方法，并进行调用测试。

程序运行结果

姓名: 张三,性别: 男,年龄: 38的java老师正在讲解面向对象

姓名: 李四,性别: 女,年龄: 28的UI老师正在讲解产品设计工作流程

姓名: 李四,性别: 女,年龄: 28的UI老师正在教大家绘图

训练提示：UI讲师类已经继承员工类,已经有父类了,所以绘画需要定义成接口

参考方案

* 定义标准的抽象父类员工Employee类
* 定义接口Draw类
* 定义子类JavaTeacher,继承父类Employee,覆盖重写抽象方法
* 定义子类UiTeacher,继承父类Emploee,实现接口Draw,覆盖重写抽象方法
* 创建子类对象,调用方法

你的代码（提交代码及正确的运行截图）

**参考答案**：参见com.javaee.employee包下的代码

题目二

一个机动车管理系统中有以下类的设计：

机动车类（vehicle）：

|--汽车类（Car）：

|--奔驰车

|--宝马车

|--摩托车类（Motor）：

|--雅马哈摩托

|--宝马摩托

所有的车都有如下信息：

属性：品牌（brand）、价格（price）

行为：运行

要求:

为所有“宝马车系（包含宝马摩托车和宝马汽车）”增加一个GPS功能。

请设计出上述的类和接口，并用代码实现。

运行结果如下:

价值500000元的奔驰车正在运行

价值800000元的宝马车正在运行

价值800000元的宝马车已经开启GPS定位

价值50000元的雅马哈摩托车正在运行

价值80000元的宝马摩托车正在运行

价值80000元的宝马摩托车已经开启GPS定位

训练提示：因为宝马车有父类汽车，宝马摩托车也有父类摩托车，所以给所有的宝马车添加GPS功能，GPS应该定义成接口

你的代码（提交代码及正确的运行截图）

**参考答案**：参见com.javaee.vehicle2