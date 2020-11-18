# Java基础入门

请先研究文末的“带着问题去学习”，包括它的出题范围和思路，去分析学习时应该怎样回忆知识点、怎样运用知识点并将它们串起来，做到即学即用、即用即学。

## 知识点

请阅读《Thinking In Java》或最新版的[《On Java 8》](https://github.com/LingCoder/OnJava8)相关章节掌握以下知识点。

### Java语言

Java是James Gosling在1995年推出的高级开发语言，经过多年发展，截止2018年9月，Java已迭代演进到第11版。Java语言主要用于开发互联网应用，包括各种面向业务的企业级平台（OLTP）和面向分析的大规模数据挖掘平台（OLAP）。

Java程序编译后运行在JVM虚拟机上，而JVM虚拟机又运行在不同的操作系统上。JVM虚拟机是Java程序能够跨平台运行的核心。JDK、JRE和JVM是从大到小的包含关系。JDK是Java程序开发包，包含JRE和开发工具；JRE是Java运行时环境，包含JVM和运行时需要的核心类库。javac编译器将.java源文件编译成.class字节码文件，然后由JVM运行.class文件，main方法是所有程序的入口。

### 字节和进制

计算机存储数据的最小单元叫字节，一个字节有8位。关于字节和进制，请参考《深入理解计算机系统》一书第2章“信息的表示和处理”。

### 学习Java语言

掌握注释、关键字、数据类型、常量字面值、变量定义和标识符命名规则和规范等相关知识，重点掌握：

1. Java添加代码注释的3种方式：单行注释、多行注释及文档注释
2. Java关键字有哪些
3. 6种字面值常量：整数、小数、字符、字符串、布尔和null
4. 如何定义变量、如何给变量赋值以及变量的作用域的概念
5. 4类（整型、浮点数、字符型和布尔型）8种基本数据类型有哪些，3种引用数据类型：类、接口、抽象数据类型（数组、列表、映射、集合等等）
6. 必须满足的“标识符命名规则”和类、方法及变量名的“命名规范”

### 开发环境搭建

掌握JDK的下载和安装、环境变量和配置，特别是不同操作系统环境下的安装和配置方法（Windows、Linux和Mac）。安装Intellij IDEA开发环境，掌握如下关键知识点：

1. 如何创建project
2. 如何创建包目录结构
3. 怎样调节字体设置
4. 熟悉常用快捷键
5. 编写代码打印hello, world

### 数据类型转换

理解自动类型转换的实质是“提升”，即范围小的类型向大的类型发生转换：`byte short char-->int-->long-->float-->double`。理解强制类型转换是从范围大的向范围小的类型转换，可能会损失精度，需要程序员手动执行。

### 运算符

学习掌握Java语言各种运算符：

1. 算术运算符：加减乘除和取模运算，特别是+运算在不同数据类型上的表现，如字符串拼接
2. 赋值运算符，特别是各种运算后赋值
3. 自增自减运算符，放前面和放后面的区别
4. 6种关系运算符
5. 逻辑运算符及其短路求值
6. 三元运算符
7. 位移运算符
8. 各种运算符的优先级

### 方法

方法是对重复代码进行抽象的最基本方法，可以反复调用。重点掌握：

1. 方法的定义，包括修饰符、返回值类型、方法名、参数列表和return语句
2. 方法重载，即同名不同参的方法，不同参体现在个数、类型和顺序上
3. 基本数据类型作为方法参数，对实参不会造成任何影响（值类型）
4. 引用数据类型作为方法参数，会对实参造成影响（引用类型）

### 选择判断

所有的程序都由3种基本结构组成：顺序、分支和循环。对于条件判断来说，重点掌握if语句和switch语句。

### 循环

重点掌握：

1. for循环的语句格式，逗号操作符
2. while循环和do..while循环
3. continue和break的区别
4. 无限循环
5. 嵌套循环

Java 5引入了增强版的for-in循环，可以用于所有可迭代（iterable）的对象：

```java
public class ForInString {
  public static void main(String[] args) {
    for(char c: "An African Swallow".toCharArray())
      System.out.print(c + " ");
  }
}
```

输出结果：

```
A n   A f r i c a n   S w a l l o w
```

Java 7 增加了在字符串上switch的用法：

```java
switch(color) {
  case "red":
    System.out.println("RED");
    break;
  case "green":
    System.out.println("GREEN");
    break;
  case "blue":
    System.out.println("BLUE");
    break;
  case "yellow":
    System.out.println("YELLOW");
    break;
  default:
    System.out.println("Unknown");
    break;
}
```

### 调试小技巧

重点掌握如何在Intellij IDEA中对代码进行调试：

1. 如何加断点
2. 如何以debug模式运行代码
3. 查看Console窗口和Debug窗口
4. 如何设置观察点观察目标变量
5. 如何单步调试，包括step into和step over

### 数组

数据是长度固定的，存储相同数据类型的容器。`String[] args`即可定义一个数组，数组的初始化有三种方式。数组通过从0开始的索引下标进行访问。JVM虚拟机内存分为5个区域：寄存器、本地方法栈、堆内存、方法栈、方法区。数组存放在堆内存上，数组名存储的是内存地址，因此数组类型被称为引用类型。如果访问的下标超过了元素数量，会导致数组越界异常；如果访问了内存地址为Null的数组，会导致空指针异常。

## 练习题

1. Java源文件和编译后的文件扩展名分别为？

源文件以.java为扩展名，编译后的文件以.class为扩展名。

2. 常量变量的定义？

常量定义：final 数据类型 常量名称 = 常量值

变量定义：数据类型 变量名称 [= 变量值]

3. 编程实践（参考答案参见代码）：

（1）请编写程序，得到如下输出：

 Java is a cross-platform programming language

called "write once, run everywhere"

（2）请编写程序，分别打印输出不同类型的常量

4. 选择题

（1）下列输出语句中，输出结果为5+5=10的是：
A：System.out.println(5+5+"="+5+5);
B：System.out.println(5+5+"="+(5+5));
C：System.out.println("5+5="+5+5);
D：System.out.println("5+5="+(5+5));

（2）下列不属于赋值运算符是？ (D )
A： =
B： *=
C： %=
D： ++

（3）代码如下：

```java
public static void main(String[] args){

    ______________

}

public static void method(){
   System.out.println("I am a PROGRAMMER");
}
```

运行结果是：I am a PROGRAMMER
横线处应该填写的正确代码是（C）
A、method;
B、void v = method();
C、method();
D、method("I am a PROGRAMMER");

5. 定义一个int类型的变量，初始化值为1234，求这个数的个位，十位，百位，千位分别是多少?

思路：善用取模运算和除法运算来得到每一位的值

```java
private static void extractInteger() {
	int num = 1234;
  System.out.println("Unit: " + num % 10);
  System.out.println("Decade: " + num / 10 % 10);
  System.out.println("Hundreds: " + num / 100 % 10);
  System.out.println("Kilobit: " + num / 1000 % 10);
}
```

6. 使用方法重载计算两个整数的和，三个整数的和，两个小数的和并测试

```java
private static void overloadOperator() {
  System.out.println("1 + 2 = " + add(1, 2));
  System.out.println("1 + 2 + 3 = " + add(1, 2, 3));
  System.out.println("3.14159 + 3.14159 = " + add(3.14159, 3.14159));
}

private static int add(int a, int b) {
  return a + b;
}

private static int add(int a, int b, int c) {
  return a + b + c;
}

private static double add(double a, double b) {
  return a + b;
}
```

7. 选择题

（1）下列语句序列执行后，b 的值是（B）

 ```java
int a=2, b=4;
if( a < --b){
  a *= a;
}
 ```

A、5

B、3

C、15

D、10

（2）以下一段代码执行完毕后y的值是（A）

```java
int x = 11; 
int y = 0; 
if(x>5){
  y = x + 5; 
} else {
  y = x – 5; 
} 
```

A、16 

B、6  

C、11 

D、0

（3）下列语句序列执行后，i 的值是（D）

```java
 int i=8, j=16;  
 if( i-1 > j ){
   i--; 
 } else{
   j--; 
 } 
```


 A、15  

 B、16  

 C、7   

 D、8 

8. 编程题

（1）打印出1到100之间的既是3的倍数又是5倍数的数字.（请提交代码及正确的运行截图）

```java
for (int i = 1; i <= 100; i++) {
  if (i % 3 == 0 && i % 5 == 0) {
    System.out.println(i);
  }
}
```

9. 选择题

（1）下面正确的初始化语句是（C ）

A. char array[]=hello; 

B. char array[100]=hello; 

C. char array[]={'h','e','l','l','o'};   

D. char array[]={'hello'}; 

（2）当访问无效的数组下标时，会发生（B）

A、正常执行 

B、抛出数组索引越界异常,中止程序  

C、系统崩溃 

D、直接跳过 

（3）若只能修改一处，想要输出结果为 0，可以对哪一步进行修改（B ）

public static void main(String[] args) {

  int [ ] arr = new int[1]; //①

  arr[0] = 3; //②

  System.out.println( arr[1] ); //③

}

A、②处修改为 arr[3] = 0;

B、③处修改为 System.out.println(arr[0]-3) ;

C、①处修改为 int [ ] arr = new int[2];

D、②处修改为 arr[1] = 0;

（4）请问数组 int[] num = {1,-1,-56,56,12};，索引为3的元素值是？(D )

A： 1

B： -1

C： -56

D： 56

10. 编程题

（1）现有一个小数数组{12.9, 53.54, 75.0, 99.1, 3.14}，请编写代码，找出数组中的最小值并打印。（编写代码及附上正确的运行截图）

```java
public class ArrayDemo {
    public static void main(String[] args) {
        double[] doubles = {12.9, 53.54, 75.0, 99.1, 3.14};
        double min = Double.MAX_VALUE;
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] < min) {
                min = doubles[i];
            }
        }
        System.out.println("Minimal value: " + min);
    }
}
```





